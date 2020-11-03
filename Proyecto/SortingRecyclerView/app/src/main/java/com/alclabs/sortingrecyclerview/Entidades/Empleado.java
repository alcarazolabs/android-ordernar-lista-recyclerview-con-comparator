package com.alclabs.sortingrecyclerview.Entidades;

import java.util.Comparator;

public class Empleado implements Comparable<Empleado>{

    private int id;
    private String nombre;
    private double salario;

    public Empleado(int id, String nombre, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public int compareTo(Empleado empleado) {
        return this.id - empleado.getId(); //requiere enteros no ordena doubles
    }
    public static Comparator<Empleado> OrdenarPorNombreAscendente = new Comparator<Empleado>() {
        @Override
        public int compare(Empleado e1, Empleado e2) {

            return e1.getNombre().compareTo(e2.getNombre()); //Ordena
        }
    };
    public static Comparator<Empleado> OrdenarPorNombreDescendente = new Comparator<Empleado>() {
        @Override
        public int compare(Empleado e1, Empleado e2) {

            return e2.getNombre().compareTo(e1.getNombre()); //Ordena
        }
    };
}
