package com.fabricio.cinemaflex.controllers;

import com.fabricio.cinemaflex.CinemaFlexApp;
import com.fabricio.cinemaflex.models.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class CinemaController {
    Usuario admin = new Usuario();
    Usuario empleado = new Usuario();

    @FXML
    private TextField SignUsuario;

    @FXML
    private PasswordField inPassword;

    @FXML
    private Button onMenu;

    @FXML
    private ImageView onExit;

    Stage callMenu = new Stage();
    Stage callMenuEmpleado = new Stage();
    private Usuario usuario;
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @FXML
    void offMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) onExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onMouseClickedonMenuButton(MouseEvent event) {
        String nombreUsuario = SignUsuario.getText();
        String contrasenia = inPassword.getText();

        try {
            if (nombreUsuario.equals(admin.getUsuario()) && contrasenia.equals(admin.getContrasena())) {
                FXMLLoader fxmlLoader = new FXMLLoader(CinemaFlexApp.class.getResource("menu-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());

                callMenu.initStyle(StageStyle.TRANSPARENT);
                callMenu.setTitle("Cinema Flex / Menu");
                callMenu.setScene(scene);
                callMenu.show();
            } else if (nombreUsuario.equals(empleado.getUsuario2()) && contrasenia.equals(empleado.getContrasena2())) {
                FXMLLoader fxmlLoader = new FXMLLoader(CinemaFlexApp.class.getResource("menuEmpleado-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());

                callMenuEmpleado.initStyle(StageStyle.TRANSPARENT);
                callMenuEmpleado.setTitle("Cinema Flex / Menu Empleado");
                callMenuEmpleado.setScene(scene);
                callMenuEmpleado.show();
        } else {
            mostrarAlertaError();
        }

    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void mostrarAlertaError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Credenciales incorrectas. Por favor, intente de nuevo.");

        alert.showAndWait();
    }
}