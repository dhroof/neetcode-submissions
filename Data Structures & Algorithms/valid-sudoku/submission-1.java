class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row look up
        for (int i = 0; i < 9; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                if (!(board[i][j] >= '1' && board[i][j] <= '9')) {
                    continue;
                }
                map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
                if (map.get(board[i][j]) > 1) {
                    return false;
                }
            }
        }

        // column look up
        for (int i = 0; i < 9; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                if (!(board[j][i] >= '1' && board[j][i] <= '9')) {
                    continue;
                }
                map.put(board[j][i], map.getOrDefault(board[j][i], 0) + 1);
                if (map.get(board[j][i]) > 1) {
                    return false;
                }
            }
        }

        // grid look up
        for (int a = 0; a < 9; a += 3) {
            for (int b = 0; b < 9; b += 3) {
                Map<Character, Integer> map = new HashMap<>();
                for (int i = a; i < a + 3; i++) {
                    for (int j = b; j < b + 3; j++) {
                        if (!(board[i][j] >= '1' && board[i][j] <= '9')) {
                            continue;
                        }
                        map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
                        if (map.get(board[i][j]) > 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
