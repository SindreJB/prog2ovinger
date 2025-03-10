package edu.ntnu.idi.idatt.classes;

import edu.ntnu.idi.idatt.ReplaceText.ReplaceTextCommand;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReplaceTextCommandTest {

  @Test
  public void testExecute() {
    ReplaceTextCommand command = new ReplaceTextCommand("Hello", "Hi");
    String result = command.execute("Hello, world!");
    assertEquals("Hi, world!", result);
  }

  @Test
  public void testExecuteNoMatch() {
    ReplaceTextCommand command = new ReplaceTextCommand("Goodbye", "Hi");
    String result = command.execute("Hello, world!");
    assertEquals("Hello, world!", result);
  }

  @Test
  public void testExecuteMultipleMatches() {
    ReplaceTextCommand command = new ReplaceTextCommand("world", "everyone");
    String result = command.execute("Hello, world! How is the world?");
    assertEquals("Hello, everyone! How is the everyone?", result);
  }
}