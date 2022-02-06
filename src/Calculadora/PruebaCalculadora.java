/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

/**
 *
 * @author Usuario
 */
public class PruebaCalculadora {
        public static void main(String[] args){
            Calculadora c = new Calculadora(45.4,2.5,'/');
            String resultado = c.getResultado();
            System.out.println("RESULTADO OBTENIDO DE LA CLASE CALCULADORA");
            System.out.println("==========================================");
            System.out.println(resultado);
            
            System.out.println("\nAhora modifico el valor del primer valor.");
            c.setNum1(33);
            resultado = c.getResultado();
            System.out.println("NUEVO RESULTADO OBTENIDO DE LA CLASE CALCULADORA");
            System.out.println("===============================================");
            System.out.println(resultado);
            
        }
}
