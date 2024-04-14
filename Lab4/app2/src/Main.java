public class Main {
    public static void main(String[] args) {
        Integer monitor = new Integer(1);
        new ExecutionThread(monitor, 2, 4, 4, 6,4).start();
        new ExecutionThread(monitor, 3, 5, 5, 7,5).start();
    }
}
