package com.lucida.intervalicagui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import lombok.Getter;

@Getter
public class SecondaryPanelController extends ReproductionPanelController{
  @FXML
  private Text bpmValidation;
  @FXML
  private TextField bpmInputText;

  @FXML
  private Text laValidation;
  @FXML
  private TextField laInputText;
  @FXML
  private Slider bpmSlider;

  @FXML
  private Slider laSlider;


  @FXML
  protected void bpmValidationClear() {
    if (!bpmValidation.getText().isBlank()) {
      bpmValidation.setText("");
    }
  }

  @FXML
  protected void laValidationClear() {
    if (!laValidation.getText().isBlank()) {
      laValidation.setText("");
    }
  }

  @FXML
  protected void setBpmInputText(String value) {
    bpmInputText.setText(value);
  }

  @FXML
  protected void setLaInputText(String value) {
    laInputText.setText(value);
  }

  @FXML
  protected String bpmValidate() {
    /*
     Solo numeros
     no mayor a 240 ni menor a 20
     */
    String text = bpmInputText.getText();

    if (text.isBlank()) {
      bpmInputText.setText("120");
      bpmValidationClear();
      return "120";
    }

    if (!text.matches("^(0|[1-9][0-9]*)$")) {
      bpmValidation.setText("El número de pulsos por minuto debe ser número.");
      return null;
    }

    if (Integer.parseInt(text) > 240) {
      bpmValidation.setText("El número de pulsos por minuto no debe ser mayor a 240.");
      return null;
    }

    if (Integer.parseInt(text) < 20) {
      bpmValidation.setText("El número de pulsos por minuto no debe ser menor a 20.");
      return null;
    }

    //Value is valid
    bpmValidationClear();
    bpmSlider.setValue(Double.parseDouble(text));
    return text;
  }

  @FXML
  protected String laValidate() {
    /*
     Solo numeros
     no mayor a 240 ni menor a 20
     */
    String text = laInputText.getText();
    String validation = laValidation.getText();

    if (text.isBlank() && !validation.isBlank()) {
      laValidationClear();
      return null;
    }

    if (!text.matches("^(0|[1-9][0-9]*)$")) {
      laValidation.setText("El número de pulsos por minuto debe ser número.");
      return null;
    }

    if (Integer.parseInt(text) >= 800) {
      laValidation.setText("La nota 'La' no debe ser afinada más arriba de 799 Hz");
      return null;
    }

    if (Integer.parseInt(text) < 400) {
      laValidation.setText("La nota 'La' no debe ser afinada más abajo de 440 Hz");
      return null;
    }

    //Value is valid
    laValidationClear();
    laSlider.setValue(Double.parseDouble(text));
    return text;
  }

  public void initializePanelController() {
    //Bind sliders
    getBpmSlider().valueProperty().addListener((observableValue, number, t1) -> {
      getBpmInputText().setText(String.valueOf((int) getBpmSlider().getValue()));
      bpmValidationClear();
    });

    getLaSlider().valueProperty().addListener((observableValue, number, t1) -> {
      getLaInputText().setText(String.valueOf((int) getLaSlider().getValue()));
      laValidationClear();
    });
  }
}