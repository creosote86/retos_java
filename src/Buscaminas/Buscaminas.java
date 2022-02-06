/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscaminas;

//import java.util.*;

/**
 *
 * @author Usuario
 */
public class Buscaminas {

    private int[][] tablero; //Representa el tablero donde se colocan las minas y vamos visitando
    private int numAciertos;//Almacena el número de casillas visitas correctamente sin pisar una mina
    private int numMinas;//Almacena el número de minas que se situarán (en posiciones aleatorias) en el tablero
    private boolean partidaActiva;//La casilla se mantiene activa hasta pisar una mina.

    /**
     * 
     * @param x Número de filas del tablero
     * @param y Número de columnas del tablero
     * @param numMinas Número de minas a colocar en el tablero
     */
    public Buscaminas(int x, int y, int numMinas) {
        tablero = new int[x][y];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = 0;
            }
        }
        numAciertos = 0;
        this.numMinas = numMinas;
        colocarMinas();
        partidaActiva = true;

    }
    
    /**
     * 
     * @return Valor del atributo numAciertos
     */
    public int getNumAciertos() {
        return numAciertos;
    }

    /**
     * Método interno de la clase que coloca las 'numMinas' en posiciones aleatorias del tablero.
     */
    private void colocarMinas() {
        int x;
        int y;
        for (int i = 0; i < numMinas; i++) {
            x = (int) (Math.random() * tablero.length);
            y = (int) (Math.random() * tablero[0].length);
            this.tablero[x][y] = 1;
        }
    }

    /**
     * 
     * @param x Fila que se desea visitar
     * @param y Columna que se desea visitar
     * @return Devuelve una cadena de caracteres donde se indica si la vista es correcta, se ha pisado una mina,
     * se ha repetido visita, si hay alguna excepción por visita fuera de rango del tablero o si la partida está finalizada.
     */
    public String visitarCasilla(int x, int y) {
        if (this.partidaActiva) {
            try {
                switch (this.tablero[x][y]) {
                    case 0:
                        this.tablero[x][y] = 2;
                        this.numAciertos++;
                        return "(" + x + "," + y + ") Visita correcta, no has pisado una mina.";
                    case 1:
                        this.partidaActiva=false;
                        return "(" + x + "," + y + ") Pisaste mina. Game over.";
                    default:
                        return "(" + x + "," + y + ") Esa casilla ya la has visitado antes.";
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return "(" + x + "," + y + ") Representa unas coordenadas erróneas.";
            }
        }else{
            return "(" + x + "," + y + ") No sigas intentádolo porque la partida está terminada";
        }
    }
    
    /**
     * 
     * @return Muestra una cadena con el estado del tablero, el número de visitas satisfactorias y si la partida está finalizada o no.
     */
    public String toString(){
        String salida="";
        for(int i=0; i<this.tablero.length;i++){
            for(int j=0; j<this.tablero[0].length;j++){
                salida+=tablero[i][j]+"\t";
            }
            salida+="\n";
        }
        salida+="El número de aciertos es de: "+this.numAciertos+".\n";
        if(this.partidaActiva)
            salida+="La partida pertenece activa.";
        else
            salida+="Partida terminada";
        return salida;
    }

}
