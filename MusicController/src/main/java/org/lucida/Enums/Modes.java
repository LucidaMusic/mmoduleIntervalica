package org.lucida.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum Modes {
  MAJOR(Arrays.asList(Intervals.MAJ3, Intervals.JUST5), "Mayor", "", "M"),
  MINOR(Arrays.asList(Intervals.MIN3, Intervals.JUST5), "Menor", "m"),
  AUGMENTED(Arrays.asList(Intervals.MAJ3, Intervals.MIN6), "Aumentado", "aug"),
  DIMINISHED(Arrays.asList(Intervals.MIN3, Intervals.DIM5), "Disminuido", "dim"),
  SUS2(Arrays.asList(Intervals.MAJ2, Intervals.JUST5), "Segunda suspendida", "sus2"),
  SUS4(Arrays.asList(Intervals.JUST4, Intervals.JUST5), "Cuarta suspendida", "sus4");
  private final String[] id;
  private final List<Intervals> intervalsThatAdds;
  private final String formalSpanishName;

  Modes(List<Intervals> intervalsThatAdds, String formalSpanishName, String... id) {
    this.id = id;
    this.intervalsThatAdds = intervalsThatAdds;
    this.formalSpanishName = formalSpanishName;
  }

  public static boolean isValid(String modeName) {
    return Arrays.stream(Modes.values())
      .anyMatch(mode -> Arrays.asList(mode.getId()).contains(modeName));
  }

  public static Modes get(String modeName) {
    return Arrays.stream(Modes.values())
      .filter(mode -> Arrays.asList(mode.getId()).contains(modeName))
      .findFirst()
      .orElseThrow(() -> new RuntimeException("That was not a valid mode name"));
  }
}