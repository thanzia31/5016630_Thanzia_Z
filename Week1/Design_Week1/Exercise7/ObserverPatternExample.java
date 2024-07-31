import java.util.*;

interface Stock
{
    void register(Observer Observer);
    void deregister(Observer observer);
    void notifyObs();


}
interface Observer
{
    void update(String price);
}

class StockMarket implements Stock {
    private ArrayList<Observer> arr = new ArrayList<>();
    private String stockPrice;

    public void setStockPrice(String stockPrice) {
        this.stockPrice = stockPrice;
        notifyObs(); 
    }

    
    public void register(Observer observer) {
        arr.add(observer);
    }

    public void deregister(Observer observer) {
        arr.remove(observer);
    }

    
    public void notifyObs() {
        for (int i = 0; i < arr.size(); i++) {
            Observer observer = arr.get(i);
            observer.update(stockPrice);
        }
    }
}

class ObserverPeople implements Observer
{
    String name;
    ObserverPeople(String name)
    {
        this.name=name;
    }

    public void update(String price)
    {
        System.out.println("User " + name + " Notified of stock price upate to " + price);
    }
}


public class ObserverPatternExample {
    public static void main(String args[])
    {
        StockMarket stockMarket = new StockMarket();

        
        Observer investor1 = new ObserverPeople("Investor 1");
        Observer investor2 = new ObserverPeople("Investor 2");

        
        stockMarket.register(investor1);
        stockMarket.register(investor2);

        
        System.out.println("Setting stock price to rupees 100");
        stockMarket.setStockPrice("100");

        
        System.out.println("Setting stock price to  rupees 150");
        stockMarket.setStockPrice("150");

       
        stockMarket.deregister(investor1);

        
        System.out.println("Setting stock price to rupees 200");
        stockMarket.setStockPrice("200");
    }
    
}

/*
OUTPUT:

Setting stock price to rupees 100
User Investor 1 Notified of stock price upate to 100
User Investor 2 Notified of stock price upate to 100
Setting stock price to  rupees 150
User Investor 1 Notified of stock price upate to 150
User Investor 2 Notified of stock price upate to 150
Setting stock price to rupees 200
User Investor 2 Notified of stock price upate to 200
 */