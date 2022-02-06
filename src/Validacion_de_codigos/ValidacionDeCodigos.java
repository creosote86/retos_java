package Validacion_de_codigos;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author creosote
 */
public class ValidacionDeCodigos {

    public static void main(String[] args) {

        int n1 = 0;
        int n2 = 0;
        int comprobacion;
        String letra;
        String[] cadena = {"76-427-V", "94-035-V", "34-864-V", "95-324-V", "90-263-V", "34-635-V", "51-619-X", "42-901-V", "68-524-V", "1234-232-H", "68-524-X"};
        String cadena1;
        boolean salir = false;

        System.out.println("VALIDACION DE CODIGOS");
        System.out.println("---------------------");
        System.out.println("Listado de codigos ya dados");

        for (int i = 0; i < cadena.length; i++) {
            System.out.printf("Codigo: %s ", cadena[i]);
            if (cadena[i].matches("[1-9][0-9]-[1-9][0-9]{2}-[X|V]")) {
                String[] separar = cadena[i].split("-");
                n1 = Integer.parseInt(separar[0]);
                n2 = Integer.parseInt(separar[1]);
                letra = separar[2];
                comprobacion = (n1 * n2) % 2;
                if (comprobacion == 0 && "V".equals(letra)) {
                    System.out.println("Valido");
                } else if (comprobacion == 1 && "X".equals(letra)) {
                    System.out.println("Valido");
                } else {
                    System.out.println("Error: Validación de letra incorrecta");
                }
            } else {
                System.out.println("Error: Formato de codigo incorrecto");
            }
        }
        System.out.println();

        do {
            System.out.print("Introduzca codigo a validar o salir para salir del programa: ");

            Scanner teclado = new Scanner(System.in);
            Pattern pat = Pattern.compile("[1-9][0-9]-[1-9][0-9]{2}-[X|V]");            
            cadena1 = teclado.nextLine();
            Matcher mat = pat.matcher(cadena1);

            if ("salir".equals(cadena1)) {
                salir = true;
            } else if (mat.matches()) {                
                String[] separar = cadena1.split("-");
                n1 = Integer.parseInt(separar[0]);
                n2 = Integer.parseInt(separar[1]);
                letra = separar[2];
                comprobacion = (n1 * n2) % 2;
                if (comprobacion == 0 && "V".equals(letra)) {
                    System.out.println("Valido");
                } else if (comprobacion == 1 && "X".equals(letra)) {
                    System.out.println("Valido");
                } else {
                    System.out.println("Error: Validación de letra incorrecta");
                }
            } else {
                System.out.println("Error: Formato de codigo incorrecto");
            }
        } while (!salir);
    }
}
