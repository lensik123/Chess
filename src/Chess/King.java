package Chess;

public class King extends ChessPiece{
	public King(String color) {
		super(color);
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
		this.check = false;
		if (toLine > 7 || toColumn > 7 || toLine < 0 || toColumn < 0 || (toLine == line && toColumn == column)) {
			return false;
		}

		int lineDiff = Math.abs(toLine - line);
		int columnDiff = Math.abs(toColumn - column);

		// Проверка на ход на одну клетку в любом направлении
		if (lineDiff <= 1 && columnDiff <= 1) {
			// Проверка на наличие фигуры на целевой клетке и если фигура противоположного цвета, то съедаем
			return (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(getColor()));
		}

		return false;

	}

	public boolean isUnderAttack(ChessBoard board, int line, int column) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				ChessPiece piece = board.board[i][j];
				if (piece != null && !piece.getColor().equals(getColor()) && piece.canMoveToPosition(board, i, j, line, column)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String getSymbol() {
		return "K";
	}
}
