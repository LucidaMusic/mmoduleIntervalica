package org.lucida.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Song {
  private List<ContextualizedChord> contextualizedChords;
  private int bpm;

  public void getInfo() {
    this.getContextualizedChords()
      .stream()
      .map(ContextualizedChord::toString)
      .forEach(System.out::println);
  }
}
