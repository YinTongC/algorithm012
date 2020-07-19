/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 */
class Solution {

	// 暴力法
	// 时间复杂度：O(n).
	// 空间复杂度：O(n).
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// 边界值处理,预防空指针
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		// 取出使用值,排序后再放入新的链表中
		List<Integer> _tempArr = new ArrayList<>();
		while (l1 != null) {
			_tempArr.add(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			_tempArr.add(l2.val);
			l2 = l2.next;
		}
		int[] arr = _tempArr.stream().sorted().mapToInt(Integer::valueOf).toArray();

		ListNode rootNode = null;
		for (int i = arr.length - 1; i >= 0; i--) {
			ListNode _node = new ListNode(arr[i]);
			_node.next = rootNode;
			rootNode = _node;
		}
		return rootNode;
	}

	// 递归
	// 时间复杂度：O(n).
	// 空间复杂度：O(n).
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// 边界值处理,预防空指针
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next,l2);
			return l1;
		}else{
			l2.next = mergeTwoLists(l2.next,l1);
			return l2;
		}
	}

}