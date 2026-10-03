
using System;

public class Solution
{
    private static readonly int[] MIN_MOVES_RANGE = { 1, 2 };

    private int rookRow;
    private int rookColumn;
    private int bishopRow;
    private int bishopColumn;
    private int queenRow;
    private int queenColumn;


    public int MinMovesToCaptureTheQueen(int rookRow, int rookColumn, int bishopRow, int bishopColumn, int queenRow, int queenColumn)
    {
        this.rookRow = rookRow;
        this.rookColumn = rookColumn;
        this.bishopRow = bishopRow;
        this.bishopColumn = bishopColumn;
        this.queenRow = queenRow;
        this.queenColumn = queenColumn;

        if (RookAndQueenAreOnSameRowWithUnobstructedPath()
                || RookAndQueenAreOnSameColumnWithUnobstructedPath()
                || BishopAndQueenAreOnSameDiagonalWithUnobstructedPath())
        {
            return MIN_MOVES_RANGE[0];
        }
        return MIN_MOVES_RANGE[1];
    }

    private bool RookAndQueenAreOnSameRowWithUnobstructedPath()
    {
        if (rookRow != queenRow)
        {
            return false;
        }
        if (bishopRow != queenRow)
        {
            return true;
        }

        int minColumn = Math.Min(rookColumn, queenColumn);
        int maxColumn = Math.Max(rookColumn, queenColumn);

        return bishopColumn < minColumn || bishopColumn > maxColumn;
    }

    private bool RookAndQueenAreOnSameColumnWithUnobstructedPath()
    {
        if (rookColumn != queenColumn)
        {
            return false;
        }
        if (bishopColumn != queenColumn)
        {
            return true;
        }

        int minRow = Math.Min(rookRow, queenRow);
        int maxRow = Math.Max(rookRow, queenRow);

        return bishopRow < minRow || bishopRow > maxRow;
    }

    private bool BishopAndQueenAreOnSameDiagonalWithUnobstructedPath()
    {
        if (Math.Abs(bishopRow - queenRow) != Math.Abs(bishopColumn - queenColumn))
        {
            return false;
        }
        if (Math.Abs(bishopRow - rookRow) != Math.Abs(bishopColumn - rookColumn))
        {
            return true;
        }

        int minRow = Math.Min(bishopRow, queenRow);
        int maxRow = Math.Max(bishopRow, queenRow);

        int minColumn = Math.Min(bishopColumn, queenColumn);
        int maxColumn = Math.Max(bishopColumn, queenColumn);

        return rookColumn < minColumn || rookColumn > maxColumn
                || rookRow < minRow || rookRow > maxRow;
    }
}
