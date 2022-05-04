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
 * La clase se llama grafo porque lo que se hara es para representar un grafo
 * usando una lista de adyacencia, habran dos tipos de nodos,
 * el primero es para guardar la informacion de los lugares (nodos)
 * y el segundo es donde estan las rutas (uniones del grafo)
 * @author adria
 */
class Nodo_ady{
    //parametros
    int id;
    String departamento;
    String nombre;
    String sucursal;
    
    //punteros
    Nodo_ady abajo; //apuntador al siguiente nodo
     //apuntador al nodo que contiene la lista de uniones
    Lista_ruta listado_ruta;
    
    public Nodo_ady(int id,String depto,String nombre,String sucursal){
        this.id =id;
        this.departamento = depto;
        this.nombre = nombre;
        this.sucursal=sucursal;
        this.abajo=null;
        this.listado_ruta=new Lista_ruta();
    }
}

class Nodo_ruta{
    //parametros
    int inicio;
    int fin;
    int peso;
    //puntero
    Nodo_ruta siguiente;
    
    public Nodo_ruta(int inicio,int fin, int peso){
        this.inicio = inicio;
        this.fin = fin;
        this.peso = peso;
        this.siguiente= null;
    }
}
class Lista_ruta{
    int tamanio;
    Nodo_ruta primero;
    Nodo_ruta ultimo;
        
    public Lista_ruta(){
        this.primero=null;
        this.ultimo=null;
        this.tamanio=0;
    }
    public void insertar(int inicio, int fin,int peso){
        Nodo_ruta nuevo = new Nodo_ruta(inicio,fin,peso);
        if(primero==null){
           primero = nuevo;
           ultimo = nuevo;
           tamanio++;
       }else{
           ultimo.siguiente= nuevo;
           ultimo = nuevo;
           tamanio++;
       }  
    }
}

public class Grafo {
    Nodo_ady primero;
    Nodo_ady ultimo;
    int tamanio;
    
    public Grafo(){
       this.primero = null;
       this.ultimo = null;
       this.tamanio = 0;
   }
   
    public void agregar_lugar(int id, String depto,String nombre,String sucursal){
       Nodo_ady nuevo = new Nodo_ady(id,depto,nombre,sucursal);
       if(primero==null){
           primero = nuevo;
           ultimo = nuevo;
           tamanio++;
       }else{
           ultimo.abajo = nuevo;
           ultimo = nuevo;
           tamanio++;
       }  
       ordenar();
   }
   
    private void ordenar(){
        sort(primero,ultimo);
    }
    
    private Nodo_ady paritionLast(Nodo_ady start, Nodo_ady end){
        if(start == end || start ==null|| end==null){
            return start;
        }
        Nodo_ady pivot_prev =start;
        Nodo_ady curr = start;
        int pivot = end.id;
        String temp_dep= end.departamento;
        String temp_nom= end.nombre;
        String temp_sucu = end.sucursal;
        
        while (start != end) {
            if (start.id < pivot) {
                // keep tracks of last modified item
                pivot_prev = curr;
                int temp2 = curr.id;
                String temp2_dep = curr.departamento;
                String temp2_nom = curr.nombre;
                String temp2_sucu= curr.sucursal;
                
                curr.id = start.id;
                curr.departamento = start.departamento;
                curr.nombre = start.nombre;
                curr.sucursal= start.sucursal;
                
                start.id = temp2;
                start.departamento=temp2_dep;
                start.nombre = temp2_nom;
                start.sucursal = temp_sucu;
                
                curr = curr.abajo;
            }
            start = start.abajo;
        }
        int tempo_id = curr.id;
        String tempo_dep = curr.departamento;
        String tempo_nom = curr.nombre;
        String tempo_sucu = curr.sucursal;
        
        curr.id = pivot;
        curr.departamento =temp_dep;
        curr.nombre = temp_nom;
        curr.sucursal = temp_sucu;
        
        end.id = tempo_id;
        end.departamento=tempo_dep;
        end.nombre = tempo_nom;
        end.sucursal = tempo_sucu;
        return pivot_prev;
    }
    
    private void sort(Nodo_ady start, Nodo_ady end){
        if(start == null || start == end || start == end.abajo){
        return;
        }
        
        Nodo_ady pivot_prev = paritionLast(start,end);
        sort(start, pivot_prev);
        
        if(pivot_prev!=null && pivot_prev == start){
            sort(pivot_prev.abajo,end);
        }else if(pivot_prev !=null && pivot_prev.abajo!=null){
            sort(pivot_prev.abajo.abajo, end);
        }
    }
    
