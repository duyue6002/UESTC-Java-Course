package Yue.Merge;

import java.util.ArrayList;

/**
 * @author duyue
 *         <p/>
 *         这个类用来处理数组
 *         <p/>
 *         原理：
 *         创建待排序数组成功后，需要配合多线程（假设有n个线程）分别排序，
 *         需要将数组尽量等分成n个分数组（保存到列表中），由n个线程分别归
 *         并排序，并将各个有序数组（再次保存到列表中），最后整合（不归并
 *         整合）并覆盖原数组，等待最后归并。
 */

class Array {

    /**
     * 构造一个保存数组的列表，用于保存分割后的分数组
     */
    static ArrayList<int[]> arrayList = new ArrayList<int[]>();

    /**
     * @param length 数组长度
     * @return 待排序的数组
     */
    static int[] createArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 10000);
        }
        return array;
    }

    /**
     * @param array 待分割（多线程排序需要）的数组
     * @param num   线程数，即要分割的份数
     */
    static void divideArray(int[] array, int num) {
        int k = 0;                                  //记录原数组的复制进度，k代表当前数组的复制初始点
        for (int i = 0; i < num; i++) {
            int point = array.length / num;         //分数组的长度
            int[] a = new int[0];                   //保存分数组

            /*考虑到不够整除的情况，将剩余的项全部放在最后一个分数组中*/
            if (i != num - 1) a = new int[point];
            if (i == num - 1) a = new int[array.length - k];

            /*将array[k, k + a.length -1]复制到a[0, a.length]中*/
            System.arraycopy(array, k, a, 0, a.length);

            arrayList.add(a);                       //把得到的分数组保存在列表中
            k += point;                             //移动复制初始点
        }
    }

    /**
     * @param newArray 由有序分数组整合（不归并）的新数组
     * @param num      有序分数组的个数，即由num个线程分别排序后得到的数组数，也就是线程数
     */
    static void newArray(int[] newArray, int num) {
        /*原理与divideArray方法相似*/
        int k = 0;                                  //记录新数组的待整合初始点

        /*把列表元素（即数组）逐个复制到新的数组中*/
        for (int i = 0; i < num; i++) {
            System.arraycopy(arrayList.get(i), 0, newArray, k, arrayList.get(i).length);
            k += arrayList.get(i).length;           //移动待整合初始点
        }
    }
}
