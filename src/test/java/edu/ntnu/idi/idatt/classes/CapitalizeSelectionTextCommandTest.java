package edu.ntnu.idi.idatt.classes;

import edu.ntnu.idi.idatt.CapitalizeText.CapitalizeSelectionTextCommand;
import org.junit.Test;
import static org.junit.Assert.*;

public class CapitalizeSelectionTextCommandTest {

  @Test
  public void testExecute() {
    CapitalizeSelectionTextCommand command = new CapitalizeSelectionTextCommand("world");
    String result = command.execute("hello, world!");
    assertEquals("hello, World!", result);
  }

  @Test
  public void testExecuteEmptySelection() {
    CapitalizeSelectionTextCommand command = new CapitalizeSelectionTextCommand("");
    String result = command.execute("hello, world!");
    assertEquals("hello, world!", result);
  }
}