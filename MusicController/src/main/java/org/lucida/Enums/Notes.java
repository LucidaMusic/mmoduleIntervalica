package org.lucida.Enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Notes {
  A("La", "A", 0, 0),

  B("Si", "B", 2, 1),

  C("Do", "C", 3, 2),

  D("Re", "D", 5, 3),

  E("Mi", "E", 7, 4),

  F("Fa", "F", 8, 5),

  G("Sol", "G", 10, 6);

  private final String latinName;
  private final String americanName;
  private final int relativePosition;
  private final int absolutePosition;

  Notes(String latinName, String americanName, int relativePosition, int absolutePosition) {
    this.latinName = latinName;
    this.americanName = americanName;
    this.relativePosition = relativePosition;
    this.absolutePosition = absolutePosition;
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

  public static Notes getByAbsolutePosition(int absolutePosition) {
    return Arrays.stream(Notes.values())
      .filter(note -> note.getAbsolutePosition() == absolutePosition)
      .findFirst()
      .orElseThrow(() -> new RuntimeException(absolutePosition + " is not a valid absolute position for a note. Maximum is 6."));
  }

  @Override
  public String toString() {
    return toString(true);
  }

  public String toString(boolean latinNomenclature) {
    return latinNomenclature ? this.getLatinName() : this.getAmericanName();
  }
}
