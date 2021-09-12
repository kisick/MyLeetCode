package lcof_66;

/**
 * @author: gefeng
 * @created: 2021/07/20 23:53
 */
public class offer66 {
    public static void main(String[] args) {
        int[] ints = new Solution().constructArr(new int[]{1, 2, 3, 4, 5});
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}


/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * dp[5] = dp[4] * A[4];
 * B[5] = B[4]
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */
class Solution {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int[] dpL = new int[a.length];
        int[] dpR = new int[a.length];
        dpL[0] = 1;
        dpR[a.length-1] = 1;
        for (int i = 1; i < a.length; i++) {
            dpL[i] = dpL[i-1] * a[i-1];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            dpR[i] = dpR[i+1] * a[i+1];
        }
        int[] ans = new int[a.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = dpL[i] * dpR[i];
        }
        return ans;
    }
}