    public void imprimir(){
        Nodo_ady aux = primero;
        while(aux!=null){
            System.out.println("id: "+aux.id+"  nombre: "+aux.nombre);
            if(aux.listado_ruta!=null){
                Nodo_ruta aux2 = aux.listado_ruta.primero;
                while(aux2!=null){
                    System.out.println("   "+aux.id+"    conexion con: "+aux2.fin+" peso: "+aux2.peso);
                    aux2 = aux2.siguiente;
                }
            }
            aux = aux.abajo;
        }
    }
    
    public void insertar_ruta(int inicio,int fin,int peso){
        boolean insercion = false;
        Nodo_ady aux = primero;
        while(aux!=null){
            if(aux.id == inicio){
                aux.listado_ruta.insertar(inicio, fin, peso);
                insercion = true;
                break;
            }
            aux = aux.abajo;
        }
        if(insercion){
            System.out.println("se inserto con exito");
        }else{
            System.out.println("NO se encontro el lugar: " + inicio);
        }
    }
    
    private String gentext_a(){
        String nodos_l ="";
        String nodos_r="";
        String conexiones ="";
        String grafotxt = "digraph Lista_dispersion {compound=true;\n graph [dpi=45] \n rankdir = LR; \n ";
        String f = "shape = box,";
        Nodo_ady aux = primero;
        
        while(aux!=null){
            nodos_l += "N"+aux.hashCode()+"["+f+"label = \""+aux.id+"\\n"+aux.nombre+"\\n \"]; \n";
            Nodo_ruta aux2 = aux.listado_ruta.primero;
            
            while(aux2!=null){
                nodos_r += "N"+aux2.hashCode()+"["+f+"label= \""+"fin: "+aux2.fin
                        +"\\n"+"peso: "+aux2.peso+"\\n \"]; \n";
                if(aux2==aux.listado_ruta.primero){
                    conexiones +="N"+aux.hashCode() +"->"+"N"+aux2.hashCode()+"; \n";
                }
                if(aux2.siguiente!=null){
                    conexiones += "N"+aux2.hashCode()+"->"+"N"+aux2.siguiente.hashCode()+"; \n";
                }
                aux2 = aux2.siguiente;
            }
            
            if(aux.abajo!=null){
                //conexiones +="N"+aux.hashCode()+"--"+"N"+aux.abajo.hashCode()+";\n";
            }
            aux = aux.abajo;
        }
        grafotxt += "subgraph cluster_0{ \n node[style = filled]\n label=\""+"lugares\";"
                   +"\n color = \""+"blue\";\n";
        grafotxt +=nodos_l+"}\n";
        grafotxt +="subgraph cluster_1{\n label=\""+"rutas\";"
                   +"\n color = \""+"red\";\n";
        grafotxt += nodos_r+"}\n";
        grafotxt += conexiones;
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
    
    public String imagen_lista(String nombre){
        archivotxt(gentext_a(),nombre);
        String d_imagen = archivopng(nombre);
        return d_imagen;
    }
     
    private String gen_grafo(){
        String nodos_l ="";
        String conexiones ="";
        String grafotxt = "strict graph grafo {compoud=true;\n graph [dpi=50] \n rankdir = LR; \n ";
        String f = "shape = circle";
        Nodo_ady aux = primero;
        
        while(aux!=null){
            nodos_l += aux.id+"["+f+",label = \""+aux.id+"\\n"+aux.nombre+"\\n \"]; \n";
            Nodo_ruta aux2 = aux.listado_ruta.primero;
            
            while(aux2!=null){
                conexiones +=aux.id+"--"+aux2.fin+"[label = \""+aux2.peso+"\"]; \n";
                aux2 = aux2.siguiente;
            }
            
            if(aux.abajo!=null){
                //conexiones +="N"+aux.hashCode()+"--"+"N"+aux.abajo.hashCode()+";\n";
            }
            aux = aux.abajo;
        }
        
        grafotxt+=nodos_l;
        grafotxt += "{ \n";
        grafotxt += conexiones;
        grafotxt += "}\n";
        grafotxt += "}\n";
        System.out.println(grafotxt);
        return grafotxt;
    } 
    
    public String imagen_grafo(String nombre){
        archivotxt(gen_grafo(),nombre);
        String d_imagen = archivopng(nombre);
        return d_imagen;
    }
}
