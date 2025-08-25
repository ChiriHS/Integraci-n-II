package Modelo;

import Controlador.ControladorAdmin;
import DAO.Conexion;
import DAO.DAOAdminImpl;
import Vistas.Admin;

public class Principal {

    public static void main(String[] args) {        
        /*
        Asistencia asistencia = new Asistencia();
        asistencia.setUsuarioId(1);
        asistencia.setHoraSalida(LocalDateTime.now());
        
        try {
            DAOAsistencia asis = new DAOAsistenciaImpl();
            asis.salida(asistencia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
         */
 /*
        Admin vista = new Admin();          // 1. instanciar vista
        DAOAdminImpl dao = new DAOAdminImpl();  // 2. instanciar DAO
        ControladorAdmin controller = new ControladorAdmin(vista, dao); // 3. pasar vista al controlador

        Conexion obj_conexion = new Conexion();
        obj_conexion.Conectar();

        JFrame frame = new JFrame("Panel Login - Prueba");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(vista);
        frame.setVisible(true);
         */
    }
}
