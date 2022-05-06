/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase_3_201404297;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author adria
 */
class Nodo_Merkle{
    int id;
    String hash;
    String sede;
    String destino;
    String fecha_hora;
    String cliente;
    String mensajero;
    
    Nodo_Merkle izquierdo;
    Nodo_Merkle derecho;
    
    public Nodo_Merkle(String hash,String sede,String destino,String fecha_hora,
            String cliente,String mensajero){
        this.hash=hash;
        this.sede=sede;
        this.destino=destino;
        this.fecha_hora=fecha_hora;
        this.cliente=cliente;
        this.mensajero =mensajero;
        this.id = 0;
    }
}
public class Arbol_Merkle {
    int tamanio;
    Nodo_Merkle raiz;
    int max=10;
    Nodo_Merkle[] nodos;
    
    public Arbol_Merkle(){
        this.tamanio=0;
        this.raiz=null;
        this.nodos = new Nodo_Merkle[15];
        for(int i = 0;i<15;i++){
            nodos[i] = null;
        }
    }
    
    public void agregar(String hash,String sede,String destino,String fecha_hora,
            String cliente,String mensajero){
        Nodo_Merkle nuevo = new Nodo_Merkle(hash, sede, destino, fecha_hora,
                    cliente, mensajero);
        for(int i=0; i<nodos.length;i++){
            if(i==2||i==5||i==6||i==9||i==12||i==13||i==14){
                //no hacer nada
            }else if(nodos[i]==null){
                nodos[i] = nuevo;
                tamanio++;
                break;
            }else if(nodos[i].id==-1){
                nodos[i] = nuevo;
                tamanio++;
                break;
           }
        }
    }
    
    
    
    public Nodo_Merkle buscar(String hash){
        Nodo_Merkle result = null;
        for(int i = 0;i<nodos.length;i++){
            if(hash.equals(nodos[i].hash)){
                result = nodos[i];
                break;
            }
        }
        return result;
    }
    
    public String hash_root(){
        String result = "";
        if(tamanio<3){
            if(nodos[2]==null){
                if(nodos[0]!= null ){
                    if(nodos[1] == null){
                        String vacio = "-1";
                        String hash_a = "-1"+"-1"+"-1"+"-1"+"-1";
                        String hash_vacio = encriptar(hash_a);
                        Nodo_Merkle aux = new Nodo_Merkle(hash_vacio,vacio,vacio,vacio,
                                vacio,vacio);
                        nodos[1] = aux;
                        tamanio++;
                    }
                    String hashmixed = nodos[0].hash+nodos[1].hash;
                    String hashed = encriptar(hashmixed);
                    nodos[2]= new Nodo_Merkle(hashed,"raiz01","raiz01","raiz01","raiz01","raiz01");
                    tamanio++;
                    result = hashed;
                }
            }
        }else if(tamanio>2 && tamanio<5){
            if(nodos[2]==null){
                if(nodos[0]!= null ){
                    if(nodos[1] == null){
                        String vacio = "-1";
                        String hash_a = "-1"+"-1"+"-1"+"-1"+"-1";
                        String hash_vacio = encriptar(hash_a);
                        Nodo_Merkle aux = new Nodo_Merkle(hash_vacio,vacio,vacio,vacio,
                                vacio,vacio);
                        nodos[1] = aux;
                        tamanio++;
                    }
                    String hashmixed = nodos[0].hash+nodos[1].hash;
                    String hashed = encriptar(hashmixed);
                    nodos[2]= new Nodo_Merkle(hashed,"raiz01","raiz01","raiz01","raiz01","raiz01");
                    tamanio++;
                    result = hashed;
                }
            }
            for(int i = 3;i<5;i++){
                if(nodos[i]==null){
                    String vacio = "-1";
                        String hash_a = "-1"+"-1"+"-1"+"-1"+"-1";
                        String hash_vacio = encriptar(hash_a);
                        Nodo_Merkle aux = new Nodo_Merkle(hash_vacio,vacio,vacio,vacio,
                                vacio,vacio);
                        nodos[i]=aux;
                        tamanio++;
                }
            }
            String hashmixed = nodos[3].hash+nodos[4].hash;
            String hashed = encriptar(hashmixed);
            nodos[5]= new Nodo_Merkle(hashed,"raiz34","raiz34","raiz34","raiz34","raiz34");
            tamanio++;
            hashmixed = nodos[2].hash+nodos[5].hash;
            hashed = encriptar(hashmixed);
            nodos[6]= new Nodo_Merkle(hashed,"raiz25","raiz25","raiz25","raiz25","raiz25");
            tamanio++;
            result = hashed;
        }
        return result;
    }
    
    public void imprimir(){
        for(int i =0; i<nodos.length;i++){
            if(nodos[i]!=null){
                if(nodos[i]!=null && i==2){
                    System.out.println("raiz 1,2: "+nodos[i].hash);
                }
                System.out.println("Operacion :"+nodos[i].hash);
            }
        }
    }
    
    private byte[] getSHA(String input)throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
    
    private String toHexString(byte[] hash){
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
    
    public void reiniciar_arbol(){
        tamanio=0;
        for(int i = 0;i<15;i++){
            nodos[i] = null;
        }
    }
    
    public String gentxt(){
        String nodos_l ="";
        String conexiones ="";
        String grafotxt = "strict graph grafo {compoud=true;\n graph [dpi=75] \n rankdir = TB; \n ";
        String f = "shape = box";
        for(int i =0; i<nodos.length;i++){
            if(nodos[i]!=null){
                if(nodos[i]!=null && i==2){
                    //System.out.println("raiz 1,2: "+nodos[i].hash);
                    nodos_l += i+"["+f+",label = \""+nodos[i].cliente+"\\n"+nodos[i].hash+"\\n \"]; \n";
                    conexiones+= "0 -- 2\n"+"1 -- 2\n";
                }else if(nodos[i]!=null && i ==5){
                    nodos_l += i+"["+f+",label = \""+nodos[i].cliente+"\\n"+nodos[i].hash+"\\n \"]; \n";
                    conexiones+="3 -- 5\n"+"4 -- 5\n";
                    conexiones+="2 -- 6\n"+"5--6\n";
                }else{
                //System.out.println("Operacion :"+nodos[i].hash);
                nodos_l += i+"["+f+",label = \""+nodos[i].cliente+"\\n"+nodos[i].hash+"\\n \"]; \n";
                }
            }
        }
        grafotxt+=nodos_l;
        grafotxt += "{ \n";
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
    
    public String imagen_Merkle(String nombre){
        archivotxt(gentxt(),nombre);
        String d_imagen = archivopng(nombre);
        return d_imagen;
    }
}
