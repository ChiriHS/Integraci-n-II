/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import Modelo.Usuario;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NitroYayi
 */
public class DAOAdminImplTest {

    public DAOAdminImplTest() {
    }

    DAOAdminImpl instance = new DAOAdminImpl();
    Usuario user = new Usuario();

    @Test
    public void testRegistrar() throws Exception {
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

    @Test
    public void testModificar() throws Exception {

        assertFalse(instance.existeUsuario("Yayi"));
        assertFalse(instance.existeEmail("yayi@gmail.com"));

        user.setNombre("Yayi");
        user.setEmail("yayi@gmail.com");
        user.setClave("1234");
        user.setRol("USUARIO");
        instance.registrar(user);

        assertTrue(instance.existeUsuario("Yayi"));
        assertTrue(instance.existeEmail("yayi@gmail.com"));

        List<Usuario> lista = instance.mostrar();
        int idRegistrado = -1;
        for (Usuario u : lista) {
            if (u.getNombre().equals("Yayi")) {
                idRegistrado = u.getId();
                break;
            }
        }
        user.setId(idRegistrado);
        user.setNombre("Yayo");
        user.setEmail("yayo@gmail.com");
        user.setClave("1234");
        user.setRol("USUARIO");
        instance.modificar(user);

        assertTrue(instance.existeUsuario("Yayo"));
        assertTrue(instance.existeEmail("yayo@gmail.com"));

        instance.eliminar(user);

        assertFalse(instance.existeUsuario("Yayo"));
        assertFalse(instance.existeEmail("yayo@gmail.com"));

    }

    @Test
    public void testEliminar() throws Exception {

        assertFalse(instance.existeUsuario("Yayi"));
        assertFalse(instance.existeEmail("yayi@gmail.com"));

        user.setNombre("Yayi");
        user.setEmail("yayi@gmail.com");
        user.setClave("1234");
        user.setRol("USUARIO");
        instance.registrar(user);

        assertTrue(instance.existeUsuario("Yayi"));
        assertTrue(instance.existeEmail("yayi@gmail.com"));

        List<Usuario> lista = instance.mostrar();
        int idRegistrado = -1;
        for (Usuario u : lista) {
            if (u.getNombre().equals("Yayi")) {
                idRegistrado = u.getId();
                break;
            }
        }
        user.setId(idRegistrado);
        instance.eliminar(user);

        assertFalse(instance.existeUsuario("Yayi"));
        assertFalse(instance.existeEmail("yayi@gmail.com"));

    }

    @Test
    public void testMostrar() throws Exception {
        List<Usuario> lista = instance.mostrar();

        assertNotNull(lista);

        assertTrue(lista.size() >= 0);
    }

    @Test
    public void testExisteUsuarioYEmail() throws Exception {
        assertFalse(instance.existeUsuario("Yayi"));
        assertFalse(instance.existeEmail("yayi@gmail.com"));

        user.setNombre("Yayi");
        user.setEmail("yayi@gmail.com");
        user.setClave("1234");
        user.setRol("USUARIO");
        instance.registrar(user);

        assertTrue(instance.existeUsuario("Yayi"));
        assertFalse(instance.existeUsuario("No Existe"));

        assertTrue(instance.existeEmail("yayi@gmail.com"));
        assertFalse(instance.existeEmail("No Existe"));

        instance.eliminar(user);

        assertFalse(instance.existeUsuario("Yayi"));
        assertFalse(instance.existeEmail("yayi@gmail.com"));

    }
}
