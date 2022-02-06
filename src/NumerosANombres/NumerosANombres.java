package NumerosANombres;


import java.util.Arrays;

/**
 * @author ESTE EJERCICIO HA SIDO REALIZADO POR Morandeira Parejo, Lucas Norberto y revisado por Fran
 */
public class NumerosANombres {

    public static void main(String[] args) {

// Declaración de variables
//
// Variables de entrada
        int[] arrayEntrada = {0, 99, 10, 20, 15, 25, 66, 11, 7, 90, 72};
// Variables de salida
        String[] arrayResultado = new String[arrayEntrada.length];
// Variables auxiliares
        String[][] arrayNombresNumeros = {{"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"},
        {"diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"},
        {"veinte", "veintiuno", "veintidós", "veintitrés", "veinticuatro", "veinticinco", "veintiséis", "veintisiete", "veintiocho", "veintinueve"},
        {"treinta"},
        {"cuarenta"},
        {"cincuenta"},
        {"sesenta"},
        {"setenta"},
        {"ochenta"},
        {"noventa"}};

        for (int i = 0; i < arrayEntrada.length; i++) {
            if (arrayEntrada[i] < 9) {
                arrayResultado[i] = arrayNombresNumeros[0][arrayEntrada[i]];
            } else if (arrayEntrada[i] < 30) {
                int numero = arrayEntrada[i] / 10;
                int numero2 = arrayEntrada[i] % 10;
                arrayResultado[i] = arrayNombresNumeros[numero][numero2];
            } else {
                int numero3 = arrayEntrada[i] / 10;
                int numero4 = arrayEntrada[i] % 10;
                if (numero4 == 0) {
                    arrayResultado[i] = arrayNombresNumeros[numero3][0];
                } else {
                    arrayResultado[i] = arrayNombresNumeros[numero3][0] + " y " + arrayNombresNumeros[0][numero4];
                }

            }

        }

        System.out.println(Arrays.toString(arrayResultado));

    }
}
