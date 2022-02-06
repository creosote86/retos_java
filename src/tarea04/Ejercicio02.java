package tarea04;

import java.util.Arrays;

/**
 * Ejercicio 2. Reconocimiento de palíndromos.
 *
 * @author José María Fernández Muñoz
 */
public class Ejercicio02 {

    public static void main(String[] args) throws InterruptedException {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes

        // Variables de entrada
        // 1.- Declaración del array de objetos String de entrada
        // (Textos "Reconocer", "AMANECER", "Esto no es un palindromo",
        //    "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama",
        //    "A man a plan and a canal, Panama", "No deseo ese don..."
        String[] textos = {"Reconocer", "AMANECER", "Esto no es un palindromo", "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama",
            "A man a plan and a canal, Panama", "No deseo ese don..."};

        // Variables de salida
        // 2.- Declaración de un array de boolean para los resultados
        boolean[] resultados;
        // Variables auxiliares
        String texto_temp, texto_temp2;
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("RECONOCIMIENTO DE PALÍNDROMOS");
        System.out.println("-----------------------------");

        // 3.- Reservamos espacio para el array de resultados (procura no usar un literal)
        resultados= new boolean[textos.length];
        // 4.- Mostramos el array de textos por pantalla
        for (int i = 0; i < textos.length; i++) {
            System.out.printf("Texto %d: %s\n", (i+1), textos[i]);
        }                        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 5.- Recorremos de nuevo el array de textos
        // 5.1.- Para cada texto comprobamos si es palíndromo
        // Habrá que "limpiar" los textos de espacios y signos de puntuación
        // 5.2.- Si se trata de un palíndromo, se almacena el valor true en el
        // array de salida. Si no, se almacena false
        for (int i = 0; i < textos.length; i++) {
            
            texto_temp = textos[i].toLowerCase().replaceAll("[\\s,.:]+", "");   //Convertimos la cadena toda a minusculas y quitamos espacios en blancos
            StringBuilder palabra = new StringBuilder(texto_temp);              
            texto_temp2 = palabra.reverse().toString();                         //volteamos todos los caracteres de la palabra de izq a der.
            resultados[i] = texto_temp.equals(texto_temp2);                     //comparamos palabra original con la volteada
        }
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        {
            System.out.println();
        }
        System.out.println("RESULTADOS OBTENIDOS");
        System.out.println("--------------------");

        // 6.- Mostramos por pantalla el array de resultados
        System.out.printf("Palíndromos encontrados: %s\n", Arrays.toString(resultados));
    }

}
