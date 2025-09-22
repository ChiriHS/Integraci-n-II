
package Interfaces;

import Modelo.Asistencia;

public interface DAOAsistencia {
    
    public void entrada(Asistencia asistencia) throws Exception;
    public void salida(Asistencia asistencia) throws Exception;
}
