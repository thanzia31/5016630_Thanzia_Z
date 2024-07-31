

interface Command
{
    void execute();
}

class LightOn implements Command
{
    Light light;
    LightOn(Light light)
    {
        this.light=light;
    }
    public void execute()
    {
        light.turnOn();
    }
}

class LightOff implements Command
{
    Light light;

    LightOff(Light light)
    {
        this.light=light;
    }
    public void execute()
    {
       light.turnOff();
    }
}

class RemoteControl
{
    Command command;
    RemoteControl(Command command)
    {
        this.command=command;
    }

    public void setCommand()
    {
        command.execute();
    }
}

class Light{
    void turnOn()
    {
        System.out.println("Light Turned on");
    }

    void turnOff()
    {
        System.out.println("Light turned off");
    }

}
public class CommandPatternExample {
    public static void main(String args[])
    {
        Light light=new Light();
        Command command=new LightOn(light);
        RemoteControl remote=new RemoteControl(command);
        remote.setCommand();

    }
    
}

/*
OUTPUT:

Light Turned on
 */
