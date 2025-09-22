/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controlador;

import DAO.DAOAdminImpl;
import DAO.DAOAsistenciaImpl;
import Modelo.Asistencia;
import Modelo.Usuario;
import java.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NitroYayi
 */
public class ControladorAdminTest {

    DAOAdminImpl instance = new DAOAdminImpl();

    Usuario user = new Usuario();
    Asistencia asis = new Asistencia();

    public ControladorAdminTest() {
    }

    @Test
    public void testRegistrarUsuario() throws Exception {

        assertFalse(instance.existeUsuario("Yayi"));
        assertFalse(instance.existeUsuario("yayi@gmail.com"));

        user.setNombre("Yayi");
        user.setEmail("yayi@gmail.com");
        user.setClave("1234");
        user.setRol("USUARIO");
        instance.registrar(user);

        assertTrue(instance.existeUsuario("Yayi"));
        assertTrue(instance.existeEmail("yayi@gmail.com"));

        Usuario u = new Usuario();
        for (Usuario usu : instance.mostrar()) {
            if (usu.getId() == user.getId()) {
                u = usu;
                break;
            }
        }

        assertNotNull(u);
        assertEquals("Yayi", u.getNombre());
        assertEquals("yayi@gmail.com", u.getEmail());

        instance.eliminar(user);

        assertFalse(instance.existeUsuario("Yayi"));
        assertFalse(instance.existeEmail("yayi@gmail.com"));

    }

    @Test
    public void testModificarUsuario() throws Exception {
        assertFalse(instance.existeUsuario("Yayi"));
        assertFalse(instance.existeUsuario("yayi@gmail.com"));

        user.setNombre("Yayi");
        user.setEmail("yayi@gmail.com");
        user.setClave("1234");
        user.setRol("USUARIO");
        instance.registrar(user);

        assertTrue(instance.existeUsuario("Yayi"));
        assertTrue(instance.existeEmail("yayi@gmail.com"));

        user.setNombre("Yayo");
        user.setEmail("yayo@gmail.com");
        user.setClave("1234");
        user.setRol("USUARIO");
        instance.modificar(user);

        Usuario u = new Usuario();
        for (Usuario usu : instance.mostrar()) {
            if (usu.getId() == user.getId()) {
                u = usu;
                break;
            }
        }

        assertNotNull(u);
        assertEquals("Yayo", u.getNombre());
        assertEquals("yayo@gmail.com", u.getEmail());

        instance.eliminar(user);

        assertFalse(instance.existeUsuario("Yayo"));
        assertFalse(instance.existeEmail("yayo@gmail.com"));

    }

    @Test
    public void testEliminarUsuario() throws Exception {
        assertFalse(instance.existeUsuario("Yayi"));
        assertFalse(instance.existeUsuario("yayi@gmail.com"));

        user.setNombre("Yayi");
        user.setEmail("yayi@gmail.com");
        user.setClave("1234");
        user.setRol("USUARIO");
        instance.registrar(user);

        assertTrue(instance.existeUsuario("Yayi"));
        assertTrue(instance.existeEmail("yayi@gmail.com"));

        instance.eliminar(user);

        assertFalse(instance.existeUsuario("Yayi"));
        assertFalse(instance.existeEmail("yayi@gmail.com"));
    }

}
