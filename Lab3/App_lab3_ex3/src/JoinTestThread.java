class JoinTestThread extends Thread{
    Thread t;
    long nr;
    static long sum = 0; //static => doar o data se instantiaza cu 0,nu de fiecare daca cand se creaza un thread, de aia face suma de la thread 1 + suma de la thread 2
    String n;

    JoinTestThread(String n, Thread t, long nr){
        this.setName(n);
        this.n = n;
        this.t = t;
        this.nr = nr;
    }
    public void run() {

        for(int i = 2; i<=nr; i++) {
            if(nr%i == 0)
                sum = sum + i;
        }
        System.out.println(sum);
        System.out.println("Thread "+n+" has entered the run() method");
        try {
            if (t != null) t.join();
            System.out.println("Thread "+n+" executing operation.");
            Thread.sleep(3000);
            System.out.println("Thread "+n+" has terminated operation.");
        }
        catch(Exception e){e.printStackTrace();}
    }
}
