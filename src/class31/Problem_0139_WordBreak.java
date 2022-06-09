package class31;

import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：拆分时可以重复使用字典中的单词。你可以假设字典中没有重复的单词。
 * Leetcode题目 : https://leetcode.cn/problems/word-break/
 * Lintcode题目 : https://www.lintcode.com/problem/107/
 * <p>
 * 知识点：【前缀树】
 */
// lintcode也有测试，数据量比leetcode大很多 : https://www.lintcode.com/problem/107/
public class Problem_0139_WordBreak {

    public static class Node {
        public boolean end;
        public Node[] nexts;

        public Node() {
            end = false;
            nexts = new Node[26];
        }
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        // 对单词表生成前缀树
        Node root = new Node();
        for (String str : wordDict) {
            char[] chs = str.toCharArray();
            Node node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Node();
                }
                node = node.nexts[index];
            }
            node.end = true;
        }



        char[] str = s.toCharArray();
        int N = str.length;
        boolean[] dp = new boolean[N + 1];
        dp[N] = true; // dp[i]  word[i.....] 能不能被分解
        // dp[N] word[N...]  -> ""  能不能够被分解
        // dp[i] ... dp[i+1....]
        for (int i = N - 1; i >= 0; i--) {
            // i
            // word[i....] 能不能够被分解
            // i..i    i+1....
            // i..i+1  i+2...
            Node cur = root;
            for (int end = i; end < N; end++) {
                cur = cur.nexts[str[end] - 'a'];
                if (cur == null) {
                    break;
                }
                // 有路！
                if (cur.end) {
                    // i...end 真的是一个有效的前缀串  end+1....  能不能被分解
                    dp[i] |= dp[end + 1];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }

    /**
     * 加强版：返回方法数
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static int wordBreak2(String s, List<String> wordDict) {
        Node root = new Node();
        for (String str : wordDict) {
            char[] chs = str.toCharArray();
            Node node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Node();
                }
                node = node.nexts[index];
            }
            node.end = true;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            Node cur = root;
            for (int end = i; end < N; end++) {
                cur = cur.nexts[str[end] - 'a'];
                if (cur == null) {
                    break;
                }
                if (cur.end) {
                    dp[i] += dp[end + 1];
                }
            }
        }
        return dp[0];
    }

}
