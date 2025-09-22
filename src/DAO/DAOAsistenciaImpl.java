package DAO;

import Interfaces.DAOAsistencia;
import Modelo.Asistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
