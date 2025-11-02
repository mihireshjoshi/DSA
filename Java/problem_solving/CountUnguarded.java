//2257. Count Unguarded Cells in the Grid
//You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.
//
//A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.
//
//Return the number of unoccupied cells that are not guarded.
//
//Example 1
//Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
//Output: 7
//Explanation: The guarded and unguarded cells are shown in red and green respectively in the above diagram.
//There are a total of 7 unguarded cells, so we return 7.


package Java.problem_solving;

public class CountUnguarded {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for(int[] guard: guards) {
            grid[guard[0]][guard[1]] = 3;
        }
        for(int[] wall: walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        int ret = guards.length + walls.length;

        for(int[] guard: guards) {
            int i = guard[0];
            int j = guard[1];
            //right
            for(int c = j + 1; c < n; c++){
                if(grid[i][c] == 2 || grid[i][c] == 3) break;
                if(grid[i][c] != 1){
                    grid[i][c] = 1;
                    ret++;
                }
            }

            //left
            for(int c = j - 1; c >= 0; c--){
                if(grid[i][c] == 2 || grid[i][c] == 3) break;
                if(grid[i][c] != 1){
                    grid[i][c] = 1;
                    ret++;
                }
            }

            //down
            for(int r = i + 1; r < m; r++){
                if(grid[r][j] == 2 || grid[r][j] == 3) break;
                if(grid[r][j] != 1){
                    grid[r][j] = 1;
                    ret++;
                }
            }

            //up
            for(int r = i-+ 1; r >= 0; r--){
                if(grid[r][j] == 2 || grid[r][j] == 3) break;
                if(grid[r][j] != 1){
                    grid[r][j] = 1;
                    ret++;
                }
            }

        }

        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         System.out.print(grid[i][j] + "\t");
        //     }
        //     System.out.println();
        // }

        return m*n-ret;
    }

    public static void main(String[] args) {
        CountUnguarded countUnguarded = new CountUnguarded();
        int m = 4;
        int n = 6;
        int[][] guards = {{0,0},{1,1},{2,3}};
        int[][] walls = {{0,1},{2,2},{1,4}};
        int ret = countUnguarded.countUnguarded(m, n, guards, walls);
        System.out.println(ret);
    }

    // Using while loop:
    public int countUnguardedWhile(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for(int[] guard: guards) {
            grid[guard[0]][guard[1]] = 3;
        }
        for(int[] wall: walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        int ret = guards.length + walls.length;

        for(int[] guard: guards) {
            int i = guard[0];
            int j = guard[1];
            //right
            j++;
            while(j < n && grid[i][j] != 2 && grid[i][j] != 3){
                if(grid[i][j] == 0){
                    grid[i][j] = 1;
                    ret++;
                }
                j++;
            }

            j = guard[1];

            //left
            j--;
            while(j >= 0 && grid[i][j] != 2 && grid[i][j] != 3){
                if(grid[i][j] == 0){
                    grid[i][j] = 1;
                    ret++;
                }
                j--;
            }

            j = guard[1];

            //down
            i++;
            while(i < m && grid[i][j] != 2 && grid[i][j] != 3){
                if(grid[i][j] == 0){
                    grid[i][j] = 1;
                    ret++;
                }
                i++;
            }

            i = guard[0];

            //up
            i--;
            while(i >= 0 && grid[i][j] != 2 && grid[i][j] != 3){
                if(grid[i][j] == 0){
                    grid[i][j] = 1;
                    ret++;
                }
                i--;
            }

        }

        return m*n-ret;
    }

}
