package class15;

//leetcode 123
public class Code03_BestTimeToBuyAndSellStockIII {

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int ans = 0;
		// 0位置做完1次交易并且买入的最佳结果
		int doneOnceMinusBuyMax = -prices[0];
		// 0位置做一次交易的最大收益
		int doneOnceMax = 0;

		int min = prices[0];

		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			ans = Math.max(ans, doneOnceMinusBuyMax + prices[i]);
			// 完成一次交易的最大收益
			doneOnceMax = Math.max(doneOnceMax, prices[i] - min);
			// 完成一次交易并且买入的最大收益
			doneOnceMinusBuyMax = Math.max(doneOnceMinusBuyMax, doneOnceMax - prices[i]);
		}
		return ans;
	}

}
