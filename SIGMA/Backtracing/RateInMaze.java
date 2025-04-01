public class RateInMaze {
    static int[] dr = { -1, +1, 0, 0 };
    static int[] dc = { 0, 0, +1, -1 };
    static char[] dir = { 'U', 'D', 'R', 'L' };

    public static void rec(int[][] maze, int row, int col, String path) {
        if (row >= maze.length || col >= maze.length || col < 0 || row < 0) {
            // matrix out of bound
            return;

        }
        if (maze[row][col] == -1 || maze[row][col] == 1) {
            // already visited or blocked cell
            return;
        }

        if (row == maze.length - 1 && col == maze.length - 1) { //
            System.out.println(path);
            return;
        }
        maze[row][col] = -1;// visit markres
        for (int idx = 0; idx < maze.length; idx++) {
            int nr = row + dr[idx];// new row
            int nc = col + dc[idx];// new col

            rec(maze, nr, nc, path + dir[idx]);
        }
        // jb sb log visited ho jaye lopp then unvisited mark kr do
        maze[row][col] = 0;// unvisit mark
    }

    public static void main(String[] args) {
        int mat[][] = { { 0, 0, 0, 1 }, { 0, 1, 0, 1 }, { 0, 0, 0, 0 }, { 0, 1, 1, 0 } };
        rec(mat, 0, 0, "");
    }
}