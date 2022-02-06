/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baraja;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Principal {
    public static void main(String[]args) {
        Baraja mano = new Baraja();
        System.out.println(mano.toString());
        
        Scanner teclado = new Scanner(System.in);
        int numeroIntroducido;
        boolean creacionCorrecta = false;
        
        do {
            System.out.println("Introduzca el número de naipes que quiera para su baraja 40 o 48");

            try {
                numeroIntroducido = teclado.nextInt();
                Baraja mano2 = new Baraja(numeroIntroducido);
                creacionCorrecta = true;
                System.out.printf("Correcto se ha creado una baraja de %d naipes%n", numeroIntroducido);
                System.out.println(mano2.toString());
                System.out.println(mano2.getNumeroDeNaipes());
                for (int i = 0; i < 10; i++) {
                    System.out.println(mano2.extraerNaipeRandom());
                }
                System.out.println(mano2.toString());

            } catch (IllegalArgumentException e) {
                System.out.println("El numero introducido no es correcto. ");
                creacionCorrecta = false;
                teclado.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("No ha introducido un número");
                creacionCorrecta = false;
                teclado.nextLine();
            }

        }while (!creacionCorrecta);           
    }
}
