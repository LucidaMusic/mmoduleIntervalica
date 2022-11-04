package com.lucida.intervalicagui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {


  @Override
  public void start(Stage stage) throws IOException {
    //System.out.println(getClass().getResource());
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chordGenerator.fxml"));

    Scene scene = new Scene(fxmlLoader.load(), 1000, 600);

    stage.setTitle("Intervalica - Generador de acordes");
    stage.setScene(scene);

    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}