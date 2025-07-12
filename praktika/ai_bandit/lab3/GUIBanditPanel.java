/*
 * Author: Florian Schnoor, Robert Petker
 * Project: 3. Lab in OP
 * Version: 30/06/2025
 */
package ai_bandit.lab3;

import ai_bandit.lab2.MultiBanditSolver;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GUIBanditPanel extends JPanel {

    private GUIApp app;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] counts = app.getMultiBanditSolver().getCounts();
        int w = getWidth();
        int h = getHeight();
        int xAxis = (int)(h / 1.1);

        // coordinates system
        g.drawString("Bandit selection count",w/100,h/11);
        g.drawString("Rounds played by bandit",(int)(w/1.3),(int)(xAxis*1.08));
        g.drawLine(w/100,xAxis,(int)(w/1.1),xAxis);         // x-axis
        g.drawLine(w/100,xAxis,w/100,h/10);          // y-axis

        // plot bandit count
        int barWidth = w/20;
        int gap = w/50;
        int xOffset = w / 100 + 10;

        if(counts[0] != 0){

        int countsMax = Arrays.stream(counts).max().orElse(1);


        for (int i = 0; i < counts.length; i++) {

            int barHeight = counts[i] * (int) (h * 0.7) / countsMax;
            int x = xOffset + i * (barWidth + gap);
            int y = xAxis - barHeight;

            g.drawString("" + counts[i], x, (int) (xAxis * 1.1));

            g.fillRect(x, y, barWidth, barHeight);
        }
        }
    }


    public GUIBanditPanel(GUIApp app) {
        this.app = app;
    }
}
