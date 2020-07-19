/**
 * https://leetcode-cn.com/problems/two-sum/
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
class Solution {

	// 暴力法
    public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (target - nums[i] == nums[j]) {
					return new int[] { i, j };
				}
			}
		}

		return new int[] {};
    }
    

	// 哈希法
    public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			numMap.put(nums[i], i);
		}
		int firstNum;
		for (int i = 0; i < nums.length; i++) {
			firstNum = target - nums[i];
			if (numMap.containsKey(firstNum) && numMap.get(firstNum) != i) {
				return new int[] { i, numMap.get(firstNum) };
			}
		}
		return new int[] {};
    }
}