package org.example.mediator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ChatMediator mediator = new ChatMediator();
        createChatClient("Ismo", mediator, "IsmoController");
        createChatClient("Matti", mediator, "MattiController");
        createChatClient("Seppo", mediator, "SeppoController");
    }

    private void createChatClient(String username, ChatMediator mediator, String controllerClassName) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chat-view.fxml"));
        String fullyQualifiedClassName = "org.example.mediator." + controllerClassName;
        Class<?> controllerClass = Class.forName(fullyQualifiedClassName);
        BaseChatController controller = (BaseChatController) controllerClass
                .getConstructor(String.class, Mediator.class)
                .newInstance(username, mediator);
        loader.setController(controller);
        Stage stage = new Stage();
        stage.setTitle(username);
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/org/example/mediator/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}