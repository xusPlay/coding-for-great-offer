package class31;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 说明：分隔时可以重复使用字典中的单词。你可以假设字典中没有重复的单词。
 * 示例 1：
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 示例 2：
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * Leetcode题目 : https://leetcode.cn/problems/word-break-ii/
 */
public class Problem_0140_WordBreakII {

    public static class Node {
        public String path;
        public boolean end;
        public Node[] nexts;

        public Node() {
            path = null;
            end = false;
            nexts = new Node[26];
        }
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        char[] str = s.toCharArray();
        Node root = gettrie(wordDict);
        boolean[] dp = getdp(s, root);
        ArrayList<String> path = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        process(str, 0, root, dp, path, ans);
        return ans;
    }

    // str[index.....] 是要搞定的字符串
    // dp[0...N-1] 0... 1.... 2... N-1... 在dp里
    // root 单词表所有单词生成的前缀树头节点
    // path str[0..index-1]做过决定了，做的决定放在path里
    public static void process(char[] str, int index, Node root, boolean[] dp, ArrayList<String> path,
                               List<String> ans) {
        // 来到了终止位置
        if (index == str.length) {
            StringBuilder builder = new StringBuilder();
            // 为了最后一个单词不加空格  所以是 path.size()-1
            for (int i = 0; i < path.size() - 1; i++) {
                builder.append(path.get(i)).append(" ");
            }
            builder.append(path.get(path.size() - 1));
            ans.add(builder.toString());
        } else {
            Node cur = root;
            // 枚举 i ... end
            for (int end = index; end < str.length; end++) {
                // str[i..end] （能不能拆出来）
                int road = str[end] - 'a';
                if (cur.nexts[road] == null) {
                    break;
                }
                cur = cur.nexts[road];

                // 剪枝条件：
                // cur.end => 单词表中存在当前词（前缀树）
                // dp[end + 1] => 后面的字符串能够分解（dp表）
                // 满足以上两条，才能走这条路
                if (cur.end && dp[end + 1]) {
                    // [i...end] 前缀串
                    // str.subString(i,end+1)  [i..end]
                    // 增加现场
                    path.add(cur.path);
                    // 深度优先遍历
                    process(str, end + 1, root, dp, path, ans);
                    // 恢复现场
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public static Node gettrie(List<String> wordDict) {
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
            node.path = str;
            node.end = true;
        }
        return root;
    }

    public static boolean[] getdp(String s, Node root) {
        char[] str = s.toCharArray();
        int N = str.length;
        boolean[] dp = new boolean[N + 1];
        dp[N] = true;
        for (int i = N - 1; i >= 0; i--) {
            Node cur = root;
            for (int end = i; end < N; end++) {
                int path = str[end] - 'a';
                if (cur.nexts[path] == null) {
                    break;
                }
                cur = cur.nexts[path];
                if (cur.end && dp[end + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp;
    }

}
