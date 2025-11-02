class AppLogger{
    public void log(String s,String type){
        if(type.equals("info"))
            System.out.println("INFO -----> "+s);
        else if(type.equals("warn"))
            System.out.println("WARN -----> "+s);

    }
}
class Logger{
    public void info(String s){
        System.out.println(System.currentTimeMillis()+" INFO -----> "+s);
    }
    public void warn(String s){
        System.out.println(System.currentTimeMillis()+" WARN -----> "+s);
    }
}
class LoggerAdapter extends AppLogger{
    private Logger logger;
    public LoggerAdapter(){
        logger=new Logger();
    }
    public void log(String s,String type){
        if(type.equals("info"))
            logger.info(s);
        else if(type.equals("warn"))
            logger.warn(s);
    }
}
public class Main {
    public static void main(String[] args) {
        AppLogger appLogger = new LoggerAdapter();
        appLogger.log("Aryan is a SDE","info");
        appLogger.log("i am a boy","info");
        appLogger.log("some extensions are not downloaded","warn");
    }
}