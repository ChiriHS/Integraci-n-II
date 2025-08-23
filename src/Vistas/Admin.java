package Vistas;

public class Admin extends javax.swing.JPanel {
    

    public Admin() {
        initComponents();
        setSize(675, 424);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PFondo = new javax.swing.JPanel();
        PCRUD = new javax.swing.JPanel();
        lvlNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lvlEmail = new javax.swing.JLabel();
        lvlRol = new javax.swing.JLabel();
        lvlClave = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        cmbID = new javax.swing.JComboBox<>();
        lvlID = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        PAsistencia = new javax.swing.JPanel();
        btnEntrada = new javax.swing.JButton();
        btnSalida = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PFondo.setBackground(new java.awt.Color(73, 80, 87));
        PFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PCRUD.setBackground(new java.awt.Color(108, 117, 125));
        PCRUD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lvlNombre.setBackground(new java.awt.Color(2, 62, 138));
        lvlNombre.setForeground(new java.awt.Color(33, 37, 41));
        lvlNombre.setText("Nombre");
        PCRUD.add(lvlNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));
        PCRUD.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 120, -1));

        lvlEmail.setForeground(new java.awt.Color(33, 37, 41));
        lvlEmail.setText("Email");
        PCRUD.add(lvlEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        lvlRol.setForeground(new java.awt.Color(33, 37, 41));
        lvlRol.setText("Rol");
        PCRUD.add(lvlRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        lvlClave.setForeground(new java.awt.Color(33, 37, 41));
        lvlClave.setText("Clave");
        PCRUD.add(lvlClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));
        PCRUD.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 100, -1));
        PCRUD.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 140, -1));

        PCRUD.add(cmbID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 60, -1));

        lvlID.setForeground(new java.awt.Color(33, 37, 41));
        lvlID.setText("ID");
        PCRUD.add(lvlID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "USUARIO" }));
        PCRUD.add(cmbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 110, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        PCRUD.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        PCRUD.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        PCRUD.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        PCRUD.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        PCRUD.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        PFondo.add(PCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 380, 310));

        PAsistencia.setBackground(new java.awt.Color(108, 117, 125));
        PAsistencia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEntrada.setText("Entrada");
        PAsistencia.add(btnEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 120, 60));

        btnSalida.setText("Salida");
        PAsistencia.add(btnSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 120, 60));

        PFondo.add(PAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 180, 310));

        add(PFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 430));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PAsistencia;
    private javax.swing.JPanel PCRUD;
    private javax.swing.JPanel PFondo;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEntrada;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalida;
    public javax.swing.JComboBox<String> cmbID;
    public javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JLabel lvlClave;
    private javax.swing.JLabel lvlEmail;
    private javax.swing.JLabel lvlID;
    private javax.swing.JLabel lvlNombre;
    private javax.swing.JLabel lvlRol;
    public javax.swing.JPasswordField txtClave;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
