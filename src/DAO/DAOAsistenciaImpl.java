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
            String sql = "UPDATE Asistencia SET HoraSalida = ? WHERE UsuarioId = ? AND HoraSalida IS NULL";
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setTimestamp(1, java.sql.Timestamp.valueOf(asistencia.getHoraSalida()));
            st.setInt(2, asistencia.getUsuarioId());
            st.executeUpdate();
            st.close();
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
}
