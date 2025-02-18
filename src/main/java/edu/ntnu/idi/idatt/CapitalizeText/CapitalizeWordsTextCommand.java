package edu.ntnu.idi.idatt.CapitalizeText;

import java.util.stream.Stream;

public class CapitalizeWordsTextCommand extends CapitalizeTextCommand {

  @Override
  public String execute(String text) {
    String[] words = text.split(" ");
    StringBuilder capitalizedText = new StringBuilder();
    Stream.of(words).forEach(word -> {
      capitalizedText.append(super.execute(word)).append(" ");
    });
    return capitalizedText.toString().trim();
  }
}
