package tarea03;

// Incluir los imports que se necesiten
import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ejercicio 3: Horario de clases.
 *
 * @author Profesor
 */
public class Ejercicio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes

        // Variables de entrada
        int hora = 0, minutos = 0;
        // Variables de salida

        // Variables auxiliares
        boolean errorEntrada;
        int caso = 0, antes = 0, despues = 0;
        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("HORARIO DE CLASES");
        System.out.println("-----------------");

        // 1. Creación de un objeto de la clase LocalTime con la primera horas de clase (08:00)
        LocalTime Hora1 = LocalTime.of(8, 00);
        //LocalTime Hora1 = LocalTime.parse("08:00");
        
        // 2. Lectura por teclado y comprobación de hora y minuto
        System.out.println("Introducción del horario que desea comprobar: ");
        errorEntrada = false;
        do {
            try {
                System.out.print("Introduzca hora (00-23): ");
                hora = teclado.nextInt();
                if (hora < 0 || hora > 23) {
                    errorEntrada = true;
                    System.err.println("Hora introducida fuera de rango");
                } else {
                    errorEntrada = false;
                }
            } catch (InputMismatchException e) {
                System.err.println("Error de lectura: no es un número entero válido");
                errorEntrada = true;
                teclado.nextLine();

            }
        } while (errorEntrada);
        errorEntrada = false;
        do {
            try {
                System.out.print("Introduzca minuto (00-59): ");
                minutos = teclado.nextInt();
                if (minutos < 0 || minutos > 59) {
                    errorEntrada = true;
                    System.err.println("Minutos introducidos fuera de rango");
                } else {
                    errorEntrada = false;
                }
            } catch (InputMismatchException e) {
                System.err.println("Error de lectura: no es un número entero válido");
                errorEntrada = true;
                teclado.nextLine();                                                 //Limpiamos el buffer de entrada
            }
        } while (errorEntrada);


        // 2.1. Leer y comprobar la hora (debe estar entre 0 y 23)
        if (Hora1.getHour() <= 23 || Hora1.getHour() >= 0) {
        }

        // 2.2.  Leer y comprobar el minuto (entre 0 y 59)
        if (Hora1.getMinute() <= 59 || Hora1.getMinute() >= 0) {
        }

        // 3. Creación de objeto LocalTime a partir de los datos leídos por teclado
        LocalTime Hora2 = LocalTime.of(hora, minutos);
        //----------------------------------------------
        //               Procesamiento 
        //----------------------------------------------
        // 4. Obtener el rango en el que se encuentra la hora a partir de los dos objetos LocalTime
        //Programación 8:00 a 9:59;
        //Sistemas Informáticos 10:00 a 11:59;
        //Entornos de Desarrollo 12:00 a 13:59.

        LocalTime a = LocalTime.of(14, 0);

        if (Hora2.isBefore(Hora1)) {
            antes = (int) Hora1.until(Hora2, MINUTES);           //Calcula la diferencia entre Hora2 y Hora1     
            caso = 0;
        } else if (Hora2.isAfter(a)) {
            despues = (int) a.until(Hora2, MINUTES);             //Calcula la diferencia entre Hora2 y a   
            caso = 1;
        } else if (Hora2 == a) {
            caso = 2;
        } else if (Hora2.isAfter(Hora1)&& Hora2.isBefore(Hora1.plusHours(2)) || Hora2 == Hora1){     //Programacion: Comprueba Hora2 mayor que 8:00 y menor que 10:00
            caso = 3;
        } else if (Hora2.isAfter(Hora1.plusHours(2))&& Hora2.isBefore(Hora1.plusHours(4))|| Hora2 == Hora1.plusHours(2) ){    //Sistemas Informaticos
            caso = 4;
        } else if (Hora2.isAfter(Hora1.plusHours(4))&& Hora2.isBefore(Hora1.plusHours(6))|| Hora2 == Hora1.plusHours(4) ){    //Entornos de Desarrollo
            caso = 5;
        } 
            
        //----------------------------------------------
        //            Salida de resultados 
        //----------------------------------------------
        // 5. Mostrar la hora y introducida y los resultados obtenidos
        System.out.printf("Hora introducida: %s\n", Hora2);
        switch (caso) {
            case 0:
                System.out.println("Aún no ha comenzado la jornada. Faltan " + antes * -1 + " minutos para comentar.");
                break;
            case 1:
                System.out.println("La jornada ya ha finalizado. Han pasado " + despues + " minutos desde el fin.");
                break;
            case 2:
                System.out.println("La jornada ya ha finalizado. Han pasado 0 minutos desde el fin.");
                break;
            case 3:
                System.out.println("Clase correspondiente: Programación.");
                break;
            case 4:
                System.out.println("Clase correspondiente: Sistemas Informaticos.");
                break;
            case 5:
                System.out.println("Clase correspondiente: Entornos de Desarrollo.");
                break;
            default:                
                System.err.println("Error.");
        }
    }

}
