package edu.ntnu.idi.idatt.WrapText;

import edu.ntnu.idi.idatt.TextCommand;

public class WrapTextCommand implements TextCommand {
  private String opening;
  private String end;

  public WrapTextCommand(String opening, String end) {
    this.opening = opening;
    this.end = end;
  }

  public String getOpening() {
    return opening;
  }

  public String getEnd() {
    return end;
  }

  @Override
  public String execute(String text) {
    return opening + text + end;
  }
}
