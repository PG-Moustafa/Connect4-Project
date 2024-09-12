package Connect4;

public class InputHandler {

	public int getNumberBtn(int i, int j, String message) {
		int n = i;

		do {
			System.out.print(message);
			n = Main.scanner.nextInt();

			if (n < i || n > j)
				System.out.println("Invalid choice!");
		} while (n < i || n > j);

		Main.scanner.nextLine();
		return n;
	}

	public int getPlayerMove() {
		char choice = 'I';
		int num = 0; // the choice as a number;

		do {
			System.out.print("\nChoose A Column(A/ B/ C/ D/ E/ F/ G): ");
			choice = Main.scanner.next().toUpperCase().charAt(0);

			if ((choice != 'A') && (choice != 'B') && (choice != 'C')
					&& (choice != 'D') && (choice != 'E') && (choice != 'F')
					&& (choice != 'G')) {
				System.out.println("Invalid Column!");
			}
		} while ((choice != 'A') && (choice != 'B') && (choice != 'C')
				&& (choice != 'D') && (choice != 'E') && (choice != 'F')
				&& (choice != 'G'));

		Main.scanner.nextLine();

		switch (choice) {
			case 'A' :
				num = 0;
				break;
			case 'B' :
				num = 1;
				break;
			case 'C' :
				num = 2;
				break;
			case 'D' :
				num = 3;
				break;
			case 'E' :
				num = 4;
				break;
			case 'F' :
				num = 5;
				break;
			case 'G' :
				num = 6;
				break;
			default :
				System.out.println("Invalid choice");
		}
		return num;
	}

	// public boolean validateInput() {
	// return true;
	// }
}
