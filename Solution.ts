
function minMovesToCaptureTheQueen(rookRow: number, rookColumn: number, bishopRow: number, bishopColumn: number, queenRow: number, queenColumn: number): number {
    const movesCalculation = new MovesCalculation(rookRow, rookColumn, bishopRow, bishopColumn, queenRow, queenColumn);
    return movesCalculation.minMovesToCaptureTheQueen();
};


class MovesCalculation {

    static MIN_MOVES_RANGE = [1, 2];

    rookRow: number;
    rookColumn: number;
    bishopRow: number;
    bishopColumn: number;
    queenRow: number;
    queenColumn: number;

    constructor(rookRow: number, rookColumn: number, bishopRow: number, bishopColumn: number, queenRow: number, queenColumn: number) {
        this.rookRow = rookRow;
        this.rookColumn = rookColumn;
        this.bishopRow = bishopRow;
        this.bishopColumn = bishopColumn;
        this.queenRow = queenRow;
        this.queenColumn = queenColumn;
    }

    rookAndQueenAreOnSameRowWithUnobstructedPath(): boolean {
        if (this.rookRow !== this.queenRow) {
            return false;
        }
        if (this.bishopRow !== this.queenRow) {
            return true;
        }

        const minColumn = Math.min(this.rookColumn, this.queenColumn);
        const maxColumn = Math.max(this.rookColumn, this.queenColumn);

        return this.bishopColumn < minColumn || this.bishopColumn > maxColumn;
    }

    rookAndQueenAreOnSameColumnWithUnobstructedPath(): boolean {
        if (this.rookColumn !== this.queenColumn) {
            return false;
        }
        if (this.bishopColumn !== this.queenColumn) {
            return true;
        }

        const minRow = Math.min(this.rookRow, this.queenRow);
        const maxRow = Math.max(this.rookRow, this.queenRow);

        return this.bishopRow < minRow || this.bishopRow > maxRow;
    }

    bishopAndQueenAreOnSameDiagonalWithUnobstructedPath(): boolean {
        if (Math.abs(this.bishopRow - this.queenRow) !== Math.abs(this.bishopColumn - this.queenColumn)) {
            return false;
        }
        if (Math.abs(this.bishopRow - this.rookRow) !== Math.abs(this.bishopColumn - this.rookColumn)) {
            return true;
        }

        const minRow = Math.min(this.bishopRow, this.queenRow);
        const maxRow = Math.max(this.bishopRow, this.queenRow);

        const minColumn = Math.min(this.bishopColumn, this.queenColumn);
        const maxColumn = Math.max(this.bishopColumn, this.queenColumn);

        return this.rookColumn < minColumn || this.rookColumn > maxColumn
               || this.rookRow < minRow || this.rookRow > maxRow;
    }

    minMovesToCaptureTheQueen(): number {
        if (this.rookAndQueenAreOnSameRowWithUnobstructedPath()
            || this.rookAndQueenAreOnSameColumnWithUnobstructedPath()
            || this.bishopAndQueenAreOnSameDiagonalWithUnobstructedPath()) {
            return MovesCalculation.MIN_MOVES_RANGE[0];
        }
        return MovesCalculation.MIN_MOVES_RANGE[1];
    }
}
