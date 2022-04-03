/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase_2_201404297;

/**
 *
 * @author adria
 */
class NodoLCDE{
    int id;
    String nombre;
    NodoLCDE anterior;
    NodoLCDE siguiente;
    Lista_simple imagenes;//agregar una lista que estaran las imagenes
    public NodoLCDE(int id,String nombre,Lista_simple imagenes){
    this.anterior = null;
    this.siguiente = null;
    this.id = id;
    this.imagenes = imagenes;
    this.nombre = nombre;
    }
}
public class ListaCircularDE {
    int tamanio;
    NodoLCDE nodo_inicio;
    NodoLCDE nodo_final;
    
    public ListaCircularDE(){
        this.nodo_inicio=null;
        this.nodo_final=null;
        this.tamanio=0;
    }
    
    public void insertar(int id,String nombre,Lista_simple img){
        NodoLCDE nuevo = new NodoLCDE(id,nombre,img);
        if(nodo_inicio==null){
            nodo_inicio = nuevo;
            nodo_inicio.siguiente=nodo_final;
            nodo_inicio.anterior=nodo_final;
            nodo_final = nuevo;
            nodo_final.siguiente=nodo_inicio;
            nodo_final.anterior=nodo_inicio;
            tamanio++;
        }else{
            nodo_final.siguiente = nuevo;
            nuevo.anterior=nodo_final;
            nodo_final = nuevo;
            nodo_final.siguiente=nodo_inicio;
            nodo_inicio.anterior=nodo_final;
            tamanio++;
        }
    }
    
    public NodoLCDE buscar(int id){
        NodoLCDE resultado = null;
        NodoLCDE aux = nodo_inicio;
        if(aux==null){
            return resultado;
        }else if(aux == nodo_final){
            if(aux.id==id){
                resultado = aux;
                return resultado;
            }else{
                return resultado;
            }
        }else{
            while(aux !=nodo_final){
                if(aux.id==id){
                resultado = aux;
                return resultado;
                }else{
                aux = aux.siguiente;
                }
            }
        }
        return resultado;
    }
    
    /*public String generartxt(){
        String nodos = "";
        String conexiones = "";
        String grafotxt = "digraph Lista_album {  \n";
        String f = "shape=box,";
        NodoLCDE aux = nodo_inicio;
        if(tamanio==1){
           nodos +="N"+aux.hashCode()+"["+f+"label = \""+aux.nombre+"\""+"];"+"\n";
           Nodo_simple laux = aux.imagenes.inicio;
           while(laux!=null){
                nodos += "N"+laux.hashCode()+"["+f+"label = \""+"Imagen:"+laux.imagen+"\""+"];"+"\n";
                conexiones += "N"+aux.hashCode() +"->"+laux.hashCode()+";\n";
                if(laux.siguiente!=null){
                   conexiones+="N"+laux.hashCode()+"->"+"N"+laux.siguiente.hashCode()+";\n";
                }
                laux = laux.siguiente;
            }
            conexiones+="N"+aux.hashCode()+"->"+"N"+aux.anterior.hashCode()+"[dir = back]"+";\n";
            conexiones+="N"+nodo_final.hashCode()+"->"+"N"+nodo_final.siguiente.hashCode()+";\n";
            conexiones +="N"+aux.hashCode()+"->"+"N"+aux.hashCode()+";\n";
            conexiones +="N"+aux.hashCode()+"->"+"N"+aux.hashCode()+"[dir = back]"+";\n";
        }else{
            conexiones+="N"+nodo_inicio.hashCode()+"->"+"N"+nodo_inicio.anterior.hashCode()+";\n";
            conexiones+="N"+nodo_final.hashCode()+"->"+"N"+nodo_final.siguiente.hashCode()+";\n";
            while(aux!=nodo_final){
                nodos +="N"+aux.hashCode()+"["+f+"label = \""+aux.nombre+"\""+"];"+"\n";
                Nodo_simple laux = aux.imagenes.inicio;
                while(laux!=null){
                    nodos += "N"+laux.hashCode()+"["+f+"label = \""+"Imagen:"+laux.imagen+"\""+"];"+"\n";
                    conexiones += "N"+aux.hashCode() +"->"+"N"+laux.hashCode()+";\n";
                    if(laux.siguiente!=null){
                        conexiones+="N"+laux.hashCode()+"->"+"N"+laux.siguiente.hashCode()+";\n";
                    }
                    laux = laux.siguiente;
                }
                if(aux.siguiente!=nodo_final){
                    conexiones+="N"+aux.hashCode()+"->"+"N"+aux.siguiente.hashCode()+";\n";
                    conexiones+="N"+aux.hashCode()+"->"+"N"+aux.anterior.hashCode()+"[dir = back]"+";\n";
                }  
                aux = aux.siguiente;
            }
        }
        grafotxt += nodos;
        grafotxt += "{rank = same; \n";
        grafotxt += conexiones;
        grafotxt += "}\n";
        grafotxt += "}\n";
    
         return grafotxt;  
    }*/
}
   

