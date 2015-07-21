package MazeStack;

public class Maze {
	static final int[][] option = { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, -1 },
			{ -1, 0 }, { 0, -1 }, { -1, 1 }, { -1, -1 } };

	public static void main(String[] argv) {
		byte[][] move = { { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0 },
				{ 0, 1, 1, 1, 0, 1, 1, 0, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 1, 0, 0, 0, 1, 1 },
				{ 1, 1, 1, 1, 0, 0, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 0, 1, 1, 1, 0, 0 },
				{ 1, 0, 1, 1, 1, 1, 1, 0, 1, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 1, 1, 0 } };

		byte[][] visited = new byte[move.length][move[0].length];
		int[] stack = new int[3 * move.length * move[0].length];
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
				if (nextX == move.length - 1 && nextY == move[0].length - 1) {
					break OUT;
				}
				if (move[nextX][nextY] == 0 && visited[nextX][nextY] == 0) {
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
			move[stack[i]][stack[i + 1]] = 2;
		}
		System.out.println("IN");
		for (int i = 0; i < move.length; i++) { // print map
			for (int j = 0; j < move[i].length; j++) {
				System.out.print(move[i][j]);
			}
			System.out.println("OUT");
		}
	}
}