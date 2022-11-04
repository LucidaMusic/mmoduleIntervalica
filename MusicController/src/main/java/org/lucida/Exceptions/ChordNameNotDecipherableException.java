package org.lucida.Exceptions;

public class ChordNameNotDecipherableException extends Exception {
  @Override
  public String getMessage() {
    return "El acorde no se ha podido leer. Compruebe que no tiene errores e intentelo de nuevo";
  }
  public String getMessage(String reason) {
    return reason;
  }
}
