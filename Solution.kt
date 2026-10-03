
import kotlin.math.abs
import kotlin.math.min
import kotlin.math.max

class Solution {

    private companion object {
        val MIN_MOVES_RANGE = intArrayOf(1, 2)
    }

    private var rookRow = 0
    private var rookColumn = 0
    private var bishopRow = 0
    private var bishopColumn = 0
    private var queenRow = 0
    private var queenColumn = 0

    fun minMovesToCaptureTheQueen(rookRow: Int, rookColumn: Int, bishopRow: Int, bishopColumn: Int, queenRow: Int, queenColumn: Int): Int {
        this.rookRow = rookRow
        this.rookColumn = rookColumn
        this.bishopRow = bishopRow
        this.bishopColumn = bishopColumn
        this.queenRow = queenRow
        this.queenColumn = queenColumn

        if (rookAndQueenAreOnSameRowWithUnobstructedPath()
            || rookAndQueenAreOnSameColumnWithUnobstructedPath()
            || bishopAndQueenAreOnSameDiagonalWithUnobstructedPath()) {
            return MIN_MOVES_RANGE[0]
        }
        return MIN_MOVES_RANGE[1]
    }

    private fun rookAndQueenAreOnSameRowWithUnobstructedPath(): Boolean {
        if (rookRow != queenRow) {
            return false
        }
        if (bishopRow != queenRow) {
            return true
        }

        val minColumn = min(rookColumn, queenColumn)
        val maxColumn = max(rookColumn, queenColumn)

        return bishopColumn < minColumn || bishopColumn > maxColumn
    }

    private fun rookAndQueenAreOnSameColumnWithUnobstructedPath(): Boolean {
        if (rookColumn != queenColumn) {
            return false
        }
        if (bishopColumn != queenColumn) {
            return true
        }

        val minRow = min(rookRow, queenRow)
        val maxRow = max(rookRow, queenRow)

        return bishopRow < minRow || bishopRow > maxRow
    }

    private fun bishopAndQueenAreOnSameDiagonalWithUnobstructedPath(): Boolean {
        if (abs(bishopRow - queenRow) != abs(bishopColumn - queenColumn)) {
            return false
        }
        if (abs(bishopRow - rookRow) != abs(bishopColumn - rookColumn)) {
            return true
        }

        val minRow = min(bishopRow, queenRow)
        val maxRow = max(bishopRow, queenRow)

        val minColumn = min(bishopColumn, queenColumn)
        val maxColumn = max(bishopColumn, queenColumn)

        return rookColumn < minColumn || rookColumn > maxColumn
               || rookRow < minRow || rookRow > maxRow
    }
}
