/*
package org.lucida.Tools;

import org.lucida.Enums.DoubleExtensions;
import org.lucida.Enums.Extension;
import org.lucida.Enums.Intervals;
import org.lucida.Enums.Notes;
import org.lucida.Objects.Chord;

import java.util.ArrayList;
import java.util.List;

public class ChordContextualizator {

  public static List<ContextualizedChord> contextualize(List<Chord> chords, float tunedA) {
    List<ContextualizedChord> contextualizedChords = new ArrayList<>();

    float previousRootFreq = 0;

    for (int i = 0; i < chords.size(); i++) {
      List<Float> chordFreqs = new ArrayList<>();

      Chord chord = chords.get(i);

      //Calculo freq tonica
      float rootFreq = (i == 0) ?
        tunedA * Intervals.get(Notes.A, chord.getRoot()).getRatio()
        : previousRootFreq * Intervals.get(chords.get(i - 1).getRoot(), chord.getRoot()).getRatio();

      chordFreqs.add(rootFreq);
      previousRootFreq = rootFreq;

      //Calculamos freqs de modo
      chord
        .getMode()
        .getIntervalsThatAdds()
        .stream()
        .map(Intervals::getRatio)
        .forEach(interval -> chordFreqs.add(interval * rootFreq));

      //Calculamos freqs Extension
      if (chord.getExtension() != null) {
        Extension
          .getIntervalsThatAdds(chord.getExtension(), chord.getMode())
          .stream()
          .map(Intervals::getRatio)
          .forEach(interval -> chordFreqs.add(interval * rootFreq));
      }

      //Calculamos freqs dobleExtension
      if (chord.getDoubleExtensions().size() > 0) {
        chord
          .getDoubleExtensions()
          .stream()
          .map(DoubleExtensions::getIntervals)
          .map(Intervals::getRatio)
          .forEach(interval -> chordFreqs.add(interval * rootFreq));
      }

      //Calculamos inversion
      if (chord.getInversion() != null) {
        float inversionFreq = Intervals
          .get(chord.getRoot(), chord.getInversion())
          .getRatio() * rootFreq;

        while (inversionFreq > rootFreq) {
          inversionFreq /= 2;
        }
        chordFreqs.add(inversionFreq);
      }
      contextualizedChords.add(new ContextualizedChord(chordFreqs, chord));
    }
    return contextualizedChords;
  }
}*/
