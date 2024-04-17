package com.fabricio.cinemaflex.controllers;

import com.fabricio.cinemaflex.models.Administracion;
import com.fabricio.cinemaflex.models.Pelicula;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VenderBoletosController {

    @FXML
    private TextField OnAsientos;

    @FXML
    private TextField OnBoletos;

    @FXML
    private TextField OnHora;

    @FXML
    private TextField OnPelicula;

    @FXML
    private TextField OnPrecio;

    @FXML
    private TextField OnSala;

    @FXML
    private Button Vender;

    @FXML
    private ImageView onExit;

    private CarteleraController carteleraController;
    private Pelicula peliculaSeleccionada;
    private MenuEmpleadoController menuEmpleadoController;
    private Administracion administracion;

    public VenderBoletosController() {
        this.administracion = new Administracion();
    }

    public void setCarteleraController(CarteleraController carteleraController) {
        this.carteleraController = carteleraController;
    }

    public void setPeliculaSeleccionada(Pelicula peliculaSeleccionada) {
        this.peliculaSeleccionada = peliculaSeleccionada;
    }

    @FXML
    void offMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) onExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onMouseClickedVender() {
        String nombrePeliculaIngresado = OnPelicula.getText().trim();

        if (nombrePeliculaIngresado.isEmpty()) {
            mostrarAlerta("Error", "Ingrese el nombre de la película.");
            return;
        }

        Pelicula peliculaSeleccionada = encontrarPeliculaPorNombre(nombrePeliculaIngresado);

        if (peliculaSeleccionada == null) {
            mostrarAlerta("Error", "La película no está en la cartelera. Seleccione una película válida.");
            return;
        }

        try {
            int boletos = Integer.parseInt(OnBoletos.getText());
            String asientos = OnAsientos.getText();
            String sala = OnSala.getText();
            String hora = OnHora.getText();
            double precio = Double.parseDouble(OnPrecio.getText());

            OnBoletos.clear();
            OnAsientos.clear();
            OnSala.clear();
            OnHora.clear();
            OnPrecio.clear();

            double total = boletos * precio;

            double gananciasDiariasActuales = menuEmpleadoController.getGananciasDiarias();
            menuEmpleadoController.actualizarGananciasDiarias(gananciasDiariasActuales + total);


            mostrarAlerta("Información de Venta", "Detalles de la venta:\n\n" +
                    "Boletos: " + boletos + "\n" +
                    "Película: " + peliculaSeleccionada.getTitulo() + "\n" +
                    "Asientos: " + asientos + "\n" +
                    "Sala: " + sala + "\n" +
                    "Hora: " + hora + "\n" +
                    "Precio unitario: $" + precio + "\n" +
                    "Total: $" + total);

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Por favor, ingrese valores válidos en los campos.");
        }
    }

    private Pelicula encontrarPeliculaPorNombre(String nombre) {
        for (Pelicula pelicula : administracion.getListaPeliculas()) {
            if (pelicula.getTitulo().equalsIgnoreCase(nombre)) {
                return pelicula;
            }
        }
        return null;
    }

    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public void setMenuEmpleadoController(MenuEmpleadoController menuEmpleadoController) {
        this.menuEmpleadoController = menuEmpleadoController;
    }
}