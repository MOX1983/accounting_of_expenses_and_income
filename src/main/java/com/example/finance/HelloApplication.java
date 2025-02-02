package com.example.finance;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("finance.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 780, 510);
        stage.setTitle("Financial control!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {launch();}
}