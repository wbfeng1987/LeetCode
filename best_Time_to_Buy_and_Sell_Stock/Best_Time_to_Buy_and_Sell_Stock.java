package best_Time_to_Buy_and_Sell_Stock;

public class Best_Time_to_Buy_and_Sell_Stock {

	public static int maxProfit(int[] prices) {
		
		if (prices.length == 0) return 0;
		
		int profit = 0;
		int min = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			}
			if (profit < prices[i] - min) {
				profit = prices[i] - min;
			}
		}
		return profit;
	}
	
	public static void main(String[] args) {
		int[] prices = {2, 3, 8, 4, 3, 1, 9, 5, 1, 3};
		System.out.println(maxProfit(prices));
	}
}
