package ExtendedThread;

public class Driver {
    public static void main(String[] args) throws InterruptedException {

//        traditionally, our programs run from top to bottom*
//        multithreading : we can have multiple instances of java running simultaneously
//        we may want to do this in a couple scenarios:

//        a) we are waiting for some really slow operation like user input, web requests, filereading
//        and we want to have some portion of the app waiting for that to resolve
//        while another one does some other calculation

//        b) we are running on a machine that has multiple CPU cores and we have some really
//        bit calculation that we would like to divide up

//        the issue is, is that when multiple threads share the same resources (eg the same objects),
//        this leads to big issues!

        Thread[] nonThreaded = new MultithreadedObject[10];
        BankAccount ba = new BankAccount();
        System.out.println("starting account balance: "+ba.balance);
        for(int i = 0; i < 10; i++){
            nonThreaded[i] = new MultithreadedObject(i, 500, ba, 100);
        }


        Thread[] threaded = new MultithreadedObject[10];
        for(int i = 0; i < 10; i++){
            threaded[i] = new MultithreadedObject(i, 500, ba, 100);
        }
/*
        System.out.println("STARTING NON-MULTITHREADED");
        for(int i = 0; i < 10; i++){
            nonThreaded[i].run();
        }*/
        System.out.println("STARTING MULTITHREADED");
        for(int i = 0; i < 10; i++){
            threaded[i].start();
        }

        Thread.sleep(2000);
        System.out.println("ending account balance: "+ba.balance);


    }
}
