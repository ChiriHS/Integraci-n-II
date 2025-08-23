package Modelo;

import Controlador.ControladorAdmin;
import DAO.Conexion;
import DAO.DAOAdminImpl;
import Vistas.Admin;
import javax.swing.JFrame;

public class Principal {

    public static void main(String[] args) {

        Admin vista = new Admin();          // 1. instanciar vista
        DAOAdminImpl dao = new DAOAdminImpl();  // 2. instanciar DAO
        ControladorAdmin controller = new ControladorAdmin(vista, dao); // 3. pasar vista al controlador

        Conexion obj_conexion = new Conexion();
        obj_conexion.Conectar();

        JFrame frame = new JFrame("Panel Admin - Prueba");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(vista);
        frame.setVisible(true);
    }
}
