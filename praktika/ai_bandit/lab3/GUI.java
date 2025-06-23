package ai_bandit.lab3;

import ai_bandit.lab2.MultiBandit;
import ai_bandit.lab2.MultiBanditSolver;

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel{
    //buttons
    JButton btnReset = new JButton("Reset bandits");
    JButton btn1x = new JButton("Play 1x");
    JButton btn10x = new JButton("Play 10x");
    JButton btn100x = new JButton("Play 100x");
    JButton btnStart = new JButton("Start");
    JMenuItem itemRndm = new JMenuItem("Random bandit");
    JMenuItem itemEpsilon = new JMenuItem("Epsilon-Greedy");

    private String strategy;

    public GUI (MultiBanditSolver solver, MultiBandit bandits) {
        this.solver = solver;
        // frame
        JFrame frame = new JFrame("BanditStrategies");
        setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(getSize());
        frame.setLocationByPlatform(true);

        // menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuStrategy = new JMenu("strategy");
        frame.setJMenuBar(menuBar);
        menuBar.add(menuStrategy);
        menuStrategy.add(itemRndm);
        menuStrategy.add(itemEpsilon);

        JLabel strategyLabel = new JLabel("strategy: " + strategy);
        strategyLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // panel
        JPanel panelBtns = new JPanel();
        panelBtns.setLayout(new BoxLayout(panelBtns, BoxLayout.Y_AXIS));
        panelBtns.setPreferredSize(new Dimension(120, 400));
        btnStart.setMaximumSize(new Dimension(120,30));
        btnReset.setMaximumSize(new Dimension(120,30));
        btn1x.setMaximumSize(new Dimension(120,30));
        btn10x.setMaximumSize(new Dimension(120,30));
        btn100x.setMaximumSize(new Dimension(120,30));

        panelBtns.add(btnReset);
        panelBtns.add(btn1x);
        panelBtns.add(btn10x);
        panelBtns.add(btn100x);
        panelBtns.add(btnStart);

        // Graphs
        GUIBanditPanel guiBanditPanel = new GUIBanditPanel(solver);

        JPanel panelGraphs = new JPanel(new GridLayout(2, 1));
        panelGraphs.add(guiBanditPanel);
        panelGraphs.add(new GUICreditPanel(bandits));

        // Content
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(panelGraphs, BorderLayout.CENTER);
        contentPane.add(panelBtns, BorderLayout.WEST);
        contentPane.add(strategyLabel, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    private MultiBanditSolver solver;

    private MultiBandit bandits;

}
