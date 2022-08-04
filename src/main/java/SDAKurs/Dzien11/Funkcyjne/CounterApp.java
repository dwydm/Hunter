package SDAKurs.Dzien11.Funkcyjne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Title");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);

        JButton button = new JButton("Baton");

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(button);
        frame.add(panel);

        JTextField numberField = new JTextField("0",10);
        panel.add(numberField);
        frame.pack();

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("to był baoton");
                int number = Integer.parseInt(numberField.getText());
                number++;
                numberField.setText(number + "");
            }
        };
        button.addActionListener(actionListener);



    }
}
