

interface Notifer
{
     void send();
}

class EmailNotifer implements Notifer
{
    public void send()
    {
        System.out.println("Message sent via Email");
    }
}
abstract class NotiferDecorator implements Notifer
{
    Notifer notify;
    NotiferDecorator(Notifer notify)
    {
        this.notify=notify;
    }

    public void send()
    {
        notify.send();
    }
}

class SmsNotifierDecorator extends NotiferDecorator
{
    public SmsNotifierDecorator(Notifer notify)
    {
        super(notify);
    }

        public void send()
        
        {
            notify.send();
            System.out.println("Sms notification");
        }
    }

class SlackNotifierDecorator extends NotiferDecorator
{
    public SlackNotifierDecorator(Notifer notify)
    {
        super(notify);
    }

       public void send()
        {
            notify.send();
            System.out.println("Slack notification");
        }
    }

public class DecoratorPatternExample {

    public static void main(String args[])
    {
        Notifer notifi=new EmailNotifer();
        

        Notifer notifi1=new SmsNotifierDecorator(notifi);
        

        Notifer notifi2=new SlackNotifierDecorator(notifi1);
        notifi2.send();

    }
    
}

/*
OUTPUT:

Message sent via Email
Sms notification
Slack notification
 */