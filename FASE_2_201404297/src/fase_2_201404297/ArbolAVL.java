/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase_2_201404297;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author adria
 * estructura de datos que guarda las imagenes con su respectiva capa
 */
class NodoAVL{
    int valor; // aca lleva el valor, ya sera una imagen, nodo etc...
    ArbolABB arbol_c; // es el arbol de capas que forman las imagenes
    Matriz matriz_unificada;//matriz que unifica las capas del arbol
    int altura;
    NodoAVL izquierdo;
    NodoAVL derecho;
    
    public NodoAVL(int valor,ArbolABB arbol,Matriz union){
        this.valor=valor;
        this.altura = 0;
        this.izquierdo =null;
        this.derecho=null;
        this.arbol_c = arbol;
        this.matriz_unificada=union;
    }
}
public class ArbolAVL {
    NodoAVL raiz;
    String nodoavl ="";
    String nodoint ="";
    
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
    
    public void insertar(int id, ArbolABB arbol_capa,Matriz uni){
        raiz = insertar(id,raiz,arbol_capa,uni);
    }
    
    private NodoAVL insertar(int valor, NodoAVL raiz,ArbolABB arbol,Matriz uni){
        if(raiz == null){
            return new NodoAVL(valor,arbol,uni);
        }else{
            if(valor < raiz.valor){
                raiz.izquierdo=insertar(valor,raiz.izquierdo,arbol,uni);
                if(altura(raiz.derecho)-altura(raiz.izquierdo)==-2){
                    if(valor < raiz.izquierdo.valor){
                        raiz = ri(raiz);
                    }else{
                        raiz = rdi(raiz);
                    }
                }
            }else if(valor>raiz.valor){
                raiz.derecho = insertar(valor,raiz.derecho,arbol,uni);
                if(altura(raiz.derecho)-altura(raiz.izquierdo)==2){
                    if(valor > raiz.derecho.valor){
                        raiz = rd(raiz);
                    }else{
                        raiz = rdd(raiz);
                    }
                }
            }else{
                raiz.valor = valor;
                raiz.arbol_c=arbol;
                raiz.matriz_unificada = uni;
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
            nodo.arbol_c.imprimir();
            imprimir(nodo.derecho);
        }
    }
    public NodoAVL buscar(int id){
        int aux =id;
        NodoAVL resultado = busqueda(raiz,id);
        return resultado;
    }
    
    private NodoAVL busqueda(NodoAVL padre,int id){
        NodoAVL aux = null;
        if(padre!=null){
            if(padre.valor == id){
                aux = padre;
                return aux;
            }else if(padre.valor > id){
                aux =busqueda(padre.izquierdo,id);
            }else{
                aux = busqueda(padre.derecho,id);
            }
        }
        return aux;
    }
    
    public String txt_grafo(){
        nodoavl ="";
        nodoint = "";
        String grafotxt = "digraph arbolAVL { node [shape=\"box\"] \n";
        String f = "shape=box";
        recorrido(raiz,nodoavl);
        grafotxt += nodoavl;
        grafotxt += "}";
        return grafotxt;
    }   
    
    public void recorrido(NodoAVL nodo, String texto){
        if(nodo!=null){
            if(nodo.izquierdo != null){
                nodoavl = nodoavl + "\n"+"img_"+nodo.valor + "->"+"img_"+nodo.izquierdo.valor+";";
            }else{
                nodoavl = nodoavl + "\n"+"img_"+nodo.valor + "->"+ "NULL_"+nodo.valor+";";
            }
            if(nodo.derecho!=null){
                nodoavl = nodoavl + "\n"+"img_"+nodo.valor + "->"+"img_"+nodo.derecho.valor+";";
            }else{
                nodoavl = nodoavl + "\n"+"img_"+nodo.valor + "->"+ "NULL_"+nodo.valor+";";
            }
            recorrido(nodo.izquierdo,nodoavl);
            recorrido(nodo.derecho, nodoavl);
        }
    
    }
    
    private void archivotxt(String codigo_txt){
        String n_capa = "arbolAVL.txt";
        try {
            File f;
            f = new File(n_capa);
            if(!f.exists()){
                f.createNewFile();
            }
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write(codigo_txt);
            wr.close();
            bw.close();
        } catch (Exception e) {
        System.out.println("NO SE PUDO CREAR EL ARCHIVO");
        }
    }
    private String archivopng(){
        String ruta_a ="arbolAVL.txt";
        String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
        String fileInputPath =ruta_a;
        String fileOutputPath =ruta_a.replace(".txt", ".png");
        String tParam = "-Tjpg";
        String tOParam = "-o";
        try {  
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
                  
            Runtime rt = Runtime.getRuntime();
      
            rt.exec( cmd );
      
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return fileOutputPath;
    }
    public String imagen(){
        archivotxt(txt_grafo());
        String d_imagen = archivopng();
        return d_imagen;
    }
    
    public NodoAVL eliminar(int id){
        NodoAVL result = null;
        result = eliminar(raiz,id);
        return result;
    }
    
    private NodoAVL nodomenor(NodoAVL padre){
        NodoAVL actual = padre;
        while(padre.izquierdo!=null){
            actual = actual.izquierdo;
        }
        return actual;
    }
    
    private int obtener_balance(NodoAVL nodo){
        if(nodo ==null){
            return 0;
        }
        return altura(nodo.izquierdo)-altura(nodo.derecho);
    }
    
    private NodoAVL eliminar(NodoAVL padre,int id){
        if(raiz==null){
            return padre;
        }
        if(id<padre.valor){
            padre.izquierdo=eliminar(padre.izquierdo,id);
        }else if(id>padre.valor){
            padre.derecho = eliminar(padre.derecho,id);
        }else{
            if((padre.izquierdo==null)||(padre.derecho==null)){
                NodoAVL temp = null;
                if(temp == padre.izquierdo){
                    temp = padre.derecho;
                }else{
                    temp = padre.izquierdo;
                }
                if(temp==null){
                    temp = padre;
                    padre = null;
                }else{
                    padre = temp;
                }
                
            }else{
                NodoAVL temp = nodomenor(padre.derecho);
                padre.valor = temp.valor;
                padre.arbol_c = temp.arbol_c;
                padre.matriz_unificada=temp.matriz_unificada;
                padre.derecho = eliminar(padre.derecho,temp.valor);
            }
        }
        if(padre ==null){
            return padre;
        }
        padre.altura = MAX(altura(padre.izquierdo),altura(padre.derecho))+1;
        
        int balance = obtener_balance(padre);
        
        if(balance >1 && obtener_balance(padre.izquierdo)>=0){
            return rd(padre);
        }
        if(balance > 1 && obtener_balance(padre.izquierdo)<0){
            padre.izquierdo = ri(padre.izquierdo);
            return rd(padre);
        }
        if(balance < -1 && obtener_balance(padre.derecho)<=0){
            return ri(padre);
        }
        if(balance < -1 && obtener_balance(padre.derecho)>0){
            padre.derecho = rd(padre.derecho);
            return ri(padre);
        }
        return padre;
    }
}

