package com.epn.loginhash.controller;

import com.epn.loginhash.model.Cliente;
import com.epn.loginhash.service.AuthService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegistroClienteController {
    @FXML private TextField txtNombre;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtTelefono;
    @FXML private PasswordField txtPassword;
    @FXML private TextField txtDireccion;
    @FXML private Button btnGuardar;
    @FXML private Button btnLimpiar;

    private final AuthService authService = new AuthService();

    @FXML
    public void initialize() {
        // Opcional: limpiar campos al iniciar
    }

    @FXML
    private void handleGuardar() {
        String nombre = txtNombre.getText().trim();
        String correo = txtCorreo.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String password = txtPassword.getText().trim();
        String direccion = txtDireccion.getText().trim();

        if (nombre.isEmpty() || correo.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Los campos Nombre, Correo y Contraseña son obligatorios.");
            return;
        }

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setCorreo(correo);
        cliente.setTelefono(telefono);
        cliente.setContraseniaHash(password); // se encriptará en el servicio
        cliente.setDireccion(direccion);

        if (authService.registrarCliente(cliente)) {
            mostrarAlerta("Cliente registrado exitosamente.", Alert.AlertType.INFORMATION);
            limpiarCampos();
        } else {
            mostrarAlerta("Error al registrar. Verifique que el correo no esté duplicado.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleLimpiar() {
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        txtPassword.clear();
        txtDireccion.clear();
    }

    private void mostrarAlerta(String mensaje) {
        mostrarAlerta(mensaje, Alert.AlertType.WARNING);
    }

    private void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}