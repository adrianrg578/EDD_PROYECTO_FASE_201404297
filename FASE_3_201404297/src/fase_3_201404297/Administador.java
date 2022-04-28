/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fase_3_201404297;

/**
 *
 * @author adria
 */
public class Administador extends javax.swing.JFrame {

    /**
     * Creates new form Administador
     */
    public Administador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jText_consola = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu_cerrar_sesion = new javax.swing.JMenuItem();
        jMenu_iniciar_sesion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu_carga_lugar = new javax.swing.JMenuItem();
        jMenu_carga_mensajero = new javax.swing.JMenuItem();
        jMenu_carga_ruta = new javax.swing.JMenuItem();
        jMenu_carga_usuarios = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu_blockchain = new javax.swing.JMenuItem();
        jMenu_grafo_rutas = new javax.swing.JMenuItem();
        jMenu_lista_adyacencia = new javax.swing.JMenuItem();
        jMenu_nodo_red = new javax.swing.JMenuItem();
        jMenu_tabla_dispersion = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");

        jLabel1.setText("Consola");

        jText_consola.setEditable(false);
        jText_consola.setColumns(20);
        jText_consola.setRows(5);
        jScrollPane1.setViewportView(jText_consola);

        jMenu1.setText("Archivo");

        jMenu_cerrar_sesion.setText("Cerrar Sesion");
        jMenu1.add(jMenu_cerrar_sesion);

        jMenu_iniciar_sesion.setText("Iniciar Sesion");
        jMenu1.add(jMenu_iniciar_sesion);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Carga");

        jMenu_carga_lugar.setText("Lugares");
        jMenu2.add(jMenu_carga_lugar);

        jMenu_carga_mensajero.setText("Mensajeros");
        jMenu2.add(jMenu_carga_mensajero);

        jMenu_carga_ruta.setText("Rutas");
        jMenu2.add(jMenu_carga_ruta);

        jMenu_carga_usuarios.setText("Usuarios");
        jMenu2.add(jMenu_carga_usuarios);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ver");

        jMenu_blockchain.setText("Blockchain");
        jMenu3.add(jMenu_blockchain);

        jMenu_grafo_rutas.setText("Grafo de Rutas");
        jMenu3.add(jMenu_grafo_rutas);

        jMenu_lista_adyacencia.setText("Lista de Adyacencia");
        jMenu3.add(jMenu_lista_adyacencia);

        jMenu_nodo_red.setText("Nodos de la red");
        jMenu3.add(jMenu_nodo_red);

        jMenu_tabla_dispersion.setText("Tabla de dispersion (Hash)");
        jMenu3.add(jMenu_tabla_dispersion);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(388, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenu_blockchain;
    private javax.swing.JMenuItem jMenu_carga_lugar;
    private javax.swing.JMenuItem jMenu_carga_mensajero;
    private javax.swing.JMenuItem jMenu_carga_ruta;
    private javax.swing.JMenuItem jMenu_carga_usuarios;
    private javax.swing.JMenuItem jMenu_cerrar_sesion;
    private javax.swing.JMenuItem jMenu_grafo_rutas;
    private javax.swing.JMenuItem jMenu_iniciar_sesion;
    private javax.swing.JMenuItem jMenu_lista_adyacencia;
    private javax.swing.JMenuItem jMenu_nodo_red;
    private javax.swing.JMenuItem jMenu_tabla_dispersion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jText_consola;
    // End of variables declaration//GEN-END:variables
}
