package Controlador;

import DAO.DAOAsistenciaImpl;
import Modelo.Asistencia;
import Vistas.Admin;
import Vistas.User;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class ControladorAsistencia {

    private Admin vista;
    //private User vista2;
    private DAOAsistenciaImpl AsistenciaDAO;

    public ControladorAsistencia(Admin vista, User vista2, DAOAsistenciaImpl AsistenciaDAO) {
        this.vista = vista;
        //this.vista2 = vista2;
        this.AsistenciaDAO = AsistenciaDAO;

        this.vista.btnEntrada.addActionListener(e -> marcarEntrada());
        this.vista.btnSalida.addActionListener(e -> marcarSalida());

        //this.vista2.btnEntrada.addActionListener(e -> marcarEntrada());
        //this.vista2.btnSalida.addActionListener(e -> marcarSalida());
    }

    public void marcarEntrada() {
        int id = Integer.parseInt((String) vista.lvlBienvenidoID.getText());
        LocalDateTime fechaHora = LocalDateTime.now();
        try {
            Asistencia a = new Asistencia();
            a.setUsuarioId(id);
            a.setHoraEntrada(fechaHora);

            AsistenciaDAO.entrada(a);
            JOptionPane.showMessageDialog(vista, "Entrada marcada correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error al marcar: " + e.getMessage());
        }
    }

    public void marcarSalida() {

        int id = Integer.parseInt((String) vista.lvlBienvenidoID.getText());
        LocalDateTime fechaHora = LocalDateTime.now();
        try {
            Asistencia a = new Asistencia();
            a.setUsuarioId(id);
            a.setHoraSalida(fechaHora);

            AsistenciaDAO.salida(a);
            JOptionPane.showMessageDialog(vista, "Salida marcada correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error al marcar: " + e.getMessage());
        }
    }

}


