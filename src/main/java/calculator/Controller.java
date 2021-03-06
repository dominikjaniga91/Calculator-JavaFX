package calculator;

import calculator.service.Calculator;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.util.Objects;

public class Controller {

    @FXML private GridPane mainGridPane;
    @FXML private TextField inputField;
    @FXML private TextField outputField;
    private StringBuilder builder = new StringBuilder();
    private Calculator calculator = new Calculator();

    public void initialize(){
        assignOnClickEventToAllButtons();
    }

    /**
     * Action iterate over list of GridPane children, in this case - buttons,
     * and assign action depending on kind of button. There are four options.
     * Cancel button clear text fields and string builder.
     * Equal sign button set up provided numbers to output text
     * field. Numeric and math sign buttons set up its value
     * to input field.
     */

    public void assignOnClickEventToAllButtons(){

        ObservableList<Node> buttons = mainGridPane.getChildren();
        for (Node button : buttons) {

            Button newButton = (Button) button;
            newButton.setOnMouseClicked(e -> {
                if (newButton.isCancelButton()) {
                    clearTextField();
                } else if (newButton.getText().equals("=")){
                    setCalculationResultToOutput();
                } else if (newButton.getText().equals("DEL")){
                    removeProvidedText();
                }else {
                    setTextToInputField(newButton);
                }
            });
        }
    }

    private void removeProvidedText() {
        int size = Objects.requireNonNullElse(builder.length(), 0);
       if(size > 0) {
           builder.delete(size-1, size);
           inputField.setText(builder.toString());
       }
    }

    private void setCalculationResultToOutput(){
        Number result = calculator.performCalculation(builder.toString());
        outputField.setText(String.valueOf(result));
    }

    private void setTextToInputField(Button button) {
        builder.append(button.getText());
        inputField.setText(builder.toString());
    }

    private void clearTextField(){
        builder.delete(0, builder.length());
        inputField.setText(null);
        outputField.setText(null);
    }
}
