package leetcode027;

public class leetcode027 {
    public static void main(String[] args) {
        int[] nums  = {3,2,2,3};
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
