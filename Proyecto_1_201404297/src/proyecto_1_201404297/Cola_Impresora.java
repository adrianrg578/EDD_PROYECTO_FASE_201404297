/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1_201404297;

/**
 *
 * @author adria
 */
class Nodo_ci {
      int id_imagen;
      int id_cliente;
      String imagen;
      Nodo_ci siguiente;
     public Nodo_ci(int id_client,String img){
        this.id_cliente = id_client;
        this.imagen = img;
        this.id_imagen=0;
        this.siguiente=null;
     } 
}

public class Cola_Impresora {
    int tamanio;
    Nodo_ci inicio;
    Nodo_ci fin;
    public Cola_Impresora(){
        this.tamanio=0;
        this.inicio=null;
        this.fin=null;
    }
    
public void insertar(int id_cliente,String img){
    Nodo_ci nuevo = new Nodo_ci(id_cliente,img);
    if(inicio == null){
            inicio = fin = nuevo;
            tamanio++;
        }else{
             fin.siguiente = nuevo;
             fin = nuevo; 
             tamanio++;
        }

}

public Nodo_ci descolar(){
    if(inicio == null){
        System.out.println("\n NO HAY CLIENTES EN LA COLA \n");
        return null;
    }else{
        Nodo_ci aux = inicio;
        Nodo_ci elemento ;
    while(aux.siguiente != fin){
        aux = aux.siguiente;
    }
        elemento = aux.siguiente;
        aux.siguiente = null;
        fin = aux;
        tamanio--;
        return elemento;       
    }   
}

public String gentxt(){
    String nodos = "";
    String conexiones = "";
    String grafotxt = "digraph Cola_Impresion { \n";
    String f = "shape=box,";
    Nodo_ci aux = inicio;
    while(aux!=null){
     nodos += "N"+aux.hashCode()+"["+f +"label = \""+aux.id_cliente+"\\n"+aux.imagen+"\\n"+ "\"];\n";
             if(aux.siguiente!=null){
                 conexiones+="N"+aux.hashCode()+"->"+"N"+aux.siguiente.hashCode()+";\n";
             }
             aux = aux.siguiente;
    }
    grafotxt += nodos;
    grafotxt += "{rank = same; \n";
    grafotxt += conexiones;
    grafotxt += "}\n";
    grafotxt += "}\n";
    
    return grafotxt;
}

}
