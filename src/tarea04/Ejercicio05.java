package tarea04;

import java.util.Arrays;
import java.util.regex.*;

/**
 * Ejercicio 5. Sopa de letras.
 *
 * @author José María Fernández Muñoz
 */
public class Ejercicio05 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        // 1.- Declaración del array unidimensional que contiene la lista de palabras para buscar
        String[] listaPalabras = {"Hola", "sol", "AMOR", "ARA", "Casa", "dos"};
        // 2.- Declaración del array bidimensional que representa la sopa de letras
        char[][] sopaLetras = {{'H', 'J', 'S', 'O', 'L'}, {'O', 'E', 'C', 'A', 'U'},
        {'L', 'Y', 'K', 'D', 'A'}, {'A', 'A', 'M', 'O', 'R'}, {'V', 'C', 'A', 'S', 'A'}};

        // Variables de salida
        // 3.- Declaración del array unidimensional que almacena los resultados
        String[] resultado;

        // Variables auxiliares
        int palabras_encontradas = 0;
        String palabra_temp = "";
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("BUSCADOR DE PALABRAS EN HORIZONTAL");
        System.out.println("----------------------------------");

        // 4.- Mostramos por pantalla el contenido de la sopa de letras en forma de tabla        
        System.out.println("Sopa de letras:");
        for (int filas = 0; filas < sopaLetras.length; filas++) {
            for (int columnas = 0; columnas < sopaLetras[filas].length; columnas++) {
                System.out.printf("%s ", sopaLetras[filas][columnas]);
            }   //Cierre FOR para columnas             
            System.out.println("");
        }//Cierre FOR para filas

        // 5.- Mostramos por pantalla la lista de palabras
        System.out.printf("Lista de palabras de prueba:\n%s\n", Arrays.toString(listaPalabras));

        //----------------------------------------------
        //  Procesamiento (implementado por los alumnos)
        //----------------------------------------------
        // 6.- Reservamos espacio para el array de resultados (sin usar un literal)
        resultado = new String[listaPalabras.length - 1];

        // 7.- Exploramos la sopa de letras para buscar horizontalmente cada una de las palabras de la lista
        // 7.1.- Recorremos la lista de palabras
        // 7.2.- Para cada palabra, la buscamos horizontalmente (en cada fila de la sopa)
        for (int filas = 0; filas < sopaLetras.length; filas++) {

            for (int columnas = 0; columnas < sopaLetras[filas].length; columnas++) {
                palabra_temp = palabra_temp.concat(Character.toString(sopaLetras[filas][columnas])); //Concatenamos cada letra de la fila y formamos
                                                                                                     //la palabra temporal.
            }//Cierre FOR columnas

            for (int i = 0; i < listaPalabras.length; i++) {                                //Bucle para recorrer toda la lista de palabras

                Pattern pat = Pattern.compile("(" + listaPalabras[i].toUpperCase() + ")");  //Le pasamos la palabra en mayuscula de la lista de palabras
                Matcher mat = pat.matcher(palabra_temp);
                if (mat.find()) {                                                           //comparamos palabra temporal con la lista de palabras
                    resultado[i] = "fila " + filas + " columna " + mat.start();             //pasamos la posición al array resultado, en la misma posicion
                    i = listaPalabras.length;                                               //que la lista de palabra
                    palabras_encontradas++;                                                 //incrementamos 1 palabra encontrada para su posterior recuento
                }

            }//Cierre FOR comprobacion palabra con la lista de palabras

            palabra_temp = "";                                                              //reseteamos palabra temporal
            if (resultado[filas] == null) {                                                 //las palabras no encontradas se quedan el valor en null
                resultado[filas] = "no";                                                    //y lo pasamos a no
            }
        }//Cierre FOR filas

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");

        // 8.- Mostramos por pantalla el array de resultados y cuántas palabras se han encontrado
        System.out.printf("Resultado de la búsqueda horizontal: \n%s\nNúmero de palabras encontradas: %s\n", Arrays.toString(resultado), palabras_encontradas);
    }
}
