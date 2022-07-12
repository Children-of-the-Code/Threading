package ImplementRunnable;

import java.util.concurrent.*;

public class Driver {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int size = 100000000;
        int[] arr1 = new int[size];
        for(int i = 0; i < arr1.length; i++){
//            this will give us a random number between 0 and 9, because math.random returns a random decimal 0-1
            arr1[i] = (int) (Math.random() * 100);

        }

        long sum = 0;
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < arr1.length; i++){
            sum = sum + arr1[i];
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Adding up all numbers without threading took "+ (endTime - startTime) + " milliseconds");
        System.out.println(sum);

        ExecutorService service = Executors.newFixedThreadPool(2);
        Callable<Long> thread1 = new ObjectImplementesRunnable(arr1, 0, size/2);
        Callable<Long> thread2 = new ObjectImplementesRunnable(arr1, size/2, size);

        startTime = System.currentTimeMillis();

        Future<Long> result1 = service.submit(thread1);
        Future<Long> result2 = service.submit(thread2);

        long result = result1.get() + result2.get();
        endTime = System.currentTimeMillis();
        System.out.println("Adding up all numbers with threading took "+ (endTime - startTime) + " milliseconds");
        System.out.println(result);



    }
}
