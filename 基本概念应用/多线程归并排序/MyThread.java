package Yue.Merge;

import java.util.concurrent.CountDownLatch;

/**
 * @author duyue
 *         <p/>
 *         这个类用来定义线程，使其能够对数组进行归并排序处理
 */
class MyThread extends Thread {
    public int[] aux;                   //定义一个数组，用来保存待处理的数组
    private CountDownLatch latch;       //定义这个类用来等待各个线程都完成工作，再进行下一步操作

    /*通过构造器将待处理的数组传递到线程的类中*/
    public MyThread(int[] aux, CountDownLatch latch) {
        this.aux = aux;
        this.latch = latch;
    }

    public void run() {
        Merge mergeThread = new Merge(aux);
        mergeThread.sort(aux);
        latch.countDown();
    }
}
