package edu.ntnu.idi.idatt.CapitalizeText;

public class CapitalizeSelectionTextCommand extends CapitalizeTextCommand {

  private String selection;

  public CapitalizeSelectionTextCommand(String selection) {
      this.selection = selection;
  }

  public String getSelection() {
      return selection;
  }

  @Override
    public String execute(String text) {
      if (selection.isEmpty()) {
        return text;
      }
      String capitalizedSelection = Character.toUpperCase(selection.charAt(0)) + selection.substring(1);
      return text.replace(selection, capitalizedSelection);
    }
}
