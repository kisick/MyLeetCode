package lcof_40;

import java.util.PriorityQueue;

/**
 * @author: gefeng
 * @created: 2021/06/05 20:07
 */
public class offer40 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,1,32,3,4,5,3,1,3,7,8,3,4,5,6,1};
        int k = 5;
        Solution solution = new Solution();
        int[] leastNumbers = solution.getLeastNumbers(arr, k);
        for (int leastNumber : leastNumbers) {
            System.out.print(leastNumber + " ");
        }
    }
}


/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 冒泡排序
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j-1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
            res[i] = arr[i];
        }
        return res;
    }
}
