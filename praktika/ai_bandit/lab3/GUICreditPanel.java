package ai_bandit.lab3;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GUICreditPanel extends JPanel {

    private GUIApp app;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();
        int xAxis = (int)(h/1.8);
        int yAxis = (int)(w/100);
        // new colours
        Color niceGreen = new Color(36, 186, 36);
        Color niceRed   = new Color(140, 35, 35);

        // coordinates system
        g.drawString("Number of rounds",(int)(w/1.3),(int)(xAxis*1.1));
        g.drawLine(yAxis,xAxis,(int)(w/1.1),xAxis);                             // x-axis
        g.drawLine(yAxis,(int)(h/1.1),w/100,h/10);                     // y-axis

        // data for plotting
//        double[] credit = app.getOverallProfit();
        List<Double> credit = app.getOverallProfit();

        int roundsPlayed = app.getRoundsPlayed();
        // check if data is already valid
        if (credit == null || roundsPlayed == 0) {
            g.drawString("No data yet", w / 2, h / 2);
            return;
        }

        // determine max plotting height
//        double maxHeight = credit[credit.length - 1];
        double maxHeight = credit.get(credit.size() - 1);

        // creating plot
//        for (int i = 0; i <= credit.length-1; i++) {
        for (int i = 0; i <= credit.size()-1; i++) {
            // finding the max credit value
            for (double val : credit) {
                double absVal = Math.abs(val);
                if (absVal > maxHeight) {
                    maxHeight = absVal;
                }
            }

//            int x = (int)(((((0.75*w)/credit.length) * i)) + yAxis);       // start by 0 on the coordinate system
            int x = (int)(((((0.75*w)/credit.size()) * i)) + yAxis);

//            double height = xAxis - ((0.4*h)/maxHeight) * credit[i];       // determine height
            double height = xAxis - ((0.4*h)/maxHeight) * credit.get(i);

//            int barWidth =  Math.max(2, w / (2 * credit.length));
            int barWidth =  Math.max(2, w / (2 * credit.size()));
            int barHeight = Math.abs(xAxis - (int) height);
            int barY = Math.min(xAxis, (int) height);

            // check if its under or over the xAxis for coloring
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
        g.drawString("Credit (max credit: " + String.format("%.2f", maxHeight) + ")", yAxis, h / 11);
    }

    public GUICreditPanel(GUIApp app) {
        this.app = app;
    }
}
