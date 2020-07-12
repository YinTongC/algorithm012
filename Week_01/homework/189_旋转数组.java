/**
 * https://leetcode-cn.com/problems/rotate-array/solution/
 * 189. 旋转数组 
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 */
class Solution {

	// 暴力法  
	// 时间复杂度：O(n*k)。每个元素都被移动 1 步（O(n)） k次（O(k)） 。
	// 空间复杂度：O(1) 。没有额外空间被使用
    public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return;
		}
		k %= nums.length;
		int _num;
		for (int i = 0; i < k; i++) {
			_num = nums[nums.length - 1];
			for (int j = nums.length - 1; j > 0; j--) {
				nums[j] = nums[j - 1];
			}
			nums[0] = _num;
		}
    }

    // 不知道怎么归类法,猜测是因为计算量大,所以比翻转法慢
	// 时间复杂度：O(n) 。只遍历了每个元素一次。
	// 空间复杂度：O(1) 。使用了常数个额外空间
    public void rotate2(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return;
		}
		k %= nums.length;
		int[] _num = new int[k];
		for (int i = 0; i < k; i++) {
			_num[i] = nums[nums.length - 1 - i];
			for (int j = nums.length - 1 - i; j > 0; j -= k) {
				if (j - k >= 0) {
					nums[j] = nums[j - k];
				}
			}
		}
		for (int i = 0; i < k; i++) {
			nums[k - i - 1] = _num[i];
		}
    }

    // 翻转法
    // 时间复杂度：O(n) 。每个元素被翻转了2次。
	// 空间复杂度：O(1) 。没有使用额外的空间
    public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return;
		}
		k %= nums.length;
		turn(nums, 0, nums.length - 1);
		turn(nums, 0, k - 1);
		turn(nums, k, nums.length - 1);
    }

	private void turn(int[] nums, int start, int end) {
		int _temp;
		while (end > start) {
			_temp = nums[start];
			nums[start] = nums[end];
			nums[end] = _temp;
			start++;
			end--;
		}
	}    
}