package ImplementRunnable;

import java.util.concurrent.Callable;

//we can implement runnable or callable to create threads
//(callable can return a value)
public class ObjectImplementesRunnable implements Callable<Long> {
    int[] arr;
    int startIndex;
    int endIndex;
    public ObjectImplementesRunnable(){}
    public ObjectImplementesRunnable(int[] arr, int startIndex, int endIndex){
        this.arr = arr;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    @Override
    public Long call() throws Exception {
        long result = 0;
        for(int i = startIndex; i < endIndex; i++){
            result = result + arr[i];
        }
        return result;
    }
}
