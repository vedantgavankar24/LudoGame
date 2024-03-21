import java.awt.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.image.*;
import java.util.Scanner;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.renderable.RenderableImage;
import java.lang.Thread;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.IOException;
import static java.awt.Color.*;
import static java.lang.Thread.sleep;
import java.util.Stack;


public class LudoClass {
    private int total = 0;
    int[] xposn = {270, 270, 270, 270, 270, 230, 190, 150};
    int[] yposn = {550, 510, 470, 430, 390, 350, 350, 350};

    int initx[] = {510, 430, 430, 510, 150, 70, 70, 150, 150, 70, 70, 150, 510, 430, 430, 510};
    int inity[] = {70, 70, 150, 150, 70, 70, 150, 150, 430, 430, 510, 510, 430, 430, 510, 510};

    int xPosRed[] = {50, 90, 130, 170, 210, 250, 250, 250, 250, 250, 250, 290, 330, 330, 330, 330, 330, 330, 370, 410, 450, 490, 530, 570, 570, 570, 530, 490, 450, 410, 370, 330, 330, 330, 330, 330, 330, 290, 250, 250, 250, 250, 250, 250, 210, 170, 130, 90, 50, 10, 10, 50, 90, 130, 170, 210, 250};

    int yPosRed[] = {250, 250, 250, 250, 250, 210, 170, 130, 90, 50, 10, 10, 10, 50, 90, 130, 170, 210, 250, 250, 250, 250, 250, 250, 290, 330, 330, 330, 330, 330, 330, 370, 410, 450, 490, 530, 570, 570, 570, 530, 490, 450, 410, 370, 330, 330, 330, 330, 330, 330, 290, 290, 290, 290, 290, 290, 290};

    int xPosBlue[] = {250, 250, 250, 250, 250, 210, 170, 130, 90, 50, 10, 10, 10, 50, 90, 130, 170, 210, 250, 250, 250, 250, 250, 250, 290, 330, 330, 330, 330, 330, 330, 370, 410, 450, 490, 530, 570, 570, 570, 530, 490, 450, 410, 370, 330, 330, 330, 330, 330, 330, 290, 290, 290, 290, 290, 290, 290};
    //{10, 50, 90, 130, 170, 210};
    int yPosBlue[] = {530, 490, 450, 410, 370, 330, 330, 330, 330, 330, 330, 290, 250, 250, 250, 250, 250, 250, 210, 170, 130, 90, 50, 10, 10, 10, 50, 90, 130, 170, 210, 250, 250, 250, 250, 250, 250, 290, 330, 330, 330, 330, 330, 330, 370, 410, 450, 490, 530, 570, 570, 530, 490, 450, 410, 370, 330};
    //{250, 250, 250, 250, 250, 250};
    int xPosGreen[] = {330, 330, 330, 330, 330, 370, 410, 450, 490, 530, 570, 570, 570, 530, 490, 450, 410, 370, 330, 330, 330, 330, 330, 330, 290, 250, 250, 250, 250, 250, 250, 210, 170, 130, 90, 50, 10, 10, 10, 50, 90, 130, 170, 210, 250, 250, 250, 250, 250, 250, 290, 290, 290, 290, 290, 290, 290};
    int yPosGreen[] = {50, 90, 130, 170, 210, 250, 250, 250, 250, 250, 250, 290, 330, 330, 330, 330, 330, 330, 370, 410, 450, 490, 530, 570, 570, 570, 530, 490, 450, 410, 370, 330, 330, 330, 330, 330, 330, 290, 250, 250, 250, 250, 250, 250, 210, 170, 130, 90, 50, 10, 10, 50, 90, 130, 170, 210, 250};

    int xPosYellow[] = {530, 490, 450, 410, 370, 330, 330, 330, 330, 330, 330, 290, 250, 250, 250, 250, 250, 250, 210, 170, 130, 90, 50, 10, 10, 10, 50, 90, 130, 170, 210, 250, 250, 250, 250, 250, 250, 290, 330, 330, 330, 330, 330, 330, 370, 410, 450, 490, 530, 570, 570, 530, 490, 450, 410, 370, 330};
    int yPosYellow[] = {330, 330, 330, 330, 330, 370, 410, 450, 490, 530, 570, 570, 570, 530, 490, 450, 410, 370, 330, 330, 330, 330, 330, 330, 290, 250, 250, 250, 250, 250, 250, 210, 170, 130, 90, 50, 10, 10, 10, 50, 90, 130, 170, 210, 250, 250, 250, 250, 250, 250, 290, 290, 290, 290, 290, 290, 290};
    int xPos[][] = new int[4][57];
    //{{xPosGreen[xPosGreen.length]}, {xPosRed[xPosRed.length]}, {xPosBlue[xPosBlue.length]}, {xPosYellow[xPosYellow.length]}};
    int yPos[][] = new int[4][57];
    //{{yPosGreen[yPosGreen.length]}, {yPosRed[yPosRed.length]}, {yPosBlue[yPosBlue.length]}, {yPosYellow[yPosYellow.length]}};
    int xgreySpots[] = {490, 330, 90, 250};
    int ygreySpots[] = {250, 490, 330, 90};
    Point[] flagpoints = new Point[4];
    Stack<Integer> opt3stack = new Stack<>();
    boolean pressed = false;
    int maxdicetime = 10;
    int[] diceNumber = new int[4];
    JButton diceButton = new JButton("ROLL DICE");
    JButton dicepicButton = new JButton("");
    JButton[] buttons = createButtonArray(16); // Create an array of 5 buttons
    CustomActionListener[] customListeners = new CustomActionListener[16];
    JLabel[] labels = createLabelArray(16);
    JLabel[] chanceText = createLabelArray(4);
    JLabel diceLabel = new JLabel();
    JLabel[] timerLabels = createLabelArray(16);
    Color[] colors = createColorArray(16);

    // TimerArray timerArray = new TimerArray(16);
    JPanel glassPane = new JPanel();
    int xAbspos[] = new int[16];
    int yAbspos[] = new int[16];
    int noOfSteps[] = new int[16];
    Random random1 = new Random();
    JLabel cplabel = new JLabel("");
    int[] w = {3, 3, 1, 3};
    int b = 0;
    int currentplayer = 0;

    //ImageIcon redtoken = new ImageIcon("transredt.png");

    //Image rt = redtoken.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon redt = new ImageIcon();

    //Image rt2 = redtoken.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    ImageIcon redtby2 = new ImageIcon();
    ImageIcon colorIcon[][] = new ImageIcon[4][2];

    //ImageIcon bluetoken = new ImageIcon("transbluet.png");

    //Image bt = bluetoken.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon bluet = new ImageIcon();

    //Image bt2 = bluetoken.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    ImageIcon bluetby2 = new ImageIcon();


    //ImageIcon bluef = new ImageIcon("Undesign.png");

    //Image fb = bluef.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    //ImageIcon bluef2 = new ImageIcon(fb);

    //ImageIcon yellowtoken = new ImageIcon("transyellowt.png");

    //Image yt = yellowtoken.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon yellowt = new ImageIcon();

    //Image yt2 = yellowtoken.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    ImageIcon yellowtby2 = new ImageIcon();


    //ImageIcon greentoken = new ImageIcon("transgreent.png");

    //Image gt = greentoken.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon greent = new ImageIcon();

    //Image gt2 = greentoken.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    ImageIcon greentby2 = new ImageIcon();
boolean allowdicetime = true;
    ImageIcon diceImages[] = new ImageIcon[6];

    Color color0 = new Color(38, 226, 0, 255);
    Color color1 = new Color(255, 50, 50);
    Color color2 = new Color(10, 169, 255, 255);
    Color color3 = new Color(238, 222, 12);
    int q = 0;
    int eligible = 0;
    int[] inda={6, 5, 4, 3};
    float[] fmanrisk = new float[4];
    float[] multirisk = new float[4];
    int[] zerorisk = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    Color customColor = new Color(1, 161, 16);
    Color customColor2 = new Color(1, 104, 215);
    int sachme = 0;
    int h1 = 0;
    int h2 = 0;
    int h3 = 0;
    int reward = 0;
    int[] pdiceNumber = {0, 0, 0, 0};
    int arr[][] = new int[4][4];
    boolean ppl = false;
    int noofdicethrows = 0;
    //int m = 0;
    int dt = 0;
    int re = 0;
    JFrame jf = new JFrame();
    Clip clip[] = new Clip[8];
    JLabel chanceLabel = new JLabel("");
    Random random = new Random();

