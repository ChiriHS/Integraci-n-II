package Controlador;

import Vistas.Admin;
import Vistas.Login2;
import Vistas.Reportes;
import Vistas.ReportesGeneral;
import DAO.DAOAdminImpl;
import Modelo.Usuario;
import javax.swing.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import java.io.FileOutputStream;

public class ControladorAdmin {

    private Admin vista;
    public Reportes vista4;
    public ReportesGeneral vista3;
    private DAOAdminImpl usuarioDAO;
    Usuario u = new Usuario();

    private JFrame frameAdmin;

    public ControladorAdmin(Admin vista, DAOAdminImpl usuarioDAO, JFrame frameAdmin, ReportesGeneral vista3, Reportes vista4) {
        this.vista = vista;
        this.usuarioDAO = usuarioDAO;
        this.frameAdmin = frameAdmin;
        this.vista3 = new ReportesGeneral();
        this.vista4 = new Reportes();

        this.vista.btnRegistrar.addActionListener(e -> registrarUsuario());
        this.vista.btnModificar.addActionListener(e -> modificarUsuario());
        this.vista.btnEliminar.addActionListener(e -> eliminarUsuario());
        this.vista.btnBuscar.addActionListener(e -> buscarUsuario());
        this.vista.btnLimpiar.addActionListener(e -> limpiarCampos());
        this.vista.btnCerrarSesion.addActionListener(e -> CerrarSesion());
        this.vista.btnReporte.addActionListener(e -> irReportesG());

        this.vista3.btnVerDetalles.addActionListener(e -> irReportes());
        this.vista3.btnVolver2.addActionListener(e -> volver1());
        this.vista3.btnGenerarReporte4.addActionListener(e -> generarReporteGeneralPDF());

        this.vista4.btnVolver.addActionListener(e -> volver2());
        this.vista4.btnGenerarReporte.addActionListener(e -> generarReporteInasistenciaPDF());
        this.vista4.btnGenerarReporte2.addActionListener(e -> generarReporteAtrasosPDF());
        this.vista4.btnGenerarReporte3.addActionListener(e -> generarReporteSalidasAntPDF());

        vista.cmbRol.setSelectedItem("USUARIO");

        cargarUsuariosEnCombo();
    }

    public void CerrarSesion() {
        int confirmar = JOptionPane.showConfirmDialog(frameAdmin,
                "¿Desea cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            frameAdmin.setVisible(false);
            Login2 login = new Login2();
            ControladorLogin controladorLogin = new ControladorLogin(login);
            login.setVisible(true);
        }
    }

    public void irReportesG() {
        frameAdmin.setVisible(false);
        vista3.setVisible(true);
        cargarReporteGeneral();
    }

    public void irReportes() {
        vista3.setVisible(false);
        vista4.setVisible(true);
        cargarInasistencias();
        cargarAtrasos();
        cargarSalidasAnticipadas();
    }

    public void volver1() {
        vista3.setVisible(false);
        frameAdmin.setVisible(true);
    }

    public void volver2() {
        vista4.setVisible(false);
        vista3.setVisible(true);
    }

