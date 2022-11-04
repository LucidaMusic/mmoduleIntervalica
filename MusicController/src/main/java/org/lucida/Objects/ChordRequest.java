package org.lucida.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ChordRequest {
  private String chordName;
  private Float duration;
}
