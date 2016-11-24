package Yue.Merge;

/**
 * @author duyue
 *         <p/>
 *         这是对数组进行归并排序的类
 */
class Merge {
    private int[] temp;                 //暂时存放待排序数组的temp数组

    /**
     * @param a 待排序的数组由构造器传递到类中
     */
    Merge(int[] a) {
        temp = new int[a.length];
    }

    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public void sort(int[] a, int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);              //将左半边排序
        sort(a, mid + 1, high);         //将左半边排序
        merge(a, low, mid, high);       //归并结果
    }

    /**
     * @param a 待归并的数组，其中a[low,mid]和a[mid+1,high]都是有序的
     */
    public void merge(int[] a, int low, int mid, int high) {
        int i = low, j = mid + 1;
        /*将a[low,high]复制到temp[low,high]*/
        System.arraycopy(a, low, temp, low, high - low + 1);
        /*归并到a[low,high]*/
        for (int k = low; k <= high; k++) {
            if (i > mid)
                a[k] = temp[j++];
            else if (j > high)
                a[k] = temp[i++];
            else if (temp[j] < temp[i])
                a[k] = temp[j++];
            else
                a[k] = temp[i++];
        }
    }
}
