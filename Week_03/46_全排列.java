/**
 * https://leetcode-cn.com/problems/permutations/
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> array = new ArrayList<Integer>();
		dfs(ans, array, nums, 0);
		return ans;
	}

	private void dfs(List<List<Integer>> ans, List<Integer> array, int[] nums, int n) {
		// 如果n等于nums的长度, 说明该排列已经完成
		if (n == nums.length) {
			ans.add(array);
			return;
		}

		for (int i = 0, size = array.size(); i <= size; i++) {
			// 生成array的副本共array.size + 1 个,这样是为了可以想array中插入nums中的第n个数
			List<Integer> _temp = new ArrayList<Integer>(array);
			_temp.add(i, nums[n]);
			dfs(ans, _temp, nums, n + 1);
		}
		return;
	}
}