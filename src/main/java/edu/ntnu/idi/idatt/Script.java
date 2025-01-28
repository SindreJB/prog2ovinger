package edu.ntnu.idi.idatt;

import edu.ntnu.idi.idatt.CapitalizeText.CapitalizeTextCommand;
import edu.ntnu.idi.idatt.ReplaceText.ReplaceFirstTextCommand;
import edu.ntnu.idi.idatt.ReplaceText.ReplaceTextCommand;
import edu.ntnu.idi.idatt.WrapText.WrapLinesTextCommand;
import edu.ntnu.idi.idatt.WrapText.WrapTextCommand;
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
    System.out.println(replaceFirstTextCommand.execute(text2));

    String text3 = "Hello, world!";
    System.out.println(text3);
    TextCommand wrapTextCommand = new WrapTextCommand("<p>", "<p>");
    System.out.println(wrapTextCommand.execute(text3));

    String text4 = "Hello, world!\nHow are you?";
    System.out.println(text4);
    TextCommand wrapLinesTextCommand = new WrapLinesTextCommand("<p>", "<p>");
    System.out.println(wrapLinesTextCommand.execute(text4));


  }
}
