module org.example.mediator {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.mediator to javafx.fxml;
    exports org.example.mediator;
}