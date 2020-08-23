/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 70. 爬楼梯
   假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
   每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
   注意：给定 n 是一个正整数
 */
class Solution {
	// DP
	public static int climbStairs(int n) {
		int lest1 = 0, lest2 = 0, ans = 1;
		for (int i = 1; i <= n; ++i) {
			lest1 = lest2;
			lest2 = ans;
			ans = lest1 + lest2;
		}
		return ans;
	}
}