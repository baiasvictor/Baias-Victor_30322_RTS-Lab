public class ExecutionThread extends Thread {
    Integer monitor;
    int activity_min, activity_max,sleep;
    public ExecutionThread(Integer monitor, int sleep, int activity_min, int activity_max) {
        this.monitor = monitor;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
    }
    public ExecutionThread(Integer monitor, int activity_min, int activity_max) {
        this.monitor = monitor;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = 0;
    }
    public void run() {

        System.out.println(this.getName() + " - STATE 1");

        /*

        synchronized (this) {
        try {
            monitor.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        }

        */

        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        synchronized (monitor) {
            System.out.println(this.getName() + " - STATE 2");

            int k = (int) Math.round(Math.random() * (activity_max
                    - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
        }

        System.out.println(this.getName() + " - STATE 3");


    }
}


