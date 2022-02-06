package Validacion_de_codigos_2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author José María Fernández Muñoz
 */
public class ValidacionDeCodigos2 {

    public static void main(String[] args) {

        String[] arrayEntrada = {"ZA-2000", "XAZ2000", "XA2000", "XA-1969", "YH-1969", "XQ-1970",
            "XJ-2002", "YV-2021", "XB-2022", "YV-2042", "YA-1970", "YH-2002", "XB-2021"/*, "XÑ-2021", "YÑ-2002", "YZ-2002"*/};
        String[] arraySalida = new String[arrayEntrada.length];

        System.out.println("VALIDADOR DE NÚMEROS DE SERIE");
        System.out.println("-----------------------------");
        System.out.printf("Lista de números de series de prueba: \n\n%s\n", Arrays.toString(arrayEntrada));
        System.out.println();
        System.out.println("RESULTADOS");
        System.out.println("----------");

        Pattern pat = Pattern.compile("([X|Y][A-Z])-([\\d]{4})");
        for (int i = 0; i < arrayEntrada.length; i++) {
            Matcher mat = pat.matcher(arrayEntrada[i]);            
            if (mat.matches() && Integer.parseInt(mat.group(2)) >= 1970 && Integer.parseInt(mat.group(2)) <= (LocalDate.now()).getYear()) {
                char letras = mat.group(1).charAt(0);                
                if (Integer.parseInt(mat.group(2)) % 2 == 0 && letras == 'Y') {
                    arraySalida[i] = "VALIDO";
                } else if (Integer.parseInt(mat.group(2)) % 2 == 1 && letras == 'X') {
                    arraySalida[i] = "VALIDO";
                } else arraySalida[i] = "INVALIDO";
            } else arraySalida[i] = "INVALIDO";                        
        } System.out.println(Arrays.toString(arraySalida));
    }
}
