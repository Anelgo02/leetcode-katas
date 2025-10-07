import java.util.PriorityQueue;

public class Solution {

    /*
     * You are given an n x n integer matrix grid where each value grid[i][j]
     * represents the elevation at that point (i, j).
     * 
     * It starts raining, and water gradually rises over time. At time t, the water
     * level is t, meaning any cell with elevation less than equal to t is submerged
     * or reachable.
     * 
     * You can swim from a square to another 4-directionally adjacent square if and
     * only if the elevation of both squares individually are at most t. You can
     * swim infinite distances in zero time. Of course, you must stay within the
     * boundaries of the grid during your swim.
     * 
     * Return the minimum time until you can reach the bottom right square (n - 1, n
     * - 1) if you start at the top left square (0, 0).
     */

    // approach: Dijkstra's algorithm(not sum but max element time) with a priority
    // queue to always expand the least costly node first

    public int swimInWater(int[][] grid) {

        return dijkstraMinHeight(grid);
    }

    private int dijkstraMinHeight(int[][] grid) {
        int n = grid.length;
        int maxHeight = 0; //highest water level we have passed

        // directions for moving up, down, left, right
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // min-heap priority queue to store (time, row, col)
        // we want to expand the node with the smallest time first
        // we use a lambda function to compare the first element of the arrays in order
        // to have the minimum time at the top of the heap
        // also we will store in the queue arrays like [time, row, col]

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // visited array to keep track of visited cells
        boolean[][] visited = new boolean[n][n];

        // we start from top left and we want to reach bottom right
        pq.offer(new int[] { grid[0][0], 0, 0 });
        visited[0][0] = true;

        while (!pq.isEmpty()) {

            int[] cell = pq.poll(); // extract the min-element of the heap
            int h = cell[0];
            int r = cell[1];
            int c = cell[2];
            visited[r][c] = true;

            maxHeight = Math.max(maxHeight, h); // update the cost with the minimum level we need to have to reach the cell

            if (r == n - 1 && c == n - 1) {
                return maxHeight;
            }

            // expand to adjacents cells with bound controls and visit control
            for (int[] x : dirs) {
                int nr = r + x[0];
                int nc = c + x[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) {
                    // add to the heap and mark as visited
                    pq.offer(new int[] { grid[nr][nc], nr, nc });
                    visited[nr][nc] = true;

                }
            }

        }

        return -1;
    }

}
