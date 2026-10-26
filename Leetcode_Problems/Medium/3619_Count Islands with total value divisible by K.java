class Solution {
    public int countIslands(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int eligibleIslands = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] > 0) {
                    long islandSum = dfs(grid, r, c);
                    if (islandSum % k == 0) {
                        eligibleIslands++;
                    }
                }
            }
        }
        return eligibleIslands;
    }

    private long dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] <= 0)
            return 0;
        long currentVal = grid[r][c];
        grid[r][c] = 0;
        long totalSum = currentVal;
        totalSum += dfs(grid, r + 1, c);
        totalSum += dfs(grid, r - 1, c);
        totalSum += dfs(grid, r, c + 1);
        totalSum += dfs(grid, r, c - 1);
        return totalSum;
    }
}
