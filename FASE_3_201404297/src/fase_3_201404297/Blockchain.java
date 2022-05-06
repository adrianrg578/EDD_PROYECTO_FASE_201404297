/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase_3_201404297;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author adria
 */

class NodoBlock{
    //datos
    int index;
    String timestamp;
    int nonce;
    Arbol_Merkle data;
    String prevhash;
    String raizmerkle;
    String hash;

    
    //punteros
    NodoBlock siguiente;
    NodoBlock anterior;
    
    public NodoBlock(int index,String timestamp,int nonce,Arbol_Merkle data, 
            String prevhash,String raizmerkle,String hash){
       this.index=index;
       this.timestamp=timestamp;
       this.nonce=nonce;
       this.data=data;
       this.prevhash =prevhash;
       this.raizmerkle=raizmerkle;
       this.hash = hash;

       
       this.anterior=null;
       this.siguiente=null;
    }
    
}
//nodo data donde guardaremos todo para faciliar la creacion del archivo JSON
    class Nodo_data{
        String sede;
        String destino;
        String datetime;
        String cliente;
        String mensajero;
        
        Nodo_data(String sede,String destino, String datetime,String cliente,String mensajero){
            this.sede=sede;
            this.destino=destino;
            this.datetime=datetime;
            this.cliente=cliente;
            this.mensajero=mensajero;
        }
    }
//es practicamente una lista enlazada
public class Blockchain {
    int tamanio;
    int tiempo;
    int ceros;
    NodoBlock primero;
    NodoBlock ultimo;
    
    public Blockchain(int ceros){
        this.tiempo = 3;
        this.tamanio = 0;
        this.ceros = ceros;
        this.primero=null;
        this.ultimo =null;
    }
    
    public NodoBlock insertar(String timestamp,int nonce,Arbol_Merkle data, 
            String prevhash,String raizmerkle,String hash){
        String time_edit =timestamp.replace(" ","_");
        NodoBlock nuevo = new NodoBlock(tamanio,time_edit, nonce, data, prevhash, raizmerkle, hash);
        if(primero==null){
            primero = nuevo;
            ultimo = nuevo;
            tamanio++;
        }else{
            ultimo.siguiente=nuevo;
            nuevo.anterior=ultimo;
            ultimo=nuevo;
        }
        return nuevo;
    }
    
    public void guardar_json(NodoBlock bloque){
        JSONObject libro = new JSONObject();
        JSONObject nodo = new JSONObject();

        JSONArray data_list = new JSONArray();
        
        nodo.put("INDEX", bloque.index);
        nodo.put("TIMESTAMP", bloque.timestamp);
        nodo.put("NONCE", bloque.nonce);
        for(int i=0;i<bloque.data.tamanio;i++){
            JSONObject data = new JSONObject();
            Nodo_Merkle aux = bloque.data.nodos[i];
            if(aux!=null){
                if(!aux.cliente.contains("raiz")){
                    data.put("sede",aux.sede);
                    data.put("destino",aux.destino);
                    data.put("datetime",aux.fecha_hora);
                    data.put("cliente",aux.cliente);
                    data.put("mensajero",aux.mensajero);  
                    data_list.add(data);}
            }
        }
       
        nodo.put("DATA",data_list);
        
        nodo.put("PREVIOUSHASH",bloque.prevhash);
        nodo.put("ROOTMERKLE",bloque.raizmerkle);
        nodo.put("HASH",bloque.hash);
        libro.put("BLOQUE",nodo);
        
        BufferedWriter bw = null;
        FileWriter fw = null;
        String time = bloque.timestamp.replace(":","_");
        String nombre = verificar_directorio();
        nombre+="/"+bloque.index+"_"+time;
        nombre+=".json";
        
        try{
            File file = new File(nombre);
            if(!file.exists()){
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile(),true);
            bw = new BufferedWriter(fw);
            bw.write(libro.toJSONString());
            System.out.println("informacion actualizada");
        } catch (IOException ex) {
            System.out.println("no se pudo crear o editar el archivo");
        } finally{
            try{
                if (bw != null)
                bw.close();
                if (fw != null)
                fw.close();
            }catch (IOException ex) {
            ex.printStackTrace();
        }
        }
    }
    
    public String verificar_directorio(){
        String filename = "C:/udrawing/blockchain";
        File D = new File(filename);
        boolean D1 = D.mkdirs();
        if(D1){
            System.out.println("el directorio se creo con exito");
        }else{
            System.out.println("NO se pudo crear el directorio");
        }
        
        return filename;  
    }
    
    
    public byte[] getSHA(String input)throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
    
    public String toHexString(byte[] hash){
        BigInteger number = new BigInteger(1,hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length()<64){
            hexString.insert(0,'0');
        }
        return hexString.toString();
    }
    
    public String encriptar(String cadena){
        String result = "";
        try{
            result = toHexString(getSHA(cadena));
        }catch(NoSuchAlgorithmException e){
            System.out.println("NO se pudo crear el cifrado");
        }
        return result;
    }
    
    public int get_ceros(){
        int result = ceros;
        return result;
    }
    
    public void set_ceros(int cero){
        this.ceros=cero;
    }
    
    public String gentxt_bloque(){
        String grafotxt = "";
        grafotxt = "digraph bloques { rankdir = LR; \n";
        String f = "shape=box,";
        String nodos_b = "";
        String conexiones = "";
        NodoBlock aux = primero;
            while(aux != null){
                int index = aux.index;
                String timestamp = aux.timestamp;
                int nonce= aux.nonce;
                String prevhash = aux.prevhash;
                String root_merkle = aux.raizmerkle;
                String hash = aux.hash;
                nodos_b += index+"["+f +"label = \""+"Hash previo: "+prevhash+"\\n"+"Raiz Merkle: "+
                        root_merkle+"\\n \"];\n";
                
                /*for(int i = 0;i<aux.data.tamanio;i++){
                    Nodo_Merkle temp = aux.data.nodos[i];
                    
                    String sede = temp.sede;
                    String destino = temp.destino;
                    String datetime = temp.fecha_hora;
                    String cliente = temp.cliente;
                    String mensajero = temp.mensajero;
                
                }*/
                if(aux.siguiente!=null){
                 conexiones+=index+"->"+aux.siguiente.index+";\n";
                }
                aux = aux.siguiente;
            }
        grafotxt += nodos_b;
        grafotxt += "{rank = same; \n";
        grafotxt += conexiones;
        grafotxt += "}\n";
        grafotxt += "}\n";
        return grafotxt;
    }
    private void archivotxt(String codigo_txt,String nombre){
        String tabla = "C:\\Users\\adria\\Desktop\\recursos_f3\\"+nombre+".txt";
        try {
            File f;
            f = new File(tabla);
            if(!f.exists()){
                f.createNewFile();
            }
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write(codigo_txt);
            wr.close();
            bw.close();
        } catch (Exception e) {
        System.out.println("NO SE PUDO CREAR EL ARCHIVO");
        }
    }
    
    private String archivopng(String nombre){
        String ruta_a ="C:\\Users\\adria\\Desktop\\recursos_f3\\"+nombre+".txt";
        String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
        String fileInputPath =ruta_a;
        String fileOutputPath =ruta_a.replace(".txt", ".png");
        String tParam = "-Tjpg";
        String tOParam = "-o";
        try {  
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
                  
            Runtime rt = Runtime.getRuntime();
      
            rt.exec( cmd );
      
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return fileOutputPath;
    }
    
    public String imagen_bloque(String nombre){
        archivotxt(gentxt_bloque(),nombre);
        String d_imagen = archivopng(nombre);
        return d_imagen;
    }
}
