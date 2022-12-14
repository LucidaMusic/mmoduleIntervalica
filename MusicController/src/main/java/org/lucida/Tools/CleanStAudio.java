package org.lucida.Tools;

import javax.sound.sampled.*;

public class CleanStAudio {
  public static final int SAMPLE_RATE = 44100;

  private static final int BYTES_PER_SAMPLE = 2;       // 16-bit audio
  private static final int BITS_PER_SAMPLE = 16;       // 16-bit audio
  private static final int MAX_16_BIT = 32768;
  private static final int SAMPLE_BUFFER_SIZE = 4096;

  private static final int MONO = 1;
  private static final int STEREO = 2;
  private static final boolean LITTLE_ENDIAN = false;
  private static final boolean BIG_ENDIAN = true;
  private static final boolean SIGNED = true;
  private static final boolean UNSIGNED = false;


  private static SourceDataLine line;   // to play the sound
  private static byte[] buffer;         // our internal buffer
  private static int bufferSize = 0;    // number of samples currently in internal buffer

  static {
    init();
  }

  // open up an audio stream
  private static void init() {
    try {
      // 44,100 Hz, 16-bit audio, mono, signed PCM, little endian
      AudioFormat format = new AudioFormat((float) SAMPLE_RATE, BITS_PER_SAMPLE, STEREO, SIGNED, LITTLE_ENDIAN);
      DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

      line = (SourceDataLine) AudioSystem.getLine(info);
      line.open(format, SAMPLE_BUFFER_SIZE * BYTES_PER_SAMPLE);

      // the internal buffer is a fraction of the actual buffer size, this choice is arbitrary
      // it gets divided because we can't expect the buffered data to line up exactly with when
      // the sound card decides to push out its samples.
      buffer = new byte[SAMPLE_BUFFER_SIZE * BYTES_PER_SAMPLE / 3];
    } catch (LineUnavailableException e) {
      System.out.println(e.getMessage());
    }

    // no sound gets made before this call
    line.start();
  }

  public static void play(double[] samples) {
    if (samples == null) throw new IllegalArgumentException("argument to play() is null");
    for (double sample : samples) {
      play(sample);
    }
  }
  public static void play(double sample) {
    if (Double.isNaN(sample)) throw new IllegalArgumentException("sample is NaN");

    // clip if outside [-1, +1]
    if (sample < -1.0) sample = -1.0;
    if (sample > +1.0) sample = +1.0;


    // convert to bytes
    short s = (short) (MAX_16_BIT * sample);
    if (sample == 1.0) s = Short.MAX_VALUE;   // special case since 32768 not a short
    buffer[bufferSize++] = (byte) s;
    buffer[bufferSize++] = (byte) (s >> 8);   // little endian

    // send to sound card if buffer is full
    if (bufferSize >= buffer.length) {
      line.write(buffer, 0, buffer.length);
      bufferSize = 0;
    }
  }

}
