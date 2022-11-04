package com.lucida.intervalicagui.controllers;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class BaseController extends SecondaryPanelController implements Initializable{
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    initializeIcons();
    initializePanelController();
    initializeMainPanel();
  }
}
