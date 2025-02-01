package year2025.january;

public class WordSearch {
    public static void main(String[] args) {

    }

    static public boolean isWordExist(char[][] board, String word) {
        // Code here

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j]; // Save the original value
        board[i][j] = '*'; // Mark as visited

        boolean found = dfs(board, i + 1, j, word, index + 1) || // Down
                dfs(board, i - 1, j, word, index + 1) || // Up
                dfs(board, i, j + 1, word, index + 1) || // Right
                dfs(board, i, j - 1, word, index + 1);  // Left

        board[i][j] = temp; // Restore the original value
        return found;
    }

}
