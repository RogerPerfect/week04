package class04;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */
public class Homework03_2 {
    
    public static void main(String[] args) throws InterruptedException {
        
        long start=System.currentTimeMillis();
        final int[] result = new int[1];
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Runnable task = () -> {
            result[0] = sum();
            System.out.println("当前线程执行结果：" + result[0]);
        };
        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(5000);

         //这是得到的返回值
        
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+ result[0]);
         
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        
        // 然后退出main线程
    }
    
    private static int sum() {
        return fibo(36);
    }
    
    private static int fibo(int a) {
        if ( a < 2) 
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
