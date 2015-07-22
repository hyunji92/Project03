package MazeStack2;

public class StackNode {

	protected int line; // 행을 저장할 변수
	protected int row;
	protected int move;
	protected StackNode link;
	
	public StackNode(int line, int row, int move){
		this.line = line;
		this.row = row;
		this.move = move;
		this.link = null;
	}
}
