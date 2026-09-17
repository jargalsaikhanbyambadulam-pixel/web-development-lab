public class NQueens {

    static int N = 4;

    public static boolean isSafe(char[][] board, int row, int col) {

        // Зүүн тал шалгах
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q')
                return false;
        }

        // Дээд диагональ
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Доод диагональ
        for (int i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    public static boolean solve(char[][] board, int col) {

        // Бүх бэрс тавигдсан
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col)) {

                board[i][col] = 'Q';

                if (solve(board, col + 1))
                    return true;

                // Backtracking
                board[i][col] = '.';
            }
        }

        return false;
    }

    public static void printBoard(char[][] board) {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        char[][] board = new char[N][N];

        // Хоосон board
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '.';
            }
        }

        if (solve(board, 0)) {

            System.out.println("Shiidel:");
            printBoard(board);

        } else {

            System.out.println("Shiidel oldsongv.");
        }
    }
}