/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase_2_201404297;

/**
 *
 * @author adria
 */
class NodoABB{
    int indice;
    NodoABB izquierdo;
    NodoABB derecho;
    Matriz capa ; //este es el dato que en resumen se guarda
    
    public NodoABB(Matriz capa){
        this.capa=capa;
        this.izquierdo = null;
        this.derecho = null;
    }

}

public class ArbolABB {
    NodoABB raiz ;
    int nodos ;
    public ArbolABB(){
        this.raiz = null;
        this.nodos=0;
    }
    
    public void insertar(Matriz capa){
        raiz = insertar(capa,raiz);
        nodos++;
    }
    
    public NodoABB insertar(Matriz capa,NodoABB raiz){
        NodoABB aux = new NodoABB(capa);
        if(raiz==null){
            System.out.println("se inserto nodo en la raiz");
            return aux; 
        }else{
            if(capa.id > raiz.capa.id){
                raiz.derecho = insertar(capa,raiz.derecho);
                System.out.println("se inserto nodo en el lado derecho");
            }else{
                raiz.izquierdo = insertar(capa,raiz.izquierdo);
                System.out.println("se inserto nodo en el lado izquierdo");
            }
        }
        return raiz;
    }
    
    public void pre(NodoABB padre){
        if (padre!=null){
            System.out.println("capa no: "+padre.capa.id);
            pre(padre.izquierdo);
            pre(padre.derecho);
        }
        //System.out.println("hay "+ nodos+" nodos en el arbol");
    }
    
    public void inorden(NodoABB padre){
        if(padre != null){
            inorden(padre.izquierdo);
            System.out.println(padre.capa.id);
            inorden(padre.derecho);
        }
    }
    
    public void post(NodoABB padre){
        if(padre!=null){
            post(padre.izquierdo);
            post(padre.derecho);
            System.out.println(padre.capa.id);
        }
        
    }
    public void imprimir(){
        //pre(raiz);
        inorden(raiz);
        //post(raiz);
    }
    
    public Matriz buscar(int id){
        int aux = id;
        Matriz resultado = busqueda(raiz,id);
        return resultado;
    }
    
    private Matriz busqueda(NodoABB padre,int id){
        Matriz aux = null;
        
        if (padre!=null){
            if(padre.capa.id == id){
                aux = padre.capa;
                return aux;
            }else if(padre.capa.id > id){
               aux = busqueda(padre.izquierdo,id);
            }else{
               aux = busqueda(padre.derecho,id);
            }  
        } 
        return aux;
    }
}
