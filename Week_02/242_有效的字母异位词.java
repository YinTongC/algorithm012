/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
class Solution {

	// 排序后比较
	// 时间复杂度：O(n).
	// 空间复杂度：O(n).
    public boolean isAnagram1(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] ss = s.toCharArray();
		char[] ts = t.toCharArray();
		Arrays.sort(ss);
		Arrays.sort(ts);
		for (int i = 0; i < ss.length; i++) {
			if (ss[i] != ts[i]) {
				return false;
			}
		}
		return true;
    }

	// 硬比较
    public boolean isAnagram2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] ts = t.toCharArray();
		for (int i = 0; i < ts.length; i++) {
			s = s.replaceFirst(String.valueOf(t.charAt(i)), "");
		}
		return "".equals(s);
    }

    // 减法
    public boolean isAnagram3(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
		while (s.length() != 0) {
			t = t.replace(s.substring(0, 1), "");
			s = s.replace(s.substring(0, 1), "");
			if (t.length() != s.length()) {
				return false;
			}
		}
		return true;
    }
}