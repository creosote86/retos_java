package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 4: puntuación de un texto.
 *
 * @author Nombre alumno/a
 */
public class Ejercicio04 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        
        // Variables de entrada
            String texto ="";
            
        // Variables de salida
            int puntuacion_total;
        // Variables auxiliares
            int min_caracteres = 0;
            int min_multiplicador = 5;
            int puntuacion_vocales = 0;
            int puntuacion_xyz = 0;
            int puntuacion_X = 0;
            int puntuacion_resto = 0;
            int multiplicador = 0;
            int caracter, valor_caracter;            
            
        // Clase Scanner para petición de datos
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("VALOR DE UN TEXTO");
        System.out.println("------------------");
        while (min_caracteres<5){                                                   //bucle para verificar que el texto introduccido es de 5 caracteres
            System.out.print("Introduzca un texto con al menos 5 caracteres: ");    //si es de menos de 5 caracteres vuelve a pedir introducir texto
            texto = teclado.next();
            min_caracteres = texto.length();
        }
        while ((min_multiplicador>3)|(min_multiplicador<1)){                            //bucle para verificar que el multiplicador esta entre 1 y 3
            System.out.print("Introduzca el valor del multiplicador (entre 1-3): ");    
            min_multiplicador = teclado.nextInt();
            multiplicador = min_multiplicador;

        }
               
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
                       
         for (int a=0; a<texto.length();a++){           //Bucle para leer todos los caracteres del texto introducido.
 
            caracter = texto.charAt(a);
            valor_caracter = (int)caracter;             
         
         switch (caracter){
            //    A        E        I        O        U        a         e         i         o         u     Todas las vocales valen 1 punto.
            case 65: case 69: case 73: case 79: case 85: case 97: case 101: case 105: case 111: case 117:
                   puntuacion_vocales = puntuacion_vocales + 1;
                 break;
            //    x          y         z    Los tres caracteres vales cada uno 2 puntos.
            case 120: case 121: case 122: 
                   puntuacion_xyz = puntuacion_xyz + 2;
                 break;
            //    X                         La X vale 5 puntos
            case 88: 
                   puntuacion_X = puntuacion_X + 5;
                 break;
            //                              El resto de caracteres restan 1 punto.
            default:                        
                puntuacion_resto = puntuacion_resto - 1;
            }                                           
         }
         
         puntuacion_total = (puntuacion_vocales+puntuacion_xyz+puntuacion_X+puntuacion_resto)*multiplicador;                            
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("El valor del texto es: " + puntuacion_total);        
    }
}
