package org.lucida.Objects;

import lombok.Getter;
import lombok.Setter;
import org.lucida.Enums.Alterations;
import org.lucida.Enums.Notes;

@Getter
@Setter
public class Note {
  private Notes note;
  private Alterations alteration;
  private float frequency;

  public Note(Notes note, Alterations alteration) {
    this.note = note;
    this.alteration = alteration;
  }

  public String getName(boolean latinNomenclature) {
    return (latinNomenclature ? getNote().getLatinName() : getNote().getAmericanName())
      + getAlteration().getId();
  }

  public int getTrueRelativePosition(){
    return getNote().getRelativePosition()+ alteration.getAlterationValue();
  }

  @Override
  public String toString() {
    return getNote().toString(true)+getAlteration().getId();
  }
}