    KeyAdapter ka = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                // Trigger the button's action when the Space key is pressed
                if (diceButton.isVisible()) {
                    diceButton.doClick();
                }
            }
        }
    };

    public class CustomButton extends JButton {
        private boolean pressed = false;

        public CustomButton(String text) {
            super(text);
            setOpaque(false); // Make the button background transparent
            setContentAreaFilled(false); // Remove default content fill
            //  setBorderPainted(false); // Remove button border

            ///          addActionListener(new ActionListener() {
            ///           @Override
            ///        public void actionPerformed(ActionEvent e) {
            ///         // Your custom action when the button is clicked
            ///      System.out.println("Button clicked!");
///                }
            ///         });

            addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    pressed = true;
                    repaint();
                }

                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    pressed = false;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Handle custom graphics here, for example, drawing a rectangle
            if (pressed) {
                g.setColor(new Color(220, 220, 220)); // Change the color when pressed
                g.fillRect(0, 0, getWidth(), getHeight());
            } else {
                g.setColor(new Color(0, 0, 0, 0)); // Transparent background
                g.fillRect(0, 0, getWidth(), getHeight());
            }

            g.setColor(black);
            g.fillArc(-14, -29, 68, 68, 240, 60);
            g.setColor(color0);
            g.fillArc(-9, -20, 58, 58, 240, 60);
            g.setColor(black);
            g.fillOval(8, 0, 25, 18);

            //      g.setColor(black);
            //    g.drawArc(-9, -20, 58, 58, 240, 60);
            //  g.setColor(customColor);
            g.setColor(color0);
            g.fillOval(10, 1, 20, 16);

            //          g.setColor(black);
            //        g.drawOval(10, 1, 19, 17);
            //  g.fillRect(10, 10, 20, 20);

        }
    }

    class killThread extends Thread {
        private int value;

        public killThread(int value) {
            this.value = value;
        }

        public void run() {
            diceTimer.stop();
            dt = 0;
            // timer.stop();
            highlightAvw2.stop();
          //  highlightAvw3.stop();

            highlightAvw3.stop();
            h1 = 0;
            h2 = 0;
            h3 = 0;
            diceButton.setVisible(false);
            if (clip[0] != null) {
                // timer.stop();
                highlightAvw2.stop();
                highlightAvw3.stop();
               // highlightAvw3.stop();
                diceTimer.stop();
                clip[0].setFramePosition(0);
            }
            clip[0].start();
            clip[0].drain();
            //}
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if (clip[0] != null) {
                    clip[0].close();
                }
            }));

            try {
                sleep(2180);
            } catch (Exception e) {

            }
            int cp = value/4;
            buttons[value].setIcon(colorIcon[cp][0]);
            buttons[value].setBorderPainted(false);
            //buttons[value].setBorderPainted(false);
            int killsteps = noOfSteps[value];
            noOfSteps[value] = 0;
            while (killsteps - 2 != -1) {
                int x1 = xPos[cp][killsteps - 1];
                int y1 = yPos[cp][killsteps - 1];
                int x2 = xPos[cp][killsteps - 2];
                int y2 = yPos[cp][killsteps - 2];
                while (x1 != x2 || y1 != y2) {
                    if (x1 < x2) {
                        x1 = x1 + 5;
                    } else if (x2 < x1) {
                        x1 = x1 - 5;
                    }
                    if (y1 < y2) {
                        y1 = y1 + 5;
                    } else if (y2 < y1) {
                        y1 = y1 - 5;
                    }
                    buttons[value].setIcon(colorIcon[cp][0]);
                    buttons[value].setBounds(x1, y1, 40, 40);
                    try {
                        sleep(15);
                    } catch (Exception e) {

                    }
                }
                killsteps--;
                if (killsteps - 2 == -1) {
                    chanceLabel.setVisible(true);
                }
            }

            //           sleep(150);

            buttons[value].setBounds(initx[value], inity[value], 40, 40);
            buttons[value].setBorderPainted(true);
            diceButton.setVisible(true);

            if(allowdicetime==true) {
                diceTimer.start();
            }
            dt = 0;
            ///////timer.start();
            ///////highlightAv.start();
            h1 = 0;
            h2 = 0;
            h3 = 0;
        }
    }

    int[] echees = {0, 20, 4, 4};
    class VG extends Thread {
        private int value;
        private int diceRoll;

        public VG(int value, int diceRoll) {
            this.value = value;
            this.diceRoll = diceRoll;
        }

        int n = 1;

        public void run() {
            int cp = value/4;
            diceTimer.stop();
            timer.stop();
            highlightAvw2.stop();
         //   highlightAvw3.stop();
            highlightAvw3.stop();

            removeAction();

            if (diceRoll <= 57 - noOfSteps[value] && (buttons[value].getLocation().getX() != initx[value] || buttons[value].getLocation().getY() != inity[value])) {
                for (int i = 0; i < diceRoll; i++) {

                    if (i != diceRoll - 1) {

                        updateTokenPosition(n, 0, cp);

                    }
                    if (i == diceRoll - 1) {

                        updateTokenPosition(n, 1, cp);

                    }

                    try {
                        sleep(40);
                    } catch (Exception e) {

                    }
                }
            } else {
                diceButton.setVisible(true);
                if(allowdicetime==true) {
                    diceTimer.restart();
                }
                dt = 0;
            }

            if (diceRoll == 6 && (buttons[value].getLocation().getX() == initx[value] && buttons[value].getLocation().getY() == inity[value])) {

                updateTokenPosition(n, 0, cp);
                diceButton.setVisible(true);
                if(allowdicetime==true) {
                    diceTimer.restart();
                }
                dt = 0;
                chanceLabel.setVisible(true);
            }

        }


        private void updateTokenPosition(int n, int k, int cp) {
            int v = 0;
            glassPane.add(buttons[value]);
            if (n == 1 && noOfSteps[value] >= 1) {
                buttons[value].setBorderPainted(false);
                int x1 = xPos[cp][noOfSteps[value] - 1];
                int y1 = yPos[cp][noOfSteps[value] - 1];
                int x2 = xPos[cp][noOfSteps[value]];
                int y2 = yPos[cp][noOfSteps[value]];
                while (x1 != x2 || y1 != y2) {
                    if (x1 < x2) {
                        x1 = x1 + 4;
                    }
                    if (x2 < x1) {
                        x1 = x1 - 4;
                    }
                    if (y1 < y2) {
                        y1 = y1 + 4;
                    }
                    if (y2 < y1) {
                        y1 = y1 - 4;
                    }
                    buttons[value].setBounds(x1, y1, 40, 40);
                    try {
                        sleep(16);
                    } catch (Exception e) {

                    }

                }
            }
            if (clip[3] != null) {
                clip[3].setFramePosition(0);
            }
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if (clip[3] != null) {
                    clip[3].close();
                }
            }));
            clip[3].start();
            clip[3].drain();


            buttons[value].setBounds(xPos[cp][noOfSteps[value]], yPos[cp][noOfSteps[value]], 40, 40);

            preventAnyOverlap(value, k, cp);

            if (k == 1 && isStarSpot(xPos[cp][noOfSteps[value]], yPos[cp][noOfSteps[value]]) == true) {
                if (clip[4] != null) {
                    clip[4].setFramePosition(0);
                }
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    if (clip[4] != null) {
                        clip[4].close();
                    }
                }));
                clip[4].start();
                clip[4].drain();
            }

            noOfSteps[value] = noOfSteps[value] + n;


            if (noOfSteps[arr[cp][0]] == 57 && noOfSteps[arr[cp][1]] == 57 && noOfSteps[arr[cp][2]] == 57 && noOfSteps[arr[cp][3]] == 57) {
                v = 4;
                if (clip[6] != null) {
                    clip[6].setFramePosition(0);
                }
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    if (clip[6] != null) {
                        clip[6].close();
                    }
                }));
                w[cp] = 0;
                pdiceNumber[cp] = 0;
                clip[6].start();
                clip[6].drain();
            }
            if (noOfSteps[value] == 57 && v != 4 && k == 1) {
                reward = 1;
                if (clip[5] != null) {
                    clip[5].setFramePosition(0);
                }
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    if (clip[5] != null) {
                        clip[5].close();
                    }
                }));
                clip[5].start();
                clip[5].drain();
            }


            if (k == 1 && (reward == 1 || sachme == 1)) {
                pdiceNumber[cp] = 6;
                chanceLabel.setText(chanceText[currentplayer].getText());
                chanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
            }
            if (k == 1) {
                diceButton.setVisible(true);
               // highlightAvw3.stop();
                highlightAvw3.stop();
                highlightAvw2.stop();
                buttons[value].setBorderPainted(true);
                if(!(sachme == 1)) {
                    chanceLabel.setVisible(true);
                }










                h1=0;
                h2=0;
                h3=0;
                dt = 0;
                glassPane.add(chanceLabel);
                if(allowdicetime==true) {
                    diceTimer.restart();
                }
            }
        }

    }
    Timer chancelabelColor = new Timer(5, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(w[0] == 0 && w[1] == 0 && w[2] == 0 && w[3] == 0) {
                killProcesses();
            }
       //     if(w[currentplayer] == 0) {
         //       chanceLabel.setText(chanceText[decideWhoGoesNext(currentplayer, pdiceNumber[currentplayer])].getText());
           ///     chanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
                // System.out.println(decideWhoGoesNext(currentplayer, pdiceNumber[currentplayer]))
            //}
            if (chanceLabel.getText() == chanceText[0].getText()) {
                chanceLabel.setForeground(customColor);
                diceButton.setBackground(color0);
            } else if (chanceLabel.getText() == chanceText[1].getText()) {
                chanceLabel.setForeground(color1);
                diceButton.setBackground(color1);
            } else if (chanceLabel.getText() == chanceText[2].getText()) {
                chanceLabel.setForeground(customColor2);
                diceButton.setBackground(color2);
            } else {
                chanceLabel.setForeground(new Color(217, 175, 23));
                diceButton.setBackground(color3);
            }

        }
    });
    Timer appropriateColor = new Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i <= 15; i++) {
                xAbspos[i] = (int) buttons[i].getLocation().getX();
                yAbspos[i] = (int) buttons[i].getLocation().getY();
            }

            for (int i = 0; i <= 15; i++) {
                for (int j = 0; j <= 3; j++) {
                    buttons[i].setContentAreaFilled(false);
                }

                if ((xAbspos[i] == initx[i] && yAbspos[i] == inity[i]) || ((xAbspos[i] != initx[i] || yAbspos[i] != inity[i]) && noOfSteps[i] >= 52)) {
                    if (i >= 0 && i <= 3) {
                        colors[i] = color0;
                    }
                    if (i >= 4 && i <= 7) {
                        colors[i] = color1;
                    }
                    if (i >= 8 && i <= 11) {
                        colors[i] = color2;
                    }
                    if (i >= 12 && i <= 15) {
                        colors[i] = color3;
                    }
                    //buttons[i].setBackground(colors[i]);
                }

                if (xAbspos[i] >= 50 && xAbspos[i] < 90 && yAbspos[i] >= 250 && yAbspos[i] < 290) {
                    colors[i] = red;
                    buttons[i].setContentAreaFilled(true);
                    buttons[i].setBackground(red);
                    if (i >= 4 && i <= 7) {
                        colors[i] = color1;
                        buttons[i].setBackground(color1);
                    }
                }
                if (xAbspos[i] >= 330 && xAbspos[i] < 370 && yAbspos[i] >= 50 && yAbspos[i] < 90) {
                    colors[i] = customColor;
                    buttons[i].setContentAreaFilled(true);
                    buttons[i].setBackground(customColor);
                    if (i >= 0 && i <= 3) {
                        colors[i] = color0;
                        buttons[i].setBackground(color0);
                    }
                }
                if (xAbspos[i] >= 530 && xAbspos[i] < 570 && yAbspos[i] >= 330 && yAbspos[i] < 370) {
                    colors[i] = orange;
                    buttons[i].setContentAreaFilled(true);
                    buttons[i].setBackground(orange);
                    if (i >= 12 && i <= 15) {
                        colors[i] = color3;
                        buttons[i].setBackground(color3);
                    }
                }
                if (xAbspos[i] >= 250 && xAbspos[i] < 290 && yAbspos[i] >= 530 && yAbspos[i] < 570) {
                    colors[i] = customColor2;
                    buttons[i].setContentAreaFilled(true);
                    buttons[i].setBackground(customColor2);
                    if (i >= 8 && i <= 11) {
                        colors[i] = color2;
                        buttons[i].setBackground(color2);
                    }
                }


            }
        }

    });
    Timer timer = new Timer(1, new ActionListener() {
        // private int elapsedTime = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            // glassPane.remove(diceButton);
            //if (elapsedTime <= 5000 && pressed == true) {
            if (noOfSteps[arr[currentplayer][0]] == 57 && noOfSteps[arr[currentplayer][1]] == 57 && noOfSteps[arr[currentplayer][2]] == 57 && noOfSteps[arr[currentplayer][3]] == 57) {
                w[currentplayer] = 0;
            }
            if (q != 0) {
                if (pressed == true && q > 1) {
                    removeAction();
                    ((Timer) e.getSource()).stop();
                    //    diceButton.setVisible(true);
                }

            }
            if (q == 0) {
                removeAction();
                diceButton.setVisible(true);
                dt = 0;
                if(allowdicetime==true) {
                    diceTimer.restart();
                }

                ((Timer) e.getSource()).stop();
                // diceButton.setVisible(true);
            }

     /////       chanceLabel.setText(chanceText[decideWhoGoesNext(currentplayer, pdiceNumber[currentplayer])].getText());
   ////         chanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
          ////  System.out.println("from timer q==0" +
       ///    //         "000000000000000000000000000000" +
                //    "000000000000000000000000000000" +
                  //  "000000000000000000000000000000" +
                    //"000000000000000000000000000000");
            // System.out.println(decideWhoGoesNext(currentplayer, pdiceNumber[currentplayer]));

            ////glassPane.add(chanceLabel);

        }
    });
    Timer highlightAvw2 = new Timer(400, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            int t = 0;
            for (int j = 0; j <= 3; j++) {
                if (checkAvailability(arr[currentplayer][j], diceNumber[currentplayer]) == true) {
                    t = t + 1;
                }
            }

            h2 = h2 + 1;
            if (t > 0) {
                int d = 0;
                int manage[] = new int[t];
                for (int j = 0; j <= 3; j++) {
                    if (checkAvailability(arr[currentplayer][j], diceNumber[currentplayer]) == true) {
                        manage[d] = arr[currentplayer][j];
                        d = d + 1;
                        if (d == t) {
                            break;
                        }
                    }
                }
                if (t == 1) {
                    VG sg = new VG(manage[0], diceNumber[currentplayer]);
                    synchronized (sg) {
                        sg.start();
                    }
                    ((Timer) e.getSource()).stop();
                } else {
                    int count = 0;
                    int temp = noOfSteps[manage[0]];
                    for (int i = 0; i < t; i++) {
                        if (noOfSteps[manage[i]] == temp) {
                            count = count + 1;
                        }
                    }
                    if (temp > 0 && count == t) {
                        VG kg = new VG(manage[0], diceNumber[currentplayer]);
                        synchronized (kg) {
                            kg.start();
                        }
                        ((Timer) e.getSource()).stop();
                    } else {
                        if (h2 >= echees[w[currentplayer]]) {
                            int r1 = random.nextInt(t);
                            VG sg = new VG(manage[r1], diceNumber[currentplayer]);
                            synchronized (sg) {
                                sg.start();
                            }
                            ((Timer) e.getSource()).stop();
                        }
                    }
                }
                if (h2 % 2 == 1) {
                    for (int j = 0; j < t; j++) {
                        buttons[manage[j]].setContentAreaFilled(true);
                        buttons[manage[j]].setBackground(new Color(255, 128, 0));
                    }
                } else {
                    for (int j = 0; j < t; j++) {
                        buttons[manage[j]].setContentAreaFilled(false);
                    }
                }
            } else {
                removeAction();
                ((Timer) e.getSource()).stop();
            }
        }

    });

    Timer highlightAvw3 = new Timer(400, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            int t = 0;
            for (int j = 0; j <= 3; j++) {
                if (checkAvailability(arr[currentplayer][j], diceNumber[currentplayer]) == true) {
                    t = t + 1;
                }
            }

            h3 = h3 + 1;
            if (t > 0) {
                int d = 0;
                int manage[] = new int[t];
                for (int j = 0; j <= 3; j++) {
                    if (checkAvailability(arr[currentplayer][j], diceNumber[currentplayer]) == true) {
                        manage[d] = arr[currentplayer][j];
                        d = d + 1;
                        if (d == t) {
                            break;
                        }
                    }
                }

                int count = 0;
                int temp = noOfSteps[manage[0]];
                for (int i = 0; i < t; i++) {
                    if (noOfSteps[manage[i]] == temp) {
                        count = count + 1;
                    }
                }
                if (t == 1) {
                    VG sg = new VG(manage[0], diceNumber[currentplayer]);
                    synchronized (sg) {
                        sg.start();
                    }
                    ((Timer) e.getSource()).stop();
                } else if (temp > 0 && count == t) {
                    VG kg = new VG(manage[0], diceNumber[currentplayer]);
                    synchronized (kg) {
                        kg.start();
                    }
                    ((Timer) e.getSource()).stop();
                }
                if (h3 >= 4) {
                    System.out.println();
                    System.out.println("**************************************************************************************************");
                    System.out.println("**************************************************************************************************");
                    System.out.println();
                    System.out.println("currentplayer= " + currentplayer);
                    float[] initrisk = {0f, 0f, 0f, 0f};
                    float[] finrisk = {0f, 0f, 0f, 0f};


                    int dicenumber = Integer.parseInt(diceLabel.getText());

                    for (int k = 0; k < t; k++) {
                        initrisk[k] = calculateExactProb(currentplayer, manage[k], 0, initrisk[k]);
                        finrisk[k] = calculateExactProb(currentplayer, manage[k], dicenumber, finrisk[k]);
                    }

                    for (int q = 0; q < t; q++) {
                        System.out.println();
                        System.out.println("q = " + q);
                        System.out.println("manage[" + q + "] = " + manage[q]);
                        System.out.println("initrisk[" + q + "] = " + initrisk[q]);
                        System.out.println();
                    }




//                    int[] added = new int[12];
  //                  int add=0;
    //                for(int k=0; k<t; k++) {
      //                  for (int i = noOfSteps[k] - 1; i <= 50; i++) {
        //
          //              }
            //        }




                    for (int q = 0; q < t; q++) {
                        System.out.println();
                        System.out.println("q = " + q);
                        System.out.println("manage[" + q + "] = " + manage[q]);
                        System.out.println("initrisk[" + q + "] = " + initrisk[q]);
                        System.out.println("finrisk[" + q + "] = " + finrisk[q]);
                        System.out.println();
                    }

                    System.out.println("***************************************************************************************************");
                    System.out.println();
                    System.out.println();
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    int f = 0;

                    for (int q = 0; q < t; q++) {
                        fmanrisk[q] = finrisk[q] - initrisk[q];
                        multirisk[q] = fmanrisk[q];//*(noOfSteps[manage[q]]);
                        System.out.println("finrisk[" + q + "]=" + finrisk[q]);
                        System.out.println("initrisk[" + q + "]=" + initrisk[q]);
                        if (fmanrisk[q] < 0) {
                            f = f + 1;
                        }
                    }

                    System.out.println();

                    System.out.println();
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println();
                    for (int q = 0; q < t; q++) {
                        System.out.println("fmanrisk[" + q + "]=" + fmanrisk[q]);
                        System.out.println();
                    }
                    System.out.println("8888888888888888");
                    System.out.println();
//                    for (int q = 0; q < t; q++) {
  //                      if(noOfSteps[manage[q]] == 0) {
    //                        fmanrisk[q] = 0;
      //                      multirisk[q] = 0;
        //                } else if (noOfSteps[manage[q]] > 0 && fmanrisk[q] < 0) {
          //                  multirisk[q] = fmanrisk[q] * (noOfSteps[manage[q]]) * (noOfSteps[manage[q]]) * (noOfSteps[manage[q]]) ;//* (-1);
            //            } else {
              //              multirisk[q] = fmanrisk[q] * (noOfSteps[manage[q]]) * (noOfSteps[manage[q]]) * (noOfSteps[manage[q]]);
                //        }
                  //      System.out.println("multirisk[" + q + "]=" + multirisk[q]);
                    //    System.out.println();
                    //}

                    System.out.println("***************************************************************************************************");

                    int kelp = 0;
                    for (int j = 0; j < t; j++) {
                        if (multirisk[j] < multirisk[kelp]) {
                            kelp = j;
                        }
                    }
                    System.out.println("og1 selected kelp = "+kelp+ ", manage["+kelp+"] = "+manage[kelp]);
                    if (f > 1) {
                        float[] fe = new float[f];
                        int[] feq = new int[f];
                        int o = 0;
                        for (int q = 0; q < t; q++) {
                            if (fmanrisk[q] < 0) {
                                fe[o] = fmanrisk[q];
                                feq[o] = q;
                                o = o + 1;
                            }
                        }

                        int ct = 0;
                        float fkelp = fe[0];
                        for (int q = 0; q < o; q++) {
                            if (fe[q] == fkelp) {
                                ct = ct + 1;
                            }
                        }
                        if (ct == o) {
                            fkelp = noOfSteps[feq[0]];
                            for (int q = 0; q < o; q++) {
                                if (noOfSteps[feq[q]] < fkelp) {
                                    kelp = feq[q];
                                }
                            }
                            System.out.println("og2 selected kelp due to ct = "+kelp+ ", manage["+kelp+"] = "+manage[kelp]);
                        } else {
                            fkelp = fe[0];

                            for (int q = 0; q < o; q++) {
                                if (fe[q] > fkelp) {
                                    kelp = feq[q];
                                }
                            }
                            System.out.println("og3 selected manage[kelp]=" + manage[kelp]);
                        }
                    }

                    if(multirisk[kelp] >= 0) {
                        count = 0;
                        for (int i = 0; i < t; i++) {
                            if (multirisk[i] == multirisk[kelp]) {
                                count++;
                            }
                        }
 //                       if (count > 1) {
   //                         int less = noOfSteps[manage[kelp]];
     //                       System.out.println("finding kelp with eq. multi and with smallest noofsteps, multirisk[kelp] >= 0");
       //                     for (int i = 0; i < t; i++) {
         //                       if (multirisk[i] == multirisk[kelp] && noOfSteps[manage[i]] < less && ((noOfSteps[manage[i]] - noOfSteps[manage[kelp]] > 18) || (noOfSteps[manage[i]] - noOfSteps[manage[kelp]] < -18)) ) {
           //                         less = noOfSteps[manage[i]];
             //                       kelp = i;
               //                 }
                 //           }
                   //         System.out.println("replaced old kelp with " + manage[kelp]);
                     //   }
                    }
                    if (dicenumber == 6 && noOfSteps[manage[kelp]] != 0) {
                        if(noOfSteps[manage[kelp]] >= 36) {
                            if ((fmanrisk[kelp] >= 0 && fmanrisk[kelp] <= (1f / 36f)) || (fmanrisk[kelp] <= 0 && fmanrisk[kelp] >= -(1f / 36f))) {
                                for (int j = 0; j < t; j++) {
                                    if (j != kelp && noOfSteps[manage[j]] == 0) {
                                        kelp = j;
                                    }
                                }
                            }
                        }
                        if(noOfSteps[manage[kelp]] <= 16) {
                            if ((fmanrisk[kelp] >= 0 && fmanrisk[kelp] <= (1f / 6f)) || (fmanrisk[kelp] <= 0 && fmanrisk[kelp] >= -(1f / 6f))) {
                                for (int j = 0; j < t; j++) {
                                    if (j != kelp && noOfSteps[manage[j]] == 0) {
                                        kelp = j;
                                    }
                                }
                            }
                        }
                        System.out.println("6 chanced selected manage[kelp]=" + manage[kelp]);
                    }






                    float[] futkill = new float[t];
                    for(int i=0; i<t; i++) {
                        futkill[i] = 0f;
                    }
                    int[] num = new int[16];

                    for(int i=0; i<t; i++) {
                        int cp1noofsteps = noOfSteps[manage[i]];
                        int futnos = cp1noofsteps - 1 + dicenumber;
                        if (cp1noofsteps > 0 && cp1noofsteps < 51) {
                            int x = xPos[currentplayer][futnos];
                            int y = yPos[currentplayer][futnos];
                            if (isSafeSpot(x, y) == false && tokenIsAlone(x, y) >= 1) {
                                for (int l = 0; l < 16; l++) {
                                    num[l] = 20;
                                }
                                for (int j = 0; j <= 15; j++) {
                                    xAbspos[j] = (int) buttons[j].getLocation().getX();
                                    yAbspos[j] = (int) buttons[j].getLocation().getY();
                                    if (xAbspos[j] >= x && xAbspos[j] < x + 40 && yAbspos[j] >= y && yAbspos[j] < y + 40) {
                                        num[j] = j;
                                    }
                                }
                                int handle[] = new int[tokenIsAlone(x, y)];
                                int h = 0;

                                for (int o = 0; o < 16; o++) {
                                    if (num[o] != 20) {
                                        handle[h] = num[o];
                                        h = h + 1;
                                    }
                                }
                                int a = 0;
                                for (int o = 0; o < h; o++) {
                                    if (handle[o] / 4 == currentplayer) {
                                        a = 1;
                                    }
                                }
                                if (a != 1) {
                                    if (h > 0) {
                                        float mycondn = finrisk[i] * (noOfSteps[manage[i]] + futnos);
                                        System.out.println("mycondn[" + i + "] = " + mycondn);

                                        float hiscondn = ((1f / 6f) + finrisk[i]) * noOfSteps[handle[0]] * h;
                                        System.out.println("hiscondn[" + i + "] = " + hiscondn);

                                        System.out.println("manage[" + i + "] = " + manage[i] + " caught red handed");
                                        if(hiscondn - mycondn>=0) {
                                            futkill[i] = hiscondn - mycondn;
                                        }
                                        System.out.println("futkill[" + i + "] = " + futkill[i]);
                                    }
                                }
                            }
                        }
                    }

                    for(int i=0; i<t; i++) {
                        if((futkill[i] - fmanrisk[i]) > (futkill[kelp] - fmanrisk[kelp])) {
                            kelp = i;
                        }
                    }

                    System.out.println("########################################################################");
                    /*float[] initrisk2 = {0f, 0f, 0f, 0f};
                    float[] finrisk2 = {0f, 0f, 0f, 0f};

                    int ab[] = new int[t];
                    int ba[] = new int[t];
                    int c[] = new int[t];

                    for(int i=0; i<t; i++) {
                        ab[i] = noOfSteps[manage[i]];
                        ba[i] = manage[i];
                        c[i] = i;
                    }

                    bubbleSort(ab, ba, c, t);
                    int g=0;
                    for (int i = 0; i < t; i++) {
                        initrisk2[c[i]] = calculateExactProb(currentplayer, manage[c[i]], 0, initrisk[c[i]]);
                        System.out.println("initrisk2["+c[i]+"] = " +initrisk2[c[i]]);
                        finrisk2[c[i]] = calculateExactProb(currentplayer, manage[c[i]], dicenumber, finrisk[c[i]]);
                        System.out.println("finrisk2["+c[i]+"] = " +finrisk2[c[i]]);
                        g = g + 1;
                    }
                    */

                    System.out.println("finally selected manage[kelp] = " +manage[kelp]);
                    System.out.println();
                    System.out.println("########################################################################");
                    VG kg = new VG(manage[kelp], dicenumber);
                    synchronized (kg) {
                        kg.start();
                    }
                    ((Timer) e.getSource()).stop();
                }


                else {
                    if (h3 % 2 == 1) {
                        for (int j = 0; j < t; j++) {
                            buttons[manage[j]].setContentAreaFilled(true);
                            buttons[manage[j]].setBackground(new Color(255, 128, 0));
                        }
                    } else {
                        for (int j = 0; j < t; j++) {
                            buttons[manage[j]].setContentAreaFilled(false);
                        }
                    }
                }
            }
            else {
                removeAction();
            }
        }
    });

    Timer highlightAvw3adv = new Timer(400, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            int t = 0;
            for (int j = 0; j <= 3; j++) {
                if (checkAvailability(arr[currentplayer][j], diceNumber[currentplayer]) == true) {
                    t = t + 1;
                }
            }

            h3 = h3 + 1;
            if (t > 0) {
                int d = 0;
                int manage[] = new int[t];
                for (int j = 0; j <= 3; j++) {
                    if (checkAvailability(arr[currentplayer][j], diceNumber[currentplayer]) == true) {
                        manage[d] = arr[currentplayer][j];
                        d = d + 1;
                        if (d == t) {
                            break;
                        }
                    }
                }

                int count = 0;
                int temp = noOfSteps[manage[0]];
                for (int i = 0; i < t; i++) {
                    if (noOfSteps[manage[i]] == temp) {
                        count = count + 1;
                    }
                }
                if (t == 1) {
                    VG sg = new VG(manage[0], diceNumber[currentplayer]);
                    synchronized (sg) {
                        sg.start();
                    }
                    ((Timer) e.getSource()).stop();
                } else if (temp > 0 && count == t) {
                    VG kg = new VG(manage[0], diceNumber[currentplayer]);
                    synchronized (kg) {
                        kg.start();
                    }
                    ((Timer) e.getSource()).stop();
                }
                if (h3 >= 4) {
                    System.out.println();
                    System.out.println("**************************************************************************************************");
                    System.out.println("**************************************************************************************************");
                    System.out.println();
                    System.out.println("currentplayer= " + currentplayer);
                    float[] initrisk = {0f, 0f, 0f, 0f};
                    float[] finrisk = {0f, 0f, 0f, 0f};

                    float[] finriskonothers = {0f, 0f, 0f, 0f};
                    float[] initriskonothers = {0f, 0f, 0f, 0f};

                    int dicenumber = Integer.parseInt(diceLabel.getText());

                    for (int k = 0; k < t; k++) {
                        initrisk[k] = calculateExactProb(currentplayer, manage[k], 0, initrisk[k]);
                        finrisk[k] = calculateExactProb(currentplayer, manage[k], dicenumber, finrisk[k]);
                    }

                    int[] noofsteps = new int[16];

                    for (int k = 0; k < t; k++) {
                        for (int i = 0; i <= 15; i++) {
                            if (i == manage[k] && noOfSteps[i] == 0 && dicenumber == 6) {
                                noofsteps[i] = 1;
                            } else if (i == manage[k] && noOfSteps[i] != 0) {
                                noofsteps[i] = noOfSteps[i] + dicenumber;
                            } //else if (noofsteps[i] == 0 && i/4 != currentplayer) {
                            //noofsteps[i] = 1;
                            //    }
                            else {
                                noofsteps[i] = noOfSteps[i];
                            }
                        }
                        for (int i = 0; i <= 15; i++) {
                            if (i / 4 != currentplayer) {
                                initriskonothers[k] = initriskonothers[k] + calculateExactProbadv(i / 4, i, 0, initriskonothers[k], noOfSteps);
                            }
                            if (i / 4 != currentplayer) {
                                finriskonothers[k] = finriskonothers[k] + calculateExactProbadv(i / 4, i, 0, finriskonothers[k], noofsteps);
                            }
                        }
                    }


                    float[] truerisk = new float[4];
                    for (int k = 0; k < t; k++) {
                        truerisk[k] = (finriskonothers[k]) - (finrisk[k] - initrisk[k]);
                    }

                    for (int k = 0; k < t; k++) {
                        System.out.println("k = "+k);
                        System.out.println("finriskonothers[" +manage[k]+"] = "+finriskonothers[k]);
                        System.out.println("initriskonothers[" +manage[k]+"] = "+initriskonothers[k]);
                        System.out.println("fmanriskonothers[" +manage[k]+"] = "+(finriskonothers[k] - initriskonothers[k]));
                        System.out.println("");
                        System.out.println("initrisk[" +manage[k]+"] = "+initrisk[k]);
                        System.out.println("finrisk[" +manage[k]+"] = "+finrisk[k]);
                        System.out.println("fmanrisk[" +manage[k]+"] = "+(finrisk[k]-initrisk[k]));
                        System.out.println("");
                        System.out.println("truerisk[" +manage[k]+"] = "+truerisk[k]);
                        System.out.println("");
                        System.out.println("");
                    }
                    int kelp = 0;
                    float comprisk = fmanrisk[kelp];
                    float af=0f;
                    for (int k = 0; k < t; k++) {
                        af = fmanrisk[k];
                        if(af<0) {
                            af=af*(-1);
                        }
                        if(af < comprisk) {
                            comprisk = af;
                            kelp = k;
                        }
                    }

               //     comprisk=fmanrisk[kelp];
             //       int count1=0;
           //         for (int k = 0; k < t; k++) {
         //               if(fmanrisk[k] == comprisk) {
       //                     count1++;
     //                   }
   //                 }
 //                   if(count1>1) {
                    //    for (int k = 0; k < t; k++) {
                  //          if(fmanrisk[k] == comprisk) {
                //                if(truerisk[k] > truerisk[kelp]) {
              //                      kelp = k;
          //                          comprisk=fmanrisk[kelp];
            //                    }
     //  /                     }
       //                 }
   //                 }




                    if (dicenumber == 6 && noOfSteps[manage[kelp]] != 0) {
                        if(noOfSteps[manage[kelp]] >= 36) {
                    if ((fmanrisk[kelp] >= 0 && fmanrisk[kelp] <= (1f / 36f)) || (fmanrisk[kelp] <= 0 && fmanrisk[kelp] >= -(1f / 36f))) {
                                for (int j = 0; j < t; j++) {
                                    if (j != kelp && noOfSteps[manage[j]] == 0) {
                                        kelp = j;
                                    }
                                }
                            }
                        }
                        if(noOfSteps[manage[kelp]] <= 16) {
                            if ((fmanrisk[kelp] >= 0 && fmanrisk[kelp] <= (1f / 6f)) || (fmanrisk[kelp] <= 0 && fmanrisk[kelp] >= -(1f / 6f))) {
                                for (int j = 0; j < t; j++) {
                                    if (j != kelp && noOfSteps[manage[j]] == 0) {
                                        kelp = j;
                                    }
                                }
                            }
                        }
                        System.out.println("6 chanced selected manage[kelp]=" + manage[kelp]);
                    }










                    float[] futkill = new float[t];
                    for(int i=0; i<t; i++) {
                        futkill[i] = 0f;
                    }
                    int[] num = new int[16];

                    for(int i=0; i<t; i++) {
                        int cp1noofsteps = noOfSteps[manage[i]];
                        int futnos = cp1noofsteps - 1 + dicenumber;
                        if (cp1noofsteps > 0 && cp1noofsteps < 51) {
                            int x = xPos[currentplayer][futnos];
                            int y = yPos[currentplayer][futnos];
                            if (isSafeSpot(x, y) == false && tokenIsAlone(x, y) >= 1) {
                                for (int l = 0; l < 16; l++) {
                                    num[l] = 20;
                                }
                                for (int j = 0; j <= 15; j++) {
                                    xAbspos[j] = (int) buttons[j].getLocation().getX();
                                    yAbspos[j] = (int) buttons[j].getLocation().getY();
                                    if (xAbspos[j] >= x && xAbspos[j] < x + 40 && yAbspos[j] >= y && yAbspos[j] < y + 40) {
                                        num[j] = j;
                                    }
                                }
                                int handle[] = new int[tokenIsAlone(x, y)];
                                int h = 0;

                                for (int o = 0; o < 16; o++) {
                                    if (num[o] != 20) {
                                        handle[h] = num[o];
                                        h = h + 1;
                                    }
                                }
                                int a = 0;
                                for (int o = 0; o < h; o++) {
                                    if (handle[o] / 4 == currentplayer) {
                                        a = 1;
                                    }
                                }
                                if (a != 1) {
                                    if (h > 0) {
                                        float mycondn = finrisk[i] * (noOfSteps[manage[i]] + futnos);
                                        System.out.println("mycondn[" + i + "] = " + mycondn);

                                        float hiscondn = ((1f / 6f) + finrisk[i]) * noOfSteps[handle[0]] * h;
                                        System.out.println("hiscondn[" + i + "] = " + hiscondn);

                                        System.out.println("manage[" + i + "] = " + manage[i] + " caught red handed");
                                        if(hiscondn - mycondn>=0) {
                                            futkill[i] = hiscondn - mycondn;
                                        }
                                        System.out.println("futkill[" + i + "] = " + futkill[i]);
                                    }
                                }
                            }
                        }
                    }

                    for(int i=0; i<t; i++) {
                        if((futkill[i] - fmanrisk[i]) > (futkill[kelp] - fmanrisk[kelp])) {
                            kelp = i;
                        }
                    }
                    VG kg = new VG(manage[kelp], dicenumber);
                    synchronized (kg) {
                        kg.start();
                    }
                    ((Timer) e.getSource()).stop();
                }


                else {
                    if (h3 % 2 == 1) {
                        for (int j = 0; j < t; j++) {
                            buttons[manage[j]].setContentAreaFilled(true);
                            buttons[manage[j]].setBackground(new Color(255, 128, 0));
                        }
                    } else {
                        for (int j = 0; j < t; j++) {
                            buttons[manage[j]].setContentAreaFilled(false);
                        }
                    }
                }
            }
            else {
                removeAction();
            }
        }
    });
    private float calculateExactProb (int cpp, int managek, int dicenumber, float initfin) {
        int cp1noofsteps = noOfSteps[managek];
        if (cp1noofsteps == 0) {
            initfin = 0f;
        } else if (cp1noofsteps > 0) {
                cp1noofsteps = cp1noofsteps - 1 + dicenumber;
            int j = 0;
            int[] added = new int[12];

            if (!(isSafeSpot(xPos[cpp][cp1noofsteps], yPos[cpp][cp1noofsteps])) && cp1noofsteps < 51) {
                for (int i = 0; i <= 15; i++) {
                    int cp = i / 4;
                    if (cp != cpp && w[cp] != 0 && noOfSteps[i] <= 50) {
                        boolean check = false;

                        for (int z = 0; z < j; z++) {
                            //System.out.println("initfin checked button " + i + ", compared its noofsteps with button " + added[z]);
                            if (noOfSteps[i] == noOfSteps[added[z]] && (added[z]) / 4 == cp) {
                                check = true;
                            }
                        }
                        if (check == false) {
                            added[j] = i;
                            j = j + 1;

                            int wrtstep = wrtStep1(cpp, cp1noofsteps, cp, noOfSteps[i]);
                            boolean in = false;
                            if (noOfSteps[i] >= 1) {
                                in = true;
                            }
                            initfin = initfin + givecompprob(wrtstep, in, 3);
                        } else {
                            //System.out.println("initfin check was found to be true for button " + i + " with noofsteps[" + i + "] = " + noofsteps[i]);
                        }
                    }
                }
            } else {
                //System.out.println("initfin Condition satisfied " + isSafeSpot(xPos[cpp][cp1noofsteps], yPos[cpp][cp1noofsteps]) + " " + cp1noofsteps + ", so loop wasnt started for " + managek);
            }
        }
    return initfin;
    }
    private float calculateExactProbadv (int cpp, int managek, int dicenumber, float initfin, int noofsteps[]) {
        int cp1noofsteps = noofsteps[managek];
        if (cp1noofsteps == 0) {
            initfin = 0f;
        } else if (cp1noofsteps > 0) {
            cp1noofsteps = cp1noofsteps - 1 + dicenumber;
            int j = 0;
            int[] added = new int[12];

            if (cp1noofsteps < 51) {
                //if (!(isSafeSpot(xPos[cpp][cp1noofsteps], yPos[cpp][cp1noofsteps])) && cp1noofsteps < 51) {

                    for (int i = 0; i <= 15; i++) {
                    int cp = i / 4;
                    if (cp != cpp && w[cp] != 0 && noofsteps[i] <= 50) {
                        boolean check = false;

                        for (int z = 0; z < j; z++) {
                            //System.out.println("initfin checked button " + i + ", compared its noofsteps with button " + added[z]);
                            if (noofsteps[i] == noofsteps[added[z]] && (added[z]) / 4 == cp) {
                                check = true;
                            }
                        }
                        if (check == false) {
                            added[j] = i;
                            j = j + 1;

                            int wrtstep = wrtStep1(cpp, cp1noofsteps, cp, noofsteps[i]);
                            boolean in = false;
                            if (noofsteps[i] >= 1) {
                                in = true;
                            }
                            initfin = initfin + givecompprob(wrtstep, in, 2);
                        } else {
                            //System.out.println("initfin check was found to be true for button " + i + " with noofsteps[" + i + "] = " + noofsteps[i]);
                        }
                    }
                }
            } else {
                //System.out.println("initfin Condition satisfied " + isSafeSpot(xPos[cpp][cp1noofsteps], yPos[cpp][cp1noofsteps]) + " " + cp1noofsteps + ", so loop wasnt started for " + managek);
            }
        }
        return initfin;
    }
   private void bubbleSort(int a[], int b[], int c[], int n)
    {
        int i,j,temp,temp2,temp3;
        for(i=0;i<n;i++)

        for(i=0;i<n-1;i++) //loop for number of passes
        {
            for(j=0;j<n-1-i;j++)
            {
                if(a[j]<a[j+1])
                {
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;

                    temp2=b[j];
                    b[j]=b[j+1];
                    b[j+1]=temp2;

                    temp3=c[j];
                    c[j]=c[j+1];
                    c[j+1]=temp3;
                }

            }

        }
    }
    private float givecompprob(int wrtstep, boolean in, int ser) {
        int v = 0;

        if (wrtstep != -1) {
            v = wrtstep / 6;
            //System.out.println("v= " + v);
            if (wrtstep > v * 6) {
                v = v + 1;
            }
            //System.out.println("v= " + v);
            if (in == false) {
                v = v + 1;
            }
            //System.out.println("v= " + v);
        }
        float disk = 0f;
        if (v != 0 && v < ser) {
            disk = 1f;
            for (int u = 0; u < v; u++) {
                disk = (float) disk / 6f;
            }
        }
        return disk;
    }

    ActionListener l = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            diceTimer.stop();
            dt = 0;
            diceButton.setVisible(false);
            diceButton.removeKeyListener(ka);
            sachme = 0;
            reward = 0;
            eligible = 0;
            q = 0;
            h1 = 0;
            h2 = 0;
            h3 = 0;
            b = 0;
            boolean pk = false;
            int[] manage = new int[4];
            noofdicethrows = noofdicethrows + 1;
            pressed = false;

            removeAction();
            if (diceNumber[currentplayer] == 6 && 57 - noOfSteps[arr[currentplayer][0]] < 6 && 57 - noOfSteps[arr[currentplayer][1]] < 6 && 57 - noOfSteps[arr[currentplayer][2]] < 6 && 57 - noOfSteps[arr[currentplayer][3]] < 6) {
                pk = true;
            }

            if (diceNumber[currentplayer] != 6 && pdiceNumber[currentplayer] == 6 && w[currentplayer] != 0 && pk == false) {
                diceNumber[currentplayer] = 6;
                pdiceNumber[currentplayer] = 0;
            } else {
                pdiceNumber[currentplayer] = 0;
            }

            b = 0;

            currentplayer = decideWhoGoesNext(currentplayer, diceNumber[currentplayer]);

            //          System.out.println("from actionlistener l lllllllllllllllllllllllllllllllllllllllllllllll" +
          //          "llllllllllllllllllllllllllllllllllll" +
            //        "llllllllllllllllllllllllllllllllllll" +
        //            "llllllllllllllllllllllllllllllllllll");
      //      chanceLabel.setText(chanceText[currentplayer].getText());
    //        chanceLabel.setFont(new Font("Arial", Font.BOLD, 16));

            int r = random.nextInt(6) + 1;
            diceLabel.setText(String.valueOf(r));
            diceNumber[currentplayer] = r;
            dicepicButton.setIcon(diceImages[r - 1]);


            if (diceNumber[currentplayer] == 6) {
                pdiceNumber[currentplayer] = 6;
            } else {
                pdiceNumber[currentplayer] = 0;
            }
            glassPane.add(diceLabel);

            q = 0;

            for (int j = 0; j <= 3; j++) {
                if (checkAvailability(arr[currentplayer][j], diceNumber[currentplayer]) == true) {
                    q = q + 1;
                }
            }

                if (w[currentplayer] == 1) {
                    if (q > 0) {
                        int d = 0;
                        for (int j = 0; j <= 3; j++) {
                            if (checkAvailability(arr[currentplayer][j], diceNumber[currentplayer]) == true) {
                                manage[d] = arr[currentplayer][j];
                                customListeners[manage[d]] = new CustomActionListener(manage[d]);
                                buttons[manage[d]].addActionListener(customListeners[manage[d]]);
                                glassPane.add(buttons[manage[d]]);
                                d = d + 1;
                            }
                        }
                    }
                    highlightAvw2.start();
                } else if (w[currentplayer] == 2) {
                    highlightAvw2.start();
                } else if (w[currentplayer] == 3) {
                    //highlightAvw3.start();

                    highlightAvw3.start();
                }

           timer.start();
            chanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
            chanceLabel.setText(chanceText[decideWhoGoesNext(currentplayer, pdiceNumber[currentplayer])].getText());
            if(q != 0) {
                chanceLabel.setVisible(false);
            }

        }

    };

    Timer diceTimer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dt = dt + 1;
            if (dt >= maxdicetime) {
                diceButton.doClick();
                ((Timer) e.getSource()).stop();
            }
        }
    });
    JLabel gametime = new JLabel("0");

    int mt = 0;
    Timer mainTimer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mt = mt + 1;
            gametime.setText(String.valueOf(mt));
        }
    });

    public LudoClass() {
        jf.setTitle("Ludo game");
        jf.setSize(1500, 750);
        jf.setLocationRelativeTo(null);


        CustomPanel customPanel = new CustomPanel();
        jf.setContentPane(customPanel);


        for (int i = 0; i <= 15; i++) {
            timerLabels[i].setText("");
        }
        xPos[0] = xPosGreen;
        yPos[0] = yPosGreen;
        xPos[1] = xPosRed;
        yPos[1] = yPosRed;
        xPos[2] = xPosBlue;
        yPos[2] = yPosBlue;
        xPos[3] = xPosYellow;
        yPos[3] = yPosYellow;

        flagpoints[0] = new Point(330, 10);
        flagpoints[1] = new Point(10, 250);
        flagpoints[2] = new Point(250, 570);
        flagpoints[3] = new Point(570, 330);

        int f=0;
        for(int i=0; i<=3; i++) {
            for(int j=0; j<=3; j++) {
                arr[i][j] = f;
                f=f+1;
            }
        }
        JToggleButton pp = new JToggleButton("Play/Pause");

        pp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ppl == false) {
                    ppl = true;
                } else {
                    ppl = false;
                }
                if(ppl == true) {
                    diceButton.setVisible(false);
                    chancelabelColor.stop();
                    highlightAvw2.stop();
                    //highlightAvw3.stop();
                    highlightAvw3.stop();
                    diceTimer.stop();
                    mainTimer.stop();
                    timer.stop();
                    h1 = 0;
                    h2 = 0;
                    h3 = 0;
                } else {
                    diceButton.setVisible(true);
                    chancelabelColor.start();
                    h1 = 0;
                    h2 = 0;
                    h3 = 0;
                    if(w[currentplayer] == 1 || w[currentplayer] == 2) {
                        highlightAvw2.restart();
                    }
                    else if(w[currentplayer] == 3) {
                       // highlightAvw3.restart();

                        highlightAvw3.restart();
                    }
                    timer.restart();
                    if(allowdicetime==true) {
                        diceTimer.restart();
                    }
                    dt=0;
                    mainTimer.start();
                }
            }
        });

        glassPane.add(pp);
        pp.setBounds(750, 400, 200, 30);
        chanceText[0].setText("Green player's turn");
        chanceText[1].setText("Red player's turn");
        chanceText[2].setText("Blue player's turn");
        chanceText[3].setText("Yellow player's turn");

        currentplayer=random.nextInt(0, 4);
        chanceLabel.setText(chanceText[decideWhoGoesNext(currentplayer, pdiceNumber[currentplayer])].getText());
        chanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        chancelabelColor.start();
        glassPane.add(chanceLabel);
        File audioFile[] = new File[8];
        audioFile[0] = new File("among-us-kill-gun.wav");
        audioFile[1] = new File("fanfare-trumpets.wav");
        audioFile[2] = new File("wwe-bell3.wav");
        audioFile[3] = new File("beep-out.wav");
        audioFile[4] = new File("safespot-1.wav");
        audioFile[5] = new File("success-1.wav");
        audioFile[6] = new File("tadaa.wav");
        audioFile[7] = new File("dicerollsound.wav");

        AudioInputStream audioStream[] = new AudioInputStream[8];
        for(int i=0; i<=7; i++) {
            try {
                audioStream[i] =AudioSystem.getAudioInputStream(audioFile[i]);
                clip[i] = AudioSystem.getClip();
                clip[i].open(audioStream[i]);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }


        if (clip[1] != null) {

            clip[1].setFramePosition(0);
        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (clip[1] != null) {
                clip[1].close();
            }
        }));


        clip[1].addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
                // The first clip has stopped playing, start the second clip
                if (clip[2] != null) {
                    clip[2].setFramePosition(0);
                }
                clip[2].start();
                clip[2].drain();
                //}
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    if (clip[2] != null) {
                        clip[2].close();
                    }
                }));
            }
        });

        greent = new CustomPanel1(color0, 1).createImageIcon();
        greentby2 = new CustomPanel1(color0, 2).createImageIcon();

        yellowt = new CustomPanel1(color3, 1).createImageIcon();
        yellowtby2 = new CustomPanel1(color3, 2).createImageIcon();

        bluet = new CustomPanel1(color2, 1).createImageIcon();
        bluetby2 = new CustomPanel1(color2, 2).createImageIcon();

        redt = new CustomPanel1(color1, 1).createImageIcon();
        redtby2 = new CustomPanel1(color1, 2).createImageIcon();

        colorIcon[0][0] = greent;
        colorIcon[0][1] = greentby2;
        colorIcon[1][0] = redt;
        colorIcon[1][1] = redtby2;
        colorIcon[2][0] = bluet;
        colorIcon[2][1] = bluetby2;
        colorIcon[3][0] = yellowt;
        colorIcon[3][1] = yellowtby2;


        //CustomPanel1 customPanel1 = new CustomPanel1(color0, 1).createImageIcon();
        //frame.add(customPanel);

        // Create an ImageIcon from the CustomPanel
        //ImageIcon icon = customPanel1.createImageIcon();

        // Use the ImageIcon as needed (e.g., set it as an icon for a JButton)
        //JButton button = new JButton(icon);
        //frame.add(button);



        diceImages[0] = new ImageIcon("diceimage1.png");
        diceImages[1] = new ImageIcon("diceimage2.png");
        diceImages[2] = new ImageIcon("diceimage3.png");
        diceImages[3] = new ImageIcon("diceimage4.png");
        diceImages[4] = new ImageIcon("diceimage5.png");
        diceImages[5] = new ImageIcon("diceimage6.png");

        glassPane.setOpaque(false);
        glassPane.setLayout(null);
        glassPane.setBounds(0, 0, 1500, 750);

        for (JButton button : buttons) {
            glassPane.add(button);
        }

        JComboBox<String> removePlayer = new JComboBox();
        removePlayer.setBounds(650, 500, 200, 20);
        glassPane.add(removePlayer);
        removePlayer.addItem("Remove Player");
        removePlayer.addItem("Remove GREEN player");
        removePlayer.addItem("Remove RED player");
        removePlayer.addItem("Remove BLUE player");
        removePlayer.addItem("Remove YELLOW player");
        removePlayer.addItem("Make dice button appear");


        JComboBox<String> setdicetime = new JComboBox();
        setdicetime.setBounds(650, 530, 200, 20);
        glassPane.add(setdicetime);
        setdicetime.addItem("Set max dice roll time");
        setdicetime.addItem("0 second");
        setdicetime.addItem("5 seconds");
        setdicetime.addItem("10 seconds");
        setdicetime.addItem("12 seconds");
        setdicetime.addItem("15 seconds");
        setdicetime.addItem("30 seconds");
        setdicetime.addItem("Infinite");
        setdicetime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<?> source = (JComboBox<?>) e.getSource();
                int sd = source.getSelectedIndex();
                if (sd == 1) {
                    allowdicetime = true;
                    diceTimer.restart();
                    dt=0;
                    maxdicetime = 0;
                }
                if (sd == 2) {
                    allowdicetime = true;
                    diceTimer.restart();
                    dt=0;
                    maxdicetime = 5;
                }
                if (sd == 3) {
                    allowdicetime = true;
                    diceTimer.restart();
                    dt=0;
                    maxdicetime = 10;
                }
                if (sd == 4) {
                    allowdicetime = true;
                    diceTimer.restart();
                    dt=0;
                    maxdicetime = 12;
                }
                if (sd == 5) {
                    allowdicetime = true;
                    diceTimer.restart();
                    dt=0;
                    maxdicetime = 15;
                }
                if (sd == 6) {
                    allowdicetime = true;
                    diceTimer.restart();
                    dt=0;
                    maxdicetime = 30;
                }
                if (sd == 7) {
                    allowdicetime = false;
                    diceTimer.stop();
                }
            }
        });


        JPasswordField rp = new JPasswordField(15);
        JPanel JP = new JPanel();
        JLabel l1 = new JLabel("Enter manipulation code: ");
        JButton b1 = new JButton("OK");
        JP.add(l1);
        JP.add(rp);
        JP.add(b1);
        JP.setBounds(900, 490, 500, 100);

        glassPane.add(JP);
        JP.setVisible(false);
        removePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<?> source = (JComboBox<?>) e.getSource();
                String selectedValue = (String) source.getSelectedItem();
                if (selectedValue == "Make dice button appear") {
                    JP.setVisible(false);
                    re = 0;
                    Timer free = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            re = re + 1;
                            if (re > maxdicetime) {
                                diceButton.setVisible(true);
                                ((Timer) e.getSource()).stop();
                            }
                            if (diceButton.isVisible() == true) {
                                ((Timer) e.getSource()).stop();
                            }
                        }
                    });
                    free.start();
                }
                //JP.setBackground(white);
                if (selectedValue != "Remove Player" && selectedValue != "Make dice button appear") {
                    JP.setVisible(true);
                    b1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String s2 = String.valueOf(rp.getPassword());
                            if (s2.equals("60018220106")) {
                                int rep=0;
                                if (selectedValue == "Remove GREEN player") {
                                    rep=0;
                                    w[0] = 0;
                                    for (int i = 0; i <= 3; i++) {
                                        noOfSteps[i] = 57;
                                        buttons[i].setBounds(initx[i], inity[i], 40, 40);
                                        rp.setText("");
                                        JP.setVisible(false);
                                        buttons[i].setVisible(false);
                                    }
                                    removePlayer.removeItem(selectedValue);
                                }
                                else if (selectedValue == "Remove RED player") {
                                    rep=1;
                                    w[1] = 0;
                                    for (int i = 4; i <= 7; i++) {
                                        noOfSteps[i] = 57;
                                        buttons[i].setBounds(initx[i], inity[i], 40, 40);
                                        rp.setText("");
                                        JP.setVisible(false);
                                        buttons[i].setVisible(false);
                                    }
                                    removePlayer.removeItem(selectedValue);
                                }
                                else if (selectedValue == "Remove BLUE player") {
                                    rep=2;
                                    w[2] = 0;
                                    for (int i = 8; i <= 11; i++) {
                                        noOfSteps[i] = 57;
                                        buttons[i].setBounds(initx[i], inity[i], 40, 40);
                                        rp.setText("");
                                        JP.setVisible(false);
                                        buttons[i].setVisible(false);
                                    }
                                    removePlayer.removeItem(selectedValue);
                                }
                                else {
                                    rep=3;
                                    w[3] = 0;
                                    for (int i = 12; i <= 15; i++) {
                                        noOfSteps[i] = 57;
                                        buttons[i].setBounds(initx[i], inity[i], 40, 40);
                                        rp.setText("");
                                        JP.setVisible(false);
                                        buttons[i].setVisible(false);
                                    }
                                    removePlayer.removeItem(selectedValue);
                                }
                                removeAction();
                              //  highlightAvw3.stop();
                                highlightAvw3.stop();
                                highlightAvw2.stop();


                                timer.stop();
                                if(rep == currentplayer) {
                                    chanceLabel.setText(chanceText[decideWhoGoesNext(currentplayer, 5)].getText());
                                    chanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
                                }

                                // System.out.println(decideWhoGoesNext(currentplayer, pdiceNumber[currentplayer]));
                                diceButton.setVisible(true);
                                if(allowdicetime==true) {
                                    diceTimer.restart();
                                }
                                dt=0;
                                glassPane.add(chanceLabel);

                            } else {
                                JP.setVisible(false);
                            }
                        }
                    });
                } else {
                    JP.setVisible(false);
                }
            }
        });


        for (int t = 0; t <= 15; t++) {
            buttons[t].setBounds(initx[t], inity[t], 40, 40);
            buttons[t].setContentAreaFilled(false);
            buttons[t].setFocusable(false);
            //   noOfSteps[t]=50;
            //  buttons[t].setBorderPainted(false);
            glassPane.add(buttons[t]);
        }
        glassPane.add(gametime);
        gametime.setBounds(670, 20, 100, 30);
        mainTimer.start();
        if(allowdicetime==true) {
            diceTimer.restart();
        }
        dt=0;
        /////   appropriateColor.start();
        for (int j = 0; j <= 15; j++) {
            buttons[j].setText("");
            buttons[j].setIcon(colorIcon[j/4][0]);
        }


        glassPane.setVisible(true);
        jf.setVisible(true);


        jf.setGlassPane(glassPane);
        jf.getGlassPane().setVisible(true);

        dicepicButton.setText("");
        dicepicButton.setIcon(diceImages[4]);
        //  diceButton.setBackground(Color.red);
        dicepicButton.setBounds(750, 200, 83, 83);

        glassPane.add(dicepicButton);

        diceButton.setBounds(750, 300, 200, 30);
        chanceLabel.setBounds(750, 340, 200, 30);

        glassPane.add(diceButton);
        glassPane.add(chanceLabel);

