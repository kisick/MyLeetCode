package leetcode056;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/12/24 23:46
 */
public class leetcode056 {

    @Test
    public void test() {

    }

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> ansList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
            // 新增一个区间
            if (i == 0 || cur[0] > ansList.get(ansList.size()-1)[1]) {
                ansList.add(cur);
            } else {
                // 与前一个区间合并
                // list的最后一个元素
                int[] end = ansList.get(ansList.size() - 1);
                end[1] = Math.max(end[1],cur[1]);
            }
        }
        return ansList.toArray(new int[0][0]);
    }

    public int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
