import java.util.Date;

public class WThread extends Thread{
    FileService service;
    public WThread(FileService service) {
        this.service = service;
    }
    public void run(){
        while(!Main.isStopThreads()){
            String msg=
                    String.valueOf(Math.round(Math.random()*100));
            /// service.write(msg);
            synchronized (this){
                Date date = new Date(System.currentTimeMillis());
                service.out.println("Date: " + date);
                service.out.println("Message: " + msg);
                service.out.flush();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
