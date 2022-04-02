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
    public Nodo_simple(int imagen){
    this.id = 0;
    this.imagen=imagen;
    }
}

class Lista_simple{
    Nodo_simple inicio;
    Nodo_simple fin;
    int tamanio;
    public Lista_simple(){
        this.inicio=null;
        this.fin = null;
        this.tamanio = 0;
    }
    
    public void insertar(int imagen){
        Nodo_simple nuevo = new Nodo_simple(imagen);
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
   
}
