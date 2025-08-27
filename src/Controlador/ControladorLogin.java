package Controlador;

import DAO.Conexion;
import DAO.DAOAdminImpl;
import DAO.DAOAsistenciaImpl;
import Vistas.Admin;
import Vistas.Login2;
import Vistas.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControladorLogin {

    private Conexion conexion;
    private Login2 vista;

    Admin vistaA = new Admin();
    User vistaU = new User();

    public ControladorLogin(Login2 vista) {
        this.vista = vista;
        this.conexion = new Conexion();

        // Acción del botón de login
        this.vista.btnSesion.addActionListener(e -> {
            try {
                login();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vista, "Error al iniciar sesión: " + ex.getMessage());
            }
        });
    }

    public void login() throws Exception {
        String email = vista.txtEmail.getText().trim();
        char[] passwordArreglo = vista.pwdContra.getPassword();
        String clave = new String(passwordArreglo);

        if (email.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Debe ingresar correo y contraseña");
            return;
        }

        try {
            conexion.Conectar();
            String sql = "SELECT * FROM Usuario WHERE email = ? AND clave = ?";
            PreparedStatement st = conexion.Conectar().prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, clave);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String rol = rs.getString("rol");
                String nombre = rs.getString("nombre");
                String id = rs.getString("id");

                vista.setVisible(false); // ocultamos login

                switch (rol.toUpperCase()) {
                    case "ADMIN":

                        DAOAdminImpl daoAdmin = new DAOAdminImpl();
                        new ControladorAdmin(vistaA, daoAdmin);

                        DAOAsistenciaImpl daoAsistencia = new DAOAsistenciaImpl();
                        new ControladorAsistencia(vistaA, vistaU, daoAsistencia);

                        vistaA.lvlBienvenidoAdmin.setText(nombre);
                        vistaA.lvlBienvenidoID.setText(id);

                        JFrame frameAdmin = new JFrame("Panel Administrador");
                        frameAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frameAdmin.setSize(920, 650);
                        frameAdmin.setLocationRelativeTo(null);
                        frameAdmin.setContentPane(vistaA);
                        frameAdmin.setResizable(false);
                        frameAdmin.setVisible(true);
                        break;

                    case "USUARIO":
                        DAOAsistenciaImpl asistenciaDAO = new DAOAsistenciaImpl();
                        new ControladorAsistencia(vistaA, vistaU, asistenciaDAO);

                        vistaU.lvlBienvenidoNombre.setText(nombre);
                        vistaU.lvlBienvenidoID.setText(id);

                        JFrame frameUser = new JFrame("Panel Usuario");
                        frameUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frameUser.setSize(920, 650);
                        frameUser.setLocationRelativeTo(null);
                        frameUser.setContentPane(vistaU);
                        frameUser.setResizable(false);
                        frameUser.setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Rol desconocido: " + rol);
                        vista.setVisible(true); // volvemos al login
                        return;
                }

            } else {
                JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos");
            }

            rs.close();
            st.close();

        } finally {

        }
    }

}
