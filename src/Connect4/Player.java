package Connect4;

public class Player {
	private String name;
	private char disc;

	public Player() {

	}

	public Player(String name, char disc) {
		this.name = name;
		this.disc = disc;
	}

	@Override
	public String toString() {
		return "Player " + "\nName = " + name + "\nDiscColor = " + disc + "\n";
	}

	public String enterPlayerName() {
		System.out.print("Enter Player's Name: ");
		return Main.scanner.nextLine(); // Read the entire line for the name
	}

	public char enterDiscColor() {
		char color;
		do {
			System.out.print("Choose Player's Disc Color(Yellow/Red): ");
			color = Main.scanner.next().toLowerCase().charAt(0);
			Main.scanner.nextLine();

			if ((color != 'y') && (color != 'r')) {
				System.out.println(
						"Invalid color entered. Please choose Yellow or Red.");
			}
		} while (((color != 'y') && (color != 'r')));

		return color;
	}

	public static Player createPlayer(short playerNb) {
		Player p = new Player();
		System.out.println("\n*** Player " + playerNb + " ***");
		// Read Player Name
		p.setName(p.enterPlayerName());
		// Read Player's Disc Color
		p.setDisc(p.enterDiscColor());
		return p;
	}

	public static void checkPlayer2DiscColor(Player p1, Player p2) {
		while (p1.getDisc() == p2.getDisc()) {
			System.out.println(
					"Sorry! Can't choose the " + p1.getDisc() + " Color");
			p2.setDisc(p2.enterDiscColor());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getDisc() {
		return disc;
	}

	public void setDisc(char disc) {
		this.disc = disc;
	}

}
