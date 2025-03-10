package edu.ntnu.idi.idatt.ReplaceText;

import edu.ntnu.idi.idatt.TextCommand;

public class ReplaceTextCommand implements TextCommand {
  private String target;
  private String replacement;

  public ReplaceTextCommand(String target, String replacement) {
      this.target = target;
      this.replacement = replacement;
  }

  public String getTarget() {
      return target;
  }

  public String getReplacement() {
      return replacement;
  }

  public String execute(String text) {
      return text.replace(target, replacement);
  }
}
