package year2025.january;

public class SolveTheSudoku {
    public static void main(String[] args) {


    }

    static void solveSudoku(int[][] mat) {

        solve(mat, 0, 0);

    }

    private static boolean solve(int[][] board, int row, int col) {
        // If we reach the last cell, Sudoku is solved
        if (row == 9) return true;

        // Move to next row if column exceeds 8
        if (col == 9) return solve(board, row + 1, 0);

        // Skip filled cells
        if (board[row][col] != 0) return solve(board, row, col + 1);

        // Try placing numbers from 1 to 9
        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;  // Place the number
                if (solve(board, row, col + 1)) return true; // Recur
                board[row][col] = 0; // Backtrack
            }
        }
        return false; // No valid number found, backtrack
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
        }

        // Check 3x3 sub-grid
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) return false;
            }
        }

        return true;
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
