package com.fabricio.cinemaflex.models;

public class Accion extends Pelicula {
    private String violencia;

    public Accion(String titulo, String descripcion, int duracion, String categoria, String violencia) {
        super(titulo, descripcion, duracion, categoria);
        this.violencia = violencia;
    }

    public String getViolencia() {
        return violencia;
    }
}
