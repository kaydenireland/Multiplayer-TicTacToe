public class Board {

    char[][] board;

    public Board() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Getters and Setters

    public char[][] getBoard() {
        return board;
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Functional Methods

    public void setMove(int row, int col, char player) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            board[row][col] = player;
        }
    }

    public boolean canMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            return board[row][col] == '-';
        }
        return false;
    }

    public boolean checkGameOver() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public Result getStatus() {
        if (checkGameOver()) {
            // Check who won
            for (int i = 0; i < 3; i++) {
                if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                    return board[i][0] == 'X' ? Result.X_Wins : Result.O_Wins;
                }
                if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                    return board[0][i] == 'X' ? Result.X_Wins : Result.O_Wins;
                }
            }
            if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                return board[0][0] == 'X' ? Result.X_Wins : Result.O_Wins;
            }
            if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                return board[0][2] == 'X' ? Result.X_Wins : Result.O_Wins;
            }
        } else if (isFull()) {
            return Result.Draw;
        }
        return Result.InProgress;
    }

}
