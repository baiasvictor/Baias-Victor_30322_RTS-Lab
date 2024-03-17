// Controller

import java.util.Observable;

public class Controller extends Observable {

    private Fir fir;
    private Window window;

    public Controller(Fir fir, Window window) {
        this.fir = fir;
        this.window = window;
    }

    public void startThread() {
        int c = 0;
        while (c < 1000) {

            // This I implemented just to have an animation for the bars
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for (int j = 0; j < fir.processorLoad; j++) {
                j++;
                j--;
            }
            c++;
            int[] values = {fir.id, c};
            setChanged();
            notifyObservers(values);
        }
    }
}
