package thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ThreadException {

   /* public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(()->{
            System.out.println(456);
            throw new RuntimeException("123");
        });
    }*/

    public static void main(String[] args) throws ExecutionException, InterruptedException {
      /*  MyThreadFactory myThreadFactory = new MyThreadFactory(new MyUncaughtExceptionHandler());
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(myThreadFactory );
        try {
            newCachedThreadPool.execute(()->{
                System.out.println(1244);
                throw new RuntimeException("222222222222");
            });
        } catch (Exception e) {
            System.out.println("catched exception!");
        }*/
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();//
        ExecutorService newCachedThreadPool = Executors.newFixedThreadPool(10);
        try {
            final CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<String>();
            for (int i = 0; i <100; i++) {
                Future<?> future = newCachedThreadPool.submit(()->{
                    try{
                        System.out.println(1/0);
                        System.out.println(Thread.currentThread().getName());
                        //throw new RuntimeException("222222222222");
                    }catch (Exception e){
                        strings.add("12");
                    }
                });
            }
           Thread.sleep(1000);
            System.out.println(strings.size());
            System.out.println(124);

           /* Object object = submit.get();
            System.out.println(object);*/
        } catch (Exception e) {
            throw e;
            //System.out.println("catched exception!");
        }
    }

    private static class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("caught    "+e);
        }
    }

    @Test
    public void test2(){

        for (int i = 0; i < 10; i++) {

            System.out.println(1);

            if(i%2 == 0){
                throw new RuntimeException("122222222222222");
            }
            System.out.println("111111111111111111");
        }
    }
}
