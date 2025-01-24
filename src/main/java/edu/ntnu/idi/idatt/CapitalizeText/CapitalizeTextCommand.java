package edu.ntnu.idi.idatt.CapitalizeText;

import edu.ntnu.idi.idatt.TextCommand;

public class CapitalizeTextCommand implements TextCommand {

  @Override
  public String execute(String text) {
      return text.toUpperCase();
  }
}
