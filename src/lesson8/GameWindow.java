package lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private ButtleMap buttleMap;
    private Setting setting;
    private int startX=900;
    private  int startY=300;


    public GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(startX, startY, 400, 480);
        setTitle("TicTacToe");

        JPanel panelSetting = new JPanel(new GridLayout(1, 1));
        JButton buttonSetting = new JButton("Setting");

        JPanel panel = new JPanel(new GridLayout(2, 2));
        JButton buttonStart = new JButton("Start");
        JButton buttonExit = new JButton("Exit");

        add(panelSetting,BorderLayout.NORTH);
        panelSetting.add(buttonSetting);

        add(panel, BorderLayout.SOUTH);
        panel.add(buttonStart);
        panel.add(buttonExit);

        buttleMap=new ButtleMap(this);
        add(buttleMap,BorderLayout.CENTER);

        setting =new Setting(this);

        buttonSetting.addActionListener(e->setting.setVisible(true));
        buttonStart.addActionListener(e->setting.setVisible(true));
        buttonExit.addActionListener(e -> System.exit(0));


        setVisible(true);
    }
    public void startNewGame(int fiedSize,int dotsToWin){
       buttleMap.startNewGame(fiedSize,dotsToWin);
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }
}
