package com.lucida.intervalicagui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import org.lucida.Objects.Chord;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;


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
  }

  public void createGrid() {
    VBox chordInfoContainer = new VBox();
    chordInfoContainer.setAlignment(Pos.CENTER);
    chordInfoContainer.setMinHeight(150);
    chordInfoContainer.setMinWidth(140);

    Label chordNameLabel = new Label(chord.getName());
    chordNameLabel.setStyle("-fx-text-fill: #499ae3;" +
      "-fx-font-weight: bold;" +
      "-fx-font-size: 18;");

    GridPane gridpane = new GridPane();
    gridpane.setAlignment(Pos.CENTER);
    gridpane.setGridLinesVisible(false);
    gridpane.setPadding(new Insets(10, 10, 10, 10));
    gridpane.setHgap(15);
    gridpane.setVgap(10);
    gridpane.setBorder(Border.stroke(Paint.valueOf("#499ae3")));

    gridpane.add(new Label(chord.getRoot().getName(true)), 0, 0);
    gridpane.add(new Label(chord.getMode().getFormalSpanishName()), 0, 1);
    gridpane.add(new Label(chord.getModeNotes()[0].getName(true)), 1, 1);
    gridpane.add(new Label(chord.getModeNotes()[1].getName(true)), 1, 2);


    if (chord.hasExtension()) {
      gridpane.add(new Label(chord.getExtension().getName()), 0, 3);

      AtomicInteger i = new AtomicInteger(0);
      chord
        .getExtensionNotes()
        .map(note -> note.getName(true))
        .map(Label::new)
        .forEach(label -> {
          gridpane.add(label, 1, gridpane.getRowCount() - 1 + i.get());
          i.getAndAdd(1);
        });
    }
    if (chord.hasDoubleExtensions()) {
      for (int i = chord.getDoubleExtensions().size()-1; i >= 0; i--) {
        gridpane.add(new Label(chord.getDoubleExtensions().get(i).getName()), 0, gridpane.getRowCount());
        gridpane.add(new Label(chord.getDoubleExtensionNotes().get(i).getName(true)), 1, gridpane.getRowCount() - 1);
      }
    }

    chordInfoContainer.getChildren().addAll(chordNameLabel, gridpane);
    scrollPane.setContent(chordInfoContainer);
  }
/*
  public void createGrid() {
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
    label.setOpaqueInsets(new Insets(5, 5, 5, 5));
    StackPane stackPane = new StackPane(label);
    stackPane.setAlignment(Pos.CENTER);
    return stackPane;
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }
}
