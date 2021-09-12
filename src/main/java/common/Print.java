package common;

/**
 * @author: gefeng
 * @created: 2021/09/01 23:38
 */
public class Print {
    public static void printArray(int[][] nums) {
        for (int[] num : nums) {
            for (int i : num) {
                System.out.print(i+" ");
            }
            System.out.println("");
        }
    }

    public static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i+" ");
        }
    }
}
