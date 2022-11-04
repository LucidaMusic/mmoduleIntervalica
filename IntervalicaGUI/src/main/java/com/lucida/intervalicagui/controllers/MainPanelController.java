package com.lucida.intervalicagui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import lombok.Getter;
import org.lucida.Exceptions.ChordNameNotDecipherableException;
import org.lucida.Objects.Chord;
import org.lucida.Tools.ChordNamesDecipher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class MainPanelController extends ChordListController {
  @FXML
  TextField enterChordInput;
  @FXML
  Button enterChordButton;
  @FXML
  ChoiceBox<Float> durationChoiceBox;
  @FXML
  Text chordNameValidation;

  //Data
  List<Chord> chordList = new ArrayList<>();

  @FXML
  protected void enterChordButtonAction() throws IOException {
    String text = enterChordInput.getText();

    Float duration = durationChoiceBox.getValue();

    if (text.isBlank()) {
      if (!chordNameValidation.getText().isBlank()) {
        chordNameValidation.setText("");
      }

      return;
    }

    if (duration == null) {
      chordNameValidation.setText("Falta la duración del acorde.");
      return;
    }

    Chord chord;
    try {
      chord = ChordNamesDecipher.decipher(text, durationChoiceBox.getValue());
      chordList.add(chord);
    } catch (ChordNameNotDecipherableException e) {
      chordNameValidation.setText(
        "El nombre de acorde introducido no es correcto. Por favor, revisa que sea correcto.");
      return;
    }

    if (!chordNameValidation.getText().isBlank()) {
      chordNameValidation.setText("");
    }

    chordsHBox.getChildren().add(getRectangleChord(chord));
  }

  public void initializeMainPanel() {
    //Duration choices
    ObservableList<Float> durationChoices = FXCollections.observableArrayList(
      0.5f, 1f, 2f, 4f);

    durationChoiceBox.setItems(durationChoices);
  }
}