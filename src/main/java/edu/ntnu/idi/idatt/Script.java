package edu.ntnu.idi.idatt;

import edu.ntnu.idi.idatt.CapitalizeText.CapitalizeTextCommand;
import edu.ntnu.idi.idatt.ReplaceText.ReplaceFirstTextCommand;
import edu.ntnu.idi.idatt.ReplaceText.ReplaceTextCommand;
import java.util.ArrayList;
import java.util.List;

public class Script {

  private List<TextCommand> textCommands;

  public Script() {
      this.textCommands = new ArrayList<>();
  }

  public String execute(String text) {
    final String[] result = {text};
    textCommands.stream()
        .forEach(textCommand -> result[0] = textCommand.execute(result[0]));
    return result[0];
  }

  public void customScript() {
    String text = "Hello Hello, world!";
    System.out.println(text);
    TextCommand replaceTextCommand = new ReplaceTextCommand("Hello", "Hi");
    System.out.println(replaceTextCommand.execute(text));

    String text2 = "Hello Hello, world!";
    System.out.println(text2);
    TextCommand replaceFirstTextCommand = new ReplaceFirstTextCommand("Hello", "Hi");
    System.out.println(replaceFirstTextCommand.execute(text));
  }
}
