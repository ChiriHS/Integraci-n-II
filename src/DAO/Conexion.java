package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String bd = "marcajeasistencia";
    private static final String url = "jdbc:mysql://localhost:3306/" + bd;
    private static final String usuario = "root";
    private static final String clave = "";
    Connection conexion = null;

    public Connection Conectar() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexion exitosa con: " + bd);
        } catch (ClassNotFoundException | SQLException error_conexion) {
            System.out.println("Error al conectar: " + error_conexion.getMessage());
        }
        return conexion;
    }

    public void cerrar() {
        try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException error_conexion) {
            System.err.println("Error al cerrar la conexión: " + error_conexion.getMessage());
        }
    }

    public String get_BD() {
        return bd;
    }
};
