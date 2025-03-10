package edu.ntnu.idi.idatt.CapitalizeText;

import edu.ntnu.idi.idatt.TextCommand;

public class CapitalizeTextCommand implements TextCommand {

  @Override
  public String execute(String text) {
    return Character.toUpperCase(text.charAt(0)) + text.substring(1);
  }
}
