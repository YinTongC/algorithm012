/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
class Solution {

	// 1.
	// 递归二叉树寻找到 p,q 并返回p,q的父节点数组(包括自己),然后用其中一个数组按深度判断是否在另一个数组中
	// 有想法但是没有写 

	// 2.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	// 找到p或者q,到了最深处还是没找到则返回null
		if (root == null || root.val == p.val || root.val == q.val) return root;

		// 递归查找,得到的值可以确定当前root的左右子节点是否是p或q的父节点
		TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
		TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

		// 如果左子节点为null,则返回右子节点,右子节点是null也无所谓,因为左右子节点都为null的时候也要返回null 
		if(leftNode==null) return rightNode;
		// 如果右子节点为null,则返回左子节点,因为左右子节点都为null的时候也要返回null
		if(rightNode==null) return leftNode;
		// 如果左右子节点都不为null,则说明当前root是p,q的最近公共祖先
		return root;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */