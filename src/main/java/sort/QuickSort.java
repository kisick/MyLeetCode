package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/06/19 16:36
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {4,6,3,2,1};
        sort(a, 0, a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }

    /**
     * 对nums[i-j]区间范围进行排序
     * 选取nums[i] 为中心轴
     */
    public static void sort(int[] nums, int left, int right) {
        int i = left, j = right;
        if (right - left < 1) {
            return;
        }
        int pivot = nums[left];
        while (right > left) {
            while (nums[right] > pivot && right > left) {
                right--;
            }
            if (right > left) {
                nums[left] = nums[right];
                left++;
            }
            while (nums[left] < pivot && right > left) {
                left++;
            }
            if (right > left) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        sort(nums,i, left-1);
        sort(nums,right+1, j);
    }
}
