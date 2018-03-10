
public class Balloons {

	public static void main(String[] args) {    
		int[] nums = {3, 1 , 5, 8};
		int[][] opt = new int[nums.length][nums.length];
		
		for (int length = 1; length <= nums.length; length++) {
			for (int left = 0; left <= nums.length - length; left++) {
				int right = left + length - 1;
				for (int k = left; k <= right; k++) {
					//opt[left][k-1]  + opt[k+1][right] + nums[k] * nums[left-1] * nums[right+1]
					int q = k - 1 < left ? 0 : opt[left][k - 1];
					int p = k + 1 > right ? 0 : opt[k + 1][right];
					
					opt[left][right] = Math.max(opt[left][right],q + p + 
							(getBalloonValue(nums, k) * getBalloonValue(nums, left-1) * getBalloonValue(nums, right+1)));
				}
			}
		}
		System.out.println(opt[0][nums.length - 1]);
	}
	/*
	 * Helper method to handle boundary cases
	 */
	public static int getBalloonValue(int[] nums, int index) {
		return (index < 0 || index >= nums.length) ?  1 : nums[index];
	}
}
