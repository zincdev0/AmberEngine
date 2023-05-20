package net.zincdev.engine.amber.instance;

public class EngineThread extends Thread {
    private final EngineInstance PARENT;

    private final long startTime = System.currentTimeMillis();
    private long lastTime = 0;

    public EngineThread(EngineInstance parent) {
        this.PARENT = parent;

        this.start();
    }

    @Override
    public void run() {
        while(true) {
            float delta = ((System.currentTimeMillis() - startTime) - lastTime) / 1000F;
            lastTime = System.currentTimeMillis() - startTime;

            this.PARENT.$EventUpdate.InvokeEvents((event) -> event.Invoke(delta));
            this.PARENT.PANEL.repaint();

            if(!this.PARENT.closing) {
                try {
                    Thread.sleep((int) (1000F / this.PARENT.framesPerSecond));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
