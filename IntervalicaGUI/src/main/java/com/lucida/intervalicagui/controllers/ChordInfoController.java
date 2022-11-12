package com.lucida.intervalicagui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import org.lucida.Objects.Chord;

import java.net.URL;
import java.util.ResourceBundle;


public class ChordInfoController implements Initializable {
  //Labels
/*
  @FXML
  Label rootNameLabel;
  @FXML
  Label modeNameLabel;

  //Other
  @FXML
  GridPane chordInfoGrid;
*/

  @FXML
  ScrollPane scrollPane;

  private Chord chord;

/*  public void setChord(Chord chord) {
    this.chord = chord;
    System.out.println(chord.getRoot().getName(true));
    System.out.println(chord.getRoot().getAlteration().getId());
    rootNameLabel.setText(chord.getRoot().getName(true));
    modeNameLabel.setText(chord.getMode().getFormalSpanishName());
   // if (chord.hasExtension()) {
      chordInfoGrid=new GridPane();
      chordInfoGrid.add(new Label("Extension"), 0, 0);
      chordInfoGrid.add(getGridLabel(chord.getExtension().getName()), 1, 0);
    //}

//    Optional.ofNullable(chord.getDoubleExtensions().getName())
//      .ifPresent(doubleExtension-> doubleExtensionNameLabel.setText(doubleExtension));


  }*/

  public void setChord(Chord chord) {
    this.chord = chord;
    createGrid();
  }

  public void createGrid() {
    System.out.println(this.chord.toString());
    GridPane gridpane = new GridPane();
    gridpane.setAlignment(Pos.CENTER);
    gridpane.setGridLinesVisible(true);
    gridpane.setPadding(new Insets(10, 10, 10, 10));
    gridpane.add(new Label("Tónica:"), 0, 0);
    gridpane.add(new Label(chord.getRoot().getName(true)), 1, 0);
    gridpane.add(new Label("Modo:"), 0, 1);
    gridpane.add(new Label(chord.getMode().getFormalSpanishName()), 1, 1);
    if (chord.hasExtension()) {
      System.out.println(chord.getExtension().getName());
      gridpane.add(new Label("Extensión:"), 0, 2);
      gridpane.add(new Label(chord.getExtension().getName()), 1, 2);
    }
    if (chord.hasDoubleExtensions()) {
      gridpane.add(new Label("Añadiduras:"), 0, gridpane.getRowCount());
      for (int i = 0; i < chord.getDoubleExtensions().size(); i++) {
        gridpane.add(new Label(chord.getDoubleExtensions().get(0).getName()), 1, gridpane.getRowCount() + i - 1);
      }
    }

    scrollPane.setContent(gridpane);
  }
/*
  public void createGrid() {
    System.out.println(this.chord.toString());
    GridPane gridpane = new GridPane();
    gridpane.setAlignment(Pos.CENTER);
    gridpane.setGridLinesVisible(true);
    gridpane.setPadding(new Insets(10, 10, 10, 10));
    gridpane.add(new Label("Tónica:"), 0, 0);
    gridpane.add(new Label(chord.getRoot().getName(true)), 1, 0);
    gridpane.add(new Label("Modo:"), 0, 1);
    gridpane.add(new Label(chord.getMode().getFormalSpanishName()), 1, 1);
    if (chord.hasExtension()) {
      System.out.println(chord.getExtension().getName());
      gridpane.add(new Label("Extensión:"), 0, 2);
      gridpane.add(new Label(chord.getExtension().getName()), 1, 2);
    }
    if (chord.hasDoubleExtensions()) {
      gridpane.add(new Label("Añadiduras:"), 0, gridpane.getRowCount());
      for (int i = 0; i < chord.getDoubleExtensions().size(); i++) {
        gridpane.add(new Label(chord.getDoubleExtensions().get(0).getName()), 1, gridpane.getRowCount() + i - 1);
      }
    }

    scrollPane.setContent(gridpane);
  }
*/

  private Node getGridLabel(String text) {
    Label label = new Label(text);
    label.setOpaqueInsets(new Insets(0, 0, 0, 5));
    StackPane stackPane = new StackPane(label);
    stackPane.setAlignment(Pos.CENTER);
    return stackPane;
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }
}
