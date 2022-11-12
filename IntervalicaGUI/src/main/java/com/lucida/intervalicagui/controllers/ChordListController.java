package com.lucida.intervalicagui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import lombok.Getter;
import org.lucida.Objects.Chord;

import java.io.IOException;

@Getter
public class ChordListController {
  @FXML
  HBox chordsHBox;

  public Parent getRectangleChord(Chord chord) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("chordInfoObservable2.fxml"));
    Parent chordInfoObservable = loader.load();

    ChordInfoController chordInfoController = loader.getController();
    chordInfoController.setChord(chord);

    return chordInfoObservable;
  }
/*
  public HBox getRectangleChord(String text) {
    Text chordName = new Text(text);
    chordName.setFont(Font.font("System", 64));
    chordName.setWrappingWidth(180);

    Button deleteButton = new Button("X");
    deleteButton.setOnAction(actionEvent -> {
      chordsHBox.getChildren().remove(deleteButton.getParent());
    });

    HBox hBox = new HBox(chordName, deleteButton);
    hBox.setMinWidth(200);
    hBox.setAlignment(Pos.CENTER);
    return hBox;
  }
*/
}