package NumberStuff;

import javax.swing.*;

public class operatorButton extends JButton {

  private final char operator;

  operatorButton(char operator) {
    this.operator = operator;
    setText(String.valueOf(operator));
  }

  public char getOperator() {
    return operator;
  }
}
