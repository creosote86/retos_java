package tarea02;

import java.util.Scanner;

/**
 *
 * Ejercicio 2: Análisis del año.
 * 
 * @author Nombre alumno/a
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
            
            int año_actual = 2021;
            
        // Variables de entrada
        
            int año;

        // Variables de salida
        
            String resultado = "";
            String siglo = "";
        
        // Variables auxiliares
            
            int año_aux = 0;
            int siglo_num = 0;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("ANÁLISIS DEL AÑO");
        System.out.println("----------------");
        System.out.print("Introduzca un año (entre 1801-2100): ");
        año = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------       

                if ((año<1801) || (año>2100)){
                    resultado = "El año introducido no es valido";                    
                }
                else {
                    if ((año>=1801) || (año<=2100)){
                        if (año<año_actual){
                            año_aux = año_actual-año;
                            siglo_num = (año/100)+1;
                            resultado = "El año introducido es anterior al actual. Han pasado " + año_aux + " años";
                        }
                        else {
                            if (año==año_actual){
                                siglo_num = (año/100)+1;
                                resultado = "El año introducido coincide con el actual";
                            }
                            else {
                                if (año>año_actual) {
                                    año_aux = año-año_actual;
                                    siglo_num = (año/100)+1;
                                    resultado = "El año introducido es posterior al actual. Faltan " + año_aux + " años";                            
                                }
                            }
                        }
                    }
                }
                
        if (siglo_num==19) 
                siglo = "El año pertenece al siglo XIX";
        else if (siglo_num==20)
                siglo = "El año pertenece al siglo XX";
        else if (siglo_num==21)
                siglo = "El año pertenece al siglo XXI";
        else if (siglo_num==22)
                siglo = "El año pertenece al siglo XXII";
        
        
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println(resultado);
        System.out.println(siglo);

    }
}
