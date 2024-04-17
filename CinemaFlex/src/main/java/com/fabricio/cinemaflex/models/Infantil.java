package com.fabricio.cinemaflex.models;

public class Infantil extends Pelicula {
    private String familiar;

    public Infantil(String titulo, String descripcion, int duracion, String categoria, String familiar) {
        super(titulo, descripcion, duracion, categoria);
        this.familiar = familiar;
    }

    public String getFamiliar() {
        return familiar;
    }
}
