package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExceptionThread2 implements Runnable {
    public void run() {
        throw new RuntimeException("NullPointer");
    }

    public static void main(String[] args) {
        try{
            ThreadFactory tFactory = new MyThreadFactory();
            ExecutorService service = Executors.newCachedThreadPool(tFactory);
            Runnable task = new ExceptionThread2();
            service.execute(task);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    // 处理从线程里抛出来的异常。
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Catched Throwable: " + 
                e.getClass().getSimpleName() + ", " + e.getMessage());
    }
}

class MyThreadFactory implements ThreadFactory {
    // 重新组织创建线程的方式
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        // 为每一个线程都绑定一个异常处理器。
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("Thread[" + t.getName() + "] created.");
        return t;
    }
}