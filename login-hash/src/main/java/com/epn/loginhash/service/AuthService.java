package com.epn.loginhash.service;

import com.epn.loginhash.dao.ClienteDAO;
import com.epn.loginhash.model.Cliente;
import java.util.Optional;

public class AuthService {
    private final ClienteDAO clienteDAO;

    public AuthService() {
        this.clienteDAO = new ClienteDAO();
    }

    public boolean autenticarAdministrador(String correo, String password) {
        System.out.println("Buscando usuario: " + correo);
        Optional<Cliente> optional = clienteDAO.buscarPorUsuario(correo);
        if (optional.isEmpty()) {
            System.out.println("Usuario NO encontrado");
            return false;
        }
        Cliente cliente = optional.get();
        System.out.println("Usuario encontrado: " + cliente.getCorreo());
        System.out.println("Rol: " + cliente.getRol());
        System.out.println("Hash almacenado: " + cliente.getContraseniaHash());
        boolean match = PasswordUtil.checkPassword(password, cliente.getContraseniaHash());
        System.out.println("¿Coinciden? " + match);
        return match && "Administrador".equals(cliente.getRol());
    }

    public boolean registrarCliente(Cliente cliente) {
        if (cliente == null) return false;
        // Validaciones básicas
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty() ||
                cliente.getCorreo() == null || cliente.getCorreo().trim().isEmpty() ||
                cliente.getContraseniaHash() == null || cliente.getContraseniaHash().trim().isEmpty()) {
            return false;
        }
        if (clienteDAO.existeUsuario(cliente.getCorreo())) {
            return false;
        }
        // Encriptar contraseña
        String hash = PasswordUtil.hashPassword(cliente.getContraseniaHash());
        cliente.setContraseniaHash(hash);
        // Asignar rol por defecto
        cliente.setRol("Cliente");
        return clienteDAO.guardar(cliente);
    }
}