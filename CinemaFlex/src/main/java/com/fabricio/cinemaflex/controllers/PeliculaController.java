package com.fabricio.cinemaflex.controllers;

import com.fabricio.cinemaflex.models.Administracion;
import com.fabricio.cinemaflex.models.Accion;
import com.fabricio.cinemaflex.models.Infantil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PeliculaController {
    @FXML
    private TextField OnCategoria;

    @FXML
    private TextArea OnDescripcion;

    @FXML
    private TextField OnDuracion;

    @FXML
    private TextField OnDiferencia;

    @FXML
    private TextField OnTitulo;

    @FXML
    private ImageView onExit;

    @FXML
    private Button SaveCambios;

    private Administracion administracion;

    public PeliculaController() {
        this.administracion = new Administracion();
    }

    @FXML
    void offMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) onExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onMouseClickedSaveCambios(MouseEvent event) {
        String titulo = OnTitulo.getText();
        String descripcion = OnDescripcion.getText();
        String duracionText = OnDuracion.getText();
        String categoria = OnCategoria.getText();
        String diferencia = OnDiferencia.getText();

        int duracion = 0;
        try {
            duracion = Integer.parseInt(duracionText);
        } catch (NumberFormatException e) {
            mostrarAlerta("¡ADVERTENCIA!", "La duración debe ser un número válido.");
            return;
        }

        if (diferencia.toLowerCase().equalsIgnoreCase("si")) {
            String violencia = diferencia;
            Accion nuevaPelicula = new Accion(titulo, descripcion, duracion, categoria, violencia);
            administracion.addPelicula(nuevaPelicula);
        } else {
            String familiar = diferencia;
            Infantil nuevaPelicula = new Infantil(titulo, descripcion, duracion, categoria, familiar);
            administracion.addPelicula(nuevaPelicula);
        }

        mostrarAlertaInformation("Información", "La pelicula se ha agregado correctamente");

        OnTitulo.clear();
        OnDescripcion.clear();
        OnDuracion.clear();
        OnCategoria.clear();
        OnDiferencia.clear();
    }


    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    private void mostrarAlertaInformation(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

}