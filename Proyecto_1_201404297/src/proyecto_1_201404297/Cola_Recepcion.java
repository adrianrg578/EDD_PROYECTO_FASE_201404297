/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1_201404297;

/**
 *
 * @author adria
 */

class Nodo{
    int id;
    String nombre;
    int color;
    int bw;
    Nodo siguiente;
    
    public Nodo(int id_cliente,String nombre_cliente,int img_color, int img_bw){
        this.id = id_cliente;
        this.nombre = nombre_cliente;
        this.color = img_color;
        this.bw = img_bw;
        this.siguiente = null;
    }
}

public class Cola_Recepcion {
    Nodo inicio;
    Nodo fin;
    
    public Cola_Recepcion(){
        this.inicio = null;
        this.fin = null;
    }
    
public void encolar(int id_cliente,String nombre_cliente,int img_color,int img_bw){
    Nodo nuevo = new Nodo(id_cliente, nombre_cliente, img_color, img_bw);
     if(inicio == null){
            inicio = fin = nuevo;
        }else{
             fin.siguiente = nuevo;
             fin = nuevo;        
        }
}

public Nodo descolar(){
    if(inicio == null){
        System.out.println("\n NO HAY CLIENTES EN LA COLA \n");
        return null;
    }else{
        Nodo aux = inicio;
        Nodo elemento ;
    while(aux.siguiente != fin){
        aux = aux.siguiente;
    }
        elemento = aux.siguiente;
        aux.siguiente = null;
        fin = aux;
        return elemento;
    }   
}

public void imprimir(){
    Nodo aux = inicio;
    if(aux==null){
        System.out.println("Lista vacia");
    }else{
        while(aux!=null){
        System.out.println("Id de Cliente: " + aux.id );
        System.out.println("Nombre de Cliente: " + aux.nombre );
        System.out.println("Imagenes a color: " + aux.color );
        System.out.println("Imagen blanco y negro: " + aux.bw +"\n" );
        aux = aux.siguiente;
        }
    }
    }
}
