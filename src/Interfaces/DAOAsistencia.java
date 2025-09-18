
package Interfaces;

import Modelo.Asistencia;
import java.util.List;

public interface DAOAsistencia {
    
    public void entrada(Asistencia asistencia) throws Exception;
    public void salida(Asistencia asistencia) throws Exception;
    public List<Asistencia>  mostrar() throws Exception;
}
