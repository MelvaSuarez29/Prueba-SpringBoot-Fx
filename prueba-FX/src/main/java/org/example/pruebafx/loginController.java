package org.example.pruebafx;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void onLoginButtonClick() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
    }
    @FXML
    public void onSignUpButtonClick() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
    }
}
