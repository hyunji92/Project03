package MazeStack;

public class Maze {
	static final int[][] option = { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, -1 },
			{ -1, 0 }, { 0, -1 }, { -1, 1 }, { -1, -1 } };

	public static void main(String[] argv) {
		int[][] maze = { { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0 },
				{ 0, 1, 1, 1, 0, 1, 1, 0, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 1, 0, 0, 0, 1, 1 },
				{ 1, 1, 1, 1, 0, 0, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 0, 1, 1, 1, 0, 0 },
				{ 1, 0, 1, 1, 1, 1, 1, 0, 1, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 1, 1, 0 } };

		byte[][] visited = new byte[maze.length][maze[0].length];
		int[] stack = new int[3 * maze.length * maze[0].length];
		int top = 0;

		stack[top++] = 0; // x 
		stack[top++] = 0; // y 
		stack[top++] = 1; // direction
		OUT: while (top != 0) {
			int dir = stack[--top];
			int y = stack[--top];
			int x = stack[--top];
			while (dir < 8) {
				int nextX = x + option[dir][0];
				int nextY = y + option[dir][1];
				if (nextX == maze.length - 1 && nextY == maze[0].length - 1) {
					break OUT;
				}
				if (maze[nextX][nextY] == 0 && visited[nextX][nextY] == 0) {
					visited[x][y] = 1;
					stack[top++] = x;
					stack[top++] = y;
					stack[top++] = ++dir;
					x = nextX;
					y = nextY;
					dir = 0;
				} else
					dir++;
			}
		}
		for (int i = 0; i < top; i += 3) { // mark path
			maze[stack[i]][stack[i + 1]] = 2;
		}
		System.out.println("IN");
		for (int i = 0; i < maze.length; i++) { // print map
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println("OUT");
			System.out.println();
			
		}
	}
}