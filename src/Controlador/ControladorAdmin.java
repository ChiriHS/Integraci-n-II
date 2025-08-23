package Controlador;

import Vistas.Admin;
import DAO.DAOAdminImpl;
import Modelo.Usuario;
import javax.swing.*;
import java.util.List;

public class ControladorAdmin {

    private Admin vista;
    private DAOAdminImpl usuarioDAO;

    public ControladorAdmin(Admin vista, DAOAdminImpl usuarioDAO) {
        this.vista = vista;
        this.usuarioDAO = usuarioDAO;

        // Eventos de los botones
        this.vista.btnRegistrar.addActionListener(e -> registrarUsuario());
        this.vista.btnModificar.addActionListener(e -> modificarUsuario());
        this.vista.btnEliminar.addActionListener(e -> eliminarUsuario());
        this.vista.btnBuscar.addActionListener(e -> buscarUsuario());
        this.vista.btnLimpiar.addActionListener(e -> limpiarCampos());

        cargarUsuariosEnCombo();
    }


    public void registrarUsuario() {
        try {
            Usuario u = new Usuario();
            u.setNombre(vista.txtNombre.getText());
            u.setEmail(vista.txtEmail.getText());
            u.setClave(new String(vista.txtClave.getPassword()));
            u.setRol((String) vista.cmbRol.getSelectedItem());

            usuarioDAO.registrar(u);
            JOptionPane.showMessageDialog(vista, "Usuario registrado correctamente");
            limpiarCampos();
            cargarUsuariosEnCombo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al registrar: " + ex.getMessage());
        }
    }

    public void modificarUsuario() {
        try {
            Usuario u = new Usuario();
            u.setId(Integer.parseInt((String) vista.cmbID.getSelectedItem()));
            u.setNombre(vista.txtNombre.getText());
            u.setEmail(vista.txtEmail.getText());
            u.setClave(new String(vista.txtClave.getPassword()));
            u.setRol((String) vista.cmbRol.getSelectedItem());

            usuarioDAO.modificar(u);
            JOptionPane.showMessageDialog(vista, "Usuario modificado correctamente");
            limpiarCampos();
            cargarUsuariosEnCombo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al modificar: " + ex.getMessage());
        }
    }

    public void eliminarUsuario() {
        try {
            int id = Integer.parseInt((String) vista.cmbID.getSelectedItem());
            Usuario u = new Usuario();
            u.setId(id);

            usuarioDAO.eliminar(u);
            JOptionPane.showMessageDialog(vista, "Usuario eliminado correctamente");
            limpiarCampos();
            cargarUsuariosEnCombo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al eliminar: " + ex.getMessage());
        }
    }

    public void buscarUsuario() {
        try {
            int id = Integer.parseInt((String) vista.cmbID.getSelectedItem());
            List<Usuario> lista = usuarioDAO.mostrar();
            for (Usuario u : lista) {
                if (u.getId() == id) {
                    vista.txtNombre.setText(u.getNombre());
                    vista.txtEmail.setText(u.getEmail());
                    vista.txtClave.setText(u.getClave());
                    vista.cmbRol.setSelectedItem(u.getRol());
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al buscar: " + ex.getMessage());
        }
    }

    public void limpiarCampos() {
        vista.txtNombre.setText("");
        vista.txtEmail.setText("");
        vista.txtClave.setText("");
        vista.cmbRol.setSelectedIndex(0);
    }

    public void cargarUsuariosEnCombo() {
        try {
            vista.cmbID.removeAllItems();
            List<Usuario> lista = usuarioDAO.mostrar();
            for (Usuario u : lista) {
                vista.cmbID.addItem(String.valueOf(u.getId()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error cargando IDs: " + e.getMessage());
        }
    }
  
}

