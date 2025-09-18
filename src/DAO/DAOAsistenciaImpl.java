package DAO;

import Interfaces.DAOAsistencia;
import Modelo.Asistencia;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.*;

public class DAOAsistenciaImpl extends Conexion implements DAOAsistencia {

    @Override
    public void entrada(Asistencia asistencia) throws Exception {
        if (asistencia.getHoraEntrada() == null) {
            throw new Exception("Hora de entrada no puede ser null");
        }
        try {
            this.Conectar();
            String checkSql = "SELECT COUNT(*) FROM asistencia WHERE UsuarioId = ? AND DATE(HoraEntrada) = CURRENT_DATE";
            PreparedStatement checkSt = this.conexion.prepareStatement(checkSql);
            checkSt.setInt(1, asistencia.getUsuarioId());
            ResultSet rs = checkSt.executeQuery();

            rs.next();
            int count = rs.getInt(1);
            rs.close();
            checkSt.close();

            if (count > 0) {
                throw new Exception("Ya marcaste entrada hoy");
            }

            String sql = "INSERT INTO Asistencia (UsuarioId, HoraEntrada) VALUES (?, ?)";
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setInt(1, asistencia.getUsuarioId());
            st.setTimestamp(2, java.sql.Timestamp.valueOf(asistencia.getHoraEntrada()));
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void salida(Asistencia asistencia) throws Exception {
        if (asistencia.getHoraSalida() == null) {
            throw new Exception("Hora de salida no puede ser null");
        }
        try {
            this.Conectar();
            String sql = "UPDATE Asistencia SET HoraSalida = ? "
                    + "WHERE UsuarioId = ? AND DATE(HoraEntrada) = CURRENT_DATE AND HoraSalida IS NULL";
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setTimestamp(1, java.sql.Timestamp.valueOf(asistencia.getHoraSalida()));
            st.setInt(2, asistencia.getUsuarioId());

            int filasActualizadas = st.executeUpdate();
            st.close();

            if (filasActualizadas == 0) {
                throw new Exception("Todavia no marcas entrada o ya marcaste salida hoy");
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<Asistencia> mostrar() throws Exception {
        List<Asistencia> lista = new ArrayList<>();
        String sql = "SELECT UsuarioId, HoraEntrada, HoraSalida FROM Asistencia ORDER BY HoraEntrada DESC";

        try (PreparedStatement ps = conexion.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Asistencia a = new Asistencia();
                a.setUsuarioId(rs.getInt("UsuarioId"));

                Timestamp tsEntrada = rs.getTimestamp("HoraEntrada");
                if (tsEntrada != null) {
                    a.setHoraEntrada(tsEntrada.toLocalDateTime());
                }

                Timestamp tsSalida = rs.getTimestamp("HoraSalida");
                if (tsSalida != null) {
                    a.setHoraSalida(tsSalida.toLocalDateTime());
                }

                lista.add(a);
            }
        }

        return lista;
    }

    public boolean tieneEntradaHoy(int usuarioId) throws Exception {
        try {
            this.Conectar();
            String sql = "SELECT COUNT(*) FROM asistencia "
                    + "WHERE UsuarioId = ? AND DATE(HoraEntrada) = CURDATE()";
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setInt(1, usuarioId);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public boolean tieneSalidaHoy(int usuarioId) throws Exception {
        try {
            this.Conectar();
            String sql = "SELECT COUNT(*) FROM asistencia "
                    + "WHERE UsuarioId = ? AND DATE(HoraEntrada) = CURDATE() AND HoraSalida IS NOT NULL";
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setInt(1, usuarioId);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

}
