package org.example.mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatMediator implements Mediator {
    private final Map<String, BaseChatController> controllers = new HashMap<>();

    public void registerController(BaseChatController controller) {
        controllers.put(controller.getUsername(), controller);
    }

    @Override
    public void sendMessage(String from, String to, String message) {
        BaseChatController recipientController = controllers.get(to);
        if (recipientController != null) {
            recipientController.receiveMessage(from, message);
        } else {
            BaseChatController senderController = controllers.get(from);
            if (senderController != null) {
                senderController.receiveMessage("System", "User '" + to + "' not found.");
            }
        }
    }

}