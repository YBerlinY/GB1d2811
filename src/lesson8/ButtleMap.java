package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtleMap extends JPanel {
    private GameWindow gameWindow;
    private Setting setting;
    private int fiedSize;
    private int dotsToWin;
    private int cellWidth;
    private int cellHeight;


    private boolean isInit = false;

    public ButtleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;
                if (isInit && !Logic.isFinishedFGame()) {
                    Logic.goPleer(cellY, cellX);
                }
                repaint();
                result();

            }
        });
    }

    public void startNewGame(int fiedSize, int dotsToWin) {
        this.fiedSize = fiedSize;
        this.dotsToWin = dotsToWin;
        repaint();
        isInit = true;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }
        g.setColor(Color.GRAY);
        ((Graphics2D) g).setStroke(new BasicStroke(2f));
        cellWidth = getWidth() / fiedSize;
        cellHeight = getHeight() / fiedSize;

        for (int i = 1; i < fiedSize; i++) {
            int x = cellWidth * i;
            int y = cellHeight * i;
            g.drawLine(x, 0, x, getHeight());
            g.drawLine(0, y, getWidth(), y);
        }

        for (int i = 0; i < Logic.field.length; i++) {
            for (int j = 0; j < Logic.field[i].length; j++) {
                if (Logic.field[i][j] == Logic.DOT_X) {
                    paintX((Graphics2D) g, i, j);
                }
                if (Logic.field[i][j] == Logic.DOT_O) {
                    paintO((Graphics2D) g, i, j);
                }
            }
        }
        if (Logic.winLine == true) {
            paintWinLine((Graphics2D) g);
        }
    }

    private void paintX(Graphics2D g, int y, int x) {

        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(3f));
        g.drawLine(x * cellWidth, y * cellHeight,
                (x + 1) * cellWidth, (y + 1) * cellHeight);
        g.drawLine((x + 1) * cellWidth, y * cellHeight,
                x * cellWidth, (y + 1) * cellHeight);
    }

    private void paintO(Graphics2D g, int y, int x) {

        g.setColor(Color.GRAY);
        g.setStroke(new BasicStroke(3f));
        g.drawOval(x * cellWidth, y * cellHeight,
                cellWidth, cellHeight);
    }

    public void paintWinLine(Graphics2D g) {

        g.setColor(Color.RED);
        g.setStroke(new BasicStroke(3f));

        for (int i = 1; i <= Logic.dotsToWin; i++) {

            if (Logic.dY == -1 && Logic.dX == 1) {
                g.drawLine(Logic.sX * cellWidth, (Logic.sY + 1) * cellHeight,
                        (Logic.sX + i * Logic.dX) * cellWidth, (Logic.sY + 1 + i * Logic.dY) * cellHeight);

            }
            if (Logic.dY == 1 && Logic.dX == 0) {
                g.drawLine(Logic.sX * cellWidth + cellWidth / 2, Logic.sY * cellHeight,
                        (Logic.sX + i * Logic.dX) * cellWidth + cellWidth / 2, (Logic.sY + i * Logic.dY) * cellHeight);
            }
            if (Logic.dY == 0 && Logic.dX == 1) {
                g.drawLine(Logic.sX * cellWidth, Logic.sY * cellHeight + cellHeight / 2,
                        (Logic.sX + i * Logic.dX) * cellWidth, (Logic.sY + i * Logic.dY) * cellHeight + cellHeight / 2);
            }
            if (Logic.dY == 1 && Logic.dX == 1) {
                g.drawLine(Logic.sX * cellWidth, Logic.sY * cellHeight,
                        (Logic.sX + 1 + i * Logic.dX) * cellWidth, (Logic.sY + 1 + i * Logic.dY) * cellHeight);

            }
        }
    }

    private void result() {
        switch (Logic.res) {
            case 1:
                JOptionPane.showMessageDialog(null, "Поздравляем! Вы победили",
                        "Результат игры", JOptionPane.PLAIN_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Ничья, попробуйте ещё раз!",
                        "Результат игры", JOptionPane.PLAIN_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Вы проиграли, попробуйте ещё раз!",
                        "Результат игры", JOptionPane.PLAIN_MESSAGE);
                break;
        }
        Logic.res = 0;
        Logic.winLine = false;
    }
}
