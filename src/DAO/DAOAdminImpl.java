package DAO;

import Interfaces.DAOAdmin;
import Modelo.Usuario;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Statement;

public class DAOAdminImpl extends Conexion implements DAOAdmin {

    @Override
    public void registrar(Usuario user) throws Exception {
        try {
            this.Conectar();
            String sql = "INSERT INTO Usuario (nombre, email, clave, rol) VALUES (?, ?, ?, ?)";
            PreparedStatement st = this.conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, user.getNombre());
            st.setString(2, user.getEmail());
            st.setString(3, user.getClave());
            st.setString(4, user.getRol());
            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
            rs.close();
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
            String sql = "DELETE FROM usuario WHERE id = ?";
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setInt(1, user.getId());

            int filasAfectadas = st.executeUpdate();
            st.close();

            if (filasAfectadas == 0) {
                throw new Exception("No se pudo eliminar el usuario con ID: " + user.getId());
            }

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
            String sql = "SELECT * FROM usuario";
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

    public boolean existeUsuario(String nombre) throws SQLException {
        this.Conectar();
        String sql = "SELECT COUNT(*) FROM usuario WHERE nombre = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    public boolean existeEmail(String email) throws SQLException {
        this.Conectar();
        String sql = "SELECT COUNT(*) FROM usuario WHERE email = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    public List<String[]> inasistencias() throws Exception {
        List<String[]> lista = new ArrayList<>();
        this.Conectar();
        for (int i = 0; i < 7; i++) {
            LocalDate fecha = LocalDate.now().minusDays(i);
            String sql = "SELECT u.id, u.nombre "
                    + "FROM usuario u "
                    + "LEFT JOIN asistencia a ON u.id = a.UsuarioId AND DATE(a.HoraEntrada) = ? "
                    + "WHERE a.UsuarioId IS NULL;";
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, fecha.toString());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(new String[]{
                    rs.getString("id"),
                    rs.getString("nombre"),
                    fecha.toString()
                });
            }
            rs.close();
            st.close();
        }
        return lista;
    }

    public List<String[]> atrasos() throws Exception {
        List<String[]> lista = new ArrayList<>();
        try {
            this.Conectar();
            String sql = "SELECT u.id, u.nombre, DATE(a.HoraEntrada) AS fecha, "
                    + "TIME(A.HoraEntrada) AS hora "
                    + "FROM usuario u "
                    + "JOIN asistencia a ON u.id = a.UsuarioId "
                    + "WHERE DATE(a.HoraEntrada) <= CURDATE() AND TIME(a.HoraEntrada) > '09:30:00' ";
            PreparedStatement st = this.conexion.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(new String[]{
                    rs.getString("id"),
                    rs.getString("nombre"),
                    rs.getString("fecha")
                });
            }
            rs.close();
            st.close();
        } finally {
            this.cerrar();
        }
        return lista;
    }

    public List<String[]> salidaAnticipada() throws Exception {
        List<String[]> lista = new ArrayList<>();
        try {
            this.Conectar();
            String sql = "SELECT u.id, u.nombre, DATE(a.HoraSalida) AS fecha, "
                    + "TIME(a.HoraSalida) AS hora "
                    + "FROM usuario u "
                    + "JOIN asistencia a ON u.id = a.UsuarioId "
                    + "WHERE DATE(a.HoraEntrada) <= CURDATE() AND TIME(a.HoraSalida) < '17:30:00' ";
            PreparedStatement st = this.conexion.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(new String[]{
                    rs.getString("id"),
                    rs.getString("nombre"),
                    rs.getString("fecha")
                });
            }
            rs.close();
            st.close();
        } finally {
            this.cerrar();
        }
        return lista;
    }

}
