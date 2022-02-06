/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumno;

/**
 *
 * @author Usuario
 */
public class Alumno {
    
    private String nombre;
    private String apellidos;
    private double[]notas;
    
    public Alumno(String nombre, String apellidos,double[]notas){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.notas = new double[notas.length];
        for(int i=0; i<notas.length;i++){
            this.notas[i]=notas[i];
        }
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getApellidos(){
        return apellidos;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos=apellidos;
    }
    
    public double[] getNotas(){
        return notas.clone();
    }
    
    public void setNotas(double[]notas){
        this.notas = new double[notas.length];
        for(int i=0; i<notas.length;i++){
            this.notas[i]=notas[i];
        }
    }
    
    public double calcularMedia(){
        double media=0;
        for(int i=0; i<notas.length;i++)
            media=media+notas[i];
        return media/notas.length;
    }
    
    public double calcularMinima(){
        double min=notas[0];
        for(int i=1; i<notas.length;i++)
            if(min>notas[i])
                min=notas[i];
        return min;
    }
    
    public double calcularMaxima(){
        double max=notas[0];
        for(int i=1; i<notas.length;i++)
            if(max<notas[i])
                max=notas[i];
        return max;
    }
    
    public int contarAprobados(){
        int aprobados=0;
        for(int i=0; i<notas.length;i++)
            if(notas[i]>=5)
                aprobados++;
        return aprobados;
    }
    
    @Override
    public String toString(){
        String cadena = "Nombre: "+nombre+"\n";
        cadena = cadena + "Apellidos: "+apellidos+"\n";
        cadena = cadena + "Listado de notas: [";
        for(int i=0; i<notas.length;i++){
            cadena = cadena + notas[i];
            if(i==(notas.length-1))
                cadena = cadena + "]";
            else
                cadena = cadena +", ";
        }
        return cadena;
    }
}
