package class34;

/**
 * 给定一个字符串str，和一个正数k，返回字符种类不超过k种的最长子串长度。
 * Leetcode题目 : https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/
 * <p>
 * 知识点：【滑动窗口】
 *
 * 找到问题的单调性才能用滑动窗口
 */
public class Problem_0340_LongestSubstringWithAtMostKDistinctCharacters {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k < 1) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[] count = new int[256];
        int diff = 0;
        int R = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            // R 窗口的右边界
            while (R < N && (diff < k || (diff == k && count[str[R]] > 0))) {
                diff += count[str[R]] == 0 ? 1 : 0;
                count[str[R++]]++;
            }
            // R 来到违规的第一个位置
            ans = Math.max(ans, R - i);
            diff -= count[str[i]] == 1 ? 1 : 0;
            count[str[i]]--;
        }
        return ans;
    }

}
