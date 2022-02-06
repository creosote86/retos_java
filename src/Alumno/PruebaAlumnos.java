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
public class PruebaAlumnos {
    public static void main(String args[]){
        double notas1[]={5,2,10,8,7,3};
        Alumno a1 = new Alumno("Fran", "Martínez López", notas1);
        System.out.println("El nombre del alumno es "+a1.getNombre());
        System.out.println("Los apellidos del alumno son "+a1.getApellidos());
        a1.setApellidos("Pérez Pérez");
        System.out.println("Los nuevos apellidos del alumno son "+a1.getApellidos());
        System.out.printf("La nota media de los exámenes es %.2f\n",a1.calcularMedia());
        System.out.println("La nota mínima de los exámenes es "+a1.calcularMinima());
        System.out.println("La nota máxima de los exámenes es "+a1.calcularMaxima());
        System.out.println("El número de exámenes aprobados es "+a1.contarAprobados());
        System.out.println("Datos del alumno:\n"+a1.toString());
    }
}
