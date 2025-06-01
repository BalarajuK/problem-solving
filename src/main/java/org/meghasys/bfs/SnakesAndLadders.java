package org.meghasys.bfs;

import java.util.*;

/**
 * 909. Snakes and Ladders
 */
public class SnakesAndLadders {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}
               // {-1,-1},{-1,3}
        };
        System.out.println(new SnakesAndLadders().snakesAndLadders(board));
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        // Cell number to point(i,j) with respect to matrix
        int[][] map = getCellMap(n);

        Queue<int[]> q = new ArrayDeque<>();
        // Cell position and steps
        q.offer(new int[]{1, 0});

        int destination = n * n;
        boolean[] visited = new boolean[destination + 1];
        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i = 1; i <= 6; i++) {
                int next = current[0] + i;
                int step = current[1] + 1;

                if(next>destination){
                    continue;
                }

                int[] point = map[next];
                int nextMove = getMove(board, next, point[0], point[1]);
                if (nextMove == destination) {
                    return step;
                }

                if (!visited[nextMove]) {
                    visited[nextMove] = true;
                    q.add(new int[]{nextMove, step});
                }
            }
        }
        return -1;
    }

    private static int getMove(int[][] board, int defaultVal, int i, int j) {
        return board[i][j] == -1 ? defaultVal : board[i][j];
    }

    private static int[][] getCellMap(int n) {
        int[][] cells = new int[n * n + 1][2];
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cols.add(i);
        }

        int l = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j : cols) {
                cells[l++] = new int[]{i, j};
            }
            Collections.reverse(cols);
        }
        return cells;
    }

}
