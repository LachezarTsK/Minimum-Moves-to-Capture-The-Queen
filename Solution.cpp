
#include <cmath>
#include <array>
#include <algorithm>
using namespace std;

class Solution {

    inline static array<int, 2> MIN_MOVES_RANGE{ 1, 2 };

    int rookRow{};
    int rookColumn{};
    int bishopRow{};
    int bishopColumn{};
    int queenRow{};
    int queenColumn{};

public:
    int minMovesToCaptureTheQueen(int rookRow, int rookColumn, int bishopRow, int bishopColumn, int queenRow, int queenColumn) {
        this->rookRow = rookRow;
        this->rookColumn = rookColumn;
        this->bishopRow = bishopRow;
        this->bishopColumn = bishopColumn;
        this->queenRow = queenRow;
        this->queenColumn = queenColumn;

        if (rookAndQueenAreOnSameRowWithUnobstructedPath()
            || rookAndQueenAreOnSameColumnWithUnobstructedPath()
            || bishopAndQueenAreOnSameDiagonalWithUnobstructedPath()) {
            return MIN_MOVES_RANGE[0];
        }
        return MIN_MOVES_RANGE[1];
    }

private:
    bool rookAndQueenAreOnSameRowWithUnobstructedPath() {
        if (rookRow != queenRow) {
            return false;
        }
        if (bishopRow != queenRow) {
            return true;
        }

        int minColumn = min(rookColumn, queenColumn);
        int maxColumn = max(rookColumn, queenColumn);

        return bishopColumn < minColumn || bishopColumn > maxColumn;
    }

    bool rookAndQueenAreOnSameColumnWithUnobstructedPath() {
        if (rookColumn != queenColumn) {
            return false;
        }
        if (bishopColumn != queenColumn) {
            return true;
        }

        int minRow = min(rookRow, queenRow);
        int maxRow = max(rookRow, queenRow);

        return bishopRow < minRow || bishopRow > maxRow;
    }

    bool bishopAndQueenAreOnSameDiagonalWithUnobstructedPath() {
        if (abs(bishopRow - queenRow) != abs(bishopColumn - queenColumn)) {
            return false;
        }
        if (abs(bishopRow - rookRow) != abs(bishopColumn - rookColumn)) {
            return true;
        }

        int minRow = min(bishopRow, queenRow);
        int maxRow = max(bishopRow, queenRow);

        int minColumn = min(bishopColumn, queenColumn);
        int maxColumn = max(bishopColumn, queenColumn);

        return rookColumn < minColumn || rookColumn > maxColumn
               || rookRow < minRow || rookRow > maxRow;
    }
};
