package class28;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀，如果不存在公共前缀，返回空字符串 ""。
 * Leetcode题目：https://leetcode.cn/problems/longest-common-prefix/
 */
public class Problem_0014_LongestCommonPrefix {

    /**
     * 用一个变量维护最小的前缀长度
     * 挨个比较
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        char[] chs = strs[0].toCharArray();
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            int index = 0;
            while (index < tmp.length && index < chs.length) {
                if (chs[index] != tmp[index]) {
                    break;
                }
                index++;
            }
            min = Math.min(index, min);
            if (min == 0) {
                return "";
            }
        }
        return strs[0].substring(0, min);
    }

}
