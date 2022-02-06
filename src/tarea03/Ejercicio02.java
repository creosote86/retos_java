package tarea03;

// Incluir los imports que se necesiten
import libtarea3.Dado;

/**
 * Ejercicio 2: Lanzando los dados.
 *
 * @author José María Fernández Muñoz
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        Dado Dados;

        // Variables de entrada
        // Variables de salida
        // (no hace falta ninguna)
        // Variables auxiliares
        System.out.println("LANZANDO LOS DADOS");
        System.out.println("------------------");
        System.out.println();

        //----------------------------------------------
        //               Análisis inicial
        //----------------------------------------------        
        // 1. Consulta de valores iniciales
        System.out.println("1.-CONSULTA INICIAL DE VALORES GLOBALES");
        System.out.println("---------------------------------------");
        System.out.println();

        // 1.1. Número total de dados creados
        System.out.printf("Número de total de dados creados hasta el momento: %s\n", Dado.getNumeroDadosCreados());

        // 1.2. Número total de lanzamientos
        Dados = new Dado(4);
        System.out.printf("Número de total de lanzamientos llevados a cabo hasta el momento: %s\n", Dados.getNumeroLanzamientos());

        // 1.3. Consulta de los lanzamientos realizados (bucle desde 1 hasta el número de caras que se desea analizar)   
        try {
            for (int a = 1; a <= Dados.getNumeroCaras(); a++) {
                System.out.printf("Número de veces que se ha obtenido " + a + ": %s\n", Dados.getNumeroVecesCara(a));
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error");
        }

        //----------------------------------------------
        //      Creación y lanzamiento de dados
        //----------------------------------------------
        System.out.println();
        System.out.println("2.- CREACIÓN Y LANZAMIENTO DE DADOS");
        System.out.println("-----------------------------------");
        System.out.println();
        // 2.1. Intentos de creación 
        // Se intentan crear 10 dados que tengan aleatoriamente entre 0 y 8 caras (bucle)
        // Sólo algunas llamadas al constructor funcionarán y en esos casos es cuando se podrá lanzar el dado
        // Otras harán que salte una excepción IllegalArgumentException
        // Habrá que recogerla y mostrar el mensaje de error por pantalla
        //int a;

        for (int b = 1; b <= 10; b++) {                                             //Bucle para crear 10 dados
            int numero_aleatorio = (int) (Math.random() * ((8 - 0 )+1));       //Usamos Math.random para crear un numero aleatorio entre 1 y 8. Math.random ((nº max - nº min) +1)
            try {
                Dados = new Dado(numero_aleatorio);                                 //Creación de un dado con numero de caras aleatoria sacadas de la variable numero_aleatorio
                System.out.printf("Intento " + b + ": Intentando crear dado aleatorio de %s", Dados.getNumeroCaras());
                System.out.printf(" caras. Correcto. Creado dado de %s. caras\n", Dados.getNumeroCaras());
                for (int c = 1; c <= 8; c++) {                                       //Bucle para realizar 8 lanzamientos del dado creado correctamente
                    Dados.lanzar();
                }
                System.out.printf("Lo lanzamos 8 veces: %s \n", Dados.getSerieHistoricaLanzamientos());
            } catch (IllegalArgumentException e) {
                System.err.println("Intento " + b + ": Intentando crear dado aleatorio de " + numero_aleatorio + " caras. Error: Numero de caras no valido: " + numero_aleatorio);
            }
        }
        try {
            Thread.sleep(100);                                                      //Se crea una pequeña pausa para que no se sature el sistema en los bucles
        } catch (InterruptedException ex) {                                         //he imprima la salida en pantalla en la parte de análisis de resultados finales.
        }
        //----------------------------------------------
        //         Análisis de resultados finales
        //----------------------------------------------
        // 3. Análisis de resultados una vez realizados todos los lanzamientos
        System.out.println();
        System.out.println("3.-ANÁLISIS DE RESULTADOS FINALES");
        System.out.println("---------------------------------");

        // 3.1. Número total de dados creados
        System.out.printf("Número de total de dados creados hasta el momento: %s\n", Dado.getNumeroDadosCreados());

        // 3.2. Número total de lanzamientos
        System.out.printf("Número de total de lanzamientos llevados a cabo hasta el momento: %s\n", Dado.getNumeroLanzamientosGlobal());
        // 3.3. Análisis de los lanzamientos realizados (bucle desde 1 hasta el número de caras que se desea analizar)   
        try {
            for (int a = 1; a <= Dados.getNumeroCaras(); a++) {
                System.out.printf("Número de veces que se ha obtenido " + a + ": %s\n", Dado.getNumeroVecesCaraGlobal(a));
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error");
        }
    }
}
