package class33;

/**
 * 给定一个数n，所有人的编号从0到n-1
 * 给定一个函数 boolean know(int i, int j)，该函数表示i这个人认不认识j这个人，认识关系是单向的
 * 有了这个函数，你可以检查认识这件事情。
 * 规定何为明星？1）所有人都认识这个人。2）这个人不认识自己之外的所有人。那么这个人就是明星
 * 利用know函数，找到明星，返回明星的编号，如果没有明星返回-1。
 * Leetcode题目 : https://leetcode.cn/problems/find-the-celebrity/
 */
public class Problem_0277_FindTheCelebrity {

    // 提交时不要提交这个函数，因为默认系统会给你这个函数
    // knows方法，自己会认识自己
    public static boolean knows(int x, int i) {
        return true;
    }

    // 只提交下面的方法 0 ~ n-1
    public int findCelebrity(int n) {
        // 谁可能成为明星，谁就是cand

        int cand = 0;

        for (int i = 0; i < n; ++i) {
            // 如果cand认识i，cand一定不是明星，i变成候选
            // 如果cand不认识i，那么i一定不是明星
            if (knows(cand, i)) {
                cand = i;
            }
        }
        // cand是什么？唯一可能是明星的人！
        // 下一步就是验证，它到底是不是明星
        // 1) cand是不是不认识所有的人 cand...（右侧cand都不认识）
        // 所以，只用验证 ....cand的左侧即可
        for (int i = 0; i < cand; ++i) {
            if (knows(cand, i)) {
                return -1;
            }
        }
        // 2) 是不是所有的人都认识cand
        for (int i = 0; i < n; ++i) {
            if (!knows(i, cand)) {
                return -1;
            }
        }
        return cand;
    }

}
