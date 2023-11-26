package Chess;

public class Bishop extends ChessPiece{
	public Bishop(String color) {
		super(color);
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
		if (toLine > 7 || toColumn > 7 || toLine < 0 || toColumn < 0 || (toLine == line && toColumn == column)) return false;

		if (Math.abs(toLine - line) == Math.abs(toColumn - column)){

			int directionLine = (toLine - line > 0) ? 1 : -1;
			int directionColumn = (toColumn - column > 0) ? 1 : -1;

			int currentLine = directionLine + line;
			int currentColumn = directionColumn + column;

			while (currentLine != toLine && currentColumn != toColumn){
				if(chessBoard.board[currentLine][currentColumn] != null){
					return false;
				}

				currentLine += directionLine;
				currentColumn += directionColumn;
			}

			return (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(getColor()));

		}

		return false;
	}

	@Override
	public String getSymbol() {
		return "B";
	}
}
