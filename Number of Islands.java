// Time Complexity: O(m × n)
// Every cell is visited once, either ignored (if '0') or processed (if '1').
// Each cell is added to the queue at most once.

// Space Complexity: O(min(m, n))
// In the worst case (when the island is long like a line), the queue can store up to min(m, n) elements at a time.

/*
Approach :
Traversal & Detection:
Loop through every cell in the grid.
If a cell is '1', it means we found a new island → increment count.
BFS Flood Fill:
Start BFS from the current cell.
Use a queue to explore all connected '1's (4 directions).
Convert every visited '1' into '0' to mark it as visited.
Edge Condition Handling:
Make sure we stay within bounds and only process unvisited land ('1').
BFS continues until all cells of the island are visited.
The grid is modified in-place, so no extra space for visited cells.
*/


class Solution {
    public int numIslands(char[][] grid) {
        int [][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int count=0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i < m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j] == '1'){
                    q.add(i);
                    q.add(j);
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int r = q.poll();
                        int c = q.poll();
                        for(int []dir : dirs){
                            int nr = r + dir[0];
                            int nc = c + dir[1];
                            if(nr > -1 && nr < m && nc >-1 && nc < n && grid[nr][nc] == '1'){
                                q.add(nr);
                                q.add(nc);
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
