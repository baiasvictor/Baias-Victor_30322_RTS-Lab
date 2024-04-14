public class Main {
    public static void main(String[] args) {
        Integer monitor = new Integer(1);
        new ExecutionThread(monitor, 2, 3,7).start();
        new ExecutionThread(monitor, 3, 5).start();
        new ExecutionThread(monitor, 4, 7).start();

    }
}
