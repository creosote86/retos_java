package tarea04;

/**
 * Ejercicio 3. Inversión de palabras.
 *
 * @author José María Fernández Muñoz
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes

        // 1.- Declaración del array de objetos String de entrada
        // (Textos "Reconocer", "AMANECER", "Esto no es un palindromo",
        //    "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama",
        //    "A man a plan and a canal, Panama", "No deseo ese don..."
        String[] textos = {"Reconocer", "AMANECER", "Esto no es un palindromo", "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama",
            "A man a plan and a canal, Panama", "No deseo ese don..."};

        // Variables de salida
        // 2.- Declaración de un array de String para los resultados
        String[] resultado;

        // Variables auxiliares
        String texto_temp, texto_temp2 = "", texto_temp3 = "";
        int j;
        //StringBuilder[] resultado_temp;

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("INVERSIÓN DE PALABRAS");
        System.out.println("---------------------");

        // 3.- Reservamos espacio para el array de resultados (procura no usar un literal)
        resultado = new String[textos.length];

        // 4.- Mostramos el contenido del array de textos por pantalla
        // colocando cada texto en una línea diferente
        for (int i = 0; i < textos.length; i++) {
            System.out.printf("- Texto %d: %s\n", (i + 1), textos[i]);
        }

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 5.- Recorremos el array de textos.
        // Para cada texto:
        //   5.1.- obtenemos cada palabra del texto;
        //   5.2.- invertimos cada palaba del texto;
        //   5.3.- almacenamos cada palabra invertida separadas por espacios en una misma cadena.
        //         Esa cadena de palabras invertidas se almacenará en el array de resultados
        for (j = 0; j < textos.length; j++) {

            String s = textos[j];                       //Le pasamos a la variable "s" las palabras que contiene el array
            String[] words = s.split("\\s+");           //Separamos las palabras en el array words

            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].replaceAll("[^\\w]", "");  //Eliminamos todos los signos de puntuación
                texto_temp = words[i];
                StringBuilder palabra = new StringBuilder(texto_temp);
                texto_temp2 = palabra.reverse().toString();

                texto_temp3 = texto_temp3.concat(texto_temp2) + " ";

            }
            resultado[j] = texto_temp3;
            resultado[j] = resultado[j].trim();       //Eliminamos los espacios del inicio y el final
            texto_temp3 = "";
        }
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADOS OBTENIDOS");
        System.out.println("--------------------");
        // 6.- Mostdramos los resultado por pantalla.
        // Recorremos el array de textos y para cada texto:
        //   6.1. Mostramos el texto original 
        //   6.2. Mostramos el texto con las palabras invertidas
        for (int i = 0; i < resultado.length; i++) {
            System.out.printf("Texto %s: \"%s\"\n", i + 1, textos[i]);
            System.out.printf("Palabras invertidas: \"%s\"\n\n", resultado[i]);
        }
    }

}
