package org.lucida.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Intervals {
    UNISON("Unísono", 1, 0, 0),
    MIN2("Segunda menor", 16 / 15f, 1, 1),
    MAJ2("Segunda mayor", 9 / 8f, 2, 1),
    MIN3("Tercera menor", 6 / 5f, 3, 2),
    MAJ3("Tercera mayor", 5 / 4f, 4, 2),
    JUST4("Cuarta justa", 4 / 3f, 5, 3),
    AUG4("Cuarta aumentada", 7 / 5f, 6, 3),
    DIM5("Quinta disminuida", 7 / 5f, 6, 4),
    JUST5("Quinta justa", 3 / 2f, 7, 4),
    MIN6("Sexta menor", 8 / 5f, 8, 5),
    MAJ6("Sexta mayor", 5 / 3f, 9, 5),
    MIN7("Séptima menor", 9 / 5f, 10, 6),
    DOM7("Séptima de dominante", 7 / 4f, 10, 6),
    DIM7("Séptima de disminuido", 7 / 4f, 10, 6),
    MAJ7("Séptima mayor", 15 / 8f, 11, 6),
    OCTAVE("Octava", 2, 12, 0),
    MIN9("Novena menor", 2, 13, 1),
    MAJ9("Novena mayor", 15 / 8f, 14, 1),
    AUG9("Novena aumentada", 15 / 8f, 15, 1),
    MAJ10("Décima mayor", 15 / 8f, 16, 2),
    JUST11("Oncena justa", 15 / 8f, 17, 3),
    AUG11("Oncena aumentada", 15 / 8f, 18, 3),
    JUST12("Duodécima justa", 15 / 8f, 19, 4),
    MIN13("Trecena menor", 15 / 8f, 20, 5),
    MAJ13("Trecena mayor", 15 / 8f, 21, 5);

    private final String spanishName;
    private final float ratio;
    private final int scaleJumps;
    private final int noteJumps;

    public static Intervals get(Notes a, Notes b) {
        return Arrays.stream(Intervals.values())
                //All intervals must be positive
                .filter(interval -> interval.scaleJumps == (b.getRelativePosition() - a.getRelativePosition() < 0 ? b.getRelativePosition() - a.getRelativePosition() + 12 : b.getRelativePosition() - a.getRelativePosition()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not contemplated interval"));
    }

    @Override
    public String toString() {
        return "Name: " + this.getSpanishName() + ", Ratio: " + this.getRatio();
    }
}
