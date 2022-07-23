package Cwiczenia.EscapeRoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControllerWindow extends Controller {
    JFrame frame = new JFrame();


    public ControllerWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
