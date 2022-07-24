package Cwiczenia.Snake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class SnakePanel extends JPanel implements ActionListener {
    private static final int SCORE_TAB = 75;
    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private static final int UNIT_SIZE = 25;
    private static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    private static final int DELAY = 100;
    private final int[] xSnake = new int[GAME_UNITS];
    private final int[] ySnake = new int[GAME_UNITS];
    private int SnakeParts = 6;
    private int applesEaten = 0;
    private int appleX;
    private int appleY;
    private char direction = 'D';
    private boolean running = false;
    private Timer timer;
    private Random random;


    SnakePanel() {
        random = new Random();
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT + SCORE_TAB));
        setBackground(new Color(19, 161, 20));
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
        startGame();

    }

    public void startGame() {
        Arrays.fill(ySnake,SCORE_TAB);
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if(!running) {
            gameOver(g);
            return;
        }

        //score
        g.setFont(new Font("Brandish",Font.BOLD,30));
        g.setColor(Color.BLACK);
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString(("SCORE: " + applesEaten),(SCREEN_WIDTH - metrics.stringWidth("SCORE: "))/2,(int) (SCORE_TAB/2));

        //playable grid
        g.setColor(new Color(77, 227, 24));
        for (int i = 0; i <= (SCREEN_HEIGHT / UNIT_SIZE) + SCORE_TAB; i++) {
            g.drawLine(i * UNIT_SIZE, SCORE_TAB, i * UNIT_SIZE, SCREEN_HEIGHT + SCORE_TAB);
            g.drawLine(0, (i * UNIT_SIZE) + SCORE_TAB, SCREEN_WIDTH, (i * UNIT_SIZE) + SCORE_TAB);
        }

        g.setColor(Color.RED);
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);


        for (int i = 0; i < SnakeParts; i++) {
            if (i == 0) {
                g.setColor(new Color(213, 145, 33));
                g.fillRect(xSnake[i], ySnake[i], UNIT_SIZE, UNIT_SIZE);
            } else {
                g.setColor(new Color(171, 105, 18));
                g.fillOval(xSnake[i], ySnake[i], UNIT_SIZE, UNIT_SIZE);
            }
        }

    }


    public void newApple() {
            appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
            appleY = (random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE) + SCORE_TAB;

    }

    public void move() {
        for (int i = SnakeParts; i > 0; i--) {
            xSnake[i] = xSnake[i - 1];
            ySnake[i] = ySnake[i - 1];
        }

        switch (direction) {
            case 'D':
                xSnake[0] = xSnake[0] + UNIT_SIZE;
                break;
            case 'A':
                xSnake[0] = xSnake[0] - UNIT_SIZE;
                break;
            case 'W':
                ySnake[0] = ySnake[0] - UNIT_SIZE;
                break;
            case 'S':
                ySnake[0] = ySnake[0] + UNIT_SIZE;
        }

    }

    public void checkApple() {
        if (appleX == xSnake[0] && appleY == ySnake[0]) {
            SnakeParts++;
            applesEaten++;
            newApple();
        }

    }

    public void checkCollisions() {
        //check for body collisions
        for (int i = SnakeParts; i > 0; i--) {
            if ((xSnake[0] == xSnake[i]) && (ySnake[0] == ySnake[i])) {
                running = false;
            }
        }
        //check for border collision
        if (xSnake[0] < 0 || xSnake[0] >= SCREEN_WIDTH) {
            running = false;
        }

        if (ySnake[0] < SCORE_TAB || ySnake[0] >= SCREEN_HEIGHT + SCORE_TAB) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }


    }

    public void gameOver(Graphics g) {
        g.setColor(new Color(220, 216, 7));
        g.setFont(new Font("Brandish",Font.BOLD,40));
        FontMetrics gameOverMetrics = getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (SCREEN_WIDTH - gameOverMetrics.stringWidth("GAME OVER"))/2 - UNIT_SIZE, SCREEN_HEIGHT/2 - UNIT_SIZE);

        g.setFont(new Font("Brandish",Font.BOLD,25));
        g.setColor(new Color(215, 17, 59));
        FontMetrics scoreMetrics = getFontMetrics(g.getFont());
        g.drawString(("FINAL SCORE: " + applesEaten),(SCREEN_WIDTH - scoreMetrics.stringWidth("FINAL SCORE: "))/2 - UNIT_SIZE,SCREEN_HEIGHT/2 + UNIT_SIZE);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();

    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent) {
            switch (keyEvent.getKeyCode()) {
                case KeyEvent.VK_W:
                    if (direction != KeyEvent.VK_S) {
                        direction = KeyEvent.VK_W;
                    }
                    break;
                case KeyEvent.VK_S:
                    if (direction != KeyEvent.VK_W) {
                        direction = KeyEvent.VK_S;
                    }
                    break;
                case KeyEvent.VK_A:
                    if (direction != KeyEvent.VK_D) {
                        direction = KeyEvent.VK_A;
                    }
                    break;
                case KeyEvent.VK_D:
                    if (direction != KeyEvent.VK_A) {
                        direction = KeyEvent.VK_D;
                    }
                    break;
            }

        }
    }

}
