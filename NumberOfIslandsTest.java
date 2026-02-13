import java.util.*;

public class NumberOfIslandsTest {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0'; // Mark as visited
        System.out.println("Visiting cell (" + r + ", " + c + ") and marking it as visited.");

        dfs(grid, r + 1, c); // Down
        dfs(grid, r - 1, c); // Up
        dfs(grid, r, c + 1); // Right
        dfs(grid, r, c - 1); // Left
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the grid (rows separated by new lines, '1' for land and '0' for water):");
        List<char[]> gridList = new ArrayList<>();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            gridList.add(line.toCharArray());
        }
        char[][] grid = gridList.toArray(new char[0][]);

        NumberOfIslandsTest test = new NumberOfIslandsTest();
        int result = test.numIslands(grid);
        System.out.println("Number of islands: " + result);
    }
}

