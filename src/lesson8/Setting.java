package lesson8;

import javax.swing.*;
import java.awt.*;

public class Setting extends JFrame {
    private final int MIN_SIZE = 3;
    private final int MAX_SIZE = 10;

    private final GameWindow gameWindow;
    private final JSlider sliderSize;
    private final JSlider sliderDotsToWin;
    static int fieldSize;
    static int dotsToWin;


    public Setting(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBounds(gameWindow.getStartX(), gameWindow.getStartY(), 350, 300);
        setTitle("Setting");

        setLayout(new GridLayout(5, 1));
        sliderSize = new JSlider(MIN_SIZE, MAX_SIZE, MIN_SIZE);
        sliderSize.setMajorTickSpacing(1);
        sliderSize.setPaintLabels(true);
        sliderSize.setPaintTicks(true);
        sliderDotsToWin = new JSlider(MIN_SIZE, MIN_SIZE, MIN_SIZE);
        sliderDotsToWin.setMajorTickSpacing(1);
        sliderDotsToWin.setPaintLabels(true);
        sliderDotsToWin.setPaintTicks(true);

        sliderSize.addChangeListener(e -> sliderDotsToWin.setMaximum(sliderSize.getValue()));

        add(new Label("Size"));
        add(sliderSize);
        add(new Label("Winning line"));
        add(sliderDotsToWin);

        JButton button = new JButton("Start");
        add(button);

        button.addActionListener(e -> {
            fieldSize = sliderSize.getValue();
            dotsToWin = sliderDotsToWin.getValue();
            Logic.size = fieldSize;
            Logic.dotsToWin = dotsToWin;
            Logic.initField();
            gameWindow.startNewGame(fieldSize, dotsToWin);
            setVisible(false);
        });

        setVisible(false);
    }
}
