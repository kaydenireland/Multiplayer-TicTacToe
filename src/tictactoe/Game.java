package tictactoe;

public class Game {

    Board board;
    char currentPlayer;
    Result gameResult;
    boolean gameOver;

    public Game() {
        board = new Board();
        currentPlayer = 'X';
        gameResult = Result.InProgress;
        gameOver = false;
    }

    // Getters and Setters

    public Board getBoard() {
        return board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public Result getResult() {
        return gameResult;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void reset() {
        board.clear();
        currentPlayer = 'X';
        gameResult = Result.InProgress;
        gameOver = false;
    }

    // Functional Methods

    public boolean makeMove(int row, int col) {
        if (board.isValidMove(row, col) && !gameOver) {
            board.setMove(row, col, currentPlayer);
            if (board.checkGameOver()) {
                gameOver = true;
                gameResult = (currentPlayer == 'X') ? Result.X_Wins : Result.O_Wins;
            } else if (board.isFull()) {
                gameOver = true;
                gameResult = Result.Draw;
            } else {
                switchPlayer();
            }
            return true;
        }
        return false;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

}
