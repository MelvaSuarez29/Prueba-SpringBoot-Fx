module com.epn.loginhash {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jbcrypt;


    opens com.epn.loginhash to javafx.fxml;
    opens com.epn.loginhash.controller to javafx.fxml;
    opens com.epn.loginhash.model to javafx.fxml;
    exports com.epn.loginhash;
}