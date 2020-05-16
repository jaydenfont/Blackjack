import java.util.Scanner;

public class Game {
	
	public static String namePrompt() {
		
		try {
			System.out.println("Please Enter Your Name: ");
			Scanner namePrompt = new Scanner(System.in);
			String name = namePrompt.next();
			
			if (name == null || name.equals("")) {
				throw new IllegalArgumentException();
			}
			return name;
		}
		catch (IllegalArgumentException e) {
			System.out.println("Please enter a name");
			return namePrompt();
		}
		
	}
	// Prompts user input, returns 0, 1, or 2 depending on the user choice
	public static int movePrompt() {
		try {
			Scanner playPrompt = new Scanner(System.in);
			int choice = playPrompt.nextInt();
			if (choice != 0 && choice != 1 && choice != 2) {
				throw new IllegalArgumentException("Invalid Response");
			}
			return choice;
		}
		catch (IllegalArgumentException e) {
			System.out.println("Try again (only enter 0, 1, or 2)");
			return movePrompt();
		}
	}
	
	public static void executeGame() {
		
		// Get Player name
		String name = namePrompt();
		
		// Construct dealer and player
		Dealer dealer = new Dealer();
		HumanPlayer player = new HumanPlayer(name);
		
		// Dealing first card
		System.out.println("Dealer has dealt the first card");
		System.out.println("");
		player.callHit(dealer.deal());
		
		// Game loop
		while (!(player.busted() || player.isStanding() || player.equalsTwentyOne())) { // deal until bust, blackjack, or player stops

			// Prompts
			System.out.println("");
			System.out.println("What is your next move? \nEnter 0 (view hand), 1 (hit) or 2 (stand)");
			int choice = movePrompt();
			
			// Shows hand
			if (choice == 0) {
				player.showHand();
			}
			
			// Hit
			if (choice == 1) {
				player.callHit(dealer.deal());
			}
			
			// Stand
			if (choice == 2) {
				player.callStand();
			}
			
		}
		
		// if player busts, they lose
		if (player.busted()) {
			player.showHand();
			player.lose();
		}
		
		// if player stands, peek at next card. If next card would've caused a bust, player wins.
		else if (player.isStanding()) {
			player.showHand();
			int nextCard = dealer.deal().showValue();
			int finalValue = player.showTotal() + nextCard;
			System.out.println("Value would have been: " + finalValue);
			if (finalValue > 21) {
				player.win();
			}
			else {
				player.lose();
			}
		}
		
		// If player's total = 21, they win
		else if (player.equalsTwentyOne()) {
			player.showHand();
			player.win();
		}
	}
	public static void main(String[] args) {
		executeGame();
	}

}
