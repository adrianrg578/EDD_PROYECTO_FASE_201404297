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
    String nodo_c;
    String pre_;
    String in_;
    String post_;
    String hoja;
    public ArbolABB(){
        this.raiz = null;
        this.nodos=0;
        this.nodo_c ="";
        this.pre_="";
        this.in_ ="";
        this.post_ = "";
        this.hoja="";
        
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
    
    public String pre(){
        pre_ = "";
        String result ="";
        result = pre(raiz);
        return result;
    }
    
    private String pre(NodoABB padre){
        if (padre!=null){
            System.out.println("capa no: "+padre.capa.id);
            pre_ += Integer.toString(padre.capa.id)+", ";
            pre(padre.izquierdo);
            pre(padre.derecho);
        }
        //System.out.println("hay "+ nodos+" nodos en el arbol");
        return pre_;
    }
    
    public String txt_te(){
        nodo_c = "";
        String conexiones ="";
        String grafotxt = "digraph arbol {node [shape=\"ellipse\"] \n";
        String f = "shape=ellipse";
        recorrido(raiz,nodo_c);
        grafotxt += nodo_c;
        grafotxt +="}";
        return grafotxt;
    }
    public void recorrido(NodoABB padre, String texto){
        if(padre!=null){
            if(padre.izquierdo!=null){
                nodo_c = nodo_c +"\n" + padre.capa.id + "->"+ padre.izquierdo.capa.id +";";
            }else{
                nodo_c = nodo_c + "\n"+ padre.capa.id + "->" +"NULL_"+ padre.capa.id+";";
            }
            if(padre.derecho!=null){
                nodo_c = nodo_c +"\n" + padre.capa.id + "->"+ padre.derecho.capa.id + ";";
            }else{
                nodo_c = nodo_c + "\n"+ padre.capa.id + "->" +"NULL_"+ padre.capa.id+";";
            }
            recorrido(padre.izquierdo,nodo_c);
            recorrido(padre.derecho,nodo_c);
        }
    }
    
    public String inorden(){
        in_ = "";
        String result ="";
        result = inorden(raiz);
        return result;
    
    }
    
    private String inorden(NodoABB padre){
        if(padre != null){
            inorden(padre.izquierdo);
            System.out.println(padre.capa.id);
            in_ += Integer.toString(padre.capa.id)+", ";
            inorden(padre.derecho);
        }
        return in_;
    }
    
    public String post(){
        post_ ="";
        String result ="";
        result = post(raiz);
        return result;
    }
    
    private String post(NodoABB padre){
        if(padre!=null){
            post(padre.izquierdo);
            post(padre.derecho);
            System.out.println(padre.capa.id);
            post_ += Integer.toString(padre.capa.id)+", ";
        }
        return post_;
    }
    public void imprimir(){
        //pre(raiz);
        //inorden(raiz);
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
    
    private void archivotxt(String codigo_txt){
        String n_capa = "arbolABB.txt";
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
        String ruta_a ="arbolABB.txt";
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
        archivotxt(txt_te());
        String d_imagen = archivopng();
        return d_imagen;
    }
    
    public int profundidad(){
        int result = -1;
        result = profundidad(raiz);
        return result;
    }
    
    private int profundidad(NodoABB praiz){
        if(praiz== null){
            return 0;
        }
        int niz = profundidad(praiz.izquierdo);
        int nde = profundidad(praiz.derecho);
        return(niz > nde) ? (niz+1):(nde+1);
    }
    
    public String hoja(){
        hoja ="";
        String result = hoja(raiz);
        return result;
    }
 
    private String hoja(NodoABB padre){
        if(padre!=null){
            if(padre.izquierdo== null && padre.derecho==null){
                hoja = hoja +padre.capa.id +", ";
            }
            hoja(padre.izquierdo);
            hoja(padre.derecho);

        }
    return hoja;
    }
    
    
}
