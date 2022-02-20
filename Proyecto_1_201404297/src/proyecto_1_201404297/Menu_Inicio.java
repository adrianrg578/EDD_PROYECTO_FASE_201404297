/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1_201404297;

import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Iterator;
/**
 *
 * @author adria
 */
public class Menu_Inicio {
    
    boolean parametro_cm = false;
    boolean parametro_v = false;
    String direccion_carga = "";
    String direccion_parcial = "C:\\Users\\adria\\Desktop\\Grafos";
    Cola_Recepcion recepcion = new Cola_Recepcion();
    Lista_Simple ventanas = new Lista_Simple();
    public Menu_Inicio(){
    
    }
    
public void principal(){
System.out.println("-------------------- MENU --------------------");
        System.out.println("     1. PARAMETROS INICIALES");
        System.out.println("     2. EJECUTAR PASO");
        System.out.println("     3. ESTADO EN MEMORIA DE LAS ESTRUCTURAS");
        System.out.println("     4. REPORTES");
        System.out.println("     5. ACERCA DE");
        System.out.println("     6. SALIR \n");
        
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("ESCRIBA LA OPCION A EJECUTAR: ");
        opcion = sc.nextInt();
        sc.nextLine();
        
        switch (opcion) {
        case 1:
            opcion1();
            break;
        case 2:
            System.out.println("ACA VAN LOS PASOS \n");
            principal();
            break;
        case 3:
            System.out.println("ACA VA EL ESTADO DE LAS ESTRUCTURAS \n");
            archivotxt(recepcion.gentxt(),"Cola_recepcion.txt");
            archivopng(direccion_parcial,"Cola_recepcion.txt");
            principal();
            break;
        case 4:
            System.out.println("ACA VAN LOS REPORTES \n");
            principal();
            break;
        case 5:
            System.out.println("----------------- ACERCA DE ------------------ \n");
            System.out.println("ESTRUCTURAS DE DATOS SECCION B");
            System.out.println("PRIMER SEMESTRE 2022");
            System.out.println("ALBEN ADRIAN RAMIREZ GOMEZ");
            System.out.println("201404297 \n");
            principal();
            break;
        case 6:
            System.out.println("---------- SALIENDO DEL PROGRAMA ----------");
            System.exit(0);
            break;     
        default:
                System.out.println("LA OPCION ELEGIDA NO ESTA DISPONIBLE, INTENTE DE NUEVO");
                principal();
    }
}

public void opcion1(){
    System.out.println("\n \n");
    System.out.println("------------ PARAMETROS INICIALES ------------");
    System.out.println("     1) CARGA MASIVA");
    System.out.println("     2) CANTIDAD DE VENTANILLAS");
    System.out.println("     3. VOLVER \n");
    Scanner sc = new Scanner(System.in);
    int opcion1;
    System.out.println("ESCRIBA LA OPCION A EJECUTAR: ");
    opcion1=sc.nextInt();
    sc.nextLine();
    switch (opcion1) {
        case 1:
            System.out.println("\n ");
            System.out.println("INSERTE DIRECCION");
            System.out.println("Direccion: ");
            String dir = sc.nextLine();
            if(direccion_carga == ""){
                direccion_carga = dir;
                leerjson();
            }else{
                if(direccion_carga == dir){
                    System.out.println("El ARCHIVO YA HA SIDO CARGADO");
                }else{
                    System.out.println("YA SE HA CARGADO UN ARCHIVO ANTERIORMENTE");
                }
            }
            opcion1();
            break;
        case 2:
            System.out.println("\n \n ");
            System.out.println("INSERTE LA CANTIDAD DE VENTANILLAS A USAR: ");
            int ventanillas;
            ventanillas =sc.nextInt();
            sc.nextLine();
            if(ventanillas == 0){
                System.out.println("EL NUMERO DE VENTANILLAS NO PUEDE SER CERO");
            }else{
                for(int i = 1; i < ventanillas+1;i++ ){
                    ventanas.creacion_ventanilla(i);
                }
                
                System.out.println("hay: " +ventanas.tamanio);
            }
            opcion1();
            break;
        case 3:
            System.out.println("-----SALIENDO DE LOS PARAMETROS INCIALES----- \n");
            principal();
            break;    
        default:
            System.out.println("LA OPCION ELEGIDA NO ESTA DISPONIBLE, INTENTE DE NUEVO");
            opcion1();      
    }
    
}

public void opcion2(){

}

public void leerjson(){
    JSONParser parser = new JSONParser();
    
    try(Reader reader = new FileReader(direccion_carga)) {
        JSONObject objetojson = (JSONObject) parser.parse(reader);
      //System.out.println(objetojson);
        if(objetojson.size() > 0){
            for(Iterator iterator = objetojson.keySet().iterator();iterator.hasNext();){
                String key = (String) iterator.next();
                JSONObject valor = (JSONObject)objetojson.get(key);
                int id = Integer.parseInt((String) valor.get("id_cliente"));
                String nombre = (String) valor.get("nombre_cliente");
                int color = Integer.parseInt((String) valor.get("img_color"));
                int bw = Integer.parseInt((String) valor.get("img_bw"));
                recepcion.encolar(id, nombre, color, bw);
                
            }
        }
        parametro_cm = true;
    } catch (IOException e) {
        System.out.println("EL ARCHIVO NO SE PUEDE ABRIR, O NO EXISTE");
        parametro_cm = false;
    } catch (ParseException e){
        System.out.println("EL ARCHIVO NO ES UN ARCHIVO JSON");
        parametro_cm = false;
    }
    
}

public void archivotxt(String grafo,String estructura){
    try {
        String ruta = "";
        ruta+= direccion_parcial+"\\"+estructura;
        File f;
        f = new File(ruta);
        
        FileWriter w = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(w);
        PrintWriter wr = new PrintWriter(bw);
        wr.write(grafo);
        wr.close();
        bw.close();
    } catch (Exception e) {
        System.out.println("NO SE PUDO CREAR EL ARCHIVO");
    }
}

    public void archivopng(String ruta,String estructura){
        try {
      String ruta_a ="";
      ruta_a +=ruta+"\\"+estructura;
      
      String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
      
      String fileInputPath =ruta_a;
      String fileOutputPath =ruta_a.replace(".txt", ".jpg");
      
      String tParam = "-Tjpg";
      String tOParam = "-o";
        
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
        
    }
}