//diceImages[0].paintIcon(customPanel, customPanel.getGraphics(), 150, 350);
        diceLabel.setText("");
        glassPane.add(diceLabel);
        diceLabel.setVisible(true);


        diceLabel.setBounds(900, 200, 100, 30);


        glassPane.addKeyListener(ka);

        // Set the panel to be focusable so that it can receive key events
        glassPane.setFocusable(true);
        diceButton.addActionListener(l);
        //diceButton.setForeground(white);

        CustomButton customButton = new CustomButton("");
        // glassPane.add(customButton);
        customButton.setBounds(330, 50, 40, 40);
        glassPane.setVisible(true);
        jf.setVisible(true);


        clip[1].start();
        clip[1].drain();

    }

    private static Image loadImageFromFile(String filePath) {
        try {
            return ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int tokenIsAlone(int x, int y) {
        int t = 0;
        for (int i = 0; i <= 15; i++) {
            xAbspos[i] = (int) buttons[i].getLocation().getX();
            yAbspos[i] = (int) buttons[i].getLocation().getY();
            if (xAbspos[i] >= x && xAbspos[i] < x + 40 && yAbspos[i] >= y && yAbspos[i] < y + 40) {
                t = t + 1;
            }
        }
        return t;
    }
    public int gettokenColor(Icon icon) {
        int c = 5;
        for (int i = 0; i < 2; i++) {
            if (icon == colorIcon[1][i]) {
                c = 1;
                return c;
            }
            if (icon == colorIcon[2][i]) {
                c = 2;
                return c;
            }
            if (icon == colorIcon[3][i]) {
                c = 3;
                return c;
            }
            if (icon == colorIcon[0][i]) {
                c = 0;
                return c;
            }
        }
        return c;
    }
    public boolean isEligiblePlayer(int currentplayer) {
        if (currentplayer == 0) {
            for (int x = 0; x <= 3; x++) {
                if (noOfSteps[x] < 57) {
                    return true;
                }
            }
        }
        if (currentplayer == 1) {
            for (int x = 4; x <= 7; x++) {
                if (noOfSteps[x] < 57) {
                    return true;
                }
            }
        }
        if (currentplayer == 2) {
            for (int x = 8; x <= 11; x++) {
                if (noOfSteps[x] < 57) {
                    return true;
                }
            }
        }
        if (currentplayer == 3) {
            for (int x = 12; x <= 15; x++) {
                if (noOfSteps[x] < 57) {
                    return true;
                }
            }
        }
        return false;
    }
    public int getNextPlayer(int currentplayer) {
        if (currentplayer == 0) {
            return 3;
        }
        if (currentplayer == 1) {
            return 0;
        }
        if (currentplayer == 2) {
            return 1;
        }
        if (currentplayer == 3) {
            return 2;
        }
        return 100;
    }
    private JButton[] createButtonArray(int size) {
        JButton[] buttons = new JButton[size];
        for (int i = 0; i < size; i++) {
            buttons[i] = new JButton("Button " + (i + 1));
        }
        return buttons;
    }
    private Color[] createColorArray(int size) {
        Color[] colors = new Color[size];
        for (int i = 0; i < size; i++) {
            colors[i] = new Color(255, 255, 255);
        }
        return colors;
    }
    private JLabel[] createLabelArray(int size) {
        JLabel[] labels = new JLabel[size];
        for (int i = 0; i < size; i++) {
            labels[i] = new JLabel();
        }
        return labels;
    }
    private ImageIcon[] createIconArray(int size) {
        ImageIcon[] icons = new ImageIcon[size];
        for (int i = 0; i < size; i++) {
            icons[i] = new ImageIcon();
        }
        return icons;
    }


    class TimerArray {
        private List<Timer> timers;
        private List<Integer> elapsedTimes;
        //   private List<JLabel> timerLabels;

        public TimerArray(int numTimers) {
            timers = new ArrayList<>();
            elapsedTimes = new ArrayList<>();
            // timerLabels = new ArrayList<>();

            for (int i = 0; i < numTimers; i++) {
                Timer timer = createTimer(i);
                timers.add(timer);
                elapsedTimes.add(0);
                timerLabels[i].setText("0");
            }
        }

        private Timer createTimer(final int timerIndex) {
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    elapsedTimes.set(timerIndex, elapsedTimes.get(timerIndex) + 1);
                    updateTimerLabel(timerIndex);
                }
            });
            return timer;
        }

        public int getNumTimers() {
            return timers.size();
        }

        public JLabel getTimerLabel(int index) {
            return timerLabels[index];
        }

        public void startTimer(int index) {
            if (isValidIndex(index)) {
                timers.get(index).start();
            }
        }

        public void stopTimer(int index) {
            if (isValidIndex(index)) {
                timers.get(index).stop();
            }
        }

        public void resetTimer(int index) {
            if (isValidIndex(index)) {
                elapsedTimes.set(index, 0);
                updateTimerLabel(index);
            }
        }

        private boolean isValidIndex(int index) {
            return index >= 0 && index < timers.size();
        }

        private void updateTimerLabel(int index) {
            if (isValidIndex(index)) {
                timerLabels[index].setText("" + elapsedTimes.get(index));
            }
        }
    }



    void preventAnyOverlap(int finalJ, int k, int cp) {
        int num[] = {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20};
        int x=xPos[cp][noOfSteps[finalJ]];
        int y=yPos[cp][noOfSteps[finalJ]];

        for (int i = 0; i <= 15; i++) {
            xAbspos[i] = (int) buttons[i].getLocation().getX();
            yAbspos[i] = (int) buttons[i].getLocation().getY();
            if (xAbspos[i] >= x && xAbspos[i] < x + 40 && yAbspos[i] >= y && yAbspos[i] < y + 40) {
                num[i] = i;
                buttons[i].setIcon(colorIcon[gettokenColor(buttons[i].getIcon())][1]);
            }
        }
        int handle[] = new int[tokenIsAlone(x, y)];
        int h = 0;

        for (int o = 0; o < 16; o++) {
            if (num[o] != 20) {
                handle[h] = num[o];
                h = h + 1;
                //   System.out.println("from red po: " + num[o]);
            }
        }

        if(tokenIsAlone(x, y) > 1) {

            boolean safe = true;


            if (tokenIsAlone(x, y) == 2) {
                if (gettokenColor(buttons[handle[0]].getIcon()) == gettokenColor(buttons[handle[1]].getIcon()) || isSafeSpot(x, y) == true) {

                    for (int i = 0; i < h; i++) {
                        labels[handle[i]].setText("");
                    }

                    buttons[handle[0]].setBounds(x, y, 20, 20);
                    buttons[handle[1]].setBounds(x + 20, y + 20, 20, 20);
                } else {
                    safe = false;
                }
            }


            if (tokenIsAlone(x, y) == 3) {
                if (isSafeSpot(x, y) == true || (gettokenColor(buttons[handle[0]].getIcon()) == gettokenColor(buttons[handle[1]].getIcon()) && gettokenColor(buttons[handle[1]].getIcon()) == gettokenColor(buttons[handle[2]].getIcon()))) {

                    for (int i = 0; i < h; i++) {
                        labels[handle[i]].setText("");
                    }

                    buttons[handle[0]].setBounds(x, y, 20, 20);
                    buttons[handle[1]].setBounds(x + 20, y, 20, 20);
                    buttons[handle[2]].setBounds(x, y + 20, 20, 20);
                }
                if (isSafeSpot(x, y) == false && (gettokenColor(buttons[handle[0]].getIcon()) == gettokenColor(buttons[handle[1]].getIcon()) && gettokenColor(buttons[handle[1]].getIcon()) == gettokenColor(buttons[handle[2]].getIcon())) == false) {
                    safe = false;

                }
            }


            if (tokenIsAlone(x, y) == 4) {
                boolean check = isSafeSpot(x, y) == true || gettokenColor(buttons[handle[0]].getIcon()) == gettokenColor(buttons[handle[1]].getIcon()) && gettokenColor(buttons[handle[2]].getIcon()) == gettokenColor(buttons[handle[3]].getIcon()) && gettokenColor(buttons[handle[1]].getIcon()) == gettokenColor(buttons[handle[2]].getIcon());
                if (check == true) {
                    for (int i = 0; i < h; i++) {
                        labels[handle[i]].setText("");
                    }
                    buttons[handle[0]].setBounds(x, y, 20, 20);
                    buttons[handle[1]].setBounds(x + 20, y, 20, 20);
                    buttons[handle[2]].setBounds(x, y + 20, 20, 20);
                    buttons[handle[3]].setBounds(x + 20, y + 20, 20, 20);

                }

                if (check == false) {
                    safe = false;
                }
            }


            if (tokenIsAlone(x, y) >= 5) {
                if (isSafeSpot(x, y) == true) {

                    for (int i = 0; i < h; i++) {
                        labels[handle[i]].setText("");
                    }

                    int rang[] = {0, 0, 0, 0};

                    for (int m = 0; m < tokenIsAlone(x, y); m++) {
                        if (gettokenColor(buttons[handle[m]].getIcon()) == 0) {
                            buttons[handle[m]].setBounds(x + 20, y, 20, 20);
                            rang[0] = rang[0] + 1;
                        }
                        if (gettokenColor(buttons[handle[m]].getIcon()) == 1) {
                            buttons[handle[m]].setBounds(x, y, 20, 20);
                            rang[1] = rang[1] + 1;
                        }
                        if (gettokenColor(buttons[handle[m]].getIcon()) == 2) {
                            buttons[handle[m]].setBounds(x, y + 20, 20, 20);
                            rang[2] = rang[2] + 1;
                        }
                        if (gettokenColor(buttons[handle[m]].getIcon()) == 3) {
                            buttons[handle[m]].setBounds(x + 20, y + 20, 20, 20);
                            rang[3] = rang[3] + 1;
                        }
                    }


                    for (int u = 0; u < handle.length; u++) {
                        labels[handle[u]].setText("");
                        if (y >= 250 && y <= 370) {
                            labels[handle[u]].setForeground(Color.black);
                            labels[handle[u]].setText(String.valueOf(rang[gettokenColor(buttons[handle[u]].getIcon())]));
                            if (gettokenColor(buttons[handle[u]].getIcon()) == 1) {
                                labels[handle[u]].setBounds(x + 5, y - 20, 20, 20);
                            }

                            if (gettokenColor(buttons[handle[u]].getIcon()) == 0) {
                                labels[handle[u]].setBounds(x + 30, y - 20, 20, 20);
                            }
                            if (gettokenColor(buttons[handle[u]].getIcon()) == 2) {
                                labels[handle[u]].setBounds(x + 5, y + 40, 20, 20);
                            }
                            if (gettokenColor(buttons[handle[u]].getIcon()) == 3) {
                                labels[handle[u]].setBounds(x + 30, y + 40, 20, 20);
                            }
                            glassPane.add(labels[handle[u]]);
                            labels[handle[u]].setVisible(true);
                        }

                        if (x >= 250 && x <= 370) {
                            labels[handle[u]].setForeground(Color.black);
                            labels[handle[u]].setText(String.valueOf(rang[gettokenColor(buttons[handle[u]].getIcon())]));
                            if (gettokenColor(buttons[handle[u]].getIcon()) == 1) {
                                labels[handle[u]].setBounds(x - 10, y, 20, 20);
                            }
                            if (gettokenColor(buttons[handle[u]].getIcon()) == 0) {
                                labels[handle[u]].setBounds(x + 43, y, 20, 20);
                            }
                            if (gettokenColor(buttons[handle[u]].getIcon()) == 2) {
                                labels[handle[u]].setBounds(x - 10, y + 20, 20, 20);
                            }
                            if (gettokenColor(buttons[handle[u]].getIcon()) == 3) {
                                labels[handle[u]].setBounds(x + 43, y + 20, 20, 20);
                            }
                            glassPane.add(labels[handle[u]]);
                            labels[handle[u]].setVisible(true);
                        }
                    }
                }

                if (isSafeSpot(x, y) == false) {
                    safe = false;
                }
            }
            if (safe == false && tokenIsAlone(x, y) >= 2 && k == 1 && isSafeSpot(x, y) == false) {

                for (int m = 0; m <= h - 1; m++) {
                    if (handle[m] != finalJ) {
                        int c = gettokenColor(buttons[handle[m]].getIcon());
                        if (c != cp) {
                            buttons[handle[m]].setIcon(colorIcon[c][0]);
                        }

                        if (gettokenColor(buttons[handle[m]].getIcon()) != cp) {
                            // buttons[handle[y]].setBounds(initx[handle[y]], inity[handle[y]], 40, 40);
                            killThread yg = new killThread(handle[m]);
                            yg.start();
                        }

                    }
                }
                buttons[finalJ].setBounds(x, y, 40, 40);
                buttons[finalJ].setIcon(colorIcon[cp][0]);
                sachme = 1;
            }

        }

        else if (tokenIsAlone(x, y) == 1 || noOfSteps[finalJ] == 0) { //&& (h==1 || h-killed==1)) {
            labels[finalJ].setText("");
            buttons[finalJ].setBounds(x, y, 40, 40);
            buttons[finalJ].setIcon(colorIcon[cp][0]);
        }

        if (noOfSteps[finalJ] >= 1) {
            //tokenIsAlone(xPosRed[noOfSteps[finalJ]], yPosRed[noOfSteps[finalJ]]) <= 4 &&
            int num2[] = {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20};


            for (int i = 0; i <= 15; i++) {
                xAbspos[i] = (int) buttons[i].getLocation().getX();
                yAbspos[i] = (int) buttons[i].getLocation().getY();
                if (xAbspos[i] >= xPos[cp][noOfSteps[finalJ] - 1] && xAbspos[i] < xPos[cp][noOfSteps[finalJ] - 1] + 40 && yAbspos[i] >= yPos[cp][noOfSteps[finalJ] - 1] && yAbspos[i] < yPos[cp][noOfSteps[finalJ] - 1] + 40) {
                    num2[i] = i;
                }
            }


            int handle2[] = new int[tokenIsAlone(xPos[cp][noOfSteps[finalJ] - 1], yPos[cp][noOfSteps[finalJ] - 1])];
            int h2 = 0;
            int r = 0;
            for (int o = 0; o < 16; o++) {
                if (num2[o] != 20) {
                    handle2[h2] = num2[o];
                    h2 = h2 + 1;
                    if (o >= 4 && o <= 7) {
                        r = r + 1;
                    }
                }
            }


            int rang2[] = {0, 0, 0, 0};
            if (h2 >= 5 && isSafeSpot(xPos[cp][noOfSteps[finalJ] - 1], yPos[cp][noOfSteps[finalJ] - 1]) == true) {
                for (int o = 0; o < h2; o++) {
                    if (gettokenColor(buttons[handle2[o]].getIcon()) == 0) {
                        buttons[handle2[o]].setBounds(xPos[cp][noOfSteps[finalJ] - 1] + 20, yPos[cp][noOfSteps[finalJ] - 1], 20, 20);
                        rang2[0] = rang2[0] + 1;
                    }
                    if (gettokenColor(buttons[handle2[o]].getIcon()) == 1) {
                        buttons[handle2[o]].setBounds(xPos[cp][noOfSteps[finalJ] - 1], yPos[cp][noOfSteps[finalJ] - 1], 20, 20);
                        rang2[1] = rang2[1] + 1;
                    }
                    if (gettokenColor(buttons[handle2[o]].getIcon()) == 2) {
                        buttons[handle2[o]].setBounds(xPos[cp][noOfSteps[finalJ] - 1], yPos[cp][noOfSteps[finalJ] - 1] + 20, 20, 20);
                        rang2[2] = rang2[2] + 1;
                    }
                    if (gettokenColor(buttons[handle2[o]].getIcon()) == 3) {
                        buttons[handle2[o]].setBounds(xPos[cp][noOfSteps[finalJ] - 1] + 20, yPos[cp][noOfSteps[finalJ] - 1] + 20, 20, 20);
                        rang2[3] = rang2[3] + 1;
                    }
                }
                for (int u = 0; u < h; u++) {
                    labels[handle[u]].setText("");
                }

                for (int u = 0; u < h2; u++) {
                    labels[handle2[u]].setForeground(Color.black);
                    labels[handle2[u]].setText(String.valueOf(rang2[gettokenColor(buttons[handle2[u]].getIcon())]));
                    //     glassPane.add(labels[handle2[u]]);
                    //   labels[handle2[u]].setVisible(true);
                }

            }


            if (h2 == 4 && (isSafeSpot(xPos[cp][noOfSteps[finalJ] - 1], yPos[cp][noOfSteps[finalJ] - 1]) == true || gettokenColor(buttons[handle2[0]].getIcon()) == gettokenColor(buttons[handle2[1]].getIcon()) && gettokenColor(buttons[handle2[2]].getIcon()) == gettokenColor(buttons[handle2[3]].getIcon()) && gettokenColor(buttons[handle2[1]].getIcon()) == gettokenColor(buttons[handle2[2]].getIcon()))) {
                for (int i = 0; i < h2; i++) {
                    labels[handle2[i]].setText("");
                }

                buttons[handle2[0]].setBounds(xPos[cp][noOfSteps[finalJ] - 1], yPos[cp][noOfSteps[finalJ] - 1], 20, 20);
                buttons[handle2[1]].setBounds(xPos[cp][noOfSteps[finalJ] - 1] + 20, yPos[cp][noOfSteps[finalJ] - 1], 20, 20);
                buttons[handle2[2]].setBounds(xPos[cp][noOfSteps[finalJ] - 1], yPos[cp][noOfSteps[finalJ] - 1] + 20, 20, 20);
                buttons[handle2[3]].setBounds(xPos[cp][noOfSteps[finalJ] - 1] + 20, yPos[cp][noOfSteps[finalJ] - 1] + 20, 20, 20);

            }


            if (tokenIsAlone(xPos[cp][noOfSteps[finalJ] - 1], yPos[cp][noOfSteps[finalJ] - 1]) == 1) {
                buttons[handle2[0]].setBounds(xPos[cp][noOfSteps[finalJ] - 1], yPos[cp][noOfSteps[finalJ] - 1], 40, 40);
                buttons[handle2[0]].setIcon(colorIcon[gettokenColor(buttons[handle2[0]].getIcon())][0]);
            }
        }


    }
    private boolean isSafeSpot(int x, int y) {
        int xSafespot[] = {50, 250, 330, 490, 530, 330, 250, 90};
        int ySafespot[] = {250, 90, 50, 250, 330, 490, 530, 330};
        boolean d = false;
        for (int s = 0; s <= 7; s++) {
            if (x == xSafespot[s] && y == ySafespot[s]) {
                d = true;
            }
        }
        return d;
    }
    private boolean isStarSpot(int x, int y) {
        int xStarspot[] = {250, 90, 330, 490};
        int yStarspot[] = {90, 330, 490, 250};
        boolean d = false;
        for (int s = 0; s <= 3; s++) {
            if (x == xStarspot[s] && y == yStarspot[s]) {
                d = true;
            }
        }
        return d;
    }
    class CustomActionListener implements ActionListener {
        private int value;

        public CustomActionListener(int value) {
            this.value = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            pressed = true;





            VG ag = new VG(value, diceNumber[currentplayer]);
            synchronized (ag) {
                if (diceNumber[currentplayer] <= 57 - noOfSteps[value]) {
                    ag.start();
                    //          if (ag.isAlive() == false) {
                    //            diceButton.setVisible(true);
                    //          diceTimer.restart();
                    //    }
                }
            }
        }
    }
    private void killProcesses() {
        diceButton.setEnabled(false);
        diceButton.setVisible(true);
        chancelabelColor.stop();
        highlightAvw2.stop();
        //highlightAvw3.stop();
        highlightAvw3.stop();
        diceTimer.stop();
        mainTimer.stop();
    }
    private int decideWhoGoesNext(int currentPlayer, int dicenumber) {
        b = b + 1;
        if (dicenumber == 6) {
            return currentPlayer;
        }
        else {
            if (currentPlayer == 0 && dicenumber != 6) {
                if (b < 6) {
                    if (w[3] != 0) {
                        return 3;
                    } else {
                        return decideWhoGoesNext(3, dicenumber);
                    }
                } else {
                    return currentPlayer;
                    //killProcesses();
                    //return 100;
                }
            } else if (currentPlayer == 1 && dicenumber != 6) {
                if (b < 6) {
                    if (w[0] != 0) {
                        return 0;
                    } else {
                        return decideWhoGoesNext(0, dicenumber);
                    }
                } else {
                    return currentPlayer;
                    //killProcesses();
                    //return 100;
                }
            } else if (currentPlayer == 2 && dicenumber != 6) {
                if (b < 6) {
                    if (w[1] != 0) {
                        return 1;
                    } else {
                        return decideWhoGoesNext(1, dicenumber);
                    }
                } else {
                    return currentPlayer;
                    //killProcesses();
                    //return 100;
                }
            } else if (currentPlayer == 3 && dicenumber != 6) {
                if (b < 6) {
                    if (w[2] != 0) {
                        return 2;
                    } else {
                        return decideWhoGoesNext(2, dicenumber);
                    }
                } else {
                    return currentPlayer;
                    //killProcesses();
                    //return 100;
                }
            }
        }
        //}
        //System.out.println("ddddddddd");
        //killProcesses();
        //return 100;
        return currentPlayer;
    }
    private float gettokenRisk(int noofsteps, int currentplayer) {
        if (noofsteps >= 52 || noofsteps == 0 || isSafeSpot(xPos[currentplayer][noofsteps], yPos[currentplayer][noofsteps])) {
            System.out.println("vfydryj");
            return 0;
        } else {
            //     int cp=decideWhoGoesNext(currentplayer, diceNumber[currentplayer]);
            //   if(cp == currentplayer) {
            //               System.out.println("jhfjhvuygu");
            //             return 0;
            //       } else {
            float risk = 0f;
            float disk = 1f;
            for (int p = 0; p < 3; p++) {
                //  while (cp != currentplayer) {
                int cp = decideWhoGoesNext(currentplayer, diceNumber[currentplayer]);
                System.out.println("cp= "+cp);
              //  System.out.println("diceNumber[currentplayer]= "+diceNumber[currentplayer]);
                if (cp != currentplayer) {
                    if (xPos[currentplayer][noofsteps] != flagpoints[cp].getX() || yPos[currentplayer][noofsteps] != flagpoints[cp].getY()) {
                        int wrtstep = 0;//wrtStep(cp, currentplayer, noofsteps);
                        System.out.println();
                        System.out.println();
                        System.out.println("currentplayer= " + currentplayer);
                        System.out.println("cp= " + cp);
                        System.out.println("noofsteps= " + noofsteps);
                        System.out.println("wrtstep= " + wrtstep);
                        for (int j = 0; j <= 3; j++) {
                            disk = 1f;
                            System.out.println("Analysing button " + arr[cp][j]);
                            int temp = wrtstep - noOfSteps[arr[cp][j]];
                            System.out.println("temp= " + temp);
                            int v = temp / 6;
                            System.out.println("v= " + v);
                            if (temp > v * 6) {
                                v = v + 1;
                            }
                            System.out.println("v= " + v);
                            if (noOfSteps[arr[cp][j]] == 0) {
                                v = v + 1;
                            }
                            System.out.println("v= " + v);
                            for (int u = 0; u < v; u++) {
                                disk = (float) disk / 6f;
                            }
                            System.out.println("disk= " + disk);
                            risk = risk + disk;
                            System.out.println("risk= " + risk);
                            System.out.println();
                        }
                    }
                }
                else {
                    break;
                }
            }
            System.out.println("risk= " + risk);
            return risk;
        }
    }
    private int wrtStep(int currentcp1, int cp1noofsteps, int compcp) {
        int diff=1;
        for(int k=0; k<52; k++) {
            diff = diff + 1;
            if(cp1noofsteps<=56) {
                if (xPos[compcp][k] == xPos[currentcp1][cp1noofsteps] && yPos[compcp][k] == yPos[currentcp1][cp1noofsteps]) {
                    break;
                }
            }
        }
        if(diff==53) {
            diff = diff + 1;
        }
        return diff;
    }
    private int wrtStep1(int currentcp1, int cp1noofsteps, int compcp2, int cp2noofsteps) {
        int ogcp2noofsteps=cp2noofsteps;
        if(ogcp2noofsteps > 0) {
            ogcp2noofsteps = ogcp2noofsteps - 1;
        }
        while(xPos[compcp2][cp2noofsteps] != xPos[currentcp1][cp1noofsteps] || yPos[compcp2][cp2noofsteps] != yPos[currentcp1][cp1noofsteps]) {
            if(cp2noofsteps + 1 <= 56) {
                cp2noofsteps = cp2noofsteps + 1;
                if(cp2noofsteps == 56) {
                    break;
                }
            }
        }
        if(cp2noofsteps >= 51) {
            return -1;
        } else {
            return (cp2noofsteps - ogcp2noofsteps);
        }
    }
    private void removeAction() {
        for (int i = 0; i < 16; i++) {
            buttons[i].removeActionListener(customListeners[i]);
            buttons[i].setContentAreaFilled(false);
        }
    }
    private boolean checkAvailability(int value, int dicenumber) {
        if (dicenumber == 6) {
            if (dicenumber <= 57 - noOfSteps[value]) {
                return true;
            }
        }
        if (dicenumber != 6) {
            if (dicenumber <= 57 - noOfSteps[value] && ((int) buttons[value].getLocation().getX() != initx[value] || (int) buttons[value].getLocation().getY() != inity[value])) {// || noOfSteps[i]>0) {
                return true;
            }
        }
        return false;
    }
    class CustomPanel extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            // Image backgroundImage = loadImageFromFile("wallpaper.png");
            //g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

            g.setColor(Color.white);
            g.fillRect(10, 10, 600, 600);

            //   ImageIcon starIcon = new ImageIcon("ludostaricon.png");

            g.setColor(new Color(194, 194, 194));
            g.fillRect(90, 330, 40, 40);
            g.fillRect(250, 90, 40, 40);
            g.fillRect(490, 250, 40, 40);
            g.fillRect(330, 490, 40, 40);

            g.setColor(white);
            int[] xstar1 = {510, 514, 528, 517, 521, 510, 499, 503, 492, 506, 510};
            int[] ystar1 = {252, 266, 266, 274, 288, 279, 288, 274, 266, 266, 252};
            g.fillPolygon(xstar1, ystar1, 11);

            int[] xstar2 = {350, 354, 368, 357, 361, 350, 339, 343, 332, 346, 350};
            int[] ystar2 = {492, 506, 506, 514, 528, 519, 528, 514, 506, 506, 492};
            g.fillPolygon(xstar2, ystar2, 11);

            int[] xstar3 = {110, 114, 128, 117, 121, 110, 99, 103, 92, 106, 110};
            int[] ystar3 = {332, 346, 346, 354, 368, 359, 368, 354, 346, 346, 332};
            g.fillPolygon(xstar3, ystar3, 11);

            int[] xstar4 = {270, 274, 288, 277, 281, 270, 259, 263, 252, 266, 270};
            int[] ystar4 = {92, 106, 106, 114, 128, 119, 128, 114, 106, 106, 92};
            g.fillPolygon(xstar4, ystar4, 11);


            g.setColor(Color.orange);
            //  g.setColor(yellow);
            int[] xPts = {310, 370, 370, 370, 570, 570, 530, 530, 370, 370};
            int[] yPts = {310, 250, 370, 290, 290, 370, 370, 330, 330, 370};


            // Draw and fill the triangle
            g.fillPolygon(xPts, yPts, 10);


            g.setColor(customColor);
            //  g.setColor(color0);
            int[] xPts1 = {310, 250, 370, 290, 290, 370, 370, 330, 330, 370};
            int[] yPts1 = {310, 250, 250, 250, 50, 50, 90, 90, 250, 250};

            // Draw and fill the triangle
            g.fillPolygon(xPts1, yPts1, 10);


            g.setColor(Color.RED);
            //    g.setColor(color1);
            int[] xPts2 = {250, 310, 250, 250, 50, 50, 90, 90, 250, 250};
            int[] yPts2 = {250, 310, 370, 330, 330, 250, 250, 290, 290, 250};

            // Draw and fill the triangle
            g.fillPolygon(xPts2, yPts2, 10);


            g.setColor(customColor2);
