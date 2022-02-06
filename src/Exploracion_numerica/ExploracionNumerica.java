package Exploracion_numerica;

import java.util.Arrays;

/**
 *
 * @author creosote
 */
public class ExploracionNumerica {

    public static void main(String[] args) {

        int[] array1 = {1, 8, 3, 1, 3, 7, 5, 2, 4, 6};
        int[] array2 = {3, 4, 5, 6, 2, 5, 1, 7, 5, 5};
        int[] arrayResultado = new int[array1.length + array2.length];
        int sumaPar = 0;
        int sumaImpar = 0;
        int sumaResultadosImpar = 0;

        System.out.println("EJERCICIO DE ARRAYS");
        System.out.println("-------------------");
        System.out.printf("Array 1: %s\n", Arrays.toString(array1));
        System.out.printf("Array 2: %s\n", Arrays.toString(array2));

        //OPERACIONES
        for (int i = 0; i < arrayResultado.length; i++) {
            if (i < 10) {
                sumaPar += array2[i];
                sumaImpar += array1[i];
                if (i % 2 == 0) {
                    arrayResultado[i] = sumaPar;
                } else {
                    arrayResultado[i] = sumaImpar;
                }

            } else {
                if (i % 2 == 0) {
                    arrayResultado[i] += arrayResultado[i - 2] + arrayResultado[i - 4];
                } else {
                    arrayResultado[i] += arrayResultado[i - 2] * 2;
                }

            }
            
        }
        
        for (int i = 0; i < arrayResultado.length; i++) {
            if (arrayResultado[i]%2==1){
                sumaResultadosImpar+=arrayResultado[i];
            }
        }

        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.printf("Array Resultado: %s\n", Arrays.toString(arrayResultado));
        System.out.printf("Suma de todos los números impares del array resultado: %s\n", sumaResultadosImpar);       
    }

}
