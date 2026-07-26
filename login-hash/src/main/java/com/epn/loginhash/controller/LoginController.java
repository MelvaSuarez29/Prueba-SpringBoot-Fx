package com.epn.loginhash.controller;

import com.epn.loginhash.service.AuthService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField txtUser;
    @FXML private PasswordField txtPassword;
    @FXML private ComboBox<String> cmbRol;
    @FXML private Button btnInicio;

    private final AuthService authService = new AuthService();

    @FXML
    public void initialize() {
        cmbRol.getItems().addAll("Administrador", "Cliente", "Invitado");
        cmbRol.setValue("Administrador");
    }

    @FXML
    private void handleLogin() {
        String usuario = txtUser.getText().trim();
        String password = txtPassword.getText().trim();
        String rolSeleccionado = cmbRol.getValue();

        if (!"Administrador".equals(rolSeleccionado)) {
            mostrarAlerta("Solo el rol Administrador puede iniciar sesión.");
            return;
        }

        if (authService.autenticarAdministrador(usuario, password)) {
            abrirVentanaRegistroCliente();
        } else {
            mostrarAlerta("Credenciales Incorrectas");
        }
    }

    private void abrirVentanaRegistroCliente() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/epn/loginhash/RegistroCliente.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Registro de Cliente");
            stage.setScene(new Scene(root, 500, 400));
            stage.show();

            Stage loginStage = (Stage) btnInicio.getScene().getWindow();
            loginStage.close();
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error al abrir la ventana de registro.");
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void handleRegistro() {
        mostrarAlerta("El registro de nuevos usuarios se realiza desde la ventana de Cliente.");
    }
}