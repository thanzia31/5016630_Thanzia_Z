import java.util.*;


class Logger
{
    private static Logger instance;
    private String message="Hello world";

    private Logger(String message)
    {
        this.message=message;
    }

    public static Logger getInstance(String message)
    {

        if(instance==null)
        {
        synchronized(Logger.class)
        {
        if(instance == null)
        {
            instance=new Logger(message);
        }
    }
}
        return instance;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    
    public String getMessage() {
        return message;
    }
}
public class SingletonPatternExample {
    public static void main(String[] args) {
        
        Logger logger1 = Logger.getInstance("Initial Message");

        
        System.out.println("Logger 1 Message: " + logger1.getMessage());

        
        Logger logger2 = Logger.getInstance("Different Message");

        
        System.out.println("Logger 2 Message: " + logger2.getMessage());

        
        logger1.setMessage("Updated Message");

        
        System.out.println("Logger 1 Message after update: " + logger1.getMessage());
        System.out.println("Logger 2 Message after update: " + logger2.getMessage());
    }
}


/*

OUTPUT:
Logger 1 Message: Initial Message
Logger 2 Message: Initial Message
Logger 1 Message after update: Updated Message
Logger 2 Message after update: Updated Message
 
 */