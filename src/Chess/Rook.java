package Chess;

public class Rook extends ChessPiece{
	public Rook(String color) {
		super(color);
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
		this.check = false;

		//проверка, что в рамках доски ход
		if (toLine > 7 || toColumn > 7 || toLine < 0 || toColumn < 0 || (toLine == line && toColumn == column)) return false;
		//проверка, что ход идёт строго по вертикали, либо строго по горизонтали
		else if ((toLine - line == 0 && toColumn - column !=0) || (toLine - line != 0 && toColumn - column == 0)) {

			//определяем нужно делать проверку по вертикали или диагонали.
			int direction = (toLine - line < 0 || toColumn - column < 0) ? -1 : 1;
			int start = (toLine - line != 0) ? line + direction : column + direction;
			int end = (toLine - line != 0) ? toLine : toColumn;


			//проходимся по намеченному пути ладьи и проверяем что нет фигур.
			while (start != end) {
				if (toLine - line != 0 && chessBoard.board[start][column] != null) {
					return false; // Возврат false, если на пути есть фигура при движении по вертикали
				} else if (toColumn - column != 0 && chessBoard.board[line][start] != null) {
					return false; // Возврат false, если на пути есть фигура при движении по горизонтали
				}
				start += direction;
			}

			return (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(getColor()));

		}


		return false;
	}

	@Override
	public String getSymbol() {
		return "R";
	}
}
