package ExtendedThread;

public class BankAccount {
    public double balance;

//    synchronized only allows a single thread to access this piece of code
//    so: we lose some of the speed advantage for threading, but we have more accurate results
/*
if you go deeper into threading, you will find it is hypothetically possible to brick your application
if multiple threads are waiting for each other to complete
this is referred to as a deadlock
 */
    public synchronized void deposit(double x){
//        let's say that we're using some api call that takes an amount of time
//        to resolve
        double newBalance = balance + x;
        try {
            Thread.sleep(50);
        }catch(InterruptedException e){}
        balance = newBalance;
    }
    public void withdrawl(double x){
        double newBalance = balance + x;
        try {
            Thread.sleep(50);
        }catch(InterruptedException e){}
        balance = newBalance;
    }
}
