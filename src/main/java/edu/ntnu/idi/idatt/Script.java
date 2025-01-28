package edu.ntnu.idi.idatt;

import java.util.ArrayList;
import java.util.List;

public class Script {

  private List<TextCommand> textCommands;

  public Script() {
      this.textCommands = new ArrayList<>();
  }

  public void addCommand(TextCommand textCommand) {
      textCommands.add(textCommand);
  }

  public String execute(String text) {
    final String[] result = {text};
    textCommands.stream()
        .forEach(textCommand -> result[0] = textCommand.execute(result[0]));
    return result[0];
  }
}
