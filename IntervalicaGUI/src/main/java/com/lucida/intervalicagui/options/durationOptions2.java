package com.lucida.intervalicagui.options;

import lombok.Getter;

@Getter
public enum durationOptions2 {
  QUAVER(0.5f, "Corchea - ♪"),
  BLACK(1f, "Negra - ♩"),
  WHITE(2f, "Blanca - \uD834\uDD5E"),
  ROUND(4f, "Redonda - \uD834\uDD5D");


  private final float duration;
  private final String name;

  durationOptions2(float duration, String name) {
    this.duration = duration;
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
