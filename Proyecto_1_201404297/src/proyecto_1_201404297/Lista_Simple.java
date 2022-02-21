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
    int cantidad_img;
    int ci_cl;
    int ci_bw;
    
    public Nodo_ls(int id_ventanilla){
        this.id_ventanilla = id_ventanilla;
        this.ocupada=false;
        this.cliente = null;
        this.imagenes= new Pila();
        this.siguiente= null;
        this.cantidad_img=0;
        
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
    while(aux!=null){
        if(aux.ocupada==false){
            aux.cliente = cliente;
            aux.ocupada=true;
            aux.ci_cl=aux.cliente.color;
            aux.ci_bw=aux.cliente.bw;
            aux.cantidad_img =aux.ci_bw+aux.ci_cl;
            break;
        }else{
            if(aux.imagenes.tamanio<=aux.cantidad_img){
                if(aux.imagenes.t_cl<=aux.ci_cl){
                    aux.imagenes.insertar("color", aux.cliente.id);
                    aux.imagenes.t_cl++;
                    System.out.println("Se ingreso una imagen a "+aux.imagenes.cima.imagen+" cliente: "
                            + aux.imagenes.cima.id_cliente);
                }else{
                    aux.imagenes.insertar("blanco y negro",aux.cliente.id);
                    aux.imagenes.t_bw++;
                }
            }
            aux = aux.siguiente;
        }
    }   
}

public boolean esta_vacia(){
    Nodo_ls aux = inicio;
    boolean estado = false;
    while(aux!=null){
        if(aux.ocupada==false){
            estado = true;
            break;
        }else{
            estado=false;
        }
        aux = aux.siguiente;
    }
    return estado;
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

public String gentxt(){
    String nodos = "";
    String conexiones = "";
    String grafotxt = "digraph Ventanillas { rankdir = TB; \n";
    String f = "shape=box,";
    Nodo_ls aux = inicio;
    while(aux!=null){
     nodos += "N"+aux.hashCode()+"["+f +"label = \""+"Ventanilla: "+aux.id_ventanilla+"\\n"+aux.cliente.nombre+"\\n"
             +"id_cliente: "+aux.cliente.id+"\\n \"];\n";
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
//para imagen a color sera 2 y para blanco y negro sera 1
class Nodo_pila{
    String imagen;
    int id_cliente;
    Nodo_pila siguiente;
    
    public Nodo_pila(String tipo_imagen,int id_cliente){
        this.imagen=tipo_imagen;
        this.id_cliente = id_cliente;
        this.siguiente = null;
    }
}

class Pila{
    Nodo_pila cima;
    Nodo_pila fondo;
    int tamanio=0;
    int t_bw;
    int t_cl;
    
    
    
    public Pila(){
        this.cima = null;
        this.fondo= null;
        this.t_bw=0;
        this.t_cl=0;
    }
    
public void insertar(String imagen, int id){
    Nodo_pila nuevo = new Nodo_pila(imagen,id);
    if(cima==null){
        cima = nuevo;
        fondo = nuevo;
        tamanio++;
        /*if(nuevo.imagen=="color"){
            t_cl++;
        }else{
            t_bw++;
        }*/
    }else{
        cima.siguiente = nuevo;
        cima = nuevo;
        tamanio++;
       /* if(nuevo.imagen=="color"){
            t_cl++;
        }else{
            t_bw++;
        }*/
    }
}

public Nodo_pila extraer_cima(){
    if(cima == null){
        System.out.println("LA PILA SE ENCUENTRA VACIA");
        return null;
    }else{
        Nodo_pila aux = fondo;
        Nodo_pila elem;
        if(aux==cima){
            elem = aux;
            cima=null;
            fondo=null;
            tamanio--;
            return elem;
        }else{
        while(aux.siguiente != cima){
            aux = aux.siguiente;
        }
        elem = cima;
        aux.siguiente = null;
        cima = aux;
        tamanio--;
        return elem;
        }
    }   
}

public String gentxt(){
    String nodos = "";
    String conexiones = "";
    String grafotxt = "digraph Pila_Imagenes_Ventanilla { rankdir = TB; \n";
    String f = "shape=box,";
    Nodo_pila aux = fondo;
    while(aux!=null){
     nodos += "N"+aux.hashCode()+"["+f +"label = \""+aux.id_cliente+"\\n"+aux.imagen+"\\n \"];\n";
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