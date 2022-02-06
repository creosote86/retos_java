package tarea04;

import java.util.Arrays;
import java.util.regex.*;


/**
 * Ejercicio 1. Cálculo de puntuaciones.
 *
 * @author Jose Maria Fernandez Muñoz/a
 */
public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        // 1.- Declaramos un array de objetos String (anotaciones) 
        // con el contenido que se nos pide en el enunciado
        String[] arrayGrupoLetras = {"a", "a-b", "X-A", "O-O-B", "X--X", "O-X-", "-X-X", "O-X-O-X-O",
            "o", "O-o", "X", "o-x-o", "x", "x-x", "O-x-X", "X-X-X", "x-X-X-x"};

        // Variables de salida
        StringBuilder puntuacion = new StringBuilder();
        // Variables auxiliares
        String letras;
        int puntosLetras;                 //variable para puntuar cada char de cada grupo de letras
        int valido = 0, invalido = 0;
        //String elemento;
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CÁLCULO DE PUNTUACIONES");
        System.out.println("-----------------------");

        // 2.- Mostramos por pantalla el contenido del array de anotaciones
        System.out.printf("Anotaciones obtenidas de cada mano de juego:\n%s\n", Arrays.toString(arrayGrupoLetras));
       

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 3.- Recorremos cada elemento del array
        // 3.1.- Si el elemento "encaja" con el patrón (anotación válida), se calcula su puntuación
        // Para ello habrá que descomponer la anotación en cada uno de sus elementos,
        // calcular su valor y sumarlos.
        // 3.2.- Si no "encaja" con el patrón, la anotación será inválida y su puntuación -1
        // 3.3.- Las puntuaciones obtenidas se "acumulan" o "concatenan" separadaa por comas en un objeto de tipo StringBuilder        
        Pattern pat = Pattern.compile("([oOxX])(-[oOxX]){0,3}");

        for (int i = 0; i < arrayGrupoLetras.length; i++) {         //For para recorrer todo el array
            letras = arrayGrupoLetras[i];                           //Letras obtiene el valor de los datos del interior del array
            Matcher mat = pat.matcher(arrayGrupoLetras[i]);
            puntosLetras = 0;                                       //Reiniciamos la puntuacion
            if (mat.matches()) {                                    //Comprueba si el patron es valido

                valido++;
                for (int j = 0; j < letras.length(); j++) {         //For para recorrer letra por letra de cada valor del array

                    if (letras.charAt(j) == 'X' || letras.charAt(j) == 'x') {   //Si es x o X suma un punto                        
                        puntosLetras++;
                    } else {
                    }
                }
                puntuacion.append(puntosLetras).append(", ");       //Concatena puntuacion de cada letra del patron valido y lo coloca en el Stringbuilder puntuacion

            } else {                                                //Si el patron no es valido resta un punto
                invalido++;                                         //Incrementa invalido
                puntosLetras = -1;
                puntuacion.append(puntosLetras).append(", ");       //Concatena a puntuacion "-1".
            }
        }

        String puntuacionTotal = puntuacion.toString();             //Concatena 

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------       
        System.out.println();
        System.out.println("RESULTADO: PUNTUACIONES CALCULADAS");
        System.out.println("----------------------------------");

        // 4.- Mostramos por pantalla el resultado final
        // 4.1.- Lista completa de puntuaciones de cada mano
        System.out.println(puntuacionTotal);
        
        // 4.2.- Número de anotaciones válidas
        System.out.println("Número de anotaciones válidas: " + valido);
        
        // 4.3.- Número de anotaciones no válidas                        
        System.out.println("Número de anotaciones inválidas: " + invalido);
    }
}
