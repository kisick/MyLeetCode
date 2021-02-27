package leetcode004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2020/12/18 16:32
 */
public class leetcode004 {
    public static void main(String[] args) {
        //[0,0,0,0,0]
        //[-1,0,0,0,0,0,1]
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {5,6,7,8};
        System.out.println(Solution.findMedianSortedArrays(nums1,nums2));
    }
}

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 *示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length  = nums1.length + nums2.length;
        double res = 0;
        int m = 0,m_num = 0,n = 0,n_num = 0;
        // m为两个数组中最中间的两位数的小的那一个
        // n为两个数组中最中间的两位数的大的那一个
        if (length % 2 == 0) {
            m = (length)/2;
            n = (length)/2 +1;
        } else {
            m = n = (length)/2+1;
        }
        // 其中一个数组为空的情况
        if (nums1.length == 0) {
            res = (nums2[m-1] + nums2[n-1])/2.0;
            return res;
        }
        if (nums2.length == 0) {
            res = (nums1[m-1] + nums1[n-1])/2.0;
            return res;
        }
        // 转换为查找两个有序数组中第k大的数字
        // 设置两个指针，从0开始，向右移动，直到移动到最中间的数为止
        int r1=0,r2=0;
        // 两个指针一共需要移动m次
        while (r1+r2< m) {
            // r1表示数组1已经移动的位数，r2表示数组2已经移动的位数,一共需要移动m位，已经移动r1+r2位，还需移动m-(r1+r2)位
            if (r1 == nums1.length) {
                // r1移动到了nums数组的最后，则只需要移动r2即可
                m_num = nums2[r2+m-(r1+r2)-1];
                break;
            }
            if (r2 == nums2.length) {
                // r2移动到了nums数组的最后，则只需要移动r1即可
                m_num = nums1[r1+m-(r1+r2)-1];
                break;
            }
            // 每次将较小的那个向前移动1位
            if (nums1[r1] <= nums2[r2]) {
                m_num = nums1[r1];
                r1++;
            } else {
                m_num = nums2[r2];
                r2++;
            }
        }
        // 根据m求n，要么n=m，要么n=m+1
        if (m == n) {
            n_num = m_num;
        } else {
            // n = m+1,将指针再向前移动一位即可
            if (r1 == nums1.length) {
                // r1 已经移动到最后，则将r2移动1位即可
                n_num = nums2[r2+m-(r1+r2)];
            } else if (r2 == nums2.length) {
                // r2 已经移动到最后，则将r2移动1位即可
                n_num = nums1[r1+m-(r1+r2)];
            } else {
                // 两者都没有移动到最后，则取小的那个即可
                n_num = nums1[r1] <=  nums2[r2] ? nums1[r1] : nums2[r2];
            }
        }
        res = (m_num+n_num)/2.0;
        return res;
    }
}
