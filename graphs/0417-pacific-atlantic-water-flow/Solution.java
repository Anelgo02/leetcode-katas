import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * There is an m x n rectangular island that borders both the Pacific Ocean and
     * Atlantic Ocean. The Pacific Ocean touches the island's left and top edges,
     * and the Atlantic Ocean touches the island's right and bottom edges.
     * 
     * The island is partitioned into a grid of square cells. You are given an m x n
     * integer matrix heights where heights[r][c] represents the height above sea
     * level of the cell at coordinate (r, c).
     * 
     * The island receives a lot of rain, and the rain water can flow to neighboring
     * cells directly north, south, east, and west if the neighboring cell's height
     * is less than or equal to the current cell's height. Water can flow from any
     * cell adjacent to an ocean into the ocean.
     * 
     * Return a 2D list of grid coordinates result where result[i] = [ri, ci]
     * denotes that rain water can flow from cell (ri, ci) to both the Pacific and
     * Atlantic oceans.
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        //first I get the dimensions of the matrix
        int m = heights.length, n = heights[0].length; //rows and columns
        //I create two matrices to keep track of the cells that can reach each ocean
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        //I create a list to store the result
        List<List<Integer>> result = new ArrayList<>();
        //I perform DFS from the cells adjacent to the Pacific Ocean (top and left edges)

        //this cicle will iterate over the rows of the first column (left edge) and the last column (right edge)
        for (int i=0;i<m;i++){
            dfs(heights, pacific, i, 0, heights[i][0]);
            dfs(heights, atlantic,i, n-1, heights[i][n-1]);
        }

        //this cicle will iterate over the columns of the first row (top edge) and the last row (bottom edge)
        for(int j=0;j<n;j++){
            dfs(heights, pacific, 0, j, heights[0][j]);
            dfs(heights,atlantic,m-1, j, heights[m-1][j]);    
        }

        //I iterate through the entire matrix to find cells that can reach both oceans
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight){
        int m = heights.length, n = heights[0].length;
        //check for out of bounds
        if(r<0 || r>=m || c<0 || c>=n) return;
        //check if the cell has been visited or if the height is less than the previous cell
        if(visited[r][c] || heights[r][c]<prevHeight) return;

        //if not visited, mark it as visited
        visited[r][c] = true;
        //perform DFS in all four directions
        dfs(heights, visited, r+1, c, heights[r][c]); //down
        dfs(heights, visited, r-1, c, heights[r][c]); //up
        dfs(heights, visited, r, c+1, heights[r][c]); //right
        dfs(heights, visited, r, c-1, heights[r][c]); //left

    }

}
