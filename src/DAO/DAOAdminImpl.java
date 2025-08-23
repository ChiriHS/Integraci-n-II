package DAO;

import Interfaces.DAOAdmin;
import Modelo.Usuario;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;


public class DAOAdminImpl extends Conexion implements DAOAdmin {
@Override
public void registrar(Usuario user) throws Exception {
    try {
        this.Conectar();
        String sql = "INSERT INTO Usuario (nombre, email, clave, rol) VALUES (?, ?, ?, ?)";
        PreparedStatement st = this.conexion.prepareStatement(sql);
        st.setString(1, user.getNombre());
        st.setString(2, user.getEmail());
        st.setString(3, user.getClave());
        st.setString(4, user.getRol());
        st.executeUpdate();
        st.close();
    } catch (Exception e) {
        throw e;
    } finally {
        this.cerrar();
    }
}

@Override
public void modificar(Usuario user) throws Exception {
    try {
        this.Conectar();
        String sql = "UPDATE Usuario SET nombre = ?, email = ?, clave = ?, rol = ? WHERE id = ?";
        PreparedStatement st = this.conexion.prepareStatement(sql);
        st.setString(1, user.getNombre());
        st.setString(2, user.getEmail());
        st.setString(3, user.getClave());
        st.setString(4, user.getRol());
        st.setInt(5, user.getId());
        st.executeUpdate();
        st.close();
    } catch (Exception e) {
        throw e;
    } finally {
        this.cerrar();
    }
}

@Override
public void eliminar(Usuario user) throws Exception {
    try {
        this.Conectar();
        String sql = "DELETE FROM Usuario WHERE id = ?";
        PreparedStatement st = this.conexion.prepareStatement(sql);
        st.setInt(1, user.getId());
        st.executeUpdate();
        st.close();
    } catch (Exception e) {
        throw e;
    } finally {
        this.cerrar();
    }
}

@Override
public List<Usuario> mostrar() throws Exception {
    List<Usuario> lista = new ArrayList<>();
    try {
        this.Conectar();
        String sql = "SELECT * FROM Usuario";
        PreparedStatement st = this.conexion.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Usuario user = new Usuario();
            user.setId(rs.getInt("id"));
            user.setNombre(rs.getString("nombre"));
            user.setEmail(rs.getString("email"));
            user.setClave(rs.getString("clave"));
            user.setRol(rs.getString("rol"));
            lista.add(user);
        }
        rs.close();
        st.close();
    } catch (Exception e) {
        throw e;
    } finally {
        this.cerrar();
    }
    return lista;
}

}
