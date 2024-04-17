package com.fabricio.cinemaflex.controllers;

import com.fabricio.cinemaflex.CinemaFlexApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MenuEmpleadoController {
    private Stage callVerCartelera;
    private Stage callVenderBoletos;

    @FXML
    private Button VerCartelera;

    @FXML
    private ImageView onExit;

    @FXML
    private Button venderBoletos;
    @FXML
    private Button verGanancias;
    private double gananciasDiarias = 0.0;

    @FXML
    void OnMouseClickedVerCartelera(MouseEvent event) {
        if (callVerCartelera == null) {
            initializeVerCarteleraStage();
        }
        callVerCartelera.show();
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

    @FXML
    void offMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) onExit.getScene().getWindow();
        stage.close();
        callVerCartelera = null;
        callVenderBoletos = null;
    }

    @FXML
    void onMouseClickedVenderBoletos(MouseEvent event) {
        if (callVenderBoletos == null) {
            initializeVenderBoletosStage();
        }
        callVenderBoletos.show();
    }
    private void initializeVenderBoletosStage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(CinemaFlexApp.class.getResource("venderBoletos-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            callVenderBoletos = new Stage();
            callVenderBoletos.initStyle(StageStyle.TRANSPARENT);
            callVenderBoletos.setTitle("Cinema Flex / Vender Boletos");
            callVenderBoletos.setScene(scene);
            VenderBoletosController venderBoletosController = fxmlLoader.getController();
            venderBoletosController.setMenuEmpleadoController(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void OnMouseClickedVerGanancias(MouseEvent event) {
        mostrarGananciasDiarias();
    }
    private void mostrarGananciasDiarias() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ganancias del Día");
        alert.setHeaderText(null);
        alert.setContentText("Ganancias Totales del Día: $" + gananciasDiarias);
        alert.showAndWait();
    }
    public void actualizarGananciasDiarias(double nuevasGanancias) {
        gananciasDiarias = nuevasGanancias;
    }

    public double getGananciasDiarias() {
        return gananciasDiarias;
    }
}
