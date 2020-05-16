
// Dealer has their own random deck, returns their deck when dealing
public class Dealer {

	private final String NAME = "Dealer";
	private Deck deck;
	
	// Create deck and populate with cards
	public Dealer() {
		deck = new Deck();
		for (int i = 0; i < 52; i++) {
			deck.addRandomCard();
		}
	}
	
	private String printDeck() {
		return deck.toString();
	}
	
	// Returns deck, so it can be passed into the Player hit() method
	public Deck deal() {
		return deck; // may have to change this if deck doesn't change after removal
	}
	
}
