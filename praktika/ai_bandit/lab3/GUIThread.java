package ai_bandit.lab3;

public class GUIThread extends Thread{

    private final GUIApp app;
    private final GUI gui;
    private boolean isStarted = false;

    public GUIThread(GUIApp app, GUI gui) {
        this.app = app;
        this.gui = gui;
    }


    public void run() {
        while (gui.isDoWeAutoRun()) {
            isStarted = true;

            int numberOfRounds = 1;
            app.runRounds();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public boolean isStarted() {
        return isStarted;
    }
}
