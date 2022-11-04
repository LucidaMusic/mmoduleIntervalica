package org.lucida.Conversions;

import static java.lang.Math.round;

public class Conversions {
  static public Integer beats2ms(Float beats, Integer bpm){
    return round(beats* round(60000d/bpm));
  }
}