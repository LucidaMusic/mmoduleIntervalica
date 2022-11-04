package org.lucida.Enums;

import lombok.Getter;

import java.util.Arrays;
@Getter
public enum DoubleExtensions {
    ADD2("add2", Intervals.MAJ2),
    ADD4("add4", Intervals.JUST4),
    ADD6("add6", Intervals.MAJ6),
    ADD9("add9", Intervals.MAJ9),
    ADD11("add11", Intervals.JUST11),
    ADD13("add13", Intervals.MAJ13);

    private final String name;
    private final Intervals intervals;

    DoubleExtensions(String name, Intervals intervals){
        this.name = name;
        this.intervals=intervals;
    }

    public static boolean isValid(String doubleExtensionName) {
        return Arrays.stream(DoubleExtensions.values())
                .anyMatch(doubleExtensions -> doubleExtensions.getName().equals(doubleExtensionName));
    }

    public static DoubleExtensions get(String doubleExtensionName) {
        return Arrays.stream(DoubleExtensions.values())
                .filter(note -> note.getName().equals(doubleExtensionName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("That was not a valid double extension name"));
    }

}
