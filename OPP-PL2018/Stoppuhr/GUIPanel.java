package Stoppuhr;

import javax.swing.*;
import java.awt.*;

public class GUIPanel extends JPanel {

    private int time;

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("SansSerif", Font.BOLD, 24)); // 24 pt, fett

        g.drawString("time: " + time + " s", 100, 150);
    }
}
