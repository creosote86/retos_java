package BusquedaOX;


import java.util.Arrays;


/**
 * @author ESTE EJERCICIO HA SIDO REALIZADO POR Morandeira Parejo, Lucas Norberto y revisado por Fran
 */
public class BusquedaOX {
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        char[] caracteres = {'O', 'X', 'L', 'B'};
        //char[] caracteresAleatorio = new char[20];
        int resultado = 0;
        boolean coincidencia = false;

        /*for (int i = 0; i < caracteresAleatorio.length; i++) {
            int numeroAuxiliar = (int) (Math.random() * caracteres.length);
            caracteresAleatorio[i] = caracteres[numeroAuxiliar];
        }*/
        
        //Pruebo una cadena que no tiene OX para comprobar que NO sale abruptamente
        char[] caracteresAleatorio = {'L', 'L', 'B', 'O', 'B', 'B', 'B', 'B', 'B', 'X', 'X', 'B', 'L', 'L', 'B', 'O', 'O', 'O', 'O', 'O'};
        
        System.out.println("Mostramos la cadena inicial:");
        System.out.println("============================");
        System.out.println(Arrays.toString(caracteresAleatorio));
        
        boolean encontrado=false;
        for(int i=0; i<caracteresAleatorio.length-1 && !encontrado;i++){
            if (caracteresAleatorio[i] == 'O' && caracteresAleatorio[i + 1] == 'X') {
                encontrado=true;
                resultado = i;
            } 
        }
        
        if (encontrado) {
            System.out.println("OX en la posición " + resultado);
        } else {
            System.out.println("No hay OX");
        }

    }

}
