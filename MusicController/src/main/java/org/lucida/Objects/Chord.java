package org.lucida.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.lucida.Enums.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
public class Chord {
  private Float duration = null;
  private Note root;
  private Modes mode;
  private Extensions extension;
  private List<DoubleExtensions> doubleExtensions = new ArrayList<>();
  private Note inversion;
  private String name;

  public Chord() {

  }

  //
  public boolean hasExtension() {
    return this.extension != null;
  }

  public boolean hasDoubleExtensions() {
    return doubleExtensions.size() > 0;
  }

  public boolean hasInversion() {
    return inversion != null;
  }

  //Getters
  public Note[] getModeNotes() {
    Note[] notes = new Note[2];

    //For the two notes of the mode
    for (int i = 0; i < 2; i++) {
      notes[i] = deduceNoteFromRoot(getMode().getIntervalsThatAdds().get(i));;
    }

    return notes;
  }

  public Stream<Note> getExtensionNotes() {
    return Extensions
      .getIntervalsThatAdds(getExtension(), getMode())
      .stream()
      .map(this::deduceNoteFromRoot);
  }

  public List<Note> getDoubleExtensionNotes() {
    return doubleExtensions
      .stream()
      .map(DoubleExtensions::getInterval)
      .map(this::deduceNoteFromRoot)
      .toList();
  }

  public void addDoubleExtension(DoubleExtensions doubleExtensions) {
    this.doubleExtensions.add(doubleExtensions);
  }

  private Note deduceNoteFromRoot(Intervals interval) {
    int actualPosition = getRoot().getNote().getAbsolutePosition();

    int newPosition = interval.getNoteJumps() + actualPosition;
    while (newPosition > 6) {
      newPosition = newPosition - 7;
    }

    Notes note = Notes.getByAbsolutePosition(newPosition);

    //I have note name, but, what should be its alteration?
    int newRelativePosition = getRoot().getTrueRelativePosition() + interval.getScaleJumps();

    while (newRelativePosition > 11) {
      newRelativePosition = newRelativePosition - 12;
    }

    Alterations alteration = Alterations.getByAlterationValue(newRelativePosition - note.getRelativePosition());
    return new Note(note, alteration);
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

