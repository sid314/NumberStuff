package NumberStuff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame implements ActionListener {
    JFrame frame;
    JButton calcButtonInt,calcButtonDouble,numberFacts;
    JPanel panel;
    JTextArea introduction;
    public MainGUI(){
        frame = new JFrame();
        calcButtonInt = new JButton("Run Integer Calculator");
        numberFacts = new JButton("Run Number Facts");
        calcButtonDouble = new JButton("Run Double Calculator");
        panel = new JPanel();
        introduction = new JTextArea();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,200);
        calcButtonInt.addActionListener(this);
        numberFacts.addActionListener(this);
        calcButtonDouble.addActionListener(this);
        panel.add(calcButtonInt);
        panel.add(numberFacts);
        panel.add(calcButtonDouble);
        panel.setLayout(new GridLayout(1,2));
        introduction.setText("Click on Run Double Calculator to run calculator with decimal numbers\n Click on Run Integer Calculator to run calculator without decimal numbers\nClick on Run Number Facts to launch Number Facts GUI");
        frame.add(BorderLayout.NORTH,introduction);
        frame.add(BorderLayout.SOUTH,panel);
        frame.setVisible(true);
        introduction.setEditable(false);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==calcButtonInt){
          frame.setVisible(false);
          IntegerCalculatorGUI calc = new IntegerCalculatorGUI();
      }
      else if (e.getSource()==numberFacts){
          frame.setVisible(false);
          NumberPropertiesGUI numFacts = new NumberPropertiesGUI();
      }
      else if (e.getSource()==calcButtonDouble){
          frame.setVisible(false);
          DoubleCalculatorGUI doubleCalc = new DoubleCalculatorGUI();
      }

    }
}
