module com.fabricio.cinemaflex {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.fabricio.cinemaflex to javafx.fxml;
    exports com.fabricio.cinemaflex;
    exports com.fabricio.cinemaflex.controllers;
    opens com.fabricio.cinemaflex.controllers to javafx.fxml;
}