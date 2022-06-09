package class28;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * Leetcode题目：https://leetcode.cn/problems/generate-parentheses/
 * <p>
 * 知识点：【剪枝】
 */
public class Problem_0022_GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        char[] path = new char[n << 1];
        List<String> ans = new ArrayList<>();
        process(path, 0, 0, n, ans);
        return ans;
    }


    // path 做的决定  path[0....index-1]做完决定的！
    // path[index.....] 还没做决定，当前轮到index位置做决定！

    /**
     * 需要剪枝
     *
     * @param path           之前做的决定
     * @param index          当前来到index位置
     * @param leftMinusRight 之前做的决定中 左括号 减 有括号 的数量
     * @param leftRest       左括号还剩几个
     * @param ans            最后的结果
     */
    public static void process(char[] path, int index, int leftMinusRight, int leftRest, List<String> ans) {
        // 决定已经做完了
        if (index == path.length) {
            ans.add(String.valueOf(path));
        } else {
            // index 要放 ( 或者  )
            // 剩余的左括号大于0 才能放左括号
            if (leftRest > 0) {
                path[index] = '(';
                process(path, index + 1, leftMinusRight + 1, leftRest - 1, ans);
            }
            // 左括号减右括号数量大于0才能放 有括号
            if (leftMinusRight > 0) {
                path[index] = ')';
                process(path, index + 1, leftMinusRight - 1, leftRest, ans);
            }
        }
    }

    // 不剪枝的做法
    public static List<String> generateParenthesis2(int n) {
        char[] path = new char[n << 1];
        List<String> ans = new ArrayList<>();
        process2(path, 0, ans);
        return ans;
    }

    public static void process2(char[] path, int index, List<String> ans) {
        if (index == path.length) {
            if (isValid(path)) {
                ans.add(String.valueOf(path));
            }
        } else {
            path[index] = '(';
            process2(path, index + 1, ans);
            path[index] = ')';
            process2(path, index + 1, ans);
        }
    }

    public static boolean isValid(char[] path) {
        int count = 0;
        for (char cha : path) {
            if (cha == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

}
