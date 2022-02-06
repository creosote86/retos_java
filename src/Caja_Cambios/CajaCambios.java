package Caja_Cambios;

import java.util.InputMismatchException;

/**
 * Clase Caja de Cambios, en el que se implementa un programa que muestra como
 * subir/bajar de marchas.
 *
 * @author José María Fernández Muñoz
 */
public class CajaCambios {

    //ATRIBUTOS DE CLASE
    //-------------------
    //ATRIBUTOS DE OBJETO
    //-------------------
    private int numeroMarchas;
    private int marchaActual;
    String[] marchas = {"PRIMERA", "SEGUNDA", "TERCERA", "CUARTA", "QUINTA", "SEXTA"};

    /**
     * Constructor de 1 parametros, crea un objeto introduciendo el numero de
     * marchas. El numero de marchas tiene que estar entre 3 y 6.
     *
     * @param numeroMarchas Muestra el numero de marchas.
     * @throws IllegalArgumentException Devuelve un error si se introduce numero
     * de marchas fuera de rango
     */
    public CajaCambios(int numeroMarchas) throws IllegalArgumentException, InputMismatchException {
        if (numeroMarchas < 4 || numeroMarchas > 6) {
            throw new IllegalArgumentException(String.format("Numero de marchas incorrecta: %s\n", numeroMarchas));
        }
        this.numeroMarchas = numeroMarchas;
        this.marchaActual = 1;
        System.out.print("Objeto creado: ");

    }

    public CajaCambios() throws IllegalArgumentException, InputMismatchException {
        this(5);
    }

    public int getNumeroMarchas() {
        return this.numeroMarchas;
    }

    public String getEstado() {
        return this.marchas[this.marchaActual - 1];
    }

    public void subirMarcha() {
        if (this.marchaActual == this.numeroMarchas) {
            throw new IllegalStateException("Subiendo: Error. Marcha más alta alcanzada. No se puede subir más\n");
        }
        this.marchaActual++;
        System.out.printf("SUBIENDO: %s\n", this.marchas[this.marchaActual - 1]);
    }

    public void bajarMarcha() {
        if (this.marchaActual == 1) {
            throw new IllegalStateException("Bajando: Error. Marcha más baja alcanzada. No se puede bajar más\n");
        }
        this.marchaActual--;
        System.out.printf("BAJANDO: %s\n", this.marchas[this.marchaActual - 1]);
    }

    @Override
    public String toString() {
        return String.format("Caja de cambios de %s marchas. Actualmente en %s\n", this.numeroMarchas, this.marchas[this.marchaActual - 1]);
    }
}
