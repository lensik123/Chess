package Chess;

public class Pawn extends ChessPiece{
	public Pawn(String color) {
		super(color);
	}

	@Override
	public String getColor() {
		return this.color;
	}

	@Override
	public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
		if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7 || (toLine == line && toColumn == column))
			return false;

		int lineDiff = toLine - line;
		int columnDiff = Math.abs(toColumn - column);

		ChessPiece targetPiece = chessBoard.board[toLine][toColumn];

		if (columnDiff > 0) {
			if (targetPiece != null && !targetPiece.getColor().equals(color))
				return (lineDiff == 1 && color.equals("White")) || (lineDiff == -1 && color.equals("Black"));
			else
				return false;
		} else if (columnDiff == 0) {
			if (targetPiece == null) {
				if (lineDiff == 1 && color.equals("White"))
					return true;
				else if (lineDiff == -1 && color.equals("Black"))
					return true;
				else if (lineDiff == 2 && color.equals("White") && line == 1)
					return true;
				else return lineDiff == -2 && color.equals("Black") && line == 6;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}



	@Override
	public String getSymbol() {
		return "P";
	}
}
