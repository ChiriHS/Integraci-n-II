package Vistas;

import DAO.Conexion;
import java.sql.PreparedStatement;

public class Login2 extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login2.class.getName());
    
    Conexion conexion = new Conexion();

    public Login2() {
        initComponents();
        initComponents();
        setSize(512, 502);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Login");
        setVisible(true);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlPrincipal = new javax.swing.JPanel();
        pnlSesion = new javax.swing.JPanel();
        lblInicio = new javax.swing.JLabel();
        pwdContra = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        pnlLinea1 = new javax.swing.JPanel();
        btnSesion = new javax.swing.JButton();
        pnlLinea2 = new javax.swing.JPanel();
        iconPass = new javax.swing.JLabel();
        iconUser = new javax.swing.JLabel();
        pnlRojo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        PnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSesion.setBackground(new java.awt.Color(255, 255, 255));
        pnlSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 4));
        pnlSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInicio.setFont(new java.awt.Font("SimSun-ExtG", 1, 36)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(255, 51, 0));
        lblInicio.setText("INICIO DE SESION");
        pnlSesion.add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        pwdContra.setBackground(new java.awt.Color(255, 255, 255));
        pwdContra.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        pwdContra.setForeground(new java.awt.Color(102, 102, 102));
        pwdContra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clave", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(204, 0, 0))); // NOI18N
        pnlSesion.add(pwdContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 330, 40));

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(102, 102, 102));
        txtEmail.setToolTipText("");
        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(204, 0, 0))); // NOI18N
        pnlSesion.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 330, 40));

        pnlLinea1.setBackground(new java.awt.Color(255, 0, 0));
        pnlLinea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        javax.swing.GroupLayout pnlLinea1Layout = new javax.swing.GroupLayout(pnlLinea1);
        pnlLinea1.setLayout(pnlLinea1Layout);
        pnlLinea1Layout.setHorizontalGroup(
            pnlLinea1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );
        pnlLinea1Layout.setVerticalGroup(
            pnlLinea1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        pnlSesion.add(pnlLinea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 330, 10));

        btnSesion.setBackground(new java.awt.Color(204, 0, 0));
        btnSesion.setFont(new java.awt.Font("SimSun-ExtG", 1, 18)); // NOI18N
        btnSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnSesion.setText("Iniciar Sesion");
        btnSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSesionActionPerformed(evt);
            }
        });
        pnlSesion.add(btnSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 170, 80));

        pnlLinea2.setBackground(new java.awt.Color(255, 0, 0));
        pnlLinea2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        javax.swing.GroupLayout pnlLinea2Layout = new javax.swing.GroupLayout(pnlLinea2);
        pnlLinea2.setLayout(pnlLinea2Layout);
        pnlLinea2Layout.setHorizontalGroup(
            pnlLinea2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );
        pnlLinea2Layout.setVerticalGroup(
            pnlLinea2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        pnlSesion.add(pnlLinea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        iconPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Iconos/iconPass.png"))); // NOI18N
        pnlSesion.add(iconPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        iconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Iconos/iconUser.png"))); // NOI18N
        pnlSesion.add(iconUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        PnlPrincipal.add(pnlSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 490, 530));

        pnlRojo.setBackground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout pnlRojoLayout = new javax.swing.GroupLayout(pnlRojo);
        pnlRojo.setLayout(pnlRojoLayout);
        pnlRojoLayout.setHorizontalGroup(
            pnlRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        pnlRojoLayout.setVerticalGroup(
            pnlRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        PnlPrincipal.add(pnlRojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1038, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 13, Short.MAX_VALUE)
                    .addComponent(PnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 14, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSesionActionPerformed

    }//GEN-LAST:event_btnSesionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Login2().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlPrincipal;
    public javax.swing.JButton btnSesion;
    private javax.swing.JLabel iconPass;
    private javax.swing.JLabel iconUser;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JPanel pnlLinea1;
    private javax.swing.JPanel pnlLinea2;
    private javax.swing.JPanel pnlRojo;
    private javax.swing.JPanel pnlSesion;
    public javax.swing.JPasswordField pwdContra;
    public javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
