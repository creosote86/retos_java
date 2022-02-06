package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 5: construcción de cajas.
 *
 * @author Nombre alumno/a
 */
public class Ejercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int filas = 11, columnas = 11, relleno;
        // Variables de salida

        // Variables auxiliares
        // Clase Scanner para petición de datos
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CONSTRUCCIÓN DE CAJAS");
        System.out.println("---------------------");

        while ((filas > 10) | (filas < 2)) {                            //bucle para verificar el numero de filas esta entre 2 y 10
            System.out.print("Introduzca número de filas (2-10): ");
            filas = teclado.nextInt();
        }
        while ((columnas > 10) | (columnas < 2)) {                            //bucle para verificar el numero de columnas esta entre 2 y 10
            System.out.print("Introduzca número de columnas (2-10): ");
            columnas = teclado.nextInt();
        }

        System.out.print("¿Caja rellena? (0: vacia, cualquier otro número: rellena): ");
        relleno = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        switch (relleno){ //SIN RELLENO
            case 0:
                for (int a = 1; a <= filas; a++) {
            for (int b = 1; b <= columnas; b++) {
                if ((a == 1) & (b == 1) | (a == 1) & (b == columnas) | (a == filas) & (b == 1) | (a == filas) & (b == columnas)) { //Comprueba que este en la esquina para escribir un +
                    System.out.print("+");
                } else if ((a > 1) & (b == 1) | (a < filas) & (b == 1) | (a > 1) & (b == columnas) | (a < filas) & (b == columnas)) { //Comprueba que este en los laterales del cuadrado para dibujar |
                    System.out.print("|");
                } else if ((a == 1) & (b > 1) | (a == filas) & (b < columnas)) {
                    System.out.print("-");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
                }
                break;
        default:        //CON RELLENO
            for (int a = 1; a <= filas; a++) {
                for (int b = 1; b <= columnas; b++) {
                    if ((a == 1) & (b == 1) | (a == 1) & (b == columnas) | (a == filas) & (b == 1) | (a == filas) & (b == columnas)) { //Comprueba que este en la esquina para escribir un +
                        System.out.print("+");
                    } else if ((a > 1) & (b == 1) | (a < filas) & (b == 1) | (a > 1) & (b == columnas) | (a < filas) & (b == columnas)) { //Comprueba que este en los laterales del cuadrado para dibujar |
                        System.out.print("|");
                    } else if ((a == 1) & (b > 1) | (a == filas) & (b < columnas)) {
                        System.out.print("-");
                    } else 
                        System.out.print(a-1);
                     
                }
                System.out.println("");
            }
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();

        System.out.println(
                "RESULTADO");
        System.out.println(
                "---------");

    }

}
