/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase_2_201404297;

/**
 *
 * @author adria
 */
//Nodo de la matriz dispersa
class NodoMatriz{
    int x; //coordenada en el eje x
    int y; //coordenada en el eje y
    String color; //color que lleva expresado en hexadecimal
    
    NodoMatriz anterior; //apuntador hacia la izquierda
    NodoMatriz siguiente; //apuntador hacia la derecha
    NodoMatriz arriba;
    NodoMatriz abajo;
    
    public NodoMatriz(int y, int x, String dato){
        this.x = x;
        this.y = y;
        this.color = dato;
        this.anterior = null;
        this.siguiente= null;
        this.arriba = null;
        this.abajo = null;      
    }
}

//Matriz dispersa que guarda los datos de la capa
public class Matriz {
     NodoMatriz raiz;
     int id;
     
     public Matriz (int id){
     raiz = new NodoMatriz(-1,-1,"raiz");
     this.id = id;
     }
     
    public NodoMatriz buscar_columna(int x){
        NodoMatriz aux = raiz;
        while (aux != null){
            if (aux.x == x){
                return aux; //
            }
            aux = aux.siguiente;
        }
        return null;
    } 
    
    public NodoMatriz buscar_fila(int y){
        NodoMatriz aux = raiz;
        while (aux != null){
            if(aux.y == y){
                return aux;
            }
            aux = aux.abajo;
        }
        return null;    
    }
    
    public NodoMatriz crear_columna(int x){
        NodoMatriz nodo_columna = raiz;
        NodoMatriz nuevo = new NodoMatriz(x,-1,"col");
        NodoMatriz columna = insertar_ord_col(nuevo,nodo_columna);
        return columna;
    }
    
    public NodoMatriz insertar_ord_col(NodoMatriz nuevo,NodoMatriz cabeza_col){
        NodoMatriz aux = cabeza_col;
        boolean estado = false;
        while(true){
            if(nuevo.x == aux.x){
                aux.y = nuevo.y;
                aux.color = nuevo.color;
                return aux;
            }else if(aux.x>nuevo.x){
                estado = true;
                break;
            }
            if(aux.siguiente!=null){
                aux= aux.siguiente;
            }else{
                estado = false;
                break;
            }  
        }
        if(estado){
            nuevo.siguiente=aux;
            aux.anterior.siguiente=nuevo;
            nuevo.anterior = aux.anterior;
            aux.anterior=nuevo;
        }else{
            aux.siguiente=nuevo;
            nuevo.anterior = aux;
        }
        return nuevo;
    }
    
    public NodoMatriz crear_fila(int y){
        NodoMatriz nodo_fila = raiz;
        NodoMatriz nuevo = new NodoMatriz(-1,y,"Fila");
        NodoMatriz fila = insertar_ord_fila(nuevo,nodo_fila);
        return fila;
    }
    
    public NodoMatriz insertar_ord_fila(NodoMatriz nuevo, NodoMatriz cabeza_fila){
        NodoMatriz aux = cabeza_fila;
        boolean estado = false;
        while (true){
            if(nuevo.y==aux.y){
                aux.x = nuevo.x;
                aux.color=nuevo.color;
                return aux;
            }else if (aux.y > nuevo.y){
                estado = true;
                break;
            }
            if(aux.abajo != null){
                aux = aux.abajo;
            }else{
                estado = false;
                break;
            }
        }
        if(estado){
            nuevo.abajo=aux;
            aux.arriba.abajo=nuevo;
            nuevo.arriba=aux.arriba;
            aux.arriba=nuevo;
        }else{
            aux.abajo = nuevo;
            nuevo.arriba = aux;
        }
        return nuevo;
    }
    
    public void insertar_nodo(int x, int y, String color){
        NodoMatriz nuevo = new NodoMatriz(x,y,color);
        NodoMatriz NodoColumna = buscar_columna(x);
        NodoMatriz NodoFila = buscar_fila(y);
        
        if(NodoFila == null && NodoColumna == null){
            System.out.println("NO hay fila ni columna");
            
            NodoColumna = crear_columna(x);
            NodoFila = crear_fila(y);
            nuevo = insertar_ord_col(nuevo,NodoFila);
            nuevo = insertar_ord_fila(nuevo,NodoColumna);
        }else if(NodoFila ==null && NodoColumna !=null){
            System.out.println("NO hay fila pero si columna");
            
            NodoFila = crear_fila(y);
            nuevo = insertar_ord_col(nuevo, NodoFila);
            nuevo = insertar_ord_fila(nuevo, NodoColumna);
        }else if(NodoFila != null && NodoColumna == null){
            System.out.println("Hay filla pero no columna");
            
            NodoColumna = crear_columna(x);
            nuevo = insertar_ord_col(nuevo,NodoFila);
            nuevo = insertar_ord_fila(nuevo,NodoColumna);
        }else if(NodoFila !=null && NodoColumna !=null){
            System.out.println("existe la fila y la columna");
            
            nuevo = insertar_ord_col(nuevo, NodoFila);
            nuevo = insertar_ord_fila(nuevo, NodoColumna);
        }else{
            System.out.println("ha ocurrido un error, revisar metodos");
        }
    }
    
    public void imprimir(){
        NodoMatriz aux = raiz;
        while(aux != null){
            String texto ="";
            NodoMatriz aux2 = aux;
            while (aux2 != null){
                texto += "coordenada x: "+aux.x +" Coordenada y: "+aux.y;
                aux2 = aux2.siguiente;
            }
            System.out.println(texto);
            aux = aux.abajo;
        }
    }
}
