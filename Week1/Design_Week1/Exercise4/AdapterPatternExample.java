

interface PaymentProcesser
{
    void processPayment();
}

class PaymentGpay{
    void gPay()
    {
        System.out.println("Payement done using Gpay");
    }
}

class GpayAdapter implements PaymentProcesser
{
    PaymentGpay gpay;
    GpayAdapter(PaymentGpay gpay)
    {
        this.gpay=gpay;
    }

    public void processPayment()
    {
        gpay.gPay();
    }
}
class PaymentPaytm{
    void payTm()
    {
        System.out.println("Payment done using Paytm");
    }


}
class PaytmAdapter implements PaymentProcesser
{
    PaymentPaytm paytm;
    PaytmAdapter(PaymentPaytm paytm)
    {
        this.paytm=paytm;
    }

    public void processPayment()
    {
        paytm.payTm();
    }
}
public class AdapterPatternExample {

    public static void main(String args[])
    {
        PaymentGpay gpay = new PaymentGpay();
        PaymentPaytm paytm = new PaymentPaytm();
        
        
        GpayAdapter gpayAdapter = new GpayAdapter(gpay);
        PaytmAdapter paytmAdapter = new PaytmAdapter(paytm);
        
        
        gpayAdapter.processPayment(); 
        paytmAdapter.processPayment();
    }
    
}

/*
OUTPUT:
Payement done using Gpay
Payment done using Paytm
 */
