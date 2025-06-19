public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same - Singleton works!");
        } else {
            System.out.println("Different instances created - Singleton failed!");
        }
        
        logger1.log("Application started");
        logger2.warn("This is a warning message");
        logger1.error("This is an error message");
        
        Runnable task = () -> {
            Logger threadLogger = Logger.getInstance();
            threadLogger.log("Logging from thread: " + Thread.currentThread().getId());
        };
        
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
}