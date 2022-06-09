package class29;

import java.util.Arrays;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
 * Leetcode题目：https://leetcode.cn/problems/merge-intervals/
 * <p>
 * 知识点：
 */
public class Problem_0056_MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        // 对给定的数组进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 取出第一组的开始和结尾
        int s = intervals[0][0];
        int e = intervals[0][1];
        int size = 0;
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前数组的起始位置大于 e
            // 重新开一个段
            if (intervals[i][0] > e) {
                intervals[size][0] = s;
                intervals[size++][1] = e;
                s = intervals[i][0];
                e = intervals[i][1];
            }
            // 否则就把e向后推
            else {
                e = Math.max(e, intervals[i][1]);
            }
        }
        // 最后一组
        intervals[size][0] = s;
        intervals[size++][1] = e;
        return Arrays.copyOf(intervals, size);
    }

}
