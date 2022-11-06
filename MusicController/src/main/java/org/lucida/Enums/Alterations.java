package org.lucida.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Alterations {
  DOUBLE_FLAT("Doble bemol", "bb", -2),
  FLAT("Bemol", "b", -1),
  NATURAL("Natural", "", 0),
  SHARP("Sostenido", "#", 1),
  DOUBLE_SHARP("Doble sostenido", "##", 2);

  private final String name;
  private final String id;
  private final int alterationValue;


  public static boolean isValid(String alterationId) {
    return Arrays.stream(Alterations.values())
      .anyMatch(alteration -> alteration.getId().equals(alterationId));
  }

  public static Alterations get(String alterationId) {
    return Arrays.stream(Alterations.values())
      .filter(alteration -> alteration.getId().equals(alterationId))
      .findFirst()
      .orElseThrow(() -> new RuntimeException(alterationId + " was not a valid alteration id"));
  }

  @Override
  public String toString() {
    return getName();
  }
}
