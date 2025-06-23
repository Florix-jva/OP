package ai_bandit.lab3;

import ai_bandit.lab2.MultiBandit;
import ai_bandit.lab2.MultiBanditSolver;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GUICreditPanel extends JPanel {

    private MultiBandit bandits;
    public double credit;
    public double maxCredit;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();
        int xAxis = (int)(h/1.8);

        maxCredit = 100;

        g.drawString("Available money (abs. max.: " + maxCredit + ")",w/100,h/11);
        g.drawString("Number of rounds",(int)(w/1.3),(int)(xAxis*1.15));
        g.drawLine(w/100,xAxis,(int)(w/1.1),xAxis);     // x-axis
        g.drawLine(w/100,(int)(h/1.1),w/100,h/10);                     // y-axis


        // plot
        int amplitude = (int)(h * 0.4);

        Color niceGreen = new Color(36, 186, 36);
        Color niceRed   = new Color(140, 35, 35);

        credit = bandits.getInitialCredit() + bandits.getOverallProfit();


        for (int i = 0; i <= w; i++) {
            double angle = i * 2 * Math.PI / w;
            double sinVal = Math.sin(angle);

            int x = (int)((i + w / 100)*0.75);       // start by 0 on the coordinate system
            //int height = xAxis - (int)(sinVal * amplitude);
            double height = xAxis - (credit);

            if(height < xAxis){
                g.setColor(niceGreen);
                g.drawLine(x, xAxis, x, (int)height);
            }
            else {
                g.setColor(niceRed);
                g.drawLine(x, xAxis, x, (int)height);
            }
        }
    }
    public GUICreditPanel(MultiBandit bandits) {
        this.bandits = bandits;
    }
}
