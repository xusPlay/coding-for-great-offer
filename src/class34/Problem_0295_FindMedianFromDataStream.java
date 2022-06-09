package class34;

import java.util.PriorityQueue;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * Leetcode题目 : https://leetcode.cn/problems/find-median-from-data-stream/
 * <p>
 * <p>
 * 知识点：【堆】
 * <p>
 * 用两个堆，一个大根堆买一个小根堆
 */
public class Problem_0295_FindMedianFromDataStream {

    class MedianFinder {

        private PriorityQueue<Integer> maxh;
        private PriorityQueue<Integer> minh;

        public MedianFinder() {
            maxh = new PriorityQueue<>((a, b) -> b - a);
            minh = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            // 如果来的数值，小于大根堆堆顶元素，入大根堆
            if (maxh.isEmpty() || maxh.peek() >= num) {
                maxh.add(num);
            }
            // 大于等于大根堆堆顶元素，入小根堆
            else {
                minh.add(num);
            }
            // 调整两个堆
            balance();
        }

        /**
         * 找中位数
         *
         * @return
         */
        public double findMedian() {
            if (maxh.size() == minh.size()) {
                return (double) (maxh.peek() + minh.peek()) / 2;
            } else {
                return maxh.size() > minh.size() ? maxh.peek() : minh.peek();
            }
        }

        private void balance() {
            // 如果两个堆的大小相差等于2，弹出多得，塞进小根堆
            if (Math.abs(maxh.size() - minh.size()) == 2) {
                if (maxh.size() > minh.size()) {
                    minh.add(maxh.poll());
                } else {
                    maxh.add(minh.poll());
                }
            }
        }

    }

}