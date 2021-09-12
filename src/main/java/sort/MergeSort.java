package sort;

/**
 * @author: gefeng
 * @created: 2021/06/20 12:28
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {4,6,7,12,5,8,4,1,32,54,12,6,17,9,3,42,5,4,3,2,1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void mergeSort(int[] nums) {

    }

    public static void sort(int[] nums) {
        // 把nums 分成多个
        // 合并两个数组，关键是要copy回原数组
        mergeSortRecursive(nums, new int[nums.length], 0, nums.length-1);
    }

    /**
     * heb
     */
    public static void mergeSortRecursive(int[] nums, int[] res, int start, int end) {
        if (start >= end) {
            return;
        }
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1 , end2 = end;
        mergeSortRecursive(nums, res, start1, end1);
        mergeSortRecursive(nums, res, start2, end2);
        int index = start;
        while (start1 <= end1 && start2 <= end2) {
            res[index++] = nums[start1] < nums[start2] ? nums[start1++] : nums[start2++];
        }
        while (start1 <= end1){
            res[index++] = nums[start1++];
        }
        while (start2 <= end2){
            res[index++] = nums[start2++];
        }
        // 将合并完的结果copy回原数组
        for (int i = start; i <= end; i++) {
            nums[i] = res[i];
        }
    }


}
