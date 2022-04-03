/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase_2_201404297;

/**
 *
 * @author adria
 * arbol B de grado 5
 * 
 * 
 */
class NodoB{
    //valores
    long dpi;
    String nombre;
    String contrasenia;
    ArbolABB arbol_de_capas;
    ArbolAVL arbol_de_img;
    ListaCircularDE lista_alb;
    
    //apuntadores
    NodoB siguiente;
    NodoB anterior;
    RamaB derecha;
    RamaB izquierda;
    
    public NodoB(long dpi,String nombre,String contra){
        this.dpi = dpi;
        this.nombre = nombre;
        this.contrasenia = contra;
        this.arbol_de_capas=null;
        this.arbol_de_img = null;
        this.lista_alb = null;
        this.siguiente=null;
        this.anterior=null;
        this.derecha=null;
        this.izquierda = null;
    }
}

class RamaB{
    boolean hoja;
    int contador;
    NodoB primero;
    
    public RamaB(){
        this.primero=null;
        this.hoja = true;
        this.contador= 0;
    }
    
    public void insertar(NodoB nuevo){
        if(primero == null){
            primero = nuevo;
            contador++;
        }else{
            NodoB aux = primero;
                while(aux !=null){
                    if(aux.dpi == nuevo.dpi){
                        //ya existe
                        System.out.println("el dpi ingresado ya existe");
                        break;
                    }else{
                        if(aux.dpi > nuevo.dpi){//insersion al inicio
                            if(aux==primero){
                                aux.anterior = nuevo;
                                nuevo.siguiente = aux;
                                //
                                aux.izquierda = nuevo.derecha;
                                nuevo.derecha = null;
                        
                                primero = nuevo;
                                contador++;
                                break;
                            }else{ //se inserta en medio
                                nuevo.siguiente = aux;
                                //
                                aux.izquierda = nuevo.derecha;
                                nuevo.derecha = null;
                        
                                nuevo.anterior = aux.anterior;
                                aux.anterior.siguiente = nuevo;
                                aux.anterior=nuevo;
                                contador++;
                                break;
                            }   
                        }else if(aux.siguiente==null){//insersion al final
                            aux.siguiente = nuevo;
                            nuevo.anterior = aux;
                            contador++;
                            break;
                        }
                    }
                    aux = aux.siguiente;
                }
        }
    }
}

public class ArbolB {
    int orden_arbol = 5;
    RamaB raiz;
    
    public ArbolB(){
        this.raiz = null;
    }
    
    public void insertar(long dpi, String nombre,String pass){
        NodoB nodo = new NodoB(dpi,nombre,pass);
        if(raiz == null){
            raiz = new RamaB();
            raiz.insertar(nodo);
        }else{
        //    NodoB obj = insertar_en_rama(nodo,raiz);
        }
    
    }
    
    private NodoB insertar_en_rama(NodoB nodo, RamaB rama){
        if(rama.hoja){
            rama.insertar(nodo);
            if(rama.contador==orden_arbol){
                //la rama esta llena, toda dividir
                return dividir(rama);
            }else{
                return null;
            }
        }else{
            NodoB temp = rama.primero;
            do{
                if(nodo.dpi == temp.dpi){
                    return null;
                }else if(nodo.dpi < temp.dpi){
                    NodoB obj = insertar_en_rama(nodo,temp.izquierda);
                    if (obj instanceof NodoB){
                        rama.insertar((NodoB)obj);
                        if(rama.contador == orden_arbol){
                            return dividir(rama);
                        }
                    }
                    return null;
                }else if(temp.siguiente==null){
                    NodoB obj = insertar_en_rama(nodo,temp.derecha);
                    if(obj instanceof NodoB){
                        rama.insertar((NodoB)obj);
                        if(rama.contador == orden_arbol){
                            return dividir(rama);
                        }
                    }
                    return null;
                }
                temp = (NodoB)temp.siguiente;
            }while(temp!=null);
        }
        return null;
    }
    
    private NodoB dividir(RamaB rama){
        long vdpi = -9999;
        String vnombre = "vnombre";
        String vcontra = "vcontra";
        NodoB temp, nuevo2;
        NodoB aux = rama.primero;
        RamaB rderecha = new RamaB();
        RamaB rizquierda = new RamaB();
        
        int cont = 0;
        while(aux!=null){
            cont++;
            //este metodo solo funciona con ramas de 4 nodos
            if(cont < 3){
                temp = new NodoB(aux.dpi,aux.nombre,aux.contrasenia);
                temp.izquierda = aux.izquierda;
                if(cont == 2){
                    temp.derecha = aux.siguiente.izquierda;
                }else{
                    temp.derecha = aux.derecha;
                }
                //si la rama posee ramas deja de ser hoja
                if(temp.derecha != null && temp.izquierda !=null){
                    rizquierda.hoja = false;
                }
                
                rizquierda.insertar(temp);
            }else if(cont == 3){
                vdpi = aux.dpi;
                vnombre = aux.nombre;
                vcontra = aux.contrasenia;
            }else{
                temp = new NodoB(aux.dpi,aux.nombre,aux.contrasenia);
                temp.izquierda = aux.izquierda;
                temp.derecha = aux.derecha;
                //si la rama posee rama, ya no es hoja
                if(temp.derecha !=null && temp.izquierda !=null){
                    rderecha.hoja=false;
                }
                rderecha.insertar(temp);
            }
            aux = aux.siguiente;
        }
        nuevo2 = new NodoB(vdpi,vnombre,vcontra);
        nuevo2.derecha = rderecha;
        nuevo2.izquierda = rizquierda;
        return nuevo2;
    }
    
}
