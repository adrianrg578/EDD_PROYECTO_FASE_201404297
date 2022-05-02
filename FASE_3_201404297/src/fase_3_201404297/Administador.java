/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fase_3_201404297;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author adria
 */
public class Administador extends javax.swing.JFrame {
    ArbolB users = new ArbolB();
    TablaHash mensajeros = new TablaHash(37);
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
        jMenu_carga_mensajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_carga_mensajeroActionPerformed(evt);
            }
        });
        jMenu2.add(jMenu_carga_mensajero);

        jMenu_carga_ruta.setText("Rutas");
        jMenu2.add(jMenu_carga_ruta);

        jMenu_carga_usuarios.setText("Usuarios");
        jMenu_carga_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_carga_usuariosActionPerformed(evt);
            }
        });
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

    private void jMenu_carga_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_carga_usuariosActionPerformed
        // TODO add your handling code here:
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JSON", "json");
        selector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        selector.setFileFilter(filtro);
        int result = selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        if ((archivo==null) || (archivo.getName().equals(""))){
            JOptionPane.showMessageDialog(this, "Nombre de archivo invalido",
                    "Nombre de archivo invalido",JOptionPane.ERROR_MESSAGE);   
        }
        carga_user_json(archivo.getAbsolutePath());
        
        NodoB prueba = users.buscar("Vanny07");
        if(prueba == null){
            System.out.println("el metodo no funciono");
        }else{
            System.out.println("nombre: " + prueba.nombre);
        }
    }//GEN-LAST:event_jMenu_carga_usuariosActionPerformed

    private void jMenu_carga_mensajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_carga_mensajeroActionPerformed
        // TODO add your handling code here:
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JSON", "json");
        selector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        selector.setFileFilter(filtro);
        int result = selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        if ((archivo==null) || (archivo.getName().equals(""))){
            JOptionPane.showMessageDialog(this, "Nombre de archivo invalido",
                    "Nombre de archivo invalido",JOptionPane.ERROR_MESSAGE);   
        }
        carga_mensajeros(archivo.getAbsolutePath());
        System.out.println(mensajeros.elementos + " factor cargar: "+mensajeros.factor_carga);
        mensajeros.imprimir();
    }//GEN-LAST:event_jMenu_carga_mensajeroActionPerformed

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
    private void carga_user_json(String direccion){
        JSONParser parser = new JSONParser();
        try(Reader reader = new FileReader(direccion)){
            JSONArray arrayobj = (JSONArray) parser.parse(reader);
            //System.out.println(arrayobj);
            if(arrayobj.size()>0){
                for(int n = 0; n<arrayobj.size();n++){
                    JSONObject valor = (JSONObject)arrayobj.get(n);
                    long dpi = Long.parseLong((String) valor.get("dpi"));
                    String nombre = (String) valor.get("nombre_cliente");
                    String usuario = (String) valor.get("usuario");
                    String pass = (String) valor.get("password");
                    String correo = (String) valor.get("correo");
                    int telefono = Integer.parseInt((String) valor.get("telefono"));
                    String dir_user = (String) valor.get("direccion");
                    short id_municipio = Short.parseShort((String) valor.get("id_municipio"));
                    
                    //System.out.println("dpi: "+dpi+" nombre: "+nombre);
                    users.insertar(dpi,nombre,pass,usuario,correo,telefono,dir_user,id_municipio);
                }
            }
            
        }catch (IOException e) {
            System.out.println("EL ARCHIVO NO SE PUEDE ABRIR, O NO EXISTE");
        } catch (org.json.simple.parser.ParseException ex) {
            System.out.println("EL ARCHIVO NO ES UN ARCHIVO JSON");
        }
    }

    private void carga_mensajeros(String direccion){
        JSONParser parser = new JSONParser();
        
        try(Reader reader = new FileReader(direccion)){
            JSONArray arrayobj = (JSONArray) parser.parse(reader);
            
            if(arrayobj.size()>0){
                for (int n =0; n <arrayobj.size();n++){
                    JSONObject valor = (JSONObject) arrayobj.get(n);
                    long dpi = Long.parseLong((String)valor.get("dpi"));
                    String nombre= (String)valor.get("nombres");
                    String apellido = (String)valor.get("apellidos");
                    char licencia = valor.get("tipo_licencia").toString().charAt(0);
                    String genero = (String) valor.get("genero");
                    int telefono = Integer.parseInt((String)valor.get("telefono"));
                    String dir_mensajero = (String) valor.get("direccion");
                    
                    /*System.out.println(dpi +"\n"+nombre+"\n"+apellido+"\n"+
                            licencia+"\n"+genero+"\n"+telefono+"\n"+dir_mensajero);*/
                    mensajeros.insertar(dpi, nombre, apellido, licencia, genero, telefono, dir_mensajero);
                }
            }
        
        }catch (IOException e) {
            System.out.println("EL ARCHIVO NO SE PUEDE ABRIR, O NO EXISTE");
            
        } catch (org.json.simple.parser.ParseException ex) {
            System.out.println("EL ARCHIVO NO ES UN ARCHIVO JSON");

        }
    }
}
