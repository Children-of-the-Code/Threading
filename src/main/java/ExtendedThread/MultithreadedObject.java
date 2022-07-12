package ExtendedThread;

public class MultithreadedObject extends Thread{

    public int threadNum;
    public int waitMillis;
    public BankAccount ba;
    public int amount;
    public MultithreadedObject(int threadNum, int waitMillis, BankAccount ba, int amount){
        this.threadNum = threadNum;
        this.waitMillis = waitMillis;
        this.ba = ba;
        this.amount = amount;
    }
    public void run(){
        try {
            Thread.sleep(waitMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ba.deposit(amount);
        System.out.println("Hello from thread " + threadNum);


    }

}
