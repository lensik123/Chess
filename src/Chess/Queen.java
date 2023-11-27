package Chess;

public class Queen extends ChessPiece{
	public Queen(String color) {
		super(color);
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

		//проверка что ход в рамках доски и не на одном месте
		if (toLine > 7 || toColumn > 7 || toLine < 0 || toColumn < 0 || (toLine == line && toColumn == column)) return false;


		//если ход королевы по вертикали/горизонтали
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
			// Проверка на наличие фигуры на целевой клетке и если фигура противоположного цвета, то съедаем
			return (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(getColor()));

		}

		//если ход королевы по диагонали.
		else if (Math.abs(toLine - line) == Math.abs(toColumn - column)){

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
			//если фигура противоположного цвета, то съедает
			return (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(getColor()));

		}
		return false;

	}

	@Override
	public String getSymbol() {
		return "Q";
	}

}
