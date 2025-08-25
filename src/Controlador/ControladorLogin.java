package Controlador;

import DAO.Conexion;
import Modelo.Usuario;
import Vistas.Login2;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControladorLogin {

    Conexion conexion = new Conexion();
    
    public Usuario login(String email, String clave) throws Exception {
        Usuario usuario = null;
        try {
            conexion.Conectar();
            String sql = "SELECT * FROM Usuario WHERE email = ? AND clave = ?";
            PreparedStatement st = conexion.Conectar().prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, clave);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setClave(rs.getString("clave"));
                usuario.setRol(rs.getString("rol"));

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            conexion.cerrar();
        }
        return usuario;
    }

}
