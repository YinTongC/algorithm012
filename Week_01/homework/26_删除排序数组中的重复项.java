/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组，并在使用 O(1) 额外空间的条件下完成。
 */
class Solution {
	// 双指针法
	// 时间复杂度：O(n)。
	// 空间复杂度：O(1)。
    public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int maxIndex = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1] && i - maxIndex > 1) {
				nums[++maxIndex] = nums[i];
			}
		}
		return maxIndex;
    }
}