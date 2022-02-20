package NumberStuff;

import javax.swing.*;

public class NumberButton extends JButton {

  private final int number;

  public NumberButton(int number) {
    setText(String.valueOf(number));
    this.number = number;
  }

  public int getNumber() {
    return number;
  }
}
