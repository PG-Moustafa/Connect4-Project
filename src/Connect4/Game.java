package Connect4;

public class Game {
	InputHandler inputHandler = new InputHandler();
	private Board board = new Board();
	private Player[] players;
	private int currentPlayer;

	public Game() {
		players = new Player[2];
		currentPlayer = 0;
	}

	public void printMainMenu() {
		System.out.println("*** Welcome To Connect4 Game ***");
		System.out.println("\n1. Start Game");
		System.out.println("2. Restart Game");
		System.out.println("3. Print Players Info");
		System.out.println("4. Exit");
	}

	// Check the user command
	public void open() {
		printMainMenu();
		int choice = inputHandler.getNumberBtn(1, 4,
				"Enter your choice please: ");

		switch (choice) {
			case 1 :
				createPlayers();
				start();
				break;
			case 2 :
				restart();
				break;
			case 3 :
				printAllPlayers();
				break;
			case 4 :
				close();
				break;
			default :
				System.out.println("Invalid choice!");
				open();
		}
	}

	// Start the game...
	void start() {
		while (!isGameOver()) {
			board.display();
			Player player = players[currentPlayer];
			System.out.println("\n" + player.getName() + "'s turn. Disc "
					+ player.getDisc());

			int column;
			boolean success;
			do {
				column = inputHandler.getPlayerMove();
				success = board.dropDisc(column, player.getDisc());
			} while (!success);

			if (board.hasWinner(board, player)) {
				board.display();
				System.out.println(player.getName() + " Wins!");
				break;
			}

			switchTurn();

		}
		if (board.isFull()) {
			System.out.println("The board is full. It's a draw!");
		}
	}

	// Create Player1 and Player2
	public void createPlayers() {
		players[0] = Player.createPlayer((short) 1);
		players[1] = Player.createPlayer((short) 2);

		Player.checkPlayer2DiscColor(players[0], players[1]);
	}

	// Print Players Info
	public void printAllPlayers() {
		System.out.println("\n***Print All Players***");
		System.out.println("- Player 1 -");
		System.out.println(players[0].toString());
		System.out.println("- Player 2 -");
		System.out.println(players[1].toString());
	}

	// Restart the game
	void restart() {
		board = new Board();
		currentPlayer = 0;
		start();
	}

	// Switch turn
	void switchTurn() {
		currentPlayer = (currentPlayer + 1) % 2;
	}

	// return true if Game Over
	boolean isGameOver() {
		return board.isFull() || board.hasWinner(board, players[0])
				|| board.hasWinner(board, players[1]);
	}

	// return the winner
	Player getWinner() {
		// Return the current player if he won
		if (board.hasWinner(board, players[0]))
			return players[0];
		if (board.hasWinner(board, players[1]))
			return players[1];
		return null;
	}

	// exit the application
	void close() {
		System.out
				.println("Thank you for playing Connect4! Exiting the game...");
		System.exit(0); // Exit the application
	}

}
