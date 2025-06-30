package ai_bandit.lab3;

import ai_bandit.lab2.MultiBandit;
import ai_bandit.lab2.MultiBanditSolver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JPanel implements ActionListener {
    //buttons
    JButton btnReset = new JButton("Reset bandits");
    JButton btn1x = new JButton("Play 1x");
    JButton btn10x = new JButton("Play 10x");
    JButton btn100x = new JButton("Play 100x");
    JMenuItem itemRndm = new JMenuItem("Random bandit");
    JMenuItem itemEpsilon = new JMenuItem("Epsilon-Greedy");

    private final GUIApp app;
    private final GUIBanditPanel guiBanditPanel;
    private final GUICreditPanel guiCreditPanel;
    private int numberOfRounds = 1;
    private int strategy = 15;          // epsilon greedy as standard
    private JLabel strategyLabel;

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getStrategy() {
        return strategy;
    }
    JFrame frame = new JFrame("BanditStrategies");

    public GUI (MultiBanditSolver solver, GUIApp guiApp) {
        this.app = guiApp;
        this.guiBanditPanel = new GUIBanditPanel(app);
        this.guiCreditPanel = new GUICreditPanel(app);

        // frame
        setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(getSize());
        frame.setLocationByPlatform(true);

        // menu for choosing strategy
        JMenuBar menuBar = new JMenuBar();
        JMenu menuStrategy = new JMenu("strategy");
        frame.setJMenuBar(menuBar);
        menuBar.add(menuStrategy);
        menuStrategy.add(itemRndm);
        menuStrategy.add(itemEpsilon);
        itemRndm.setActionCommand("RNDM");
        itemRndm.addActionListener(this);
        itemEpsilon.setActionCommand("EPSILON");
        itemEpsilon.addActionListener(this);

        // display current strategy
        strategyLabel = new JLabel();
        strategyLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        updateStrategyLabel();

        // buttons
        JPanel panelBtns = new JPanel();
        panelBtns.setLayout(new BoxLayout(panelBtns, BoxLayout.Y_AXIS));
        panelBtns.setPreferredSize(new Dimension(120, 400));
        btnReset.setMaximumSize(new Dimension(120,30));
        btn1x.setMaximumSize(new Dimension(120,30));
        btn10x.setMaximumSize(new Dimension(120,30));
        btn100x.setMaximumSize(new Dimension(120,30));

        // event handling
        btnReset.setActionCommand("RESET");
        btnReset.addActionListener(this);
        btn1x.setActionCommand("1x");
        btn1x.addActionListener(this);
        btn10x.setActionCommand("10x");
        btn10x.addActionListener(this);
        btn100x.setActionCommand("100x");
        btn100x.addActionListener(this);

        panelBtns.add(btnReset);
        panelBtns.add(btn1x);
        panelBtns.add(btn10x);
        panelBtns.add(btn100x);

        frame.setVisible(true);

        // Graphs
        JPanel panelGraphs = new JPanel(new GridLayout(2, 1));
        panelGraphs.add(guiBanditPanel);
        panelGraphs.add(guiCreditPanel);

        // Content
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        contentPane.add(panelGraphs, BorderLayout.CENTER);
        contentPane.add(panelBtns, BorderLayout.WEST);
        contentPane.add(strategyLabel, BorderLayout.NORTH);

    }
    public GUIBanditPanel getBanditPanel() {
        return guiBanditPanel;
    }

    public GUICreditPanel getCreditPanel() {
        return guiCreditPanel;
    }
    private void updateStrategyLabel() {
        if(strategy < 0 || strategy > 100) {
            strategyLabel.setText("strategy: random");
        } else {
            strategyLabel.setText("strategy: epsilon-greedy");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "RESET":
                app.reset();
                break;
            case "1x":
                numberOfRounds = 1;
                app.runRounds();
                break;
            case "10x":
                numberOfRounds = 10;
                app.runRounds();
                break;
            case "100x":
                numberOfRounds = 100;
                app.runRounds();
                break;
            case "EPSILON":
                this.strategy = 15;;
                updateStrategyLabel();

                break;
            case "RNDM":
                this.strategy = -1;
                updateStrategyLabel();

                break;
            default:
                numberOfRounds = 0;
                break;
        }
    }

}
