/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import Modelo.Asistencia;
import Modelo.Usuario;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NitroYayi
 */
public class DAOAsistenciaImplTest {

    public DAOAsistenciaImplTest() {
    }

    DAOAsistenciaImpl instance2 = new DAOAsistenciaImpl();
    DAOAdminImpl instance1 = new DAOAdminImpl();

    Usuario user = new Usuario();
    Asistencia asis = new Asistencia();

    @Test
    public void testEntrada() throws Exception {

        assertFalse(instance1.existeUsuario("Yayi"));
        assertFalse(instance1.existeUsuario("yayi@gmail.com"));

        user.setNombre("Yayi");
        user.setEmail("yayi@gmail.com");
        user.setClave("1234");
        user.setRol("USUARIO");
        instance1.registrar(user);

        assertTrue(instance1.existeUsuario("Yayi"));
        assertTrue(instance1.existeEmail("yayi@gmail.com"));

        asis.setUsuarioId(user.getId());
        asis.setHoraEntrada(LocalDateTime.now());
        instance2.entrada(asis);

        assertTrue(instance2.tieneEntradaHoy(user.getId()));
        assertFalse(instance2.tieneSalidaHoy(user.getId()));

        instance1.eliminar(user);

        assertFalse(instance1.existeUsuario("Yayi"));
        assertFalse(instance1.existeEmail("yayi@gmail.com"));

    }

    @Test
    public void testSalida() throws Exception {

        assertFalse(instance1.existeUsuario("Yayi"));
        assertFalse(instance1.existeEmail("yayi@gmail.com"));

        user.setNombre("Yayi");
        user.setEmail("yayi@gmail.com");
        user.setClave("1234");
        user.setRol("USUARIO");
        instance1.registrar(user);

        assertTrue(instance1.existeUsuario("Yayi"));
        assertTrue(instance1.existeEmail("yayi@gmail.com"));

        asis.setUsuarioId(user.getId());
        asis.setHoraEntrada(LocalDateTime.now());
        instance2.entrada(asis);

        assertTrue(instance2.tieneEntradaHoy(user.getId()));
        assertFalse(instance2.tieneSalidaHoy(user.getId()));

        asis.setUsuarioId(user.getId());
        asis.setHoraSalida(LocalDateTime.now());
        instance2.salida(asis);

        assertTrue(instance2.tieneSalidaHoy(user.getId()));

        instance1.eliminar(user);

        assertFalse(instance1.existeUsuario("Yayi"));
        assertFalse(instance1.existeEmail("yayi@gmail.com"));

    }

    @Test
    public void testTieneEntradaHoy() throws Exception {

        assertFalse(instance1.existeUsuario("Yayi"));
        assertFalse(instance1.existeEmail("yayi@gmail.com"));

        user.setNombre("Yayi");
        user.setEmail("yayi@gmail.com");
        user.setClave("1234");
        user.setRol("USUARIO");
        instance1.registrar(user);

        assertTrue(instance1.existeUsuario("Yayi"));
        assertTrue(instance1.existeEmail("yayi@gmail.com"));
        
        asis.setUsuarioId(user.getId());
        asis.setHoraEntrada(LocalDateTime.now());
        instance2.entrada(asis);

        assertTrue(instance2.tieneEntradaHoy(user.getId()));
        assertFalse(instance2.tieneSalidaHoy(user.getId()));

        instance1.eliminar(user);

        assertFalse(instance1.existeUsuario("Yayi"));
        assertFalse(instance1.existeEmail("yayi@gmail.com"));

    }

    @Test
    public void testTieneSalidaHoy() throws Exception {
        assertFalse(instance1.existeUsuario("Yayi"));
        assertFalse(instance1.existeEmail("yayi@gmail.com"));

        user.setNombre("Yayi");
        user.setEmail("yayi@gmail.com");
        user.setClave("1234");
        user.setRol("USUARIO");
        instance1.registrar(user);
        
        assertTrue(instance1.existeUsuario("Yayi"));
        assertTrue(instance1.existeEmail("yayi@gmail.com"));

        asis.setUsuarioId(user.getId());
        asis.setHoraEntrada(LocalDateTime.now());
        instance2.entrada(asis);
        
        assertTrue(instance2.tieneEntradaHoy(user.getId()));
        assertFalse(instance2.tieneSalidaHoy(user.getId()));

        asis.setUsuarioId(user.getId());
        asis.setHoraSalida(LocalDateTime.now());
        instance2.salida(asis);

        assertTrue(instance2.tieneSalidaHoy(user.getId()));
        assertTrue(instance2.tieneEntradaHoy(user.getId()));

        instance1.eliminar(user);

        assertFalse(instance1.existeUsuario("Yayi"));
        assertFalse(instance1.existeEmail("yayi@gmail.com"));
    }

}
