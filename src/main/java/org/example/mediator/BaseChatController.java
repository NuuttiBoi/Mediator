package org.example.mediator;

import javafx.application.Platform;

public abstract class BaseChatController {
    protected String username;
    protected Mediator mediator;

    public BaseChatController(String username, Mediator mediator) {
        this.username = username;
        this.mediator = mediator;
        mediator.registerController(this);
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String recipient, String message) {
        mediator.sendMessage(username, recipient, message);
    }

    public void receiveMessage(String from, String message) {
        Platform.runLater(() -> displayMessage(from + ": " + message));
    }

    public abstract void displayMessage(String message);
}
