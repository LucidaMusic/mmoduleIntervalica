package org.lucida.Objects;

import lombok.Getter;
import lombok.Setter;
import org.lucida.Enums.DoubleExtensions;
import org.lucida.Enums.Extension;
import org.lucida.Enums.Modes;
import org.lucida.Enums.Notes;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Chord {
  private Float duration = null;
  private Notes root;
  private Modes mode;
  private Extension extension;
  private List<DoubleExtensions> doubleExtensions = new ArrayList<>();
  private Notes inversion;
  private String name;

  public void addDoubleExtension(DoubleExtensions doubleExtensions) {
    this.doubleExtensions.add(doubleExtensions);
  }

  @Override
  public String toString() {
    return "name='" + name + "'" +
      ", duration=" + duration +
      ", root=" + root +
      ", mode=" + mode +
      ", extension=" + extension +
      ", doubleExtensions=" + doubleExtensions +
      ", inversion=" + inversion;
  }
}

