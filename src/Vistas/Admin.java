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
        txtNombre = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        cmbID = new javax.swing.JComboBox<>();
        cmbRol = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnEntrada = new javax.swing.JButton();
        btnSalida = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lvlBienvenido = new javax.swing.JLabel();
        lvlBienvenidoAdmin = new javax.swing.JLabel();
        lvlBienvenidoID = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PFondo.setBackground(new java.awt.Color(204, 0, 0));
        PFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PCRUD.setBackground(new java.awt.Color(255, 255, 255));
        PCRUD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true), "Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N
        PCRUD.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 270, -1));

        txtClave.setBackground(new java.awt.Color(255, 255, 255));
        txtClave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtClave.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true), "Clave", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N
        PCRUD.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 240, -1));

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true), "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N
        PCRUD.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 270, -1));

        cmbID.setBackground(new java.awt.Color(255, 255, 255));
        cmbID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbID.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true), "ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N
        PCRUD.add(cmbID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, 50));

        cmbRol.setBackground(new java.awt.Color(255, 255, 255));
        cmbRol.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "USUARIO" }));
        cmbRol.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true), "Rol", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        PCRUD.add(cmbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 140, 50));

        btnBuscar.setBackground(new java.awt.Color(255, 0, 0));
        btnBuscar.setFont(new java.awt.Font("SimSun-ExtG", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 3, true), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3)));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        PCRUD.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 110, 40));

        btnLimpiar.setBackground(new java.awt.Color(255, 0, 0));
        btnLimpiar.setFont(new java.awt.Font("SimSun-ExtG", 1, 18)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        PCRUD.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 120, 40));

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setFont(new java.awt.Font("SimSun-ExtG", 1, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 0, 0));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 3, true)));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 160, 60));

        btnModificar.setBackground(new java.awt.Color(255, 255, 255));
        btnModificar.setFont(new java.awt.Font("SimSun-ExtG", 1, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 0, 0));
        btnModificar.setText("Modificar");
        btnModificar.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 3, true)));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 140, 60));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("SimSun-ExtG", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 3, true)));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 140, 60));

        PCRUD.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 550, 180));

        PFondo.add(PCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 590, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEntrada.setBackground(new java.awt.Color(255, 0, 0));
        btnEntrada.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEntrada.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrada.setText("Entrada");
        jPanel1.add(btnEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 160, 100));

        btnSalida.setBackground(new java.awt.Color(255, 0, 0));
        btnSalida.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSalida.setForeground(new java.awt.Color(255, 255, 255));
        btnSalida.setText("Salida");
        jPanel1.add(btnSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 160, 90));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Iconos/iconEntrar.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 50, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Iconos/iconSalir.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, -1, -1));

        PFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 290, 650));

        jLabel1.setFont(new java.awt.Font("SimSun-ExtG", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" ADMINISTRADOR");
        PFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 280, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Iconos/iconAdmin.png"))); // NOI18N
        PFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Iconos/iconAdmin.png"))); // NOI18N
        PFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        lvlBienvenido.setText("Bienvenido: ");
        PFondo.add(lvlBienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));
        PFondo.add(lvlBienvenidoAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));
        PFondo.add(lvlBienvenidoID, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        add(PFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 650));
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
    private javax.swing.JPanel PCRUD;
    private javax.swing.JPanel PFondo;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnEntrada;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JButton btnSalida;
    public javax.swing.JComboBox<String> cmbID;
    public javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lvlBienvenido;
    public javax.swing.JLabel lvlBienvenidoAdmin;
    public javax.swing.JLabel lvlBienvenidoID;
    public javax.swing.JPasswordField txtClave;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
