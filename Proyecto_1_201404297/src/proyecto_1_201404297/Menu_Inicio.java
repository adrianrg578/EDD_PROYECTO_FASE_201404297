/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1_201404297;

import java.util.Scanner;

/**
 *
 * @author adria
 */
public class Menu_Inicio {
    
    boolean parametro = false;
    public Menu_Inicio(){
    
    }
    
public void principal(){
System.out.println("-------------------- MENU --------------------");
        System.out.println("     1. PARAMETROS INICIALES");
        System.out.println("     2. EJECUTAR PASO");
        System.out.println("     3. ESTADO EN MEMORIA DE LAS ESTRUCTURAS");
        System.out.println("     4. REPORTES");
        System.out.println("     5. ACERCA DE");
        System.out.println("     6. SALIR \n");
        
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("ESCRIBA LA OPCION A EJECUTAR: ");
        opcion = sc.nextInt();
        sc.nextLine();
        
        switch (opcion) {
        case 1:
            opcion1();
            break;
        case 2:
            System.out.println("ACA VAN LOS PASOS \n");
            principal();
            break;
        case 3:
            System.out.println("ACA VA EL ESTADO DE LAS ESTRUCTURAS \n");
            principal();
            break;
        case 4:
            System.out.println("ACA VAN LOS REPORTES \n");
            principal();
            break;
        case 5:
            System.out.println("----------------- ACERCA DE ------------------ \n");
            System.out.println("ESTRUCTURAS DE DATOS SECCION B");
            System.out.println("PRIMER SEMESTRE 2022");
            System.out.println("ALBEN ADRIAN RAMIREZ GOMEZ");
            System.out.println("201404297 \n");
            principal();
            break;
        case 6:
            System.out.println("---------- SALIENDO DEL PROGRAMA ----------");
            System.exit(0);
            break;     
        default:
                System.out.println("LA OPCION ELEGIDA NO ESTA DISPONIBLE, INTENTE DE NUEVO");
                principal();
    }
}

public void opcion1(){
    System.out.println("\n \n");
    System.out.println("------------ PARAMETROS INICIALES ------------");
    System.out.println("     1) CARGA MASIVA");
    System.out.println("     2) CANTIDAD DE VENTANILLAS");
    System.out.println("     3. VOLVER \n");
    Scanner sc = new Scanner(System.in);
    int opcion1;
    System.out.println("ESCRIBA LA OPCION A EJECUTAR: ");
    opcion1=sc.nextInt();
    sc.nextLine();
    switch (opcion1) {
        case 1:
            System.out.println("\n \n");
            System.out.println("INSERTE DIRECCION");
            System.out.println("Direccion: \n");
            String direccion = "";
            direccion = sc.nextLine();
            System.out.println("La direccion ingresada es: "+direccion+" ");
            opcion1();
            break;
        case 2:
            System.out.println("\n \n ");
            System.out.println("INSERTE LA CANTIDAD DE VENTANILLAS A USAR: ");
            int ventanillas;
            ventanillas =sc.nextInt();
            sc.nextLine();
            System.out.println("LA CANTIDAD DE VENTANILLAS: "+ventanillas);
            opcion1();
            break;
        case 3:
            System.out.println("-----SALIENDO DE LOS PARAMETROS INCIALES----- \n");
            principal();
            break;    
        default:
            System.out.println("LA OPCION ELEGIDA NO ESTA DISPONIBLE, INTENTE DE NUEVO");
            opcion1();      
    }
    
}

public void opcion2(){

}

public void leerjson(){

}


}
