package org.example.mediator;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class IsmoController extends BaseChatController{
    @FXML
    private TextArea messageArea;
    @FXML
    private TextField recipientField;
    @FXML
    private TextField messageField;

    public IsmoController(String username, Mediator mediator) {
        super(username, mediator);
    }

    @FXML
    private void sendMessage() {
        String recipient = recipientField.getText();
        String message = messageField.getText();
        if (!recipient.isEmpty() && !message.isEmpty()) {
            super.sendMessage(recipient, message);
            displayMessage("Me -> " + recipient + ": " + message);
            messageField.clear();
        }
    }

    @Override
    public void displayMessage(String message) {
        messageArea.appendText(message + "\n");
    }

}
