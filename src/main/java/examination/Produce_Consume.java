package examination;

import java.sql.Time;
import java.util.AbstractCollection;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 使用“生产者-消费者模式”编写代码实现：线程A随机间隔（10~200ms）按顺序生成1到100的数字（共100个），
 放到某个队列中.3个线程B、C、D即时消费这些数据，线程B打印（向控制台）所有被2整除的数，
 线程C打印被3整除的数，线程D打印其它数据，要求数字的打印是有序的（从1到100）
 限时40分钟，可以使用IDE及第三方类库
 **/
public class Produce_Consume {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> produce = new ArrayBlockingQueue<>(100);
        new Thread(()->ThreadB(produce)).start();
        new Thread(()->ThreadC(produce)).start();
        new Thread(()->ThreadD(produce)).start();
        new Thread(()-> {
            try {
                ThreadA(produce);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void ThreadA(Queue<Integer> produce) throws InterruptedException {
        Random r = new Random();
        for (int i = 1; i <= 100; i++) {
            long random = r.nextInt(80) + 20;
//            System.out.println("休眠"+random+"ms");
            Thread.sleep(random);
//            System.out.println("ThreadA生产:"+i);
            produce.add(i);
        }
    }

    public static void ThreadB(Queue<Integer> produce) {
        while (true) {
            synchronized (produce) {
                if (!produce.isEmpty() && produce.peek() % 2 == 0) {
                    System.out.println("ThreadB消费:"+produce.poll());
                }
            }
        }
    }

    public static void ThreadC(Queue<Integer> produce) {
        while (true) {
            synchronized (produce) {
                if (!produce.isEmpty() && produce.peek() % 3 == 0) {
                    System.out.println("ThreadC消费:"+produce.poll());
                }
            }
        }
    }

    public static void ThreadD(Queue<Integer> produce) {
        while (true) {
            synchronized (produce) {
                if (!produce.isEmpty() && produce.peek() % 2 != 0 && produce.peek() % 3 != 0) {
                    System.out.println("ThreadD消费:"+produce.poll());
                }
            }
        }
    }
}
