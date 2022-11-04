package org.lucida.Tools;

import org.lucida.Enums.DoubleExtensions;
import org.lucida.Enums.Extension;
import org.lucida.Enums.Modes;
import org.lucida.Enums.Notes;
import org.lucida.Exceptions.ChordNameNotDecipherableException;
import org.lucida.Objects.Chord;
import org.lucida.Objects.ChordRequest;

import java.util.ArrayList;
import java.util.List;

public class ChordNamesDecipher {

  public static Chord decipher(String chordName) throws ChordNameNotDecipherableException {
    final StringBuilder chordName_SB = new StringBuilder(chordName);
    Chord chord = new Chord();
    chord.setName(chordName);
    searchRoot(chordName_SB, chord);
    searchInversion(chordName_SB, chord);
    searchDoubleExtension(chordName_SB, chord);
    searchExtension(chordName_SB, chord);
    searchMode(chordName_SB, chord);

    return chord;
  }

  public static Chord decipher(String chordName, Float duration) throws ChordNameNotDecipherableException {
    Chord chord = decipher(chordName);
    chord.setDuration(duration);
    return chord;
  }

  public static List<Chord> decipher(List<ChordRequest> chordsRequested) throws ChordNameNotDecipherableException {
    List<Chord> chordList = new ArrayList<>();
    for (ChordRequest chordRequest : chordsRequested) {
      chordList.add(decipher(chordRequest.getChordName(), chordRequest.getDuration()));
    }
    return chordList;
  }


  private static void searchRoot(StringBuilder chordName, Chord chord) throws ChordNameNotDecipherableException {
    for (int i = Math.min(chordName.length(), 4); i >= 1; i--) {
      String possibleRoot = chordName.substring(0, i);
      if (Notes.isValid(possibleRoot)) {
        chord.setRoot(Notes.get(possibleRoot));
        chordName.delete(0, possibleRoot.length());
        return;
      }
    }
    throw new ChordNameNotDecipherableException();
  }

  private static void searchInversion(StringBuilder chordName, Chord chord) throws ChordNameNotDecipherableException {

    int indexOf = chordName.indexOf("/");

    if (indexOf != -1) {
      String inversion = chordName.substring(indexOf + 1, chordName.length());

      if (!Notes.isValid(inversion))
        throw new ChordNameNotDecipherableException();

      chord.setInversion(Notes.get(inversion));
      chordName.delete(indexOf, chordName.length());
    }
  }

  private static void searchDoubleExtension(StringBuilder chordName, Chord chord) throws ChordNameNotDecipherableException {
    int lastIndexOf = chordName.lastIndexOf("add");

    if (lastIndexOf != -1) {
      String doubleExtension = chordName.substring(lastIndexOf, chordName.length());

      if (!DoubleExtensions.isValid(doubleExtension))
        throw new ChordNameNotDecipherableException();

      chord.addDoubleExtension(DoubleExtensions.get(doubleExtension));
      chordName.delete(lastIndexOf, chordName.length());

      //Double check
      searchDoubleExtension(chordName, chord);
    }
  }

  private static void searchExtension(StringBuilder chordName, Chord chord) {
    for (int i = Math.min(chordName.length(), 4); i >= 0; i--) {
      String possibleExtension = chordName.substring(chordName.length() - i, chordName.length());
      if (Extension.isValid(possibleExtension)) {
        chord.setExtension(Extension.get(possibleExtension));
        chordName.delete(chordName.length() - i, chordName.length());
        return;
      }
    }
  }

  private static void searchMode(StringBuilder chordName, Chord chord) throws ChordNameNotDecipherableException {
    String possibleMode = String.valueOf(chordName);
    if (Modes.isValid(possibleMode)) {
      chord.setMode(Modes.get(possibleMode));
      chordName.delete(0, possibleMode.length());
    } else {
      throw new ChordNameNotDecipherableException();
    }
  }
}

