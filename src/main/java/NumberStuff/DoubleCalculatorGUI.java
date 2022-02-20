package NumberStuff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoubleCalculatorGUI extends JFrame implements ActionListener {
    JFrame frame;
    operatorButton plus, minus, multiply, divide, equals;
    NumberButton one, two, three, four, five, six, seven, eight, nine, zero;
    JTextArea output;
    JPanel digitPanel;
    char operator, previousOperator;
    boolean expectingNextOperand, shouldRemoveChar, lastOperandHasValue, firstOperation;
    double currentOperand;
    double lastOperand;

    public DoubleCalculatorGUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        firstOperation = true;
        digitPanel = new JPanel();

        output = new JTextArea();

        one = new NumberButton(1);
        two = new NumberButton(2);
        three = new NumberButton(3);
        four = new NumberButton(4);
        five = new NumberButton(5);
        six = new NumberButton(6);
        seven = new NumberButton(7);
        eight = new NumberButton(8);
        nine = new NumberButton(9);
        zero = new NumberButton(0);
        plus = new operatorButton('+');
        minus = new operatorButton('-');
        multiply = new operatorButton('*');
        divide = new operatorButton('/');
        equals = new operatorButton('=');

        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        zero.addActionListener(this);
        plus.addActionListener(this);
        minus.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        equals.addActionListener(this);

        digitPanel.add(one);
        digitPanel.add(two);
        digitPanel.add(three);
        digitPanel.add(four);
        digitPanel.add(five);
        digitPanel.add(six);
        digitPanel.add(seven);
        digitPanel.add(eight);
        digitPanel.add(nine);
        digitPanel.add(zero);
        digitPanel.add(plus);
        digitPanel.add(minus);
        digitPanel.add(multiply);
        digitPanel.add(divide);
        digitPanel.add(equals);

        digitPanel.setLayout(new GridLayout(5, 3));
        output.setEditable(false);

        frame.add(BorderLayout.NORTH, output);
        frame.add(BorderLayout.SOUTH, digitPanel);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof NumberButton) {
            if (expectingNextOperand) {
                lastOperand = currentOperand;
                lastOperandHasValue = true;
                if (shouldRemoveChar) {
                    resetOutput();
                    shouldRemoveChar = false;

                }
                output.append(String.valueOf(((NumberButton) e.getSource()).getNumber()));
            } else {
                output.append(String.valueOf(((NumberButton) e.getSource()).getNumber()));
            }

        } else if (e.getSource() instanceof operatorButton) {
            if (e.getSource() == equals) {
                currentOperand = Double.parseDouble(output.getText());
                resetOutput();
                output.append(String.valueOf(calculate(lastOperand, currentOperand, operator)));
                currentOperand = calculate(lastOperand, currentOperand, operator);
                firstOperation = true;

            } else {
                currentOperand = Double.parseDouble(output.getText());
                if (!firstOperation) {
                    previousOperator = operator;
                }
                operator = ((operatorButton) e.getSource()).getOperator();

                if (lastOperandHasValue && !firstOperation) {
                    output.setText(String.valueOf(calculate(lastOperand, currentOperand, previousOperator)));
                    currentOperand = calculate(lastOperand, currentOperand, previousOperator);
                }
                output.append(String.valueOf(operator));
                expectingNextOperand = true;
                shouldRemoveChar = true;
                firstOperation = false;

            }
        }

    }

    public void resetOutput() {
        output.setText(null);
    }

    public double calculate(double firstOperand, double secondOperand, char operator) {
        double ans = 0;
        if (operator == '+') {
            ans = firstOperand + secondOperand;
        } else if (operator == '-') {
            ans = firstOperand - secondOperand;
        } else if (operator == '*') {
            ans = firstOperand * secondOperand;
        } else if (operator == '/') {
            ans = firstOperand / secondOperand;
        }

        return ans;
    }

}