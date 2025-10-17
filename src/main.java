public class main {

    public static void main(String[] args) {
        Board gameBoard = new Board();
        gameBoard.printBoard();

        gameBoard.setMove(0, 0, 'X');
        gameBoard.setMove(1, 1, 'O');

        gameBoard.printBoard();

        System.out.println("Game Status: " + gameBoard.getStatus());
    }

}
