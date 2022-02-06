package Codigo_de_Guardia;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author José María Fernández Muñoz
 */
public class CodigoGuardia {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int ejecutar;
        String trabajo, dia = "";
        String[] cie = {"3ABC36", "1EDE27", "1UWX19", "1DEF32", "1AB45", "1STU45", "1aBC28", "1ABC31"};
        Pattern pat = Pattern.compile("1([A|E|I|O|U|S|D])([A-Z]{2})([0-9]{2})");
        //A : Lunes, E: Martes, I:Miércoles, O:Jueves, U:Viernes,
        //S ó D : Fin de Semana completo
        //Matcher mat = pat.matcher(cie[i]);

        System.out.print("¿EJECUTAR PROGRAMA? (0: NO, 1: SI): ");
        try {
            ejecutar = teclado.nextInt();
            while (ejecutar == 1) {
                                    
                System.out.println("ASIGNACIÓN DE GUARDIAS");
                System.out.println("----------------------");

                for (int i = 0; i < cie.length; i++) {
                    Matcher mat = pat.matcher(cie[i]);
                    if (mat.matches() && Integer.parseInt(mat.group(3)) >= 20) {
                        trabajo = cie[i].substring(1, 2);
                        switch (trabajo) {
                            case "A":
                                dia = "Trabaja el Lunes";
                                break;
                            case "E":
                                dia = "Trabaja el Martes";
                                break;
                            case "I":
                                dia = "Trabaja el Miércoles";
                                break;
                            case "O":
                                dia = "Trabaja el Jueves";
                                break;
                            case "U":
                                dia = "Trabaja el Viernes";
                                break;
                            case "S":
                            case "D":
                                dia = "Fin de semana";
                                break;
                            default:
                                System.out.printf("El empleado %s    No trabaja \n", cie[i]);
                                break;
                        }
                        System.out.printf("El empleado %s    %s\n", cie[i], dia);
                    } else {
                        System.out.printf("El empleado %s    No trabaja \n", cie[i]);
                    }                    
                }
                ejecutar = 0;
            }                
        } catch (InputMismatchException e) {
            System.err.println(e.getMessage());
            ejecutar = 1;
        }
    }
}
