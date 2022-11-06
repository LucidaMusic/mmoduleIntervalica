package com.lucida.intervalicagui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import org.lucida.Objects.Chord;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class ChordInfoController implements Initializable {
  //Labels
  @FXML
  Label rootNameLabel;
  @FXML
  Label modeNameLabel;

  //Other
  @FXML
  GridPane chordInfoGrid;

  private Chord chord;

  public void setChord(Chord chord) {
    this.chord = chord;
    System.out.println(chord.getRoot().getName(true));
    System.out.println(chord.getRoot().getAlteration().getId());
    rootNameLabel.setText(chord.getRoot().getName(true));
    modeNameLabel.setText(chord.getMode().getFormalSpanishName());
    Optional.ofNullable(chord.getExtension())
      .ifPresent(extension -> {
        chordInfoGrid.addRow(3, new Label("Extension"), getGridLabel(extension.getName()));
      });
//    Optional.ofNullable(chord.getDoubleExtensions().getName())
//      .ifPresent(doubleExtension-> doubleExtensionNameLabel.setText(doubleExtension));


  }

  private Node getGridLabel(String text){
    Label label=new Label(text);
    label.setOpaqueInsets(new Insets(0,0,0,5));
    StackPane stackPane= new StackPane(label);
    stackPane.setAlignment(Pos.CENTER);
    return stackPane;
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }
}
