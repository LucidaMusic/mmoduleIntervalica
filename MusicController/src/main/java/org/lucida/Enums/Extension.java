package org.lucida.Enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public enum Extension {
  MIN6("6m"),
  MAJ6("6"),
  MIN7("7"),
  MAJ7("maj7"),
  MIN9("min9"),
  MAJ9("9"),
  JUST11("11"),
  MAJ13("13");

  private final String name;

  Extension(String name) {
    this.name = name;
  }

  public static boolean isValid(String extensionName) {
    return Arrays.stream(Extension.values())
      .anyMatch(extension -> extension.getName().equals(extensionName));
  }

  public static Extension get(String extensionName) {
    return Arrays.stream(Extension.values())
      .filter(extension -> extension.getName().equals(extensionName))
      .findFirst()
      .orElseThrow(() -> new RuntimeException(extensionName + " was not a valid extension name"));
  }

  public static List<Intervals> getIntervalsThatAdds(Extension extension, Modes mode) {
    List<Intervals> intervals = new ArrayList<>();

    switch (extension) {
      case MIN6:
        intervals.add(Intervals.MIN6);// sexta menor
        return intervals;

      case MAJ6:
        intervals.add(Intervals.MAJ6); // sexta mayor
        return intervals;

      case MIN7:
        if (mode.equals(Modes.MAJOR) || mode.equals(Modes.MAJOR2)) // COnsideramos septima de dominante
          intervals.add(Intervals.DOM7);
        else if (mode.equals(Modes.DIMINISHED))
          intervals.add(Intervals.DIM7);
        else //Septima de acorde menor
          intervals.add(Intervals.MIN7);
        return intervals;

      case MAJ7:
        intervals.add(Intervals.MAJ7);
        return intervals;

      case MAJ9:
        intervals.add(Intervals.MAJ9); // Novena mayor
        intervals.addAll(getIntervalsThatAdds(Extension.MIN7, mode)); // Septima menor
        return intervals;

      case MIN9:
        intervals.add(Intervals.MIN9); // Novena menor
        intervals.addAll(getIntervalsThatAdds(Extension.MIN7, mode)); // Septima menor
        return intervals;

      case JUST11:
        if (mode.equals(Modes.MINOR))
          intervals.add(Intervals.JUST11); // Onceava
        else if (mode.equals(Modes.MAJOR) || mode.equals(Modes.MAJOR2))
          intervals.add(Intervals.AUG11); // Onceava aumentada

        intervals.addAll(getIntervalsThatAdds(Extension.MAJ9, mode));
        return intervals;

      case MAJ13:
        intervals.add(Intervals.MAJ13);
        intervals.addAll(getIntervalsThatAdds(Extension.JUST11, mode));

        return intervals;
      default:
        return new ArrayList<>();
    }
  }
}