//g.setColor(color2);
            int[] xPts3 = {310, 250, 370, 330, 330, 250, 250, 290, 290, 370};
            int[] yPts3 = {310, 370, 370, 370, 570, 570, 530, 530, 370, 370};

            // Draw and fill the triangle
            g.fillPolygon(xPts3, yPts3, 10);


            //g.drawLine(245,10,);
            g.setColor(Color.black);

            g.drawRect(10, 10, 240, 240);
            g.drawRect(10, 370, 240, 240);
            g.drawRect(370, 10, 240, 240);
            g.drawRect(370, 370, 240, 240);
            g.drawRect(10, 10, 600, 600);
            g.drawLine(290, 10, 290, 610);
            g.drawLine(330, 10, 330, 610);
            g.drawLine(10, 290, 610, 290);
            g.drawLine(10, 330, 610, 330);
            g.drawRect(50, 50, 520, 520);
            g.drawRect(90, 90, 440, 440);
            g.drawRect(130, 130, 360, 360);
            g.drawRect(170, 170, 280, 280);
            g.drawRect(210, 210, 200, 200);


            g.setColor(Color.orange);
            //g.setColor(yellow);
            int[] xtrian = {310, 370, 370};
            int[] ytrian = {310, 250, 370};
            g.fillPolygon(xtrian, ytrian, 3);
            g.fillRect(370, 370, 240, 240);


            g.setColor(customColor);
            //g.setColor(color0);
            int[] xtrian1 = {310, 250, 370};
            int[] ytrian1 = {310, 250, 250};
            g.fillPolygon(xtrian1, ytrian1, 3);
            g.fillRect(370, 10, 240, 240);

            g.setColor(Color.RED);
            // g.setColor(color1);
            int[] xtrian2 = {250, 310, 250};
            int[] ytrian2 = {250, 310, 370};
            g.fillPolygon(xtrian2, ytrian2, 3);
            g.fillRect(10, 10, 240, 240);


            g.setColor(customColor2);
            //  g.setColor(color2);
            int[] xtrian3 = {310, 250, 370};
            int[] ytrian3 = {310, 370, 370};
            g.fillPolygon(xtrian3, ytrian3, 3);
            g.fillRect(10, 370, 240, 240);


            g.setColor(Color.black);
            g.drawRect(250, 250, 120, 120);
            g.drawLine(250, 250, 370, 370);
            g.drawLine(370, 250, 250, 370);
            g.drawRect(10, 10, 240, 240);
            g.drawRect(10, 370, 240, 240);
            g.drawRect(370, 10, 240, 240);
            g.drawRect(370, 370, 240, 240);
            g.drawRect(10, 10, 600, 600);
            g.drawPolygon(xstar1, ystar1, 11);
            g.drawPolygon(xstar2, ystar2, 11);
            g.drawPolygon(xstar3, ystar3, 11);
            g.drawPolygon(xstar4, ystar4, 11);

            g.setColor(Color.white);
            g.fillRect(410, 410, 160, 160);
            g.fillRect(50, 50, 160, 160);
            g.fillRect(50, 410, 160, 160);
            g.fillRect(410, 50, 160, 160);

            g.setColor(Color.black);
            for (int i = 0; i <= 15; i++) {
                g.drawRect(initx[i], inity[i], 40, 40);
            }

        }

    }
    class CustomPanel1 extends JPanel {
        private Color fillColor;
        private int m;
        private BufferedImage image;

        public CustomPanel1(Color fillColor, int m) {
            this.fillColor = fillColor;
            this.m = m;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // Handle custom graphics here, for example, drawing a rectangle
            //if (pressed) {
            //    g.setColor(new Color(220, 220, 220)); // Change the color when pressed
            //    g.fillRect(0, 0, getWidth(), getHeight());
            //} else {
            // g.setColor(new Color(0, 0, 0, 0)); // Transparent background
            // g.fillRect(0, 0, getWidth(), getHeight());
            //}

            if (m == 1) {
                g.setColor(black);
                g.fillArc(-14, -29, 68, 68, 240, 60);
                g.setColor(fillColor);
                g.fillArc(-9, -20, 58, 58, 240, 60);
                g.setColor(black);
                g.fillOval(8, 0, 25, 18);
                g.setColor(fillColor);
                g.fillOval(10, 1, 20, 16);
            }
            if (m == 2) {
                g.setColor(black);
                g.fillArc(-7, -15, 35, 35, 240, 60);
                g.setColor(fillColor);
                g.fillArc(-4, -10, 29, 29, 240, 60);
                g.setColor(black);
                g.fillOval(3, 0, 14, 10);
                g.setColor(fillColor);
                g.fillOval(5, 1, 10, 8);
            }

            //          g.setColor(black);
            //       ImageIcon icon = new ImageIcon(createImageFromComponent(this));

            // Set the ImageIcon as the button's icon
            //      setIcon(icon);
            //        g.drawOval(10, 1, 19, 17);
            //  g.fillRect(10, 10, 20, 20);

        }


        public ImageIcon createImageIcon() {
            // Create a BufferedImage to capture the painted graphics
            if (m == 1) {
                image = new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB);
            }
            if (m == 2) {
                image = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
            }

            // Get a Graphics2D context for drawing
            Graphics2D g2d = image.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // Paint custom graphics onto the Graphics2D context
            paintComponent(g2d);

            // Dispose of the Graphics2D context
            g2d.dispose();

            // Create an ImageIcon from the BufferedImage
            return new ImageIcon(image);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LudoClass());
    }
}

