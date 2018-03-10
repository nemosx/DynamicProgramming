public class CoinGameDynamicProgramming {

	public static int computeMaxScore(int arr[], int n) {
		// Create opt table to store solutions of subproblems
		int opt[][] = new int[n][n];
	
		for (int intervalLength = 2; intervalLength <= n; intervalLength += 2) {
			for (int i = 0, j = i + intervalLength - 1; i <= n - intervalLength; ++i, j = i + intervalLength - 1) {
				// Base Case
				if (intervalLength == 2) {
					opt[i][j] = Math.max(arr[i], arr[j]);
				} else {
					int x = opt[i + 1][j - 1];
					int y = opt[i + 2][j];
					int z = opt[i][j - 2];

					opt[i][j] = Math.max(arr[i] + Math.min(y, x), arr[j] + Math.min(x, z));
				}
			}
		}
		return opt[0][n - 1];
	}

	/*
	 * Test cases taken from https://www.geeksforgeeks.org/dynamic-programming-set-31-optimal-strategy-for-a-game/
	 */
	public static void main(String[] args) {
		int arr1[] = { 8, 15, 3, 7 };
		int n = arr1.length;
		System.out.println("" + computeMaxScore(arr1, n));

		int arr2[] = { 2, 2, 2, 2 };
		n = arr2.length;
		System.out.println("" + computeMaxScore(arr2, n));

		int arr3[] = { 20, 30, 2, 2, 2, 10 };
		n = arr3.length;
		System.out.println("" + computeMaxScore(arr3, n));
	}
}