package com.fabricio.cinemaflex.controllers;

import com.fabricio.cinemaflex.models.Administracion;
import com.fabricio.cinemaflex.models.Pelicula;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CarteleraController {
    @FXML
    private ListView<String> VerCartelera;
    @FXML
    private Button actualizarButton;
    @FXML
    private ImageView onExit;
    private VenderBoletosController venderBoletosController;
    private Administracion administracion;

    public CarteleraController() {
        this.administracion = new Administracion();
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) onExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize() {
        cargarListaPeliculas();
    }

    private void cargarListaPeliculas() {
        ObservableList<String> listaTitulos = FXCollections.observableArrayList();

        for (Pelicula pelicula : administracion.getListaPeliculas()) {
            listaTitulos.add(pelicula.getTitulo());
        }

        VerCartelera.setItems(listaTitulos);

        VerCartelera.setOnMouseClicked(event -> {
            String tituloSeleccionado = VerCartelera.getSelectionModel().getSelectedItem();

            if (tituloSeleccionado != null) {
                Pelicula peliculaSeleccionada = encontrarPeliculaPorTitulo(tituloSeleccionado);

                if (peliculaSeleccionada != null) {
                    mostrarDetalles(peliculaSeleccionada);
                    venderBoletosController.setPeliculaSeleccionada(peliculaSeleccionada);
                }
            }
        });
    }

    public void setVenderBoletosController(VenderBoletosController venderBoletosController) {
        this.venderBoletosController = venderBoletosController;
    }

    private Pelicula encontrarPeliculaPorTitulo(String titulo) {
        for (Pelicula pelicula : administracion.getListaPeliculas()) {
            if (pelicula.getTitulo().equals(titulo)) {
                return pelicula;
            }
        }
        return null;
    }
    private void mostrarDetalles(Pelicula pelicula) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Detalles de la Película");
        alert.setHeaderText(null);
        alert.setContentText(
                "Título: " + pelicula.getTitulo() + "\n" +
                        "Descripción: " + pelicula.getDescripcion() + "\n" +
                        "Duración: " + pelicula.getDuracion() + " minutos\n" +
                        "Categoría: " + pelicula.getCategoria());
        alert.showAndWait();
    }

    @FXML
    void onMouseClickedActualizarButton(MouseEvent event) {
        cargarListaPeliculas();
    }
}