package PYQ.Zoho.Advance;
//  Dungeon Master – Shortest Path in Grid
import java.util.*;
// Dungeon Master – Shortest Path in Grid
// 🧠 Problem Statement (Zoho Style Framing)

// You are given a 2D dungeon represented as a grid.

// Each cell can be:

// 'S' → Start position

// 'E' → Exit position

// '.' → Open path

// '#' → Wall (blocked)

// You can move in 4 directions:

// Up

// Down

// Left

// Right

// Your task:

// Find the minimum number of steps required to reach Exit from Start.

// If it is impossible → print "Trapped!"

// 📦 Constraints

// Grid size: N × M

// Movement allowed only inside grid

// Cannot pass through walls

// Each move costs 1 step

// Return shortest path length

// 🎯 What Zoho Evaluates

// Grid modeling

// BFS usage

// Visited tracking

// Edge case handling

// Clean structure

// 🧠 Correct Approach (Important)

// This is a classic BFS problem because:

// We want shortest path in an unweighted graph.

// Each cell = node.

// Each move = edge of weight 1.

// DFS ❌ (not guaranteed shortest)
// BFS ✅ (guarantees shortest in unweighted graph)

// 🏗️ Design Strategy

// We will use:

// Queue for BFS

// boolean[][] visited

// Direction arrays

// Class to represent position

public class DungeonMaster {

    static class Cell {
        int row;
        int col;
        int steps;

        Cell(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    static class Dungeon {

        char[][] grid;
        int rows;
        int cols;

        int[] dRow = { -1, 1, 0, 0 };
        int[] dCol = { 0, 0, -1, 1 };

        Dungeon(char[][] grid) {
            this.grid = grid;
            this.rows = grid.length;
            this.cols = grid[0].length;
        }

        int shortestPath() {

            boolean[][] visited = new boolean[rows][cols];
            Queue<Cell> queue = new LinkedList<>();

            int startRow = -1, startCol = -1;

            // Find Start
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 'S') {
                        startRow = i;
                        startCol = j;
                    }
                }
            }

            if (startRow == -1)
                return -1;

            queue.add(new Cell(startRow, startCol, 0));
            visited[startRow][startCol] = true;

            while (!queue.isEmpty()) {

                Cell current = queue.poll();

                if (grid[current.row][current.col] == 'E') {
                    return current.steps;
                }

                for (int i = 0; i < 4; i++) {

                    int newRow = current.row + dRow[i];
                    int newCol = current.col + dCol[i];

                    if (isValid(newRow, newCol, visited)) {
                        visited[newRow][newCol] = true;
                        queue.add(new Cell(newRow, newCol,
                                current.steps + 1));
                    }
                }
            }

            return -1; // No path
        }

        boolean isValid(int r, int c, boolean[][] visited) {
            return r >= 0 && r < rows &&
                    c >= 0 && c < cols &&
                    !visited[r][c] &&
                    grid[r][c] != '#';
        }
    }

    public static void main(String[] args) {

        char[][] grid = {
                { 'S', '.', '.', '#' },
                { '.', '#', '.', '.' },
                { '.', '#', '.', '#' },
                { '.', '.', '.', 'E' }
        };

        Dungeon dungeon = new Dungeon(grid);

        int result = dungeon.shortestPath();

        if (result == -1)
            System.out.println("Trapped!");
        else
            System.out.println("Escaped in " + result + " steps.");
    }
}
