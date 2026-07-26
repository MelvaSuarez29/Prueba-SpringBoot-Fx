package com.epn.loginhash.dao;

import com.epn.loginhash.model.Cliente;
import java.sql.*;
import java.util.Optional;

public class ClienteDAO {
    private static final String URL = "jdbc:mysql://localhost:3307/login_hash";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // cambia según tu configuración

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public boolean existeUsuario(String correo) {
        String sql = "SELECT COUNT(*) FROM clientes WHERE correo = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Optional<Cliente> buscarPorUsuario(String correo) {
        String sql = "SELECT * FROM clientes WHERE correo = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setCorreo(rs.getString("correo"));
                c.setTelefono(rs.getString("telefono"));
                c.setContraseniaHash(rs.getString("contrasena_hash"));
                c.setDireccion(rs.getString("direccion"));
                c.setRol(rs.getString("rol"));
                return Optional.of(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean guardar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, correo, telefono, contrasena_hash, direccion, rol) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getContraseniaHash());
            ps.setString(5, cliente.getDireccion());
            ps.setString(6, cliente.getRol() != null ? cliente.getRol() : "Cliente");
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}