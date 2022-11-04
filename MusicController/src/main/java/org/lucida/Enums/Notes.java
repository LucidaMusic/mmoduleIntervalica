package org.lucida.Enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Notes {
    Ab("Lab", "Ab", 11),
    A("La", "A", 0),
    As("La#", "A#", 1),

    Bb("Si", "Bb", 1),
    B("Si", "B", 2),
    Bs("Si#", "B#", 3),

    Cb("Dob", "Cb", 2),
    C("Do", "C", 3),
    Cs("Do#", "C#", 4),

    Db("Reb", "Db", 4),
    D("Re", "D", 5),
    Ds("Re#", "D#", 6),

    Eb("Mib", "Eb", 6),
    E("Mi", "E", 7),
    Es("Mi#", "E#", 8),

    Fb("Fab", "Fb", 7),
    F("Fa", "F", 8),
    Fs("Fa#", "F#", 9),

    Gb("Solb", "Gb", 9),
    G("Sol", "G", 10),
    Gs("Sol#", "G#", 11);

    private final String latinName;
    private final String americanName;
    private final int id;

    Notes(String latinName, String americanName, int id) {
        this.latinName = latinName;
        this.americanName = americanName;
        this.id = id;
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
