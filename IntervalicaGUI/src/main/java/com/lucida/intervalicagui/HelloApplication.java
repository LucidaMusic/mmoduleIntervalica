package com.lucida.intervalicagui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.lucida.Objects.Chord;

import java.io.IOException;

public class HelloApplication extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    //String path="com/lucida/intervalicagui/hello-view.fxml"
    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("chordGenerator.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
    stage.setTitle("Hello!");
    stage.setScene(scene);
    stage.show();

    Chord chord=new Chord();
  }

  public static void main(String[] args) {
    launch();
  }
}