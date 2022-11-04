package org.lucida.Tools;

import lombok.Setter;
import org.lucida.Conversions.Conversions;

import java.util.List;

@Setter
public class SoundMotor {
  private int fs;

  public SoundMotor(int fs) {
    this.fs = fs;
  }

  public SoundMotor() {
    this.fs = 44100;
  }

  public double[] freq2audioData(Float freq, int duration) {
    int n = fs * duration / 1000;
    double[] audioData = new double[n];
    for (int i = 0; i < n; i++) {
      audioData[i] = Math.sin(2 * Math.PI * i * freq / fs);
    }

    return audioData;
  }

  public double[] chord2audioData(List<Float> freqs, Float duration, int bpm) {
    int durationInMs = Conversions.beats2ms(duration, bpm);
    double[] chordAudioData = new double[durationInMs * fs / 1000];

    for (Float freq : freqs) {
      double[] freqAudioData = freq2audioData(freq, durationInMs);
      for (int i = 0; i < freqAudioData.length; i++) {
        chordAudioData[i] += freqAudioData[i] / freqs.size();
      }
    }
    return chordAudioData;
  }

}
