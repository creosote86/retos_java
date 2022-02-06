package tarea03;

// Incluir el resto de los imports que se necesiten
import java.time.LocalDate;
import libtarea3.CuentaBancaria;

/**
 * Ejercicio 1: Uso de cuentas bancarias.
 *
 * @author José María Fernández Muñoz
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // 1. Declaración de tres variables referencia a objetos instancia de la clase CuentaBancaria
        CuentaBancaria CuentaPrivada;
        CuentaBancaria CuentaConjunta;
        CuentaBancaria CuentaFamiliar;

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // En realidad no hay entrada de datos como tal dado que la información 
        // de entrada es fija y siempre la misma
        System.out.println("USANDO CUENTAS BANCARIAS");
        System.out.println("------------------------");
        System.out.printf("Fecha actual: %s\n", LocalDate.now());
        System.out.println();

        // 2.- Instanciación de tres objetos CuentaBancaria
        System.out.println("Creación de cuentas (constructores)");
        System.out.println("-----------------------------------");

        CuentaPrivada = new CuentaBancaria();
        CuentaConjunta = new CuentaBancaria();
        CuentaFamiliar = new CuentaBancaria();

        // 2.1.- Intento de crear una cuenta con fecha no válida (hay gestionar la posible excepción)
        try {
            CuentaFamiliar = new CuentaBancaria(0.0, LocalDate.parse("2027-09-01"));

        } catch (java.lang.RuntimeException e) {
            System.out.println("Intentando crear cuenta privada con una fecha no válida");
            System.out.println("Error: Parámetro de creación de la cuenta inválidos. Fecha de creación no válida: 01-09-2027\n");
        }

        // 2.2.- Intento de crear una cuenta con saldo no válido (hay gestionar la posible excepción)
        try {
            CuentaConjunta = new CuentaBancaria(-200);
        } catch (IllegalArgumentException e) {
            System.out.println("Intentando crear cuenta privada con un saldo no válido");
            System.out.println("Error: Parámetro de creación de la cuenta inválidos. Saldo inicial: -200\n");
        }

        // 2.3.- Creación de una cuenta válida usando el constructor de tres parámetros
        try {
            CuentaPrivada = new CuentaBancaria(1000, LocalDate.parse("2021-07-01"), -200);
            //System.out.printf("%s", CuentaPrivada.getFechaCreacion());
        } catch (java.lang.RuntimeException e) {
            System.out.println("Algo esta fallando");
        }

        // 2.4.- Creación de una cuenta válida usando el constructor de dos parámetros 
        try {
            CuentaConjunta = new CuentaBancaria(200, LocalDate.parse("2021-07-01"));
            //System.out.printf("%s", CuentaConjunta.getFechaCreacion());
        } catch (java.lang.RuntimeException e) {
            System.out.println("Algo sigue fallando" + "\n" + "Error: " + e + "\n");
        }
        // 2.5.- Creación de una cuenta válida usando el constructor sin parámetros 
        CuentaFamiliar = new CuentaBancaria();

        //----------------------------------------------
        //       Procesamiento + Salida de Resultados
        //----------------------------------------------
        // Dado que se va a ir mostrando información de salida a la vez que 
        // se van realizando operaciones, podemos considerar en este caso
        // que el procesamiento y la salida de resultado van unidos y "mezclados"
        // 3.- Obtención de información de la cuenta privada
        System.out.println("Prueba de los getters de la cuenta privada:");
        System.out.println("-------------------------------------------");
        System.out.printf("ID: %s\n", CuentaPrivada.getId());
        System.out.printf("Fecha de creación: %s\n", CuentaPrivada.getFechaCreacion());
        System.out.printf("Límite descubierto: % ,.2f\n", CuentaPrivada.getLimiteDescubierto());
        System.out.printf("Está embargada: %s\n", CuentaPrivada.isEmbargada());
        System.out.printf("Número de días que lleva la cuenta abierta: %s\n", CuentaPrivada.getDiasCuenta());

        // 4.- Realización de operaciones sobre las cuentas
        System.out.println("Realización de operaciones sobre las cuentas:");
        System.out.println("---------------------------------------------");        
        System.out.println("Ingresamos 100 euros en la cuenta familiar...");
        CuentaFamiliar.ingresar(100);
        System.out.println("Extraemos 100 euros de la cuenta conjunta...");
        CuentaConjunta.extraer(100);
        System.out.println("Transferimos 1100 euros de la cuenta privada a la familiar...\n");
        CuentaPrivada.transferir(1100, CuentaFamiliar);
        
        // 5.- Estado final de las cuentas
        System.out.println("Estado final de las cuentas:");
        System.out.println("----------------------------");
        
        System.out.printf("Estado final de la cuenta privada:  ID: %s", CuentaPrivada.getId());
        System.out.printf(" Saldo: % ,.2f", CuentaPrivada.getSaldo());
        System.out.printf(" - Embargada: %s\n", CuentaPrivada.isEmbargada());
        
        System.out.printf("Estado final de la cuenta conjunta: ID: %s", CuentaConjunta.getId());
        System.out.printf(" Saldo: % ,.2f", CuentaConjunta.getSaldo());
        System.out.printf(" - Embargada: %s\n", CuentaConjunta.isEmbargada());
        
        System.out.printf("Estado final de la cuenta familiar: ID: %s", CuentaFamiliar.getId());
        System.out.printf(" Saldo: % ,.2f", CuentaFamiliar.getSaldo());
        System.out.printf(" - Embargada: %s\n", CuentaFamiliar.isEmbargada());
    }

}
