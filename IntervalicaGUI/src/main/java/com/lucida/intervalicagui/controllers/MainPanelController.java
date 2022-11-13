package com.lucida.intervalicagui.controllers;

import com.lucida.intervalicagui.options.durationOptions2;
import com.lucida.intervalicagui.text.TextConstants;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import lombok.Getter;
import org.lucida.Enums.*;
import org.lucida.Exceptions.ChordNameNotDecipherableException;
import org.lucida.Objects.Chord;
import org.lucida.Tools.ChordNamesDecipher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.lucida.intervalicagui.text.TextConstants.NO_ROOT_OR_MODE;

@Getter
public class MainPanelController extends ChordListController {
  @FXML
  TextField enterChordInput;
  @FXML
  Button enterChordButton;
  @FXML
  ChoiceBox<durationOptions2> durationChoiceBox;
  @FXML
  Text chordNameValidation;

  //ChoicesBox
  @FXML
  ChoiceBox<Notes> rootChoiceBox;
  @FXML
  ChoiceBox<Alterations> alterationChoiceBox;
  @FXML
  ChoiceBox<Modes> modeChoiceBox;
  @FXML
  ChoiceBox<Extensions> extensionChoiceBox;
  @FXML
  ChoiceBox<DoubleExtensions> doubleExtensionChoiceBox;
  @FXML
  ChoiceBox<Notes> inversionChoiceBox;

  @FXML
  Button createByChoicesButton;

  @FXML
  Text chordNameValidation2;

  //Chord dynamically created by choice boxes
  private Chord chord;

  //Data
  List<Chord> chordList = new ArrayList<>();


  @FXML
  protected void enterChordButtonAction() throws IOException {
    String text = enterChordInput.getText();

    Float duration = durationChoiceBox.getValue().getDuration();

    if (text.isBlank()) {
      if (!chordNameValidation.getText().isBlank()) {
        chordNameValidation.setText("");
      }

      return;
    }

    Chord chord;
    try {
      chord = ChordNamesDecipher.decipher(text, durationChoiceBox.getValue().getDuration());
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
    ObservableList<durationOptions2> durationChoices = FXCollections.observableArrayList(
      durationOptions2.values());

    durationChoiceBox.setItems(durationChoices);
    durationChoiceBox.setValue(durationOptions2.BLACK);
    //durationChoiceBox.setStyle("-fx-font: 20px \"Segoe UI\";");

    //Root
    ObservableList<Notes> rootChoices = FXCollections.observableArrayList(
      Notes.values());

    rootChoiceBox.setItems(rootChoices);
    rootChoiceBox.valueProperty().addListener((observableValue, previousValue, newValue) -> {

    });

    //Alteration for root
    ObservableList<Alterations> alterationChoices = FXCollections.observableArrayList(
      Alterations.values());

    alterationChoiceBox.setItems(alterationChoices);
    alterationChoiceBox.setValue(Alterations.NATURAL);

    //Mode
    ObservableList<Modes> modeChoices = FXCollections.observableArrayList(
      Modes.values());

    modeChoiceBox.setItems(modeChoices);

    //Extension
    ObservableList<Extensions> extensionChoices = FXCollections.observableArrayList(
      Extensions.values());

    extensionChoiceBox.setItems(extensionChoices);

    //Double extension
    ObservableList<DoubleExtensions> doubleExtensionChoices = FXCollections.observableArrayList(
      DoubleExtensions.values());

    doubleExtensionChoiceBox.setItems(doubleExtensionChoices);

    //Inversion

  }

  public void createChordByChoicesAction() {
    if (rootChoiceBox.getSelectionModel().isEmpty() || modeChoiceBox.getSelectionModel().isEmpty())
      chordNameValidation2.setText(NO_ROOT_OR_MODE);

    if(!chordNameValidation2.getText().isBlank() && !rootChoiceBox.getSelectionModel().isEmpty() && !modeChoiceBox.getSelectionModel().isEmpty())
      chordNameValidation2.setText("");

  }
}