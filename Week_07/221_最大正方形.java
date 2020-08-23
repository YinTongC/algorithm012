/**
 * https://leetcode-cn.com/problems/valid-sudoku/
 * 36. 有效的数独
   判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
   数字 1-9 在每一行只能出现一次。
   数字 1-9 在每一列只能出现一次。
   数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
class Solution {
	public boolean isValidSudoku(char[][] board) {
	    int [] vset = new int [9];
	    int [] hset = new int [9];
	    int [] bckt = new int [9];
	    int idx = 0;
	    for (int i = 0; i < 9; i++) {
	        for (int j = 0; j < 9; j++) {
	            if (board[i][j] != '.') {
	                idx = 1 << (board[i][j] - '0') ;
	                if ((hset[i] & idx) > 0 ||
	                    (vset[j] & idx) > 0 ||
	                    (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
	                hset[i] |= idx;
	                vset[j] |= idx;
	                bckt[(i / 3) * 3 + j / 3] |= idx;
	            }
	        }
	    }
	    return true;
	}
}