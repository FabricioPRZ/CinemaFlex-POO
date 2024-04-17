package com.fabricio.cinemaflex.models;

import java.util.ArrayList;

public class Administracion {
    private static ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

    public static boolean addPelicula(Pelicula pelicula) {
        return listaPeliculas.add(pelicula);
    }

    public static ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

}
