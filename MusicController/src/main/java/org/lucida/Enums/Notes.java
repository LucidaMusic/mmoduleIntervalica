package org.lucida.Enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Notes {
  A("La", "A", 0),

  B("Si", "B", 2),

  C("Do", "C", 3),

  D("Re", "D", 5),

  E("Mi", "E", 7),

  F("Fa", "F", 8),

  G("Sol", "G", 10);

  private final String latinName;
  private final String americanName;
  private final int relativePosition;

  Notes(String latinName, String americanName, int relativePosition) {
    this.latinName = latinName;
    this.americanName = americanName;
    this.relativePosition = relativePosition;
  }

  public static boolean isValid(String noteName) {
    return Arrays.stream(Notes.values())
      .anyMatch(note -> note.getLatinName().equals(noteName) || note.getAmericanName().equals(noteName));
  }

  public static Notes get(String noteName) {
    return Arrays.stream(Notes.values())
      .filter(note -> note.getLatinName().equals(noteName) || note.getAmericanName().equals(noteName))
      .findFirst()
      .orElseThrow(() -> new RuntimeException(noteName + " was not a valid note name"));
  }

  @Override
  public String toString() {
    return toString(true);
  }

  public String toString(boolean latinNomenclature) {
    return latinNomenclature ? "Name: " + this.getLatinName() : "Name: " + this.getAmericanName();
  }
}
