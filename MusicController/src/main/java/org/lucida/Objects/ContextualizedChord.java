package org.lucida.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.lucida.Tools.SoundMotor;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ContextualizedChord {
  private List<Float> frequencies;
  private final Chord chord;

  public double[] getAudio(SoundMotor soundMotor, int bpm){
    return soundMotor.chord2audioData(frequencies, chord.getDuration(), bpm);
  }

  @Override
  public String toString() {
    return chord.toString() + '\n'+ frequencies;
  }
}