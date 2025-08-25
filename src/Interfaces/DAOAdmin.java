
package Interfaces;

import Modelo.Usuario;
import java.util.List;


public interface DAOAdmin {
    public void registrar (Usuario user) throws Exception;
    public void modificar (Usuario user) throws Exception;
    public void eliminar (Usuario user) throws Exception;
    public List<Usuario>  mostrar() throws Exception;


    

}