class Nodo_simple{
    int id;
    int imagen;
    Nodo_simple siguiente;
    public Nodo_simple(int id,int imagen){
    this.id = id;
    this.imagen=imagen;
    }
}

class Lista_simple{
    Nodo_simple inicio;
    Nodo_simple fin;
    int tamanio;
    String top ;
    public Lista_simple(){
        this.inicio=null;
        this.fin = null;
        this.tamanio = 0;
        this.top = "";
    }
    
    public void insertar(int id,int imagen){
        Nodo_simple nuevo = new Nodo_simple(id,imagen);
        if(inicio==null){
            inicio = nuevo;
            fin = nuevo;
            tamanio++;
        }else{
            fin.siguiente = nuevo;
            fin = nuevo;
            tamanio++;
        }
    }
    
    public Nodo_simple buscar(int imagen){
        Nodo_simple resultado = null;
        if(inicio==null){
            return resultado;
        }else{
         Nodo_simple aux = inicio;
         while(aux!=null){
             if(aux.imagen == imagen){
                 resultado = aux;
                 return resultado;
             }
             aux = aux.siguiente;
         }
        }
        return resultado;
    }
    
    public Nodo_simple paritionLast (Nodo_simple start, Nodo_simple end){
        if(start == end || start ==null|| end==null){
            return start;
        }
        Nodo_simple pivot_prev =start;
        Nodo_simple curr = start;
        int pivot = end.imagen;
        int tid = end.id;
        
        while (start != end) {
            if (start.imagen < pivot) {
                // keep tracks of last modified item
                pivot_prev = curr;
                int temp = curr.imagen;
                int temp2 = curr.id;
                curr.imagen = start.imagen;
                curr.id = start.id;
                start.imagen = temp;
                start.id=temp2;
                curr = curr.siguiente;
            }
            start = start.siguiente;
        }
        int temp = curr.imagen;
        int temp2 = curr.id;
        curr.imagen = pivot;
        curr.id =tid;
        end.imagen = temp;
        end.id=temp2;
        return pivot_prev;
    }
    
    public void sort(Nodo_simple start, Nodo_simple end){
        if(start == null || start == end || start == end.siguiente){
        return;
        }
        
        Nodo_simple pivot_prev = paritionLast(start,end);
        sort(start, pivot_prev);
        
        if(pivot_prev!=null && pivot_prev == start){
            sort(pivot_prev.siguiente,end);
        }else if(pivot_prev !=null && pivot_prev.siguiente!=null){
            sort(pivot_prev.siguiente.siguiente, end);
        }
    }
    
    public void ordenada(){
        sort(inicio,fin);
    }
    public String imprimir(){
        top = "";
        int contador =0;
        int tp = 5;
        Nodo_simple aux = inicio;
        while(aux!=null){
            if(contador == 5){
                break;
            }
            top += tp+" lugar: "+"imagen No."+aux.id+" contiene "+aux.imagen+" capas \n";
            aux = aux.siguiente;
            contador++;
            tp--;
        }
        return top;
    }
   
}
