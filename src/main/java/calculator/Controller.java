package calculator;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller {

    @FXML private GridPane mainGridPane;
    @FXML private TextField inputField;
    @FXML private TextField outputField;
    private StringBuilder builder = new StringBuilder();

    public void initialize(){
        assignOnClickEventToAllButtons();
    }

    public void assignOnClickEventToAllButtons(){

        ObservableList<Node> buttons = mainGridPane.getChildren();
        for (Node button : buttons) {

            Button newButton = (Button) button;
            newButton.setOnMouseClicked(e -> {
                if (newButton.isCancelButton()) {
                    clearTextField();
                } else if (newButton.getText().equals("=")){
                    assignTextToOutputField();
                } else {
                    assignTextToInputField(newButton);
                }
            });
        }
    }

    private void assignTextToOutputField(){
        outputField.setText(builder.toString());
    }

    private void assignTextToInputField(Button button) {
        builder.append(button.getText());
        inputField.setText(builder.toString());
    }

    private void clearTextField(){
        builder.delete(0, builder.length());
        inputField.setText(null);
    }
}
