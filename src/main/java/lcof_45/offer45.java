package lcof_45;


/**
 * @author: gefeng
 * @created: 2021/06/13 21:12
 */
public class offer45 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        Solution solution = new Solution();
        System.out.println(solution.minNumber(nums));
    }
}

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 输入: [10,2]
 * 输出: "102"
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
class Solution {
    public String minNumber(int[] nums) {
        // 把数组从小到达排序
        sort(nums, 0, nums.length - 1);
        StringBuilder res = new StringBuilder();
        for (int num : nums) {
            res.append(num);
        }
        return res.toString();
    }


    public static void sort(int[] nums, int left, int right) {
        int i = left, j = right;
        if (right - left < 1) {
            return;
        }
        int pivot = nums[left];
        while (left < right) {
            while (!compare(nums[right], pivot) && right > left) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (!compare(pivot,nums[left]) && right > left) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        sort(nums,i, left-1);
        sort(nums,right+1, j);
    }

    /**
     * 比较两个数字
     * a<b 返回true 表示需要交换
     * a>b 返回false
     */
    public static boolean compare(int a, int b) {
        String str1 = String.valueOf(a) + String.valueOf(b);
        String str2 = String.valueOf(b) + String.valueOf(a);
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.charAt(i) < str2.charAt(i);
            }
        }
        return false;
    }

}
