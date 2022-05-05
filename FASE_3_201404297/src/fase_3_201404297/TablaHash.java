/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase_3_201404297;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author adria
 */
class NodoHash{
    long dpi;
    String nombre;
    String apellido;
    char licencia;
    String genero;
    int telefono;
    String direccion;
    
    public NodoHash(long dpi,String nombre,String apellido,char licencia,
            String genero,int telefono,String direccion){
        this.dpi = dpi;
        this.nombre=nombre;
        this.apellido=apellido;
        this.licencia=licencia;
        this.genero=genero;
        this.telefono=telefono;
        this.direccion=direccion;
    }
}

public class TablaHash {
    NodoHash[] tabla_hash;
    int elementos;
    float factor_carga;
    int tamanio;
    
    public TablaHash(){
        this.elementos=0;
        this.factor_carga=0;
        this.tamanio=37;
        this.tabla_hash = new NodoHash[tamanio];
        
        for(int i = 0;i>tamanio;i++){
            tabla_hash[i] = null;
        }
    }
    
    public void insertar(long dpi,String nombre,String apellido,char licencia,
            String genero,int telefono,String direccion){
        int posicion = funcion_hash(dpi);
        NodoHash nuevo = new NodoHash(dpi,nombre,apellido,licencia,genero,
                telefono,direccion);
        
        if(tabla_hash[posicion]==null){
            tabla_hash[posicion]=nuevo;
        }else{
            int nueva_posicion = funcion_rehashing(dpi);
            tabla_hash[nueva_posicion]=nuevo;
        }
        elementos++;
        factor_carga = (float)elementos/tamanio;
        
        if(factor_carga > 0.75){
            rehashing();
        }
    }
    
    private int funcion_rehashing(long indice){
        long posicion;
        int resultado =0; 
        posicion = indice %(tamanio-1);
        int posint = Math.toIntExact(posicion);
            if(tabla_hash[posint]!=null){
                boolean vacio = false;
                int contador = 1; //i
                while(vacio==false){
                    posicion = ((indice % 7) +1)*contador;
                    int aux = Math.toIntExact(posicion);
                        if(tabla_hash[aux]!=null){
                            contador++;
                            vacio = false;
                        }else{
                            resultado = Math.toIntExact(posicion);
                            vacio = true;
                        }
                }
            }else{
                resultado = Math.toIntExact(posicion);
            }
        return resultado;
    }
    
    private int funcion_hash(long indice){
        long posicion;
        int resultado = 0;
        posicion = indice%(tamanio-1);
        resultado= Math.toIntExact(posicion);
        return resultado;
    }
    
    private void rehashing(){
        int proximo = next_primo(tamanio);
        int factor = 0;
        NodoHash[] temporal = new NodoHash[proximo];
        if(proximo>tamanio){

            for(int i = 0; i<proximo;i++){
                temporal[i] = null;
            }
        }
        
        NodoHash[] tabla_hash_temp = tabla_hash;
        
        tabla_hash = temporal;
        tamanio=proximo;
        
        for(int i = 0;i<tabla_hash_temp.length;i++){         
            if(tabla_hash_temp[i]!= null){
                int ps = funcion_hash(tabla_hash_temp[i].dpi);
                temporal[ps]=tabla_hash_temp[i];
            }
        }
        tabla_hash = temporal;
    }
    
    private int next_primo(int tamanio){
        int sig = tamanio+1;
        int resultado = 0;
        boolean primo = false;
        while(primo==false){
            if(esPrimo(sig)){
                primo = true;
                resultado = sig;
                return sig;
            }else{
                sig++;
            }
        
        }
        return resultado;
    }
    
    private boolean esPrimo(int numero){
        if(numero==0 || numero == 1 || numero==4){
            return false;
        }
        for(int x=2; x < numero/2;x++ ){
            if (numero % x ==0){
                return false;
            }
        }
        return true;
    }
       
    public void imprimir(){
        for(int i = 0; i<tabla_hash.length;i++){
            if(tabla_hash[i]!=null){
                System.out.println("indice: "+ i +"  DPI: "+tabla_hash[i].dpi);
            }else{
                System.out.println("indice: "+ i +"DPI: vacio" );
            }
        }
    }
    
    private String generartablatxt(){
        String nodo ="";
        String grafotxt = "digraph Tabla_Hash { \n node [shape=plaintext]; \n";
        String a = "struct1 [ label=<<TABLE><tr> \n <td>Indice</td> \n <td>valor</td>\n </tr> \n" ;
        String fn = "</TABLE>>]; \n } ";
        String b = "<tr> \n";
        String c = "</tr> \n";
        for(int i = 0; i<tabla_hash.length;i++){
            if(tabla_hash[i]!=null){
                //System.out.println("indice: "+ i +"  DPI: "+tabla_hash[i].dpi);
                nodo+=b+"<td>"+i+"</td>"+"<td>"+tabla_hash[i].dpi+"\n"+"<br/>"+tabla_hash[i].nombre+"</td> \n"+c;
            }else{
                //System.out.println("indice: "+ i +"  DPI: vacio" );
                nodo+=b+"<td>"+i+"</td>"+"<td>Vacio</td> \n"+c;
            }
        }
        String result = "";
        result +=grafotxt+a+nodo+fn;
        
        return result;
    }
    
    private void archivotxt(String codigo_txt){
        String tabla = "C:\\Users\\adria\\Desktop\\recursos_f3\\TablaHash.txt";
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
    
    private String archivopng(){
        String ruta_a ="C:\\Users\\adria\\Desktop\\recursos_f3\\TablaHash.txt";
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
    
    public String imagen(){
        archivotxt(generartablatxt());
        String d_imagen = archivopng();
        return d_imagen;
    }
    
    public NodoHash buscar(long dpi){
        NodoHash resultado = null;
        int indice = funcion_hash(dpi);
        if(indice<tabla_hash.length){
            resultado = tabla_hash[indice];
        }else{
            System.out.println("el indice esta fuera del rango");
        }
        return resultado;
    }
}
