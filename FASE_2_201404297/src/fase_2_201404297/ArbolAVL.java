/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase_2_201404297;

/**
 *
 * @author adria
 */
class NodoAVL{
    int valor; // aca lleva el valor, ya sera una imagen, nodo etc...
    ArbolABB arbol_c; // es el arbol de capas que forman las imagenes
    int altura;
    NodoAVL izquierdo;
    NodoAVL derecho;
    
    public NodoAVL(int valor){
        this.valor=valor;
        this.altura = 0;
        this.izquierdo =null;
        this.derecho=null;
        this.arbol_c = null;
    }
}
public class ArbolAVL {
    NodoAVL raiz;
    
    public ArbolAVL(){
        this.raiz = null;
    }
    
    private int MAX(int val1,int val2){
        if(val1>val2){
            return val1;
        }else{
            return val2;
        }
    }
    
    public void insertar(int id){
        raiz = insertar(id,raiz);
    }
    
    private NodoAVL insertar(int valor, NodoAVL raiz){
        if(raiz == null){
            return new NodoAVL(valor);
        }else{
            if(valor < raiz.valor){
                raiz.izquierdo=insertar(valor,raiz.izquierdo);
                if(altura(raiz.derecho)-altura(raiz.izquierdo)==-2){
                    if(valor < raiz.izquierdo.valor){
                        raiz = ri(raiz);
                    }else{
                        raiz = rdi(raiz);
                    }
                }
            }else if(valor>raiz.valor){
                raiz.derecho = insertar(valor,raiz.derecho);
                if(altura(raiz.derecho)-altura(raiz.izquierdo)==2){
                    if(valor > raiz.derecho.valor){
                        raiz = rd(raiz);
                    }else{
                        raiz = rdd(raiz);
                    }
                }
            }else{
                raiz.valor = valor;
            }
        }
        raiz.altura = MAX(altura(raiz.izquierdo),altura(raiz.derecho))+1;
        return raiz;
    }
    
    public int altura(NodoAVL nodo){
        if(nodo!=null){
            return nodo.altura;
        }
        return -1;
    }
    
    private NodoAVL ri(NodoAVL nodo){
        NodoAVL aux = nodo.izquierdo;
        nodo.izquierdo =aux.derecho;
        aux.derecho = nodo;
        nodo.altura = MAX(altura(nodo.derecho),altura(nodo.izquierdo))+1;
        aux.altura = MAX(altura(aux.izquierdo),nodo.altura)+1;
        return aux;
    }
    
    private NodoAVL rdi(NodoAVL nodo){
        nodo.izquierdo = rd(nodo.izquierdo);
        return ri(nodo);
    }
    
    private NodoAVL rd(NodoAVL nodo){
        NodoAVL aux = nodo.derecho;
        nodo.derecho = aux.izquierdo;
        aux.izquierdo = nodo;
        nodo.altura=MAX(altura(nodo.derecho),altura(nodo.izquierdo))+1;
        aux.altura=MAX(altura(aux.derecho),nodo.altura)+1;
        return aux;
    }
    
    private NodoAVL rdd(NodoAVL nodo){
        nodo.derecho = ri(nodo.derecho);
        return rd(nodo);
    }
    
    public void imprimir(){
        imprimir(raiz);
    }
    private void imprimir(NodoAVL nodo){
        if(nodo!= null){
            imprimir(nodo.izquierdo);
            System.out.println("VALOR: "+nodo.valor);
            imprimir(nodo.derecho);
        }
    }
}
