package edu.ntnu.idi.idatt.WrapText;

public class WrapLinesTextCommand extends WrapTextCommand {

  public WrapLinesTextCommand(String opening, String end) {
    super(opening, end);
  }

  @Override
  public String execute(String text) {
    String lineEnd = "\n";
    return super.execute(text).replace(lineEnd, getEnd() + lineEnd + getOpening());
  }
}
