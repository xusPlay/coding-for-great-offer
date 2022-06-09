package class28;

/**
 * 给定一个正整数 n ，输出的第 n 项。
 * 前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * 返回第N项的字符串
 * Leetcode题目：https://leetcode.cn/problems/count-and-say/
 */
public class Problem_0038_CountAndSay {

    public static String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        char[] last = countAndSay(n - 1).toCharArray();
        StringBuilder ans = new StringBuilder();
        int times = 1;
        for (int i = 1; i < last.length; i++) {
            if (last[i - 1] == last[i]) {
                times++;
            } else {
                ans.append(String.valueOf(times));
                ans.append(String.valueOf(last[i - 1]));
                times = 1;
            }
        }
        ans.append(String.valueOf(times));
        ans.append(String.valueOf(last[last.length - 1]));
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(20));
    }

}
