package Caja_Cambios;

import static java.lang.Thread.sleep;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author José María Fernández Muñoz
 */
public class PruebaCajaCambios {

    public static void main(String[] args) throws InterruptedException {
        boolean estadoPrograma = true;
        int marchas;

        Scanner teclado = new Scanner(System.in);
        System.out.println("CAJA DE CAMBIOS");
        System.out.println("---------------");
        System.out.println("Prueba del constructor sin parametros");

        CajaCambios caja1 = new CajaCambios();
        System.out.println(caja1);
        do {
            System.out.println("Prueba del constructor con parametros");
            System.out.print("Introduzca el número de marchas (4-6): ");
            try {
                marchas = teclado.nextInt();
                CajaCambios caja2 = new CajaCambios(marchas);

                System.out.printf("Prueba del metodo getEstado: %s\n", caja2.getEstado());
                System.out.printf("Prueba del metodo toString: %s\n", caja2);
                System.out.printf("Prueba de cambio (subir): \n");
                try {
                    for (int i = 0; i < marchas; i++) {
                        caja2.subirMarcha();
                        sleep(10);
                    }
                } catch (InputMismatchException | IllegalStateException e) {
                    System.err.println("Error " + e.getMessage());
                }
                try {
                    for (int i = 0; i < marchas; i++) {
                        caja2.bajarMarcha();
                        sleep(10);
                    }
                } catch (InputMismatchException | IllegalStateException e) {
                    System.err.println("Error " + e.getMessage());
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error " + e.getMessage());
                estadoPrograma = false;
            }
        } while (estadoPrograma);
    }
}
