/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1_201404297;

/**
 *
 * @author adria
 */
class Nodo_DE{
    Nodo_cola cliente;
    int id_nodo;
    Pila imagenes_impresas;
    int pasos;
    int ventanilla;
    Nodo_DE anterior;
    Nodo_DE siguiente;
    public Nodo_DE(Nodo_cola cliente,int ventanilla){
        this.id_nodo=0;
        this.imagenes_impresas=new Pila();
        this.pasos=0;
        this.ventanilla=ventanilla;
        this.cliente=cliente;
        this.siguiente = null;
        this.anterior = null;
    }
}
public class Lista_DE {
    int tamanio;
    Nodo_DE inicio;
    Nodo_DE fin;
    public Lista_DE(){
        this.inicio=null;
        this.fin = null;
        this.tamanio = 0;   
    }
    
public void insertar(Nodo_cola cliente, int ventanilla){
    Nodo_DE nuevo = new Nodo_DE(cliente,ventanilla);
    if(inicio ==null ){
        inicio = nuevo;
        inicio.siguiente=fin;
        inicio.anterior=fin;
        fin = nuevo;
        fin.siguiente=inicio;
        fin.anterior=inicio;
        tamanio ++;
    }else{
        fin.siguiente=nuevo;
        nuevo.anterior=fin;
        fin = nuevo;
        fin.siguiente=inicio;
        inicio.anterior=fin;
        tamanio++;
    }
}

public Nodo_DE buscar(int id_cliente){
    Nodo_DE aux = inicio;
    Nodo_DE resultado = null;
    if(aux==fin){
        if(aux.cliente.id==id_cliente){
            resultado=aux;
        }else{
            System.out.println("NO hay cliente con ese codigo");
        }
    }else{
    while(aux != fin){
        if(aux.cliente.id==id_cliente){
            resultado=aux;
        }
        aux = aux.siguiente;
    }
    }
    return resultado;
}

public void extraer(int id_cliente){
    Nodo_DE aux = buscar(id_cliente);
    aux.anterior.siguiente=aux.siguiente;
    aux.siguiente.anterior=aux.anterior;
    aux.siguiente=null;
    aux.anterior=null;
    //return aux;
}

public String gentxt(){
    String nodos = "";
    String conexiones = "";
    String grafotxt = "digraph Lista_Espera {  \n";
    String f = "shape=box,";
    Nodo_DE aux = inicio;
    if(tamanio==1){
         nodos += "N"+aux.hashCode()+"["+f +"label = \""+"cliente : "+aux.cliente.nombre+"\\n"+"Ventanilla: "+aux.ventanilla+"\\n"
             +"pasos: "+aux.pasos+"\\n \"];\n";
         conexiones+="N"+inicio.hashCode()+"->"+"N"+inicio.anterior.hashCode()+"[dir = back]"+";\n";
         conexiones+="N"+fin.hashCode()+"->"+"N"+fin.siguiente.hashCode()+";\n";
         conexiones +="N"+aux.hashCode()+"->"+"N"+aux.hashCode()+";\n";
         conexiones +="N"+aux.hashCode()+"->"+"N"+aux.hashCode()+"[dir = back]"+";\n";
    }else{
            conexiones+="N"+inicio.hashCode()+"->"+"N"+inicio.anterior.hashCode()+";\n";
            conexiones+="N"+fin.hashCode()+"->"+"N"+fin.siguiente.hashCode()+";\n";
        while(aux!=fin){
        nodos += "N"+aux.hashCode()+"["+f +"label = \""+"cliente : "+aux.cliente.nombre+"\\n"+"Ventanilla: "+aux.ventanilla+"\\n"
             +"pasos: "+aux.pasos+"\\n \"];\n";
             if(aux.siguiente!=fin){
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
}

}