    public void registrarUsuario() {
        try {
            String nombre = vista.txtNombre.getText().trim();
            String email = vista.txtEmail.getText().trim();
            String clave = new String(vista.txtClave.getPassword()).trim();
            String rol = (String) vista.cmbRol.getSelectedItem();

            if (nombre.isEmpty() || email.isEmpty() || clave.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios");
                return;
            }

            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                JOptionPane.showMessageDialog(vista, "Ingrese un correo válido");
                return;
            }

            if (usuarioDAO.existeUsuario(nombre)) {
                JOptionPane.showMessageDialog(vista, "Ya existe un usuario con ese nombre");
                return;
            }
            if (usuarioDAO.existeEmail(email)) {
                JOptionPane.showMessageDialog(vista, "Ya existe un usuario con ese email");
                return;
            }

            if ("ADMIN".equals(rol)) {
                int confirmar = JOptionPane.showConfirmDialog(
                        vista,
                        "¿Seguro que quieres registrarlo como ADMIN?",
                        "Confirmar Rol",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
                if (confirmar != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            u.setNombre(nombre);
            u.setEmail(email);
            u.setClave(clave);
            u.setRol(rol);

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
            String nombre = vista.txtNombre.getText().trim();
            String email = vista.txtEmail.getText().trim();
            String clave = new String(vista.txtClave.getPassword()).trim();
            String rol = (String) vista.cmbRol.getSelectedItem();

            if (nombre.isEmpty() || email.isEmpty() || clave.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios");
                return;
            }
            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                JOptionPane.showMessageDialog(vista, "Ingrese un correo válido");
                return;
            }
            
            if ("ADMIN".equals(rol)) {
                int confirmar = JOptionPane.showConfirmDialog(
                        vista,
                        "¿Quieres modificar el Rol como ADMIN?",
                        "Confirmar Rol",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
                if (confirmar != JOptionPane.YES_OPTION) {
                    return;
                }
            }
            
            int confirmar = JOptionPane.showConfirmDialog(
                    vista,
                    "¿Seguro que quieres Modificarlo?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
            if (confirmar != JOptionPane.YES_OPTION) {
                return;
            }
            u.setId(Integer.parseInt((String) vista.cmbID.getSelectedItem()));
            u.setNombre(nombre);
            u.setEmail(email);
            u.setClave(clave);
            u.setRol(rol);

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
            String nombre = vista.txtNombre.getText().trim();
            String email = vista.txtEmail.getText().trim();
            String clave = new String(vista.txtClave.getPassword()).trim();

            if (nombre.isEmpty() || email.isEmpty() || clave.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios");
                return;
            }
            int confirmar = JOptionPane.showConfirmDialog(
                    vista,
                    "¿Seguro que quieres Eliminarlo?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
            if (confirmar != JOptionPane.YES_OPTION) {
                return;
            }
            u.setId(Integer.parseInt((String) vista.cmbID.getSelectedItem()));

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
        vista.cmbRol.setSelectedItem("USUARIO");
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

    public void cargarReporteGeneral() {
        try {
            List<String[]> listaInasistencias = usuarioDAO.inasistencias();
            List<String[]> listaAtrasos = usuarioDAO.atrasos();
            List<String[]> listaSalidas = usuarioDAO.salidaAnticipada();

            Map<String, int[]> resumen = new HashMap<>();
            Map<String, String> nombres = new HashMap<>();

            for (String[] r : listaInasistencias) {
                String id = r[0];
                String nombre = r[1];
                resumen.putIfAbsent(id, new int[3]);
                nombres.putIfAbsent(id, nombre);
                resumen.get(id)[0]++;
            }

            for (String[] r : listaAtrasos) {
                String id = r[0];
                String nombre = r[1];
                resumen.putIfAbsent(id, new int[3]);
                nombres.putIfAbsent(id, nombre);
                resumen.get(id)[1]++;
            }

            for (String[] r : listaSalidas) {
                String id = r[0];
                String nombre = r[1];
                resumen.putIfAbsent(id, new int[3]);
                nombres.putIfAbsent(id, nombre);
                resumen.get(id)[2]++;
            }

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Usuario");
            model.addColumn("Nombre");
            model.addColumn("Inasistencias");
            model.addColumn("Atrasos");
            model.addColumn("Salidas Anticipadas");

            for (String id : resumen.keySet()) {
                int[] valores = resumen.get(id);
                model.addRow(new Object[]{
                    id,
                    nombres.get(id),
                    valores[0],
                    valores[1],
                    valores[2]
                });
            }

            vista3.jtGeneral.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista3, "Error cargando reporte general: " + e.getMessage());
        }
    }

    public void cargarInasistencias() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Usuario");
            model.addColumn("Nombre");
            model.addColumn("Fecha");

            for (String[] fila : usuarioDAO.inasistencias()) {
                model.addRow(fila);
            }
            vista4.jtInasistencia.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista4, "Error cargando inasistencias: " + e.getMessage());
        }
    }

    public void cargarAtrasos() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Usuario");
            model.addColumn("Nombre");
            model.addColumn("Fecha");

            for (String[] fila : usuarioDAO.atrasos()) {
                model.addRow(fila);
            }
            vista4.jtAtrasos.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista4, "Error cargando atrasos: " + e.getMessage());
        }
    }

    public void cargarSalidasAnticipadas() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Usuario");
            model.addColumn("Nombre");
            model.addColumn("Fecha");
            for (String[] fila : usuarioDAO.salidaAnticipada()) {
                model.addRow(fila);
            }
            vista4.jtAdelantos.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista4, "Error cargando salidas anticipadas: " + e.getMessage());
        }
    }

    public void generarReporteGeneralPDF() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) vista3.jtGeneral.getModel();
            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(vista3, "No hay datos para exportar");
                return;
            }
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF");
            fileChooser.setSelectedFile(new java.io.File("ReporteGeneral.pdf"));

            int userSelection = fileChooser.showSaveDialog(vista3);
            if (userSelection != JFileChooser.APPROVE_OPTION) {
                return;
            }

            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(ruta));
            document.open();

            document.add(new Paragraph("\t\tReporte General\n\n"));
            PdfPTable table = new PdfPTable(modelo.getColumnCount());

            for (int i = 0; i < modelo.getColumnCount(); i++) {
                table.addCell(modelo.getColumnName(i));
            }

            for (int i = 0; i < modelo.getRowCount(); i++) {
                for (int j = 0; j < modelo.getColumnCount(); j++) {
                    table.addCell(modelo.getValueAt(i, j).toString());
                }
            }

            document.add(table);
            document.close();

            JOptionPane.showMessageDialog(vista3, "PDF generado correctamente en: " + ruta);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista3, "Error al generar PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void generarReporteInasistenciaPDF() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) vista4.jtInasistencia.getModel();
            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(vista4, "No hay datos para generar PDF");
                return;
            }
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF");
            fileChooser.setSelectedFile(new java.io.File("ReporteInasistencia.pdf"));

            int userSelection = fileChooser.showSaveDialog(vista3);
            if (userSelection != JFileChooser.APPROVE_OPTION) {
                return;
            }

            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(ruta));
            document.open();

            document.add(new Paragraph("\t\tReporte de Inasistencias\n\n"));
            PdfPTable table = new PdfPTable(modelo.getColumnCount());

            for (int i = 0; i < modelo.getColumnCount(); i++) {
                table.addCell(modelo.getColumnName(i));
            }

            for (int i = 0; i < modelo.getRowCount(); i++) {
                for (int j = 0; j < modelo.getColumnCount(); j++) {
                    table.addCell(modelo.getValueAt(i, j).toString());
                }
            }

            document.add(table);
            document.close();

            JOptionPane.showMessageDialog(vista4, "PDF generado correctamente en: " + ruta);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista4, "Error al generar PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void generarReporteAtrasosPDF() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) vista4.jtAtrasos.getModel();
            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(vista4, "No hay datos para gemerar PDF");
                return;
            }
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF");
            fileChooser.setSelectedFile(new java.io.File("ReporteAtrasos.pdf"));

            int userSelection = fileChooser.showSaveDialog(vista3);
            if (userSelection != JFileChooser.APPROVE_OPTION) {
                return;
            }

            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(ruta));
            document.open();

            document.add(new Paragraph("Reporte de Atrasos\n\n"));
            PdfPTable table = new PdfPTable(modelo.getColumnCount());

            for (int i = 0; i < modelo.getColumnCount(); i++) {
                table.addCell(modelo.getColumnName(i));
            }

            for (int i = 0; i < modelo.getRowCount(); i++) {
                for (int j = 0; j < modelo.getColumnCount(); j++) {
                    table.addCell(modelo.getValueAt(i, j).toString());
                }
            }

            document.add(table);
            document.close();

            JOptionPane.showMessageDialog(vista4, "PDF generado correctamente en: " + ruta);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista4, "Error al generar PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void generarReporteSalidasAntPDF() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) vista4.jtAdelantos.getModel();
            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(vista4, "No hay datos para generar PDF");
                return;
            }
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF");
            fileChooser.setSelectedFile(new java.io.File("ReporteSalidasAnticipadas.pdf"));

            int userSelection = fileChooser.showSaveDialog(vista3);
            if (userSelection != JFileChooser.APPROVE_OPTION) {
                return;
            }

            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(ruta));
            document.open();

            document.add(new Paragraph("\t\tReporte de Salidas Anticipadas\n\n"));
            PdfPTable table = new PdfPTable(modelo.getColumnCount());

            for (int i = 0; i < modelo.getColumnCount(); i++) {
                table.addCell(modelo.getColumnName(i));
            }

            for (int i = 0; i < modelo.getRowCount(); i++) {
                for (int j = 0; j < modelo.getColumnCount(); j++) {
                    table.addCell(modelo.getValueAt(i, j).toString());
                }
            }

            document.add(table);
            document.close();

            JOptionPane.showMessageDialog(vista4, "PDF generado correctamente en: " + ruta);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista4, "Error al generar PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
