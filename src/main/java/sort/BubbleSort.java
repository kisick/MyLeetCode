package sort;

/**
 * @author: gefeng
 * @created: 2021/03/18 17:17
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {4,6,7,12,5,8,4,1,32,54,12,6,17,9,3,42,5,4,3,2,1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }

    // 从小到大排序
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length-1-i; j++) {
                if (a[j] > a[j+1]) {
                    int tmp= a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }
}
