package ai_bandit.lab3;

import ai_bandit.lab2.MultiBandit;
import ai_bandit.lab2.MultiBanditSolver;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GUICreditPanel extends JPanel {

    private GUIApp app;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();
        int xAxis = (int)(h/1.8);
        int yAxis = (int)(w/100);


        g.drawString("Number of rounds",(int)(w/1.3),(int)(xAxis*1.1));
        g.drawLine(yAxis,xAxis,(int)(w/1.1),xAxis);                             // x-axis
        g.drawLine(yAxis,(int)(h/1.1),w/100,h/10);                     // y-axis


        // plot
        Color niceGreen = new Color(36, 186, 36);
        Color niceRed   = new Color(140, 35, 35);
        
        double[] credit = app.getOverallProfit();

        int validLength = app.getRoundsPlayed();

        if (credit == null || validLength == 0) {
            g.drawString("No data yet", w / 2, h / 2);
            return;
        }

        double maxHeight = credit[credit.length - 1];

        for (int i = 0; i <= credit.length-1; i++) {
            double angle = i * 2 * Math.PI / w;
            double sinVal = Math.sin(angle);

            for (double val : credit) {
                double absVal = Math.abs(val);
                if (absVal > maxHeight) {
                    maxHeight = absVal;
                }
            }

            int x = (int)(((((0.75*w)/credit.length) * i)) + yAxis);       // start by 0 on the coordinate system
            double height = xAxis - ((0.4*h)/maxHeight) * credit[i];

            int barWidth = Math.max(2, w / (2 * credit.length));
            int barHeight = Math.abs(xAxis - (int) height);
            int barY = Math.min(xAxis, (int) height);

            if(height < xAxis){
                g.setColor(niceGreen);
             // g.drawLine(x, xAxis, x, (int)height);
                g.fillRect(x, barY, barWidth, barHeight);
            }
            else {
                g.setColor(niceRed);
                //g.drawLine(x, xAxis, x, (int)height);

                g.fillRect(x, barY, barWidth, barHeight);
            }
        }
        g.setColor(Color.BLACK);
        g.drawString("Credit (final credit: " + String.format("%.2f", credit[credit.length - 1]) + ")", yAxis, h / 11);

    }

    private String toString(double credit) {
        return null;
    }

    public GUICreditPanel(GUIApp app) {
        this.app = app;
    }
}
