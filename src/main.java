import tictactoe.*;

public class main {

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Tic-Tac-Toe Game Initialized!");

        int row, col;

        while (!game.isGameOver()) {
            System.out.println("Current Player: " + game.getCurrentPlayer());
            game.getBoard().print();

            // Here you would get input from the user for row and col
            // For demonstration, we'll use random moves
            row = (int) (Math.random() * 3);
            col = (int) (Math.random() * 3);
            System.out.println("\nAttempting move at (" + row + ", " + col + ")");
            if (!game.makeMove(row, col)) {
                System.out.println("Invalid move. Try again.");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Game Over! Result: " + game.getResult());
        game.getBoard().print();
    }

}
