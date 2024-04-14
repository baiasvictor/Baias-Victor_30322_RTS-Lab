
public class ExecutionThread extends Thread {
    Integer monitor;
    int activity1_min, activity1_max, activity2_min, activity2_max, sleep;
    public ExecutionThread(Integer monitor, int activity1_min, int
            activity1_max, int activity2_min, int activity2_max, int sleep) {
        this.monitor = monitor;
        this.activity1_min = activity1_min;
        this.activity1_max = activity1_max;
        this.activity2_min = activity2_min;
        this.activity2_max = activity2_max;
        this.sleep = sleep;
    }
    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random()*(activity1_max - activity1_min)+activity1_min);
        for( int i = 1 ; i<=k*100000 ; i++)
        {
            i++; i--;
        }

        synchronized (monitor){
            System.out.println(this.getName() + " - STATE 2");

            int q = (int) Math.round(Math.random()*(activity2_max-activity2_min)+activity2_min);
            for( int i = 1 ; i<=q*100000 ; i++)
            {
                i++; i--;
            }
            System.out.println(this.getName() + " - STATE 3");

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println(this.getName() + " - STATE 4");

    }
}
