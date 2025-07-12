package Stoppuhr;

public class GUIThread extends Thread {
    GUIPanel guiPanel;


    public GUIThread(GUIPanel guiPanel) {
        this.guiPanel = guiPanel;
    }

    public void run() {
        int time = guiPanel.getTime();
        while (!isInterrupted()) {
            try {
                time++;
                sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            guiPanel.setTime(time);
            guiPanel.repaint();
        }
    }
}
