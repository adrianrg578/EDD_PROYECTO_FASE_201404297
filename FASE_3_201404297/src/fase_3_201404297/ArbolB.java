/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase_3_201404297;

/**
 *
 * @author adria
 */
class NodoB{
    //valores
    long dpi;
    String nombre;
    String contrasenia;
    String user;
    String correo;
    int telefono;
    String direccion;
    short id_municipio;
    
    //apuntadores
    NodoB siguiente;
    NodoB anterior;
    RamaB derecha;
    RamaB izquierda;
    
    public NodoB(long dpi,String nombre,String contra,String user,String correo,
            int telefono,String direccion, short id_muni){
        //valores
        this.dpi = dpi;
        this.nombre = nombre;
        this.contrasenia = contra;
        this.user = user;
        this.correo = correo;
        this.telefono=telefono;
        this.direccion=direccion;
        this.id_municipio=id_muni;
        //punteros
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
    
    public void insertar(long dpi, String nombre,String pass,String user,String correo,
            int telefono,String direccion, short id_muni){
        NodoB nodo = new NodoB(dpi,nombre,pass,user,correo,telefono,direccion,id_muni);
        if(raiz == null){
            raiz = new RamaB();
            raiz.insertar(nodo);
        }else{
            NodoB obj = insertar_en_rama(nodo,raiz);
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
        String vuser = "vuser";
        String vcorreo = "vcorreo";
        int vtel = -999;
        String vdireccion = "vdir";
        short vid_muni = -9;
        NodoB temp, nuevo2;
        NodoB aux = rama.primero;
        RamaB rderecha = new RamaB();
        RamaB rizquierda = new RamaB();
        
        int cont = 0;
        while(aux!=null){
            cont++;
            //este metodo solo funciona con ramas de 4 nodos
            if(cont < 3){
                temp = new NodoB(aux.dpi,aux.nombre,aux.contrasenia,aux.user,
                aux.correo,aux.telefono,aux.direccion,aux.id_municipio);
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
                vuser = aux.user;
                vcorreo = aux.correo;
                vtel = aux.telefono;
                vdireccion = aux.direccion;
                vid_muni = aux.id_municipio;
            }else{
                temp = new NodoB(aux.dpi,aux.nombre,aux.contrasenia,aux.user,
                aux.correo,aux.telefono,aux.direccion,aux.id_municipio);
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
        nuevo2 = new NodoB(vdpi,vnombre,vcontra,vuser,vcorreo,vtel,vdireccion,
        vid_muni);
        nuevo2.derecha = rderecha;
        nuevo2.izquierda = rizquierda;
        return nuevo2;
    }
    
    public NodoB buscar(String usuario){
        String aux = usuario;
        NodoB resultado = buscar(raiz,usuario);
        return resultado;
    
    }
    
    private NodoB buscar(RamaB padre,String usuario){
        NodoB aux = null;
        if(padre!=null){
            NodoB temp = padre.primero;
            while(temp != null){
                if(temp.user.equals(usuario)){
                    aux = temp;
                    return aux;
                }else{
                    if(temp.izquierda!=null){
                        aux = buscar(temp.izquierda,usuario);
                    }else{
                        if (temp.derecha!=null){
                            aux = buscar(temp.derecha,usuario);
                        }else{
                            temp = temp.siguiente;
                        }
                    }
                }
            }
        }
        return aux;
    }
    
}
