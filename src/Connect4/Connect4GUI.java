package Connect4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Connect4GUI extends JFrame {
	private Board board;
	private Player[] players;
	private int currentPlayer;
	private JButton[][] buttons;
	private JLabel statusLabel;

	public Connect4GUI() {
		board = new Board();
		players = new Player[2];
		buttons = new JButton[board.getROWS()][board.getCOLS()];
		currentPlayer = 0;

		setTitle("Connect4 Game");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(board.getROWS(), board.getCOLS()));
		initializeBoardButtons(boardPanel);

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(1, 3));
		initializeControlButtons(controlPanel);

		statusLabel = new JLabel(
				"Welcome to Connect4! Click 'Start Game' to begin.");
		add(statusLabel, BorderLayout.NORTH);
		add(boardPanel, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.SOUTH);
	}

	private void initializeBoardButtons(JPanel boardPanel) {
		for (int row = 0; row < board.getROWS(); row++) {
			for (int col = 0; col < board.getCOLS(); col++) {
				JButton button = new JButton();
				button.setPreferredSize(new Dimension(80, 80));
				button.setBackground(Color.WHITE);
				final int column = col; // Needed for the action listener
				button.addActionListener(e -> handleButtonClick(column));
				buttons[row][col] = button;
				boardPanel.add(button);
			}
		}
	}

	private void initializeControlButtons(JPanel controlPanel) {
		JButton startButton = new JButton("Start Game");
		startButton.addActionListener(e -> startGame());

		JButton restartButton = new JButton("Restart Game");
		restartButton.addActionListener(e -> restartGame());

		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(e -> System.exit(0));

		controlPanel.add(startButton);
		controlPanel.add(restartButton);
		controlPanel.add(exitButton);
	}

	private void handleButtonClick(int col) {
		Player player = players[currentPlayer];
		if (board.dropDisc(col, player.getDisc())) {
			updateBoard();
			if (board.hasWinner(board, player)) {
				statusLabel.setText(player.getName() + " Wins!");
				disableBoard();
			} else if (board.isFull()) {
				statusLabel.setText("The board is full. It's a draw!");
				disableBoard();
			} else {
				switchTurn();
				statusLabel.setText(players[currentPlayer].getName()
						+ "'s turn. Disc: " + players[currentPlayer].getDisc());
			}
		} else {
			JOptionPane.showMessageDialog(this,
					"Column is full. Choose a different column.");
		}
	}

	private void updateBoard() {
		char[][] grid = board.getGrid();
		for (int row = 0; row < board.getROWS(); row++) {
			for (int col = 0; col < board.getCOLS(); col++) {
				if (grid[row][col] == 'Y') {
					buttons[row][col].setBackground(Color.YELLOW);
				} else if (grid[row][col] == 'R') {
					buttons[row][col].setBackground(Color.RED);
				} else {
					buttons[row][col].setBackground(Color.WHITE);
				}
			}
		}
	}

	private void disableBoard() {
		for (JButton[] buttonRow : buttons) {
			for (JButton button : buttonRow) {
				button.setEnabled(false);
			}
		}
	}

	private void switchTurn() {
		currentPlayer = (currentPlayer + 1) % 2;
	}

	private void startGame() {
		createPlayers();
		statusLabel.setText(players[currentPlayer].getName() + "'s turn. Disc: "
				+ players[currentPlayer].getDisc());
		enableBoard();
	}

	private void restartGame() {
		board = new Board();
		currentPlayer = 0;
		statusLabel.setText("Game restarted. "
				+ players[currentPlayer].getName() + "'s turn.");
		updateBoard();
		enableBoard();
	}

	private void enableBoard() {
		for (JButton[] buttonRow : buttons) {
			for (JButton button : buttonRow) {
				button.setEnabled(true);
			}
		}
	}

	private void createPlayers() {
		players[0] = new Player(
				JOptionPane.showInputDialog(this, "Enter Player 1 Name:"), 'Y');
		players[1] = new Player(
				JOptionPane.showInputDialog(this, "Enter Player 2 Name:"), 'R');
		if (players[0].getDisc() == players[1].getDisc()) {
			players[1].setDisc(players[1].getDisc() == 'Y' ? 'R' : 'Y');
		}
	}

}
