import java.util.Date;

public class RThread extends Thread{
    FileService service;
    public RThread(FileService service) {
        this.service = service;
    }
    public void run(){
        while (!Main.isStopThreads()){
            try {
                //String readMsg = service.read();
                synchronized (this) {
                    String iterator, last = "no message to read";
                    while ((iterator = service.in.readLine()) != null) {
                        last = new Date(System.currentTimeMillis()) + " - "
                                + iterator;
                        System.out.println(last);
                        Thread.sleep(3000);

                    }
                    ///System.out.println(readMsg);
                    ///Thread.sleep(3000);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
