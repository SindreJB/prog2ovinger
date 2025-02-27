package edu.ntnu.idi.idatt;

import edu.ntnu.idi.idatt.CapitalizeText.CapitalizeSelectionTextCommand;
import edu.ntnu.idi.idatt.CapitalizeText.CapitalizeTextCommand;
import edu.ntnu.idi.idatt.ReplaceText.ReplaceFirstTextCommand;
import edu.ntnu.idi.idatt.ReplaceText.ReplaceTextCommand;
import edu.ntnu.idi.idatt.WrapText.WrapLinesTextCommand;
import edu.ntnu.idi.idatt.WrapText.WrapSelectionTextCommand;
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
    System.out.println("replacing all Hello with Hi");
    String text = "Hello Hello, world!";
    System.out.println(text);
    TextCommand replaceTextCommand = new ReplaceTextCommand("Hello", "Hi");
    System.out.println(replaceTextCommand.execute(text));
    System.out.println(" ");

    System.out.println("Replacing first Hello with Hi");
    String text2 = "Hello Hello, world!";
    System.out.println(text2);
    TextCommand replaceFirstTextCommand = new ReplaceFirstTextCommand("Hello", "Hi");
    System.out.println(replaceFirstTextCommand.execute(text2));
    System.out.println(" ");

    System.out.println("wrapping text with <p>");
    String text3 = "Hello, world!";
    System.out.println(text3);
    TextCommand wrapTextCommand = new WrapTextCommand("<p>", "<p>");
    System.out.println(wrapTextCommand.execute(text3));
    System.out.println(" ");

    System.out.println("wrapping lines with <p>");
    String text4 = "Hello, world!\nHow are you?";
    System.out.println(text4);
    TextCommand wrapLinesTextCommand = new WrapLinesTextCommand("<p>", "<p>");
    System.out.println(wrapLinesTextCommand.execute(text4));
    System.out.println(" ");

    System.out.println("wrapping selection with <p>");
    String text5 = "Hello, world!";
    System.out.println(text5);
    TextCommand wrapSeletionTextCommand = new WrapSelectionTextCommand("<p>", "<p>", "world");
    System.out.println(wrapSeletionTextCommand.execute(text5));
    System.out.println(" ");

    System.out.println("capitalizing first letter of the text");
    String text6 = "hello, world!";
    System.out.println(text6);
    TextCommand capitalizeTextCommand = new CapitalizeTextCommand();
    System.out.println(capitalizeTextCommand.execute(text6));
    System.out.println(" ");

    System.out.println("capitalizing first letter of every word in the text");
    String text7 = "hello, world!";
    System.out.println(text7);
    TextCommand capitalizeWordsTextCommand = new CapitalizeTextCommand();
    System.out.println(capitalizeWordsTextCommand.execute(text7));
    System.out.println(" ");

    System.out.println("capitalizing selected words in the text");
    String text8 = "hello, world! Goodbye, world!";
    System.out.println(text8);
    TextCommand capitalizeSelectionTextCommand = new CapitalizeSelectionTextCommand("world");
    System.out.println(capitalizeSelectionTextCommand.execute(text8));
    System.out.println(" ");
  }
}
