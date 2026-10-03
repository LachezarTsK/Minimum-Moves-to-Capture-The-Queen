
package main
import "math"

var MIN_MOVES_RANGE = []int{1, 2}

var rookRow int
var rookColumn int
var bishopRow int
var bishopColumn int
var queenRow int
var queenColumn int

func minMovesToCaptureTheQueen(rRow int, rColumn int, bRow int, bColumn int, qRow int, qColumn int) int {
    rookRow = rRow
    rookColumn = rColumn
    bishopRow = bRow
    bishopColumn = bColumn
    queenRow = qRow
    queenColumn = qColumn

    if rookAndQueenAreOnSameRowWithUnobstructedPath() ||
       rookAndQueenAreOnSameColumnWithUnobstructedPath() ||
       bishopAndQueenAreOnSameDiagonalWithUnobstructedPath() {
       return MIN_MOVES_RANGE[0]
    }
    return MIN_MOVES_RANGE[1]
}

func rookAndQueenAreOnSameRowWithUnobstructedPath() bool {
    if rookRow != queenRow {
        return false
    }
    if bishopRow != queenRow {
        return true
    }

    minColumn := min(rookColumn, queenColumn)
    maxColumn := max(rookColumn, queenColumn)

    return bishopColumn < minColumn || bishopColumn > maxColumn
}

func rookAndQueenAreOnSameColumnWithUnobstructedPath() bool {
    if rookColumn != queenColumn {
            return false
    }
    if bishopColumn != queenColumn {
            return true
    }

    minRow := min(rookRow, queenRow)
    maxRow := max(rookRow, queenRow)

    return bishopRow < minRow || bishopRow > maxRow
}

func bishopAndQueenAreOnSameDiagonalWithUnobstructedPath() bool {
    if math.Abs(float64(bishopRow - queenRow)) != math.Abs(float64(bishopColumn - queenColumn)) {
        return false
    }
    if math.Abs(float64(bishopRow - rookRow)) != math.Abs(float64(bishopColumn - rookColumn)) {
        return true
    }

    minRow := min(bishopRow, queenRow)
    maxRow := max(bishopRow, queenRow)

    minColumn := min(bishopColumn, queenColumn)
    maxColumn := max(bishopColumn, queenColumn)

    return rookColumn < minColumn || rookColumn > maxColumn ||
           rookRow < minRow || rookRow > maxRow
}
