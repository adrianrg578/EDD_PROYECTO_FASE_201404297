/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase_3_201404297;

/**
 *
 * @author adria
 */
class NodoHash{
    long dpi;
    String nombre;
    String apellido;
    char licencia;
    String genero;
    int telefono;
    String direccion;
    
    public NodoHash(long dpi,String nombre,String apellido,char licencia,
            String genero,int telefono,String direccion){
        this.dpi = dpi;
        this.nombre=nombre;
        this.apellido=apellido;
        this.licencia=licencia;
        this.genero=genero;
        this.telefono=telefono;
        this.direccion=direccion;
    }
}

public class TablaHash {
    NodoHash[] tabla_hash;
    int elementos;
    int factor_carga;
    int tamanio;
    
    public TablaHash(int valor){
        this.elementos=0;
        this.factor_carga=0;
        this.tamanio=valor;
        
        for(int i = 0;i>valor;i++){
            tabla_hash[i] = null;
        }
    }
    
    public void insertar(long dpi,String nombre,String apellido,char licencia,
            String genero,int telefono,String direccion){
        int posicion = funcion_hash(dpi);
        NodoHash nuevo = new NodoHash(dpi,nombre,apellido,licencia,genero,
                telefono,direccion);
        tabla_hash[posicion]=nuevo;
        elementos++;
        factor_carga = elementos/tamanio;
        
        if(factor_carga > 0.75){
            //rehashing();
        }
    }
    
    public int funcion_hash(long indice){
        long posicion;
        int resultado = 0;
        posicion = indice%(tamanio-1);
        int posint = Math.toIntExact(posicion);
            if(tabla_hash[posint]!=null){
                boolean vacio = false;
                int contador = 1; //i
                while(vacio==false){
                    posicion = ((indice % 7) +1)*contador;
                    int aux = Math.toIntExact(posicion);
                    if(tabla_hash[aux]!=null){
                        contador++;
                        vacio = false;
                    }else{
                        resultado = Math.toIntExact(posicion);
                        vacio = true;
                    }
                }
            }else{
                resultado = Math.toIntExact(posicion);
            }
        
        return resultado;
    }
    
    public void rehashing(){
        int proximo = next_primo(tamanio);
        int factor = 0;
        NodoHash[] temporal = new NodoHash[proximo];
        if(proximo>tamanio){

            for(int i = 0; i<proximo;i++){
                temporal[i] = null;
            }
        }
        
        NodoHash[] tabla_hash_temp = tabla_hash;
        
        tabla_hash = temporal;
        tamanio=proximo;
        
        for(int i = 0;i<tabla_hash_temp.length;i++){         
            if(tabla_hash_temp[i]!= null){
                int ps = funcion_hash(tabla_hash_temp[i].dpi);
                temporal[ps]=tabla_hash_temp[i];
            }
        }
        tabla_hash = temporal;
    }
    
    public int next_primo(int tamanio){
        int sig = tamanio+1;
        int resultado = 0;
        boolean primo = false;
        while(primo==false){
            if(esPrimo(sig)){
                primo = true;
                resultado = sig;
                return sig;
            }else{
                sig++;
            }
        
        }
        return resultado;
    }
    
    public boolean esPrimo(int numero){
        if(numero==0 || numero == 1 || numero==4){
            return false;
        }
        for(int x=2; x < numero/2;x++ ){
            if (numero % x ==0){
                return false;
            }
        }
        return true;
    }
       
  public void imprimir(){
      for(int i = 0; i<tabla_hash.length;i++){
          if(tabla_hash[i]!=null){
              System.out.println("indice: "+ i +"DPI: "+tabla_hash[i].dpi);
          }else{
              System.out.println("indice: "+ i +"DPI: vacio" );
          }
      }
  }
}
