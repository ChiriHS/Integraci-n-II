package Controlador;

import DAO.DAOAsistenciaImpl;
import Vistas.Admin;
import Vistas.User;

public class ControladorAsistencia {

    private Admin vista;
    private User vista2;
    private DAOAsistenciaImpl AsistenciaDAO;

    public ControladorAsistencia(Admin vista, User vista2, DAOAsistenciaImpl AsistenciaDAO) {
        this.vista = vista;
        this.vista2 = vista2;
        this.AsistenciaDAO = AsistenciaDAO;

        this.vista.btnEntrada.addActionListener(e -> marcarEntrada());
        this.vista.btnSalida.addActionListener(e -> marcarSalida());
        
        this.vista2.btnEntrada.addActionListener(e -> marcarEntrada());
        this.vista2.btnSalida.addActionListener(e -> marcarSalida());
        
    }
    
    public void marcarEntrada(){
        
    }
    
    public void marcarSalida(){
        
    }

}
