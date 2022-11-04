module com.lucida.intervalicagui {
  requires javafx.controls;
  requires javafx.fxml;
  requires com.lucida.musiccontroller;
  requires lombok;


  opens com.lucida.intervalicagui to javafx.fxml;
  exports com.lucida.intervalicagui;
  exports com.lucida.intervalicagui.controllers;
  opens com.lucida.intervalicagui.controllers to javafx.fxml;
}