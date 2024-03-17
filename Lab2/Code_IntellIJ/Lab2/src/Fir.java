// Model

public class Fir extends Thread {
    int id;
    Window win;
    int processorLoad;
    Controller controller;

    Fir(int id,int priority, Window win, int procLoad) {
        this.id = id;
        this.win = win;
        this.processorLoad = procLoad;
        this.setPriority(priority);
        controller = new Controller(this, win);
        controller.addObserver(win);
    }

    public void run() {
        controller.startThread();
    }
}
