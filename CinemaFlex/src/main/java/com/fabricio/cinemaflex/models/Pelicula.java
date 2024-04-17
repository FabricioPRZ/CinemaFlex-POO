package com.fabricio.cinemaflex.models;

public class Pelicula {
    private String titulo;
    private String descripcion;
    private int duracion;
    private String categoria;

    public Pelicula(String titulo, String descripcion, int duracion, String categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getCategoria() {
        return categoria;
    }
}