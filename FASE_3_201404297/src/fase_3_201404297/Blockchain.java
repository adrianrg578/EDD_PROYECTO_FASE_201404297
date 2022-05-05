/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase_3_201404297;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Nodo_data data;
    String prevhash;
    String raizmerkle;
    String hash;
    
    //punteros
    NodoBlock siguiente;
    NodoBlock anterior;
    
    public NodoBlock(int index,String timestamp,int nonce,Nodo_data data, 
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
    NodoBlock primero;
    NodoBlock ultimo;
    
    public Blockchain(){
        this.tiempo = 3;
        this.tamanio = 0;
        this.primero=null;
        this.ultimo =null;
    }
    
    public void insertar(int index,String timestamp,int nonce,Nodo_data data, 
            String prevhash,String raizmerkle,String hash){
        String time_edit =timestamp.replace(" ","_");
        NodoBlock nuevo = new NodoBlock(index, time_edit, nonce, data, prevhash, raizmerkle, hash);
        guardar_json(nuevo);
        if(primero==null){
            primero = nuevo;
            ultimo = nuevo;
            tamanio++;
        }else{
            ultimo.siguiente=nuevo;
            nuevo.anterior=ultimo;
            ultimo=nuevo;
        }
    }
    
    public void guardar_json(NodoBlock bloque){
        JSONObject libro = new JSONObject();
        JSONObject nodo = new JSONObject();
        JSONObject data = new JSONObject();
        nodo.put("INDEX", bloque.index);
        nodo.put("TIMESTAMP", bloque.timestamp);
        nodo.put("NONCE", bloque.nonce);
        data.put("sede",bloque.data.sede);
        data.put("destino",bloque.data.destino);
        data.put("datetime",bloque.data.datetime);
        data.put("cliente",bloque.data.cliente);
        data.put("mensajero",bloque.data.mensajero);
        nodo.put("DATA",data+"\n");
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
}
