
class Logger{
    private static Logger instance;
    private Logger(){
    }
    public static Logger getInstance(){
        if(instance==null)
        {
            synchronized (Logger.class) {
                if(instance==null){
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    public void log(String s){
        System.out.println(s);
    }
}
/*
this is used i logging,database connection
* */
public class Main {
    public static void main(String[] args) {
       Runnable task = () -> {
           Logger logger = Logger.getInstance();
           System.out.println(logger.hashCode());
       };
        Thread t1 = new Thread(task,"t1");
        Thread t2 = new Thread(task,"t2");
        t1.start();
        t2.start();

    }
}