package NumberStuff;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NumberPropertiesGUI extends JFrame implements ActionListener {

  JFrame frame;
  JButton button;
  JPanel panel;
  JLabel inputLabel;
  JTextField inputtf;
  JTextArea output;
  JButton reset;
  String res = "";

  public NumberPropertiesGUI() {
    //frame
    frame = new JFrame("Number Properties");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    //button
    button = new JButton("Submit");
    reset = new JButton("Reset");
    //panel
    panel = new JPanel();
    //label
    inputLabel = new JLabel("Enter a number");

    //text field
    inputtf = new JTextField(10); // characters accepted

    //text area
    output = new JTextArea();
    output.setEditable(false);
    // Components Added using Flow Layout

    panel.add(inputLabel);
    panel.add(inputtf);
    panel.add(button);
    panel.add(output);
    panel.add(reset);
    //allignment
    frame.getContentPane().add(BorderLayout.CENTER, panel);

    frame.setVisible(true);
    button.addActionListener(this);
    reset.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    res = "";
    if (e.getSource() == button) {
      int n = Integer.parseInt(inputtf.getText());
      res =
        res +
        MathFunctions.prime(n) +
        MathFunctions.SumOfEvenDigits(n) +
        MathFunctions.SumOfDigits(n) +
        MathFunctions.SumOfOddDigits(n) +
        MathFunctions.Automorphic(n) +
        MathFunctions.Palindrome(n) +
        MathFunctions.EvenDigit(n) +
        MathFunctions.OddDigit(n) +
        MathFunctions.SpyNumber(n) +
        MathFunctions.Niven(n) +
        MathFunctions.Neon(n) +
        MathFunctions.Buzz(n) +
        MathFunctions.pronic(n) +
        MathFunctions.Special(n);
      output.setText(res);
    } else if (e.getSource() == reset) {
      res = "";
      output.setText(null);
      inputtf.setText(null);
    }
  }
}
