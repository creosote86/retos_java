package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 3: Valor de un naipe en el juego del tute.
 * 
 * @author Nombre alumno/a
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        
        // Variables de entrada
            int carta;
        // Variables de salida
            int resultado = 0;
        // Variables auxiliares

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("VALOR DE UN NAIPE EN EL TUTE");
        System.out.println("----------------------------");
        System.out.print("Introduzca número (1-7, 10-12): ");
        carta = teclado.nextInt();
        
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        switch (carta){
            case 1:                 //AS
                resultado = 11;
                break;
            case 2:                 //2
                resultado = 0;
                break;
            case 3:                 //TRES
                resultado = 10;
                break;
            case 4:                 //4
                resultado = 0;
                break;
            case 5:                 //5
                resultado = 0;
                break;
            case 6:                 //6
                resultado = 0;
                break;
            case 7:                 //7
                resultado = 0;
                break;
            case 8:                 //8
                resultado = -1;
                break;
            case 9:                 //9
                resultado = -1;
                break;
            case 10:                //SOTA
                resultado = 2;
                break;
            case 11:                //CABALLO
                resultado = 3;
                break;
            case 12:                //REY
                resultado = 4;
                break;
        }
        
        
        
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("El valor del naipe con ese número es: " + resultado);


    }
}
