package org.lucida.Enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Intervals {
    UNISON("Unísono", 1, 0),
    MIN2("Segunda menor", 16 / 15f, 1),
    MAJ2("Segunda mayor", 9 / 8f, 2),
    MIN3("Tercera menor", 6 / 5f, 3),
    MAJ3("Tercera mayor", 5 / 4f, 4),
    JUST4("Cuarta justa", 4 / 3f, 5),
    AUG4("Cuarta aumentada", 7 / 5f, 6),
    DIM5("Quinta disminuida", 7 / 5f, 6),
    JUST5("Quinta justa", 3 / 2f, 7),
    MIN6("Sexta menor", 8 / 5f, 8),
    MAJ6("Sexta mayor", 5 / 3f, 9),
    MIN7("Séptima menor", 9 / 5f, 10),
    DOM7("Séptima de dominante", 7 / 4f, 10),
    DIM7("Séptima de disminuido", 7 / 4f, 10),
    MAJ7("Séptima mayor", 15 / 8f, 11),
    OCTAVE("Octava", 2, 12),
    MIN9("Novena menor", 2, 13),
    MAJ9("Novena mayor", 15 / 8f, 14),
    AUG9("Novena aumentada", 15 / 8f, 15),
    MAJ10("Décima mayor", 15 / 8f, 16),
    JUST11("Oncena justa", 15 / 8f, 17),
    AUG11("Oncena aumentada", 15 / 8f, 18),
    JUST12("Duodécima justa", 15 / 8f, 19),
    MIN13("Trecena menor", 15 / 8f, 20),
    MAJ13("Trecena mayor", 15 / 8f, 21);

    private final String spanishName;
    private final float ratio;
    private final int scaleJumps;

    Intervals(String spanishName, float ratio, int scaleJumps) {
        this.spanishName = spanishName;
        this.ratio = ratio;
        this.scaleJumps = scaleJumps;
    }

    public static Intervals get(Notes a, Notes b) {
        return Arrays.stream(Intervals.values())
                //All intervals must be positive
                .filter(interval -> interval.scaleJumps == (b.getId() - a.getId() < 0 ? b.getId() - a.getId() + 12 : b.getId() - a.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not contemplated interval"));
    }

    @Override
    public String toString() {
        return "Name: " + this.getSpanishName() + ", Ratio: " + this.getRatio();
    }
}
