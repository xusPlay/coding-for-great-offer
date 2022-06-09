package class28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词指字母相同，但排列不同的字符串。
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * Leetcode题目：https://leetcode.cn/problems/group-anagrams/
 */
public class Problem_0049_GroupAnagrams {

    public static List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] record = new int[26];
            for (char cha : str.toCharArray()) {
                record[cha - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int value : record) {
                builder.append(String.valueOf(value)).append("_");
            }
            String key = builder.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }

}
