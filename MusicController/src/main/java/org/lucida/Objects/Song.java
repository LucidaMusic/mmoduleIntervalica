package org.lucida.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Song {
  private List<Chord> chords;
  private int bpm;

  public void getInfo() {
    this.getChords()
      .stream()
      .map(Chord::toString)
      .forEach(System.out::println);
  }
}
