package org.lucida.Enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum Modes {
    MAJOR("", Arrays.asList(Intervals.MAJ3, Intervals.JUST5), "Mayor"),
    MAJOR2("M", Arrays.asList(Intervals.MAJ3, Intervals.JUST5), "Mayor"),
    MINOR("m", Arrays.asList(Intervals.MIN3, Intervals.JUST5), "Menor"),
    AUGMENTED("aug", Arrays.asList(Intervals.MAJ3, Intervals.MIN6), "Aumentado"),
    DIMINISHED("dim", Arrays.asList(Intervals.MIN3, Intervals.DIM5), "Disminuido"),
    SUS2("sus2", Arrays.asList(Intervals.MAJ2, Intervals.JUST5), "Segunda suspendida"),
    SUS4("sus4", Arrays.asList(Intervals.JUST4, Intervals.JUST5), "Cuarta suspendida");
    private final String id;
    private final List<Intervals> intervalsThatAdds;
    private final String formalSpanishName;

    Modes(String id, List<Intervals> intervalsThatAdds, String formalSpanishName) {
        this.id = id;
        this.intervalsThatAdds = intervalsThatAdds;
        this.formalSpanishName = formalSpanishName;
    }

    public static boolean isValid(String modeName) {
        return Arrays.stream(Modes.values())
                .anyMatch(mode -> mode.getId().equals(modeName));
    }

    public static Modes get(String modeName) {
        return Arrays.stream(Modes.values())
                .filter(mode -> mode.getId().equals(modeName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("That was not a valid mode name"));
    }
}