package tarea04;

import java.util.Arrays;

/**
 * Ejercicio 4. ¡Línea!
 *
 * @author José María Fernández Muñoz
 */
public class Ejercicio04 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        // 1.- Declaración del array que representa las bolas que han salido hasta el momento
        int[] bola = {1, 2, 5, 10, 11, 12, 14, 15, 22, 55, 56, 57, 59, 60, 61, 66, 78, 89, 90};
        // 2.- Declaración del array bidimensional "irregular" de números enteros para representar el cartón
        //int[][] carton = new int[9][];
        int carton[][] = {{1, 2, 5, 9}, {11, 15}, {22, 29}, {34}, {47, 49}, {55, 59, 60}, {61}, {71, 75}, {88, 90}};
        // Variables de salida

        // 3.- Declaración del array unidimensional que almacenará los resultados
        String[] resultado;
        // Variables auxiliares
        int comprobacion_bolas_carton = 0, resultado_lineas = 0;

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("BUSCADOR DE LÍNEAS EN UN CARTÓN DE BINGO");
        System.out.println("----------------------------------------");

        // 4.- Mostramos por pantalla el contenido del cartón
        System.out.printf("Cartón: %s", Arrays.deepToString(carton));

        // 5.- Mostramos por pantalla la lista de bolas
        System.out.printf("\nNúmeros que ya ha salido: %s\n", Arrays.toString(bola));
        //----------------------------------------------
        //                   Procesamiento 
        //---------------------------------------------- 
        // 6.- Reservamos espacio para el array de resultados (sin usar un literal)
        resultado = new String[carton.length];
        // 7.- Recorremos cada fila del cartón
        // 7.1.- Para cada fila, recorremos todos los números que contenga
        // 7.2.- Comprobamos si cada número ha salido o no (habrá que recorrer la lista de bolas que ya han salido)
        //       Si han salido todos, se marcará esa fila como "línea" en el array de resultados
        // 7.3.- Si no han salido todos, se marcará es fila como "no" en el array de resultados

        for (int filas = 0; filas < carton.length; filas++) {                       //Bucle para recorrer el primer array (filas)
            for (int columnas = 0; columnas < carton[filas].length; columnas++) {   //Bucle para recorrer el segundo array (columnas)
                for (int nbolas = 0; nbolas < bola.length; nbolas++) {   //Bucle para recorrer el array bolas
                    if (carton[filas][columnas] == bola[nbolas]) {       //se comprueba los numeros de cada fila con las bolas
                        comprobacion_bolas_carton++;                     //Se incremente en 1 para comprobar despues si es linea o no
                        nbolas = bola.length;                            //si el numero coincide no es necesario seguir buscando entre todas las bolas
                    }
                }                                                       //Cierre FOR bolas                 
            }                                                           //Cierre FOR columnas
            if (comprobacion_bolas_carton == carton[filas].length) {    //Comprobamos el numero de fila con los numeros del carton que coincide con las bolas
                resultado[filas] = "Línea";                             //Ejemplo primera fila son 4 numeros y comprobacion solo ha obtenido 3 numeros
                resultado_lineas++;
            } else {
                resultado[filas] = "no";
            }
            //resultado_no++;
            comprobacion_bolas_carton = 0;                          //reseteamos la variable comprobacion para la siguiente fila
        }  //Cierre FOR filas
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.printf("Resultado de la búsqueda de líneas en el carton de bingo:\n%s\n", Arrays.toString(resultado));

        // 8.- Mostramos por pantalla el array de resultados y cuántas líneas han salido
        System.out.printf("Número de líneas obtenidas: %s\n", resultado_lineas);
    }
}
