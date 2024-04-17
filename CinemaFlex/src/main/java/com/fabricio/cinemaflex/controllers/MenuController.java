package com.fabricio.cinemaflex.controllers;

import java.io.IOException;

import com.fabricio.cinemaflex.CinemaFlexApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController {
    private Stage callAddPelicula;
    private Stage callVerCartelera;

    @FXML
    private Button VerCartelera;

    @FXML
    private Button addPeliculas;

    @FXML
    private ImageView onExit;


    @FXML
    void offMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) onExit.getScene().getWindow();
        stage.close();
        callVerCartelera = null;
        callAddPelicula = null;
    }

    @FXML
    void onMouseClickedAddPeliculas(MouseEvent event) {
        if (callAddPelicula == null) {
            initializeAddPeliculaStage();
        }
        callAddPelicula.show();
    }

    @FXML
    void OnMouseClickedVerCartelera(MouseEvent event) {
        if (callVerCartelera == null) {
            initializeVerCarteleraStage();
        }
        callVerCartelera.show();
    }

    private void initializeAddPeliculaStage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(CinemaFlexApp.class.getResource("AñadirPelicula-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            callAddPelicula = new Stage();
            callAddPelicula.initStyle(StageStyle.TRANSPARENT);
            callAddPelicula.setTitle("Cinema Flex / Añadir Pelicula");
            callAddPelicula.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initializeVerCarteleraStage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(CinemaFlexApp.class.getResource("cartelera-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            callVerCartelera = new Stage();
            callVerCartelera.initStyle(StageStyle.TRANSPARENT);
            callVerCartelera.setTitle("Cinema Flex / Cartelera");
            callVerCartelera.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
