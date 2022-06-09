package class32;

import java.util.HashMap;

/**
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 如果存在多个答案，只需返回 任意一个 。
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 * 示例 1：
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * 示例 2：
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * 示例 3：
 * 输入：numerator = 2, denominator = 3
 * 输出："0.(6)"
 * 示例 4：
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 * 示例 5：
 * 输入：numerator = 1, denominator = 5
 * 输出："0.2"
 * Leetcode题目 : https://leetcode.cn/problems/fraction-to-recurring-decimal/
 */
public class Problem_0166_FractionToRecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // 判断正负"+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // integral part
        // 小数点前的部分
        res.append(num / den);

        num %= den;
        // 说明整除了
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            //
            num *= 10;
            res.append(num / den);
            num %= den;
            // 循环开始了
            if (map.containsKey(num)) {
                int index = map.get(num);
                // 在一开始的位置插入一个(
                res.insert(index, "(");
                //
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(127, 999));
    }

}
