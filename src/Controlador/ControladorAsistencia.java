package Controlador;

import DAO.DAOAsistenciaImpl;
import Modelo.Asistencia;
import Vistas.Admin;
import Vistas.Login2;
import Vistas.User;
import java.time.LocalDateTime;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControladorAsistencia {

    private Admin vista;
    private User vista2;
    private DAOAsistenciaImpl AsistenciaDAO;
    private JFrame frameUser;
    
    Asistencia a = new Asistencia();

    public ControladorAsistencia(Admin vista, User vista2, DAOAsistenciaImpl AsistenciaDAO, JFrame frameUser) {
        this.vista = vista;
        this.vista2 = vista2;
        this.AsistenciaDAO = AsistenciaDAO;
        this.frameUser = frameUser;

        this.vista.btnEntrada.addActionListener(e -> marcarEntrada());
        this.vista.btnSalida.addActionListener(e -> marcarSalida());

        this.vista2.btnEntrada.addActionListener(e -> marcarEntrada2());
        this.vista2.btnSalida.addActionListener(e -> marcarSalida2());
        
        this.vista2.btnCerrarSesion2.addActionListener(e -> CerrarSesion());
    }
    
    public void CerrarSesion() {
        int confirmar = JOptionPane.showConfirmDialog(frameUser,
                "¿Desea cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            frameUser.dispose();
            Login2 login = new Login2();
            ControladorLogin controladorLogin = new ControladorLogin(login);
            login.setVisible(true);
        }
    }


    public void marcarEntrada() {
        int id = Integer.parseInt(vista.lvlBienvenidoID.getText());
        LocalDateTime fechaHora = LocalDateTime.now();
        try {
            a.setUsuarioId(id);
            a.setHoraEntrada(fechaHora);

            AsistenciaDAO.entrada(a);
            JOptionPane.showMessageDialog(vista, "Entrada marcada correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, e.getMessage());
        }
    }

    public void marcarSalida() {
        int id = Integer.parseInt(vista.lvlBienvenidoID.getText());
        LocalDateTime fechaHora = LocalDateTime.now();
        try {
            a.setUsuarioId(id);
            a.setHoraSalida(fechaHora);

            AsistenciaDAO.salida(a);
            JOptionPane.showMessageDialog(vista, "Salida marcada correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, e.getMessage());
        }
    }

    
    public void marcarEntrada2() {
        int id = Integer.parseInt(vista2.lvlBienvenidoID.getText());
        LocalDateTime fechaHora = LocalDateTime.now();
        try {
            a.setUsuarioId(id);
            a.setHoraEntrada(fechaHora);

            AsistenciaDAO.entrada(a);
            JOptionPane.showMessageDialog(vista2, "Entrada marcada correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista2, e.getMessage());
        }
    }

    public void marcarSalida2() {
        int id = Integer.parseInt(vista2.lvlBienvenidoID.getText());
        LocalDateTime fechaHora = LocalDateTime.now();
        try {
            a.setUsuarioId(id);
            a.setHoraSalida(fechaHora);

            AsistenciaDAO.salida(a);
            JOptionPane.showMessageDialog(vista2, "Salida marcada correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista2, e.getMessage());
        }
    }
}   

