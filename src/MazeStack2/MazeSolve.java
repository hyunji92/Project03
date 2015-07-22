package MazeStack2;

public class MazeSolve {

	private StackNode top;
	
	int maze[][] = { { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0 },
			{ 0, 1, 1, 1, 0, 1, 1, 0, 1, 1 },
			{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 0, 1, 1, 1, 1, 1, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 0, 1, 1 },
			{ 1, 1, 1, 0, 1, 0, 0, 0, 1, 1 },
			{ 1, 1, 1, 1, 0, 0, 1, 1, 1, 0 },
			{ 0, 1, 0, 0, 0, 1, 1, 1, 0, 0 },
			{ 1, 0, 1, 1, 1, 1, 1, 0, 1, 0 },
			{ 1, 0, 0, 0, 0, 0, 0, 1, 1, 0 } };
	int mark[][];
	int move[][] =  { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, -1 },
			{ -1, 0 }, { 0, -1 }, { -1, 1 }, { -1, -1 } };
	final int m = 10, n = 10 ;
	

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
	
	public static void main(String args[]){
		MazeSolve ms = new MazeSolve();
		ms.init();
		ms.path();
		
	}
	
	void init(){
		mark = new int[m+2][n+2];
		for(int i=0;i < m+2 ; i++){
			for(int j =0; j< n+2; j++){
				mark[i][j] = 0;
			}
		}
	}
	
	void path(){
		int mCount = 1;
		mark[1][1] = mCount;
		int i, j, mov , g, h;
		StackNode temp; //pop한 결과를 저장할 StackNode포인터 
		
	}
}
