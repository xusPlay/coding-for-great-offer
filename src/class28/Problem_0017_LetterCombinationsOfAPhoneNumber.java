package class28;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 按键2对应：'a', 'b', 'c'
 * 按键3对应：'d', 'e', 'f'
 * 按键4对应：'g', 'h', 'i'
 * 按键5对应：'j', 'k', 'l'
 * 按键6对应：'m', 'n', 'o'
 * 按键7对应：'p', 'q', 'r', 's'
 * 按键8对应：'t', 'u', 'v'
 * 按键9对应：'w', 'x', 'y', 'z'
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * Leetcode题目：https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 * <p>
 * <p>
 * 前缀树  +  深度优先遍历
 */
public class Problem_0017_LetterCombinationsOfAPhoneNumber {

    public static char[][] phone = {
            {'a', 'b', 'c'}, // 2    0
            {'d', 'e', 'f'}, // 3    1
            {'g', 'h', 'i'}, // 4    2
            {'j', 'k', 'l'}, // 5    3
            {'m', 'n', 'o'}, // 6
            {'p', 'q', 'r', 's'}, // 7
            {'t', 'u', 'v'},   // 8
            {'w', 'x', 'y', 'z'}, // 9
    };

    // "23"
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        char[] str = digits.toCharArray();
        char[] path = new char[str.length];
        process(str, 0, path, ans);
        return ans;
    }

    /**
     * @param str   按键字符串
     * @param index 来到哪个位置了
     * @param path  走过的字符串
     * @param ans   最终的答案
     */
    public static void process(char[] str, int index, char[] path, List<String> ans) {
        if (index == str.length) {
            ans.add(String.valueOf(path));
        } else {
            char[] cands = phone[str[index] - '2'];
            for (char cur : cands) {
                path[index] = cur;
                process(str, index + 1, path, ans);
            }
        }
    }

}
