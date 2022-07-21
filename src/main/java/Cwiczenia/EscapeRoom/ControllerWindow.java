package Cwiczenia.EscapeRoom;

import javax.swing.*;
import java.awt.*;

public class ControllerWindow extends Controller {
    JFrame frame = new JFrame();

    public ControllerWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.ORANGE);
    }



    @Override
    public void displayOnScreen(String message) {
        JOptionPane.showMessageDialog(frame,message);
    }

    @Override
    public String saveUserInput(String message) {
        return JOptionPane.showInputDialog(frame,message);
    }
}
