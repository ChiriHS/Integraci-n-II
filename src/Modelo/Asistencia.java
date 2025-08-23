package Modelo;

import java.time.LocalDateTime;

public class Asistencia {
    private int Id;
    private int UsuarioId;
    private LocalDateTime HoraEntrada;
    private LocalDateTime HoraSalida;

    public Asistencia() {
    }

    public Asistencia(int Id, int UsuarioId, LocalDateTime HoraEntrada, LocalDateTime HoraSalida) {
        this.Id = Id;
        this.UsuarioId = UsuarioId;
        this.HoraEntrada = HoraEntrada;
        this.HoraSalida = HoraSalida;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getUsuarioId() {
        return UsuarioId;
    }

    public void setUsuarioId(int UsuarioId) {
        this.UsuarioId = UsuarioId;
    }

    public LocalDateTime getHoraEntrada() {
        return HoraEntrada;
    }

    public void setHoraEntrada(LocalDateTime HoraEntrada) {
        this.HoraEntrada = HoraEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(LocalDateTime HoraSalida) {
        this.HoraSalida = HoraSalida;
    }
    
    

    
}
