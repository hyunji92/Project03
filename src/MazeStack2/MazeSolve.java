package MazeStack2;

public class MazeSolve {

	private StackNode top;

	int maze[][] = { { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0 },
			{ 0, 1, 1, 1, 0, 1, 1, 0, 1, 1 }, { 0, 1, 1, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 0, 1, 1, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1, 1, 1, 0, 1, 1 },
			{ 1, 1, 1, 0, 1, 0, 0, 0, 1, 1 }, { 1, 1, 1, 1, 0, 0, 1, 1, 1, 0 },
			{ 0, 1, 0, 0, 0, 1, 1, 1, 0, 0 }, { 1, 0, 1, 1, 1, 1, 1, 0, 1, 0 },
			{ 1, 0, 0, 0, 0, 0, 0, 1, 1, 0 } };
	int mark[][];
	int move[][] = { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 0 },
			{ 0, -1 }, { -1, 1 }, { -1, -1 } };
	final int m = 10, n = 10;

	private void push(int line, int row, int move) {

		StackNode stacknode = new StackNode(line, row, move);
		if (isEmpty()) {
			top = stacknode;
		} else {
			stacknode.link = top;
		}

	}

	private StackNode pop() {
		if (isEmpty()) {
			return null;

		} else {
			StackNode popNode = top;
			top = top.link;
			return popNode;
		}
	}

	private boolean isEmpty() {
		return (top == null);
	}

	public static void main(String args[]) {
		MazeSolve ms = new MazeSolve();
		ms.init();
		ms.path();

	}

	void init() {
		mark = new int[m + 2][n + 2];
		for (int i = 0; i < m + 2; i++) {
			for (int j = 0; j < n + 2; j++) {
				mark[i][j] = 0;
			}
		}
	}

	void path() {
		int mCount = 1;
		mark[1][1] = mCount;
		int i, j, mov, g, h;
		StackNode temp; // pop한 결과를 저장할 StackNode포인터

		push(1, 1, 2);

		while (top != null) {
			temp = pop();
			i = temp.line;
			j = temp.row;
			mov = temp.move;

			while (mov <= 8) {
				g = i + move[mov][0];
				h = j + move[mov][1];

				if (g == m && h == n) {
					mark[g][h] = mCount++;
					push(i, j, mov);
					System.out.println("maze");
					printArray();
					printStack();
				}
				if (maze[g][h] == 0 && mark[g][h] == 0) {
					mark[g][h] = mCount++;
					push(i, j, mov);
					mov = 0;
					i = g;
					j = h;
				}
				mov = mov + 1;
			}
		}
	}

	void printStack() {
		StackNode temp = pop();
		int count = 1;
		System.out.println("stack");

		do {
			System.out.printf("%2d. Line : %d , Row : %d , Move : %d\n",
					count++, temp.line, temp.row, temp.move);
		} while (temp != null);
		System.out.println();
	}

	void printArray() {

		for (int i=0; i<maze.length ; i++){
			for(int j = 0 ; j< maze[0].length ; j++){
				if(i == 1 && j == 1){
					System.out.println(" S ");
				}else if(i == m && j == n){
					System.out.println(" E ");
				}else{
					if(mark[i][j] != 0){
						if(mark[i][j]/10 == 0){
							System.out.printf("0%d ", mark[i][j]);
						}else{
							System.out.printf("%2d ", mark[i][j]);
						}
					}else{
						if(maze[i][j] == 0){
							System.out.print("   ");
						}else{
							System.out.print("##  ");
						}
					}
				}
			}
			System.out.println();
		}
		System.out.println();
	}

}
