/*
package org.lucida.Tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChordNormalizator {
  public static void normalize(List<ContextualizedChord> contextualizedChords, float minFreq, float maxFreq) {

    for (ContextualizedChord contextualizedChord : contextualizedChords) {
      List<Float> newListOfChordFreqs = new ArrayList<>();

      //para lo mas grave (tonica o inversion)
      //Si tiene inversion, empiezo por la ultima y par todas las demas cambio el minFreq
      //Si no, emezamos por la primera y todas las demas cambiamos el minFreq
      if (contextualizedChord.getChord().getInversion() == null) {
        newListOfChordFreqs.addAll(spreadOctaves(contextualizedChord.getFrequencies().get(0), minFreq, maxFreq));
        Float notaMasGrave = Collections.min(newListOfChordFreqs);

        for (int j = 1; j < contextualizedChord.getFrequencies().size(); j++) {
          newListOfChordFreqs.addAll(spreadOctaves(contextualizedChord.getFrequencies().get(j), notaMasGrave, maxFreq));
        }

      } else {
        newListOfChordFreqs.addAll(spreadOctaves(contextualizedChord.getFrequencies().get(contextualizedChord.getFrequencies().size() - 1), minFreq, maxFreq));
        Float notaMasGrave = Collections.min(newListOfChordFreqs);

        for (int j = 0; j < contextualizedChord.getFrequencies().size() - 1; j++) {
          newListOfChordFreqs.addAll(spreadOctaves(contextualizedChord.getFrequencies().get(j), notaMasGrave, maxFreq));
        }
      }

      //YA puedo hacer el cambio
      contextualizedChord.setFrequencies(newListOfChordFreqs);
    }
  }

  public static List<Float> spreadOctaves(float freqToSpread, float minFreq, float maxFreq) {
    List<Float> octaves = new ArrayList<>();
    //High note
    if (freqToSpread > maxFreq) {
      float x = freqToSpread;
      while (x >= minFreq) {
        if (x <= maxFreq) {
          octaves.add(x);
        }
        x /= 2;
      }
    }
    //Low note
    else if (freqToSpread < minFreq) {
      float x = freqToSpread;
      while (x <= maxFreq) {
        if (x >= minFreq) {
          octaves.add(x);
        }
        x *= 2;
      }
    }
    //Already centered note
    else if (freqToSpread <= maxFreq && freqToSpread >= minFreq) {

      octaves.add(freqToSpread);

      //Going down
      float x = freqToSpread / 2;
      while (x >= minFreq) {
        if (x <= maxFreq) {
          octaves.add(x);
        }
        x /= 2;
      }

      //Going up
      x = freqToSpread * 2;
      while (x <= maxFreq) {
        if (x >= minFreq) {
          octaves.add(x);
        }
        x *= 2;
      }
    }
    return octaves;
  }
}
*/
