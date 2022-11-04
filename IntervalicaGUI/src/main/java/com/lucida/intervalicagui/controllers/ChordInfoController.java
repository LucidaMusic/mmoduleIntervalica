package com.lucida.intervalicagui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.lucida.Objects.Chord;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class ChordInfoController implements Initializable {
  @FXML
  Label rootNameLabel;
  @FXML
  Label modeNameLabel;
  @FXML
  Label extensionNameLabel;
  @FXML
  Label doubleExtensionNameLabel;
  @FXML
  Label inversionNameLabel;

  private Chord chord;

  public void setChord(Chord chord) {
    this.chord = chord;
    rootNameLabel.setText(chord.getRoot().getLatinName());
    modeNameLabel.setText(chord.getMode().getFormalSpanishName());
    Optional.ofNullable(chord.getExtension())
      .ifPresent(extension -> extensionNameLabel.setText(extension.getName()));
//    Optional.ofNullable(chord.getDoubleExtensions().getName())
//      .ifPresent(doubleExtension-> doubleExtensionNameLabel.setText(doubleExtension));

  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }
}
