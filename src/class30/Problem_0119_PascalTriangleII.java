package class30;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 你可以优化你的算法到 O(1) 空间复杂度吗？
 * Leetcode题目 : https://leetcode.cn/problems/pascals-triangle-ii/
 */
public class Problem_0119_PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        // 类似空间压缩技巧
        // 从右向左更新
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                ans.set(j, ans.get(j - 1) + ans.get(j));
            }
            ans.add(1);
        }
        return ans;
    }

}
