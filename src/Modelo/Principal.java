package Modelo;

import Controlador.ControladorLogin;
import DAO.Conexion;
import Vistas.Login2;

public class Principal {

    public static void main(String[] args) {
        Conexion cone = new Conexion();
        cone.Conectar();
        Login2 vista = new Login2();
        new ControladorLogin(vista);
        vista.setVisible(true);

    }
}
