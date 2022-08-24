package class15;

//leetcode 188
public class Code04_BestTimeToBuyAndSellStockIV {

	public static int maxProfit(int K, int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int N = prices.length;
		if (K >= N / 2) {
			return allTrans(prices);
		}
		
		// dp[i][j] => arr[0...i]上完成j次交易获得的最大收益
		int[][] dp = new int[K + 1][N];

		int ans = 0;
		for (int tran = 1; tran <= K; tran++) {
			int pre = dp[tran][0];
			int best = pre - prices[0];
			for (int index = 1; index < N; index++) {
				pre = dp[tran - 1][index];
				dp[tran][index] = Math.max(dp[tran][index - 1], prices[index] + best);
				best = Math.max(best, pre - prices[index]);
				ans = Math.max(dp[tran][index], ans);
			}
		}
		return ans;
	}

	public static int allTrans(int[] prices) {
		int ans = 0;
		for (int i = 1; i < prices.length; i++) {
			ans += Math.max(prices[i] - prices[i - 1], 0);
		}
		return ans;
	}




	// 课上写的版本，对了
	public static int maxProfit2(int K, int[] arr) {
		if (arr == null || arr.length == 0 || K < 1) {
			return 0;
		}
		int N = arr.length;
		if (K >= N / 2) {
			return allTrans(arr);
		}
		// dp[i][j] => 一共有 i 天，完成 j 次交易获得的最大收益
		int[][] dp = new int[N][K + 1];
		// 第0列，肯定都是0， dp[...][0] = 0
		// 第0行，dp[0][...] = arr[0.0] 0
		for (int j = 1; j <= K; j++) {
			// dp[1][j]
			// i不参与交易
			int p1 = dp[0][j];

			// i参与交易，只能在0位置买入或者1位置买入
			int best = Math.max(dp[1][j - 1] - arr[1], dp[0][j - 1] - arr[0]);

			// 求两种情况的最大值
			dp[1][j] = Math.max(p1, best + arr[1]);


			// dp[1][j] 准备好一些枚举，接下来准备好的枚举
			for (int i = 2; i < N; i++) {

				// 不参与交易
				p1 = dp[i - 1][j];

				// 参与交易，假设在某位置买入
				int newP = dp[i][j - 1] - arr[i];
				best = Math.max(newP, best);


				// 两种情况求最大值
				dp[i][j] = Math.max(p1, best + arr[i]);
			}
		}
		return dp[N - 1][K];
	}

}
