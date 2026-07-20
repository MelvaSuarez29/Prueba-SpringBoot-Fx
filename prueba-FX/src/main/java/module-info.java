module org.example.pruebafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.pruebafx to javafx.fxml;
    exports org.example.pruebafx;
}