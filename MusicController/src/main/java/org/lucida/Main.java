package org.lucida;

import org.lucida.Enums.Notes;
import org.lucida.Exceptions.ChordNameNotDecipherableException;
import org.lucida.Objects.Chord;
import org.lucida.Objects.Note;
import org.lucida.Tools.ChordNamesDecipher;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws ChordNameNotDecipherableException {
    String chordName = "Cbbm"; //La Do# Mi
    Chord chord = ChordNamesDecipher.decipher(chordName, 4f);

    Chord chord2=new Chord();

    Arrays.stream(chord.getModeNotes()).map(Note::toString).forEach(System.out::println);
    //String chordName="La#"; //La# Do##
  }
}