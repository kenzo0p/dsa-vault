package Neetcode250.graphs;

public class surroundedRegions {
    private final int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private void dfs(int i, int j, int m, int n, char board[][]) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '$';

        for (int dir[] : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            dfs(newI, newJ, m, n, board);
        }

    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // check for upper row
        // bottom row
        for (int col = 0; col < n; col++) {
            dfs(0, col, m, n, board);
            dfs(m - 1, col, m, n, board);
        }
        // check for left
        // col right
        for (int row = 0; row < m; row++) {
            dfs(row, 0, m, n, board);
            dfs(row, n - 1, m, n, board);

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '$')
                    board[i][j] = 'O';
            }
        }
    }

}
