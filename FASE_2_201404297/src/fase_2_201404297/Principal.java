/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fase_2_201404297;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author adria
 */
public class Principal extends javax.swing.JFrame {
    ArbolABB arbol_capas = new ArbolABB();
    DefaultListModel modelo_capa = new DefaultListModel();
    ArbolAVL arbol_imagenes = new ArbolAVL();
    DefaultListModel modelo_img = new DefaultListModel();
    DefaultListModel modelo_album = new DefaultListModel();
    DefaultComboBoxModel modelo_dpi = new DefaultComboBoxModel();
    ListaCircularDE lista_c_album = new ListaCircularDE();
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        llenardpi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_consola = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        boton_mostrar_capa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista_capas = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lista_imagenes = new javax.swing.JList<>();
        boton_mostrar_imagen = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        lista_album = new javax.swing.JList<>();
        boton_mostar_album = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        boton_eliminar_imagen = new javax.swing.JButton();
        label_primera = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jt_reporte = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_inicio = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menu_carga_capas = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        menu_carga_imagenes = new javax.swing.JMenuItem();
        menu_carga_album = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        m_top_imagen = new javax.swing.JMenuItem();
        mp_arbol_capa = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UDrawing Paper");
        setLocation(new java.awt.Point(100, 100));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Capas cargadas");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Reporte");

        jt_consola.setEditable(false);
        jt_consola.setColumns(20);
        jt_consola.setRows(5);
        jScrollPane1.setViewportView(jt_consola);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Consola");

        boton_mostrar_capa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boton_mostrar_capa.setText("Mostrar capa");
        boton_mostrar_capa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_mostrar_capaActionPerformed(evt);
            }
        });

        lista_capas.setModel(modelo_capa);
        lista_capas.setToolTipText("");
        jScrollPane2.setViewportView(lista_capas);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Imagenes Cargadas");

        lista_imagenes.setModel(modelo_img);
        jScrollPane3.setViewportView(lista_imagenes);

        boton_mostrar_imagen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boton_mostrar_imagen.setText("Mostrar Imagen");
        boton_mostrar_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_mostrar_imagenActionPerformed(evt);
            }
        });

        lista_album.setModel(modelo_album);
        jScrollPane4.setViewportView(lista_album);

        boton_mostar_album.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boton_mostar_album.setText("Mostrar Album");
        boton_mostar_album.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_mostar_albumActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Albumes Cargados");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Resolucion de imagen");

        jComboBox1.setModel(modelo_dpi);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        boton_eliminar_imagen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boton_eliminar_imagen.setText("Eliminar Imagen");
        boton_eliminar_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminar_imagenActionPerformed(evt);
            }
        });

        jt_reporte.setEditable(false);
        jt_reporte.setColumns(20);
        jt_reporte.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jt_reporte.setRows(5);
        jScrollPane5.setViewportView(jt_reporte);

        jm_inicio.setText("Inicio");

        jMenuItem1.setText("Cerrar Sesion");
        jm_inicio.add(jMenuItem1);

        jMenuItem2.setText("Iniciar Sesion");
        jm_inicio.add(jMenuItem2);

        jMenuBar1.add(jm_inicio);

        menu_carga_capas.setText("Archivo");

        jMenuItem3.setText("Cargar Capas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menu_carga_capas.add(jMenuItem3);

        menu_carga_imagenes.setText("Cargar Imagenes");
        menu_carga_imagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_carga_imagenesActionPerformed(evt);
            }
        });
        menu_carga_capas.add(menu_carga_imagenes);

        menu_carga_album.setText("Cargar Albumes");
        menu_carga_album.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_carga_albumActionPerformed(evt);
            }
        });
        menu_carga_capas.add(menu_carga_album);

        jMenuBar1.add(menu_carga_capas);

        jMenu1.setText("Ver");

        jMenuItem7.setText("Ver Arbol Capas");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setText("Ver Arbol Imagenes");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem6.setText("Ver Listado Albumes");
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Reportes");

        m_top_imagen.setText("Top 5 Imagenes");
        m_top_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_top_imagenActionPerformed(evt);
            }
        });
        jMenu4.add(m_top_imagen);

        mp_arbol_capa.setText("Profundidad Arbol Capa");
        mp_arbol_capa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mp_arbol_capaActionPerformed(evt);
            }
        });
        jMenu4.add(mp_arbol_capa);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Mas");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_mostar_album)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(boton_mostrar_capa)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jLabel5))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boton_eliminar_imagen)
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label_primera))
                                    .addComponent(jLabel2)))
                            .addComponent(boton_mostrar_imagen)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton_mostrar_capa))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(label_primera)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boton_eliminar_imagen))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton_mostrar_imagen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(boton_mostar_album)
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
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
        leerjson_capa(archivo.getAbsolutePath());
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void boton_mostrar_capaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_mostrar_capaActionPerformed
        // TODO add your handling code here:
        Object sel =(Object) lista_capas.getSelectedValue();
        Object selectdpi = jComboBox1.getSelectedItem();
        if(arbol_capas.raiz!=null){
            System.out.println(arbol_capas.txt_te());
        }
        if(sel != null){
            String aux = String.valueOf(sel);
            int aux2 = Integer.parseInt(aux);
            int s_dpi = (int)selectdpi;
            Matriz capa_sel = arbol_capas.buscar(aux2);
            if(capa_sel == null){
                jt_consola.append("No se selecciono la capa, seleccione capa.\n");
            }else{
                String d_imagen;
                d_imagen = capa_sel.imagen(s_dpi);
                if(d_imagen.length() > 0){
                    jt_consola.append(String.valueOf(aux2)+"\n");
                    imagen_externo(d_imagen);       
                }else{
                    jt_consola.append("Ocurrio un error, no hay direccion de imagen");
                }
            }          
        }else{
            JOptionPane.showMessageDialog(this, "SELECCIONE UNA CAPA A MOSTRAR",
                    "ERROR",JOptionPane.ERROR_MESSAGE);   
        }
    }//GEN-LAST:event_boton_mostrar_capaActionPerformed

    private void menu_carga_imagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_carga_imagenesActionPerformed
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
        leerjson_img(archivo.getAbsolutePath());
    }//GEN-LAST:event_menu_carga_imagenesActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here: Arbol de capas ABB
        String d_img = arbol_capas.imagen();
        jt_reporte.setText("");
        jt_reporte.append("Recorrido Preorden: "+arbol_capas.pre() + "\n");
        jt_reporte.append("Recorrido Inorden : "+arbol_capas.inorden() + "\n");
        jt_reporte.append("Recorrido Postorden : "+arbol_capas.post() + "\n");
        jt_consola.append("\n"+d_img+"\n");
        jt_consola.append("\n La profundidad del arbol es: "+arbol_capas.profundidad()+"\n");
        imagen_externo(d_img);

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void boton_mostrar_imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_mostrar_imagenActionPerformed
        // TODO add your handling code here:
        Object sel =(Object) lista_imagenes.getSelectedValue();
        Object selectdpi = jComboBox1.getSelectedItem();
         if(arbol_imagenes.raiz!=null){
            //System.out.println(arbol_imagenes.txt_grafo());
         }
         if(sel!=null){
            String aux = String.valueOf(sel);
            int aux2 = Integer.parseInt(aux);
            int s_dpi = (int)selectdpi;
            NodoAVL resul = arbol_imagenes.buscar(aux2);
            String dir_img = resul.matriz_unificada.imagen(s_dpi);
            if(dir_img.length()>0){
                imagen_externo(dir_img);
            }else{
                jt_consola.append(" Ocurrio un error, verifique los metodos");
            }
         }else{
             JOptionPane.showMessageDialog(this, "SELECCIONE UNA IMAGEN A MOSTRAR",
                    "ERROR",JOptionPane.ERROR_MESSAGE);
         }
         
    }//GEN-LAST:event_boton_mostrar_imagenActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here: mostrar arbol de imagenes
        arbol_imagenes.imprimir();
        String d_img = arbol_imagenes.imagen();
        jt_consola.append("\n"+d_img);
        imagen_externo(d_img);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void menu_carga_albumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_carga_albumActionPerformed
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
        leerjson_album(archivo.getAbsolutePath());
    }//GEN-LAST:event_menu_carga_albumActionPerformed

    private void boton_mostar_albumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_mostar_albumActionPerformed
        // TODO add your handling code here:
        //System.out.println(lista_c_album.generartxt());
    }//GEN-LAST:event_boton_mostar_albumActionPerformed

    private void boton_eliminar_imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminar_imagenActionPerformed
        // TODO add your handling code here:
        Object sel =(Object) lista_imagenes.getSelectedValue();
        Object selectdpi = jComboBox1.getSelectedItem();
        if(sel!=null){
            String aux = String.valueOf(sel);
            int aux2 = Integer.parseInt(aux);
            int s_dpi = (int)selectdpi;
            NodoAVL busqueda = arbol_imagenes.buscar(aux2);
            NodoAVL resul = arbol_imagenes.eliminar(aux2);
            if(resul==null){
                jt_consola.append("\n NO se ha eliminado la imagen \n");
            }else{
                jt_consola.append("\n Se ha eliminado la imagen, verifique el nuevo arbol \n");
                modelo_img.removeElement(sel);
            }   
         }else{
             JOptionPane.showMessageDialog(this, "SELECCIONE UNA IMAGEN A MOSTRAR",
                    "ERROR",JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_boton_eliminar_imagenActionPerformed

    private void mp_arbol_capaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mp_arbol_capaActionPerformed
        // TODO add your handling code here:
        jt_reporte.setText("");
        jt_reporte.append("La profundida del arbol de capas es: \n"+arbol_capas.profundidad());
        
    }//GEN-LAST:event_mp_arbol_capaActionPerformed

    private void m_top_imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_top_imagenActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_m_top_imagenActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_eliminar_imagen;
    private javax.swing.JButton boton_mostar_album;
    private javax.swing.JButton boton_mostrar_capa;
    private javax.swing.JButton boton_mostrar_imagen;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JMenu jm_inicio;
    private javax.swing.JTextArea jt_consola;
    private javax.swing.JTextArea jt_reporte;
    private javax.swing.JLabel label_primera;
    private javax.swing.JList<String> lista_album;
    private javax.swing.JList<String> lista_capas;
    private javax.swing.JList<String> lista_imagenes;
    private javax.swing.JMenuItem m_top_imagen;
    private javax.swing.JMenuItem menu_carga_album;
    private javax.swing.JMenu menu_carga_capas;
    private javax.swing.JMenuItem menu_carga_imagenes;
    private javax.swing.JMenuItem mp_arbol_capa;
    // End of variables declaration//GEN-END:variables

    //metodos externos
    public void imagen_externo(String urlimg){
        try{
            File file = new File(urlimg);
            BufferedImage bufferedImage = ImageIO.read(file);
            ImageIcon imageIcon = new ImageIcon(bufferedImage);
            JFrame jframe = new JFrame();
            jframe.setLayout(new FlowLayout());
            jframe.setSize(600, 800);
            JLabel jlabel = new JLabel();
            
            jlabel.setIcon(imageIcon);
            jframe.add(jlabel);
            jframe.setVisible(true);
            jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (IOException ex) {
            System.out.println("Ocurrio un error inesperado no se mostro la imagen");
            jt_consola.append("Ocurrio un error inesperado no se mostro la imagen");

        }
    
    }
    
    public void leerjson_capa(String direccion){
        JSONParser parser = new JSONParser();
        //prueba de la creacion de una matriz borrar despues
        //ArrayList<Matriz> matrices = new ArrayList<>();

        
        try(Reader reader = new FileReader(direccion)){
            JSONArray arrayobj = (JSONArray) parser.parse(reader);
            //System.out.println(arrayobj);
            
            if(arrayobj.size()>0){
               for(int n = 0; n <arrayobj.size(); n++){
                   JSONObject valor = (JSONObject) arrayobj.get(n);
                   long capa =  (Long) valor.get("id_capa");
                   JSONArray valor_pixel = (JSONArray) valor.get("pixeles");
                   Matriz matriz = new Matriz((int)capa);
                   Matriz aux = arbol_capas.buscar((int)capa);
                   if(aux!=null){
                        jt_consola.append("\n la capa ya existe");
                   }else{
                        for(int i = 0; i <valor_pixel.size();i++){
                            JSONObject valor_interno_pixel = (JSONObject) valor_pixel.get(i);
                            long columna =(Long) valor_interno_pixel.get("columna");
                            long fila = (Long) valor_interno_pixel.get("fila");
                            String color = (String) valor_interno_pixel.get("color");
                            matriz.insertar_nodo((int)columna,(int) fila, color);
                        }
                        // matrices.add(matriz);
                        arbol_capas.insertar(matriz);
                        modelo_capa.addElement(matriz.id);
                    }
               }
            }   
        } catch (IOException e) {
            System.out.println("EL ARCHIVO NO SE PUEDE ABRIR, O NO EXISTE");
            jt_consola.append("EL ARCHIVO NO SE PUEDE ABRIR, NO EXISTE \n");
        } catch (org.json.simple.parser.ParseException ex) {
            System.out.println("EL ARCHIVO NO ES UN ARCHIVO JSON");
            jt_consola.append("EL ARCHIVO NO ES UN ARCHIVO JSON \n");

        }
        
        //lista.setModel(modelo_capa);
    }
    
    public void leerjson_img(String direccion){
        JSONParser parser = new JSONParser();
        
        try(Reader reader = new FileReader(direccion)){
            JSONArray arrayobj = (JSONArray) parser.parse(reader);
            //System.out.println(arrayobj);
            if(arrayobj.size()>0){
                for(int n = 0; n <arrayobj.size();n++){
                    JSONObject valor = (JSONObject) arrayobj.get(n);
                    long id = (Long) valor.get("id");
                    JSONArray valor_capas = (JSONArray) valor.get("capas");
                    NodoAVL result = arbol_imagenes.buscar((int)id);
                    if(result!=null){
                        jt_consola.append("\n la imagen ya existe!");
                    }else{
                        ArbolABB arbol = new ArbolABB();
                        int capaadd = (int) id + 100;
                        Matriz union = new Matriz(capaadd);
                        for(int i = 0; i<valor_capas.size();i++){
                            long capa = (Long)valor_capas.get(i);
                            Matriz actual = arbol_capas.buscar((int)capa);
                            if(actual !=null){
                                arbol.insertar(actual);
                                //aqui extraigo las coordenadas y color para unificar las capas
                                NodoMatriz aux = actual.raiz;
                                while(aux!=null){
                                    NodoMatriz aux2 = aux;
                                    while(aux2!=null){
                                        union.insertar_nodo(aux2.x,aux2.y, aux2.color);
                                        aux2 = aux2.siguiente;
                                    }
                                    aux = aux.abajo;
                                }
                                // final del recorrido de la capa
                            }
                        }
                        modelo_img.addElement(id);
                        arbol_imagenes.insertar((int)id,arbol,union);
                    }
                }
            }
        }catch (IOException e){
            System.out.println("EL ARCHIVO NO SE PUEDE ABRIR, O NO EXISTE");
            jt_consola.append("EL ARCHIVO NO SE PUEDE ABRIR, NO EXISTE \n");
        } catch (org.json.simple.parser.ParseException ex) {
            System.out.println("EL ARCHIVO NO ES UN ARCHIVO JSON");
            jt_consola.append("EL ARCHIVO NO ES UN ARCHIVO JSON \n");
        }
    }
    
    public void leerjson_album(String direccion){
        JSONParser parser = new JSONParser();
        
        try(Reader reader = new FileReader(direccion)){
            JSONArray arrayobj = (JSONArray) parser.parse(reader);
            
            if(arrayobj.size()>0){
                for(int n = 1; n<=arrayobj.size();n++){
                    JSONObject valor = (JSONObject)arrayobj.get(n);
                    String nombre_a = (String)valor.get("nombre_album");
                    JSONArray valor_img = (JSONArray) valor.get("imgs");
                    Lista_simple lista = new Lista_simple();
                    for(int i = 0; i<valor_img.size();i++){
                        long img = (Long)valor_img.get(i);
                        lista.insertar((int)img);
                    }
                    modelo_album.addElement(n);
                    lista_c_album.insertar(n, nombre_a, lista);
                }
            }
        }catch(IOException e){
            System.out.println("EL ARCHIVO NO SE PUEDE ABRIR, O NO EXISTE");
            jt_consola.append("EL ARCHIVO NO SE PUEDE ABRIR, NO EXISTE \n");
        }catch (org.json.simple.parser.ParseException ex) {
            System.out.println("EL ARCHIVO NO ES UN ARCHIVO JSON");
            jt_consola.append("EL ARCHIVO NO ES UN ARCHIVO JSON \n");
        }
    }
    
    private void llenardpi(){
        modelo_dpi.addElement(10);
        modelo_dpi.addElement(20);
        modelo_dpi.addElement(30);
        modelo_dpi.addElement(40);
        modelo_dpi.addElement(50);
        modelo_dpi.addElement(100);
        modelo_dpi.addElement(150);
        modelo_dpi.addElement(200);      
    }
}
