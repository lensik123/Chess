package Chess;

public class Horse extends ChessPiece{
	public Horse(String color) {
		super(color);
	}

	@Override
	public String getColor() {
		return this.color;
	}

	@Override
	public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

		if (toLine > 7 || toColumn > 7 || toLine < 0 || toColumn < 0 || (toLine == line && toColumn == column)) return false;

		int lineDiff = Math.abs(toLine - line);
		int columnDiff = Math.abs(toColumn - column);

		//ход коня
		if ((lineDiff == 2 && columnDiff == 1) || (lineDiff == 1 && columnDiff == 2)){

			//если фигура противоположного цвета, то съедает
			if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(getColor())) {
				return true;
			}

		}
		return false;
	}

	@Override
	public String getSymbol() {
		return "H";
	}


}
