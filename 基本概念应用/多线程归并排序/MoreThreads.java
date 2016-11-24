package Yue.Merge;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @author duyue
 *         <p/>
 *         本类是多线程处理归并排序的核心部分。
 *         <p/>
 *         原理：
 *         由用户指定线程数，例如n个线程，将数组分为n份，分别用n个线程对这n个数组进行归并排序，
 *         得到n个有序分数组，再对这n个有序数组归并就得出最后的结果。
 *         线程数越多，相应的速度就会越快。
 *         要处理的数组长度越长，多线程与单线程的对比就越大。
 */

class MoreThreads {
    /**
     * @param num 线程数，由用户定义
     */
    MoreThreads(int num) {
        System.out.println("现在是" + num + "个线程处理归并排序：");
        int length = 100;                   //数组总长度
        for (int j = 0; j < 6; j++) {

            /*记录起始时间*/
            long beginTime = System.currentTimeMillis();

            /*创建待排序的数组*/
            int[] myArray = Array.createArray(length);

            /*将数组近乎等分成num份，以便利用多线程对各个数组排序*/
            Array.divideArray(myArray, num);

            /*
             * 对各个数组利用num个线程同步排序。
             * 将num个线程保存在列表threads中，方便将各个线程处理后的数组调出。
             * CountDownLatch类用于等待所有的线程都工作完成后，进行最终的归并。
             */
            ArrayList<MyThread> threads = new ArrayList<MyThread>();
            CountDownLatch latch = new CountDownLatch(num);
            for (int i = 0; i < num; i++) {
                MyThread thread = new MyThread(Array.arrayList.get(i), latch);
                thread.start();
                threads.add(thread);
            }
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /*
             * 清空原装有数组列表中的元素，
             * 将排序后的各个数组从threads列表中调出，添加到数组列表Array中
             */
            Array.arrayList.clear();
            for (int i = 0; i < num; i++) {
                Array.arrayList.add(threads.get(i).aux);
            }

            /*把各个排序后数组规整到长数组中，并对三个有序数组归并到一个数组中*/
            Array.newArray(myArray, num);

            /*
             * 对有序数组进行归并
             * 归并原理：
             * 将第一个有序分数组（即第一个线程排序后的数组）与其下一个有序分数组（即第二个线程
             * 排序后的数组）归并成一个数组，再把归并的数组与其下一个有序分数组（即第三个线程排
             * 序后的数组）归并，依此类推.
             */
            int low = 0;                    //整合后的长数组myArray的首位
            int mid = -1;                   //待归并的第一个有序分数组的末位
            int high;                       //待归并的第二个有序分数组的末位
            for (int i = 0; i < num - 1; i++) {
                Merge merge = new Merge(myArray);
                mid = Array.arrayList.get(i).length + mid;
                high = mid + Array.arrayList.get(i + 1).length;
                merge.merge(myArray, low, mid, high);
            }

            /*记录结束时间*/
            long endTime = System.currentTimeMillis();
            System.out.println(length + "项数组归并排序的时间：" + (endTime - beginTime) + "ms");
            length = length * 10;
            Array.arrayList.clear();        //清空列表内容，对下一次循环不造成影响
        }
    }
}

