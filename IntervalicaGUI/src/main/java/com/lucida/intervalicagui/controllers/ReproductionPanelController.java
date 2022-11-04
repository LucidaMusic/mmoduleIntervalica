package com.lucida.intervalicagui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.Getter;

import java.io.File;

@Getter
public class ReproductionPanelController extends MainPanelController{
  @FXML
  Button playButton;
  @FXML
  Button pauseButton;
  @FXML
  Button stopButton;

  public void initializeIcons(){
    //Play
    ImageView playButtonImage = new ImageView(new Image(String.valueOf(new File("C:\\Users\\Sergio\\IdeaProjects\\IntervalicaGUI\\src\\main\\resources\\images\\play.png"))));
/*
    playButtonImage.setFitHeight(30);
    playButtonImage.setFitWidth(30);
*/
    playButton.setGraphic(playButtonImage);

    //Pause
    ImageView pauseButtonImage = new ImageView(new Image(String.valueOf(new File("C:\\Users\\Sergio\\IdeaProjects\\IntervalicaGUI\\src\\main\\resources\\images\\pause.png"))));
/*
    pauseButtonImage.setFitHeight(30);
    pauseButtonImage.setFitWidth(30);
*/
    pauseButton.setGraphic(pauseButtonImage);

    //Play
    ImageView stopButtonImage = new ImageView(new Image(String.valueOf(new File("C:\\Users\\Sergio\\IdeaProjects\\IntervalicaGUI\\src\\main\\resources\\images\\stop.png"))));
    stopButtonImage.setFitHeight(24);
    stopButtonImage.setFitWidth(24);
    stopButton.setGraphic(stopButtonImage);

  }
}