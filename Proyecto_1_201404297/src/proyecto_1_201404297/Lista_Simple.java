/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1_201404297;
//class Cola_Recepcion{};

/**
 *
 * @author adria
 */
class Nodo_ls{
    boolean ocupada;
    int id_ventanilla;
    Nodo_cola cliente;
    Pila imagenes;
    Nodo_ls siguiente;
    
    public Nodo_ls(int id_ventanilla){
        this.id_ventanilla = id_ventanilla;
        this.ocupada=false;
        this.cliente = null;
        this.imagenes= new Pila();
        this.siguiente= null;
    }

}
public class Lista_Simple {
    int tamanio;
    Nodo_ls inicio;
    Nodo_ls fin;
    public Lista_Simple(){
        this.tamanio=0;
        this.inicio=null;
        this.fin= null;
    }
    
public void creacion_ventanilla(int id){
    Nodo_ls nuevo = new Nodo_ls(id);
     if(inicio==null){
         inicio = nuevo;
         fin = nuevo;
         tamanio++;
     }else{
        fin.siguiente=nuevo;
        fin = nuevo;
        tamanio++;
     }
}
public void ingreso_ventanilla(Nodo_cola cliente){
    Nodo_ls aux = inicio;
    for(int i =0;i<tamanio;i++){
        if(aux.ocupada==false){
            aux.cliente=cliente;
            aux.ocupada=true;
            ingreso_imagen(buscar(i));
        }else{
            System.out.println("LA VENTANILLA ESTA OCUPADA");
            aux = aux.siguiente;
        } 
    }    
}
public void ingreso_imagen(Nodo_ls ventana){
    Nodo_ls ventanilla = ventana;
    int img_color = ventanilla.cliente.color;
    int img_bw = ventanilla.cliente.bw;
    
    System.out.println("imagen a color: "+ img_color);
}

public Nodo_ls buscar(int id){
    Nodo_ls aux = inicio;
    Nodo_ls objetivo;
    
    while(aux!=null){
        if(aux.id_ventanilla==id){
        objetivo = aux;
        return objetivo;
        }else{
        aux = aux.siguiente;
        }
    }
    return null;
}
    
}
//para imagen a color sera 2 y para blanco y negro sera 1
class Nodo_pila{
    String imagen;
    Nodo_pila siguiente;
    
    public Nodo_pila(String tipo_imagen){
        this.imagen=tipo_imagen;
        this.siguiente = null;
    }
}

class Pila{
    Nodo_pila cima;
    Nodo_pila fondo;
    
    public Pila(){
        this.cima = null;
        
    }
    
public void insertar(String imagen){
    Nodo_pila nuevo = new Nodo_pila(imagen);
    if(cima==null){
        cima = nuevo;
        fondo = nuevo;
    }else{
        cima.siguiente = nuevo;
        cima = nuevo;
    }
}

public Nodo_pila extraer_cima(){
    if(cima == null){
        System.out.println("LA PILA SE ENCUENTRA VACIA");
        return null;
    }else{
        Nodo_pila aux = fondo;
        Nodo_pila elem;
        while(aux.siguiente != cima){
            aux = aux.siguiente;
        }
        elem = cima;
        aux.siguiente = null;
        cima = aux;
        return elem;
    }   
}

public void imprimir(){
    
    
}
}