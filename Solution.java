
public class Solution {

    private static final int[] MIN_MOVES_RANGE = {1, 2};

    private int rookRow;
    private int rookColumn;
    private int bishopRow;
    private int bishopColumn;
    private int queenRow;
    private int queenColumn;

    public int minMovesToCaptureTheQueen(int rookRow, int rookColumn, int bishopRow, int bishopColumn, int queenRow, int queenColumn) {
        this.rookRow = rookRow;
        this.rookColumn = rookColumn;
        this.bishopRow = bishopRow;
        this.bishopColumn = bishopColumn;
        this.queenRow = queenRow;
        this.queenColumn = queenColumn;

        if (rookAndQueenAreOnSameRowWithUnobstructedPath()
            || rookAndQueenAreOnSameColumnWithUnobstructedPath()
            || bishopAndQueenAreOnSameDiagonalWithUnobstructedPath()) {
            return MIN_MOVES_RANGE[0];
        }
        return MIN_MOVES_RANGE[1];
    }

    private boolean rookAndQueenAreOnSameRowWithUnobstructedPath() {
        if (rookRow != queenRow) {
            return false;
        }
        if (bishopRow != queenRow) {
            return true;
        }

        int minColumn = Math.min(rookColumn, queenColumn);
        int maxColumn = Math.max(rookColumn, queenColumn);

        return bishopColumn < minColumn || bishopColumn > maxColumn;
    }

    private boolean rookAndQueenAreOnSameColumnWithUnobstructedPath() {
        if (rookColumn != queenColumn) {
            return false;
        }
        if (bishopColumn != queenColumn) {
            return true;
        }

        int minRow = Math.min(rookRow, queenRow);
        int maxRow = Math.max(rookRow, queenRow);

        return bishopRow < minRow || bishopRow > maxRow;
    }

    private boolean bishopAndQueenAreOnSameDiagonalWithUnobstructedPath() {
        if (Math.abs(bishopRow - queenRow) != Math.abs(bishopColumn - queenColumn)) {
            return false;
        }
        if (Math.abs(bishopRow - rookRow) != Math.abs(bishopColumn - rookColumn)) {
            return true;
        }

        int minRow = Math.min(bishopRow, queenRow);
        int maxRow = Math.max(bishopRow, queenRow);

        int minColumn = Math.min(bishopColumn, queenColumn);
        int maxColumn = Math.max(bishopColumn, queenColumn);

        return rookColumn < minColumn || rookColumn > maxColumn
                || rookRow < minRow || rookRow > maxRow;
    }
}
