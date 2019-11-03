package logger;

public class Logger {

     public static void log(String label) {
        System.out.println(
                System.currentTimeMillis() +"\t|"+
                        Thread.currentThread().getName()+"\t|"
                        +label
        );
    }
}
