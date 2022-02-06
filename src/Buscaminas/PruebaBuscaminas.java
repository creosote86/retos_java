/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscaminas;

//import java.io.*;

/**
 *
 * @author Usuario
 */
public class PruebaBuscaminas {
    public static void main(String args[]){
        Buscaminas b = new Buscaminas(3,3,3);
        System.out.println(b.toString());
        System.out.println(b.visitarCasilla(-1, 0));
        System.out.println(b.toString());
        System.out.println(b.visitarCasilla(0, 0));
        System.out.println(b.toString());
        System.out.println(b.visitarCasilla(2, 2));
        System.out.println(b.toString());
        System.out.println(b.visitarCasilla(1, 2));
        System.out.println(b.toString());
    }
}
