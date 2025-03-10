package edu.ntnu.idi.idatt.classes;

import edu.ntnu.idi.idatt.WrapText.WrapLinesTextCommand;
import org.junit.Test;
import static org.junit.Assert.*;

public class WrapLinesTextCommandTest {

  @Test
  public void testExecute() {
    WrapLinesTextCommand command = new WrapLinesTextCommand("<p>", "<p>");
    String result = command.execute("Hello, world!\nHow are you?");
    assertEquals("<p>Hello, world!<p>\n<p>How are you?<p>", result);
  }
}