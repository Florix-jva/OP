package Stoppuhr;

import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements  ActionListener{
    JButton startBtn = new JButton("Start");
    JButton stopBtn = new JButton("Stop");
    GUIPanel guiPanel;
    GUIThread thread;

    public GUI(){

        // frame as basis
        JFrame frame = new JFrame("Stoppuhr");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.setResizable(false);
        frame.setLocationByPlatform(true);

        // Panels
        guiPanel = new GUIPanel();
        JPanel panelBtns = new JPanel(new GridLayout(2,1 ));
        panelBtns.add(startBtn);
        panelBtns.add(stopBtn);

        // content
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(1,2));
        contentPane.add(guiPanel);
        contentPane.add(panelBtns);

        // Action handling
        startBtn.setActionCommand("START");
        startBtn.addActionListener(this);
        stopBtn.setActionCommand("STOP");
        stopBtn.addActionListener(this);
        stopBtn.setEnabled(false);
        startBtn.setEnabled(true);

        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("START")){
            thread = new GUIThread(guiPanel);
            thread.start();
            stopBtn.setEnabled(true);
            startBtn.setEnabled(false);
        }
        if(e.getActionCommand().equals("STOP")) {
            thread.interrupt();
            stopBtn.setEnabled(false);
            startBtn.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        GUI gui = new GUI();

    }
}

