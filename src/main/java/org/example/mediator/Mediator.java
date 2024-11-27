package org.example.mediator;

public interface Mediator {
    void registerController(BaseChatController controller);
    void sendMessage(String from, String to, String message);
}