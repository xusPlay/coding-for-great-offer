package class28;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * Leetcode题目：https://leetcode.cn/problems/valid-parentheses/
 */
public class Problem_0020_ValidParentheses {

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] str = s.toCharArray();
        // 优化方案，使用数组替代栈，可以提高速度（优化常数时间）
        int N = str.length;
        char[] stack = new char[N];
        int size = 0;
        for (int i = 0; i < N; i++) {
            char cha = str[i];
            if (cha == '(' || cha == '[' || cha == '{') {
                stack[size++] = cha == '(' ? ')' : (cha == '[' ? ']' : '}');
            } else {
                if (size == 0) {
                    return false;
                }
                char last = stack[--size];
                if (cha != last) {
                    return false;
                }
            }
        }
        return size == 0;
    }

}
