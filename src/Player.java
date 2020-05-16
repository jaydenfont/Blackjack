
public class Player {
	
	private Deck hand;
	private int currentTotal;
	private boolean busted;
	private boolean standing;
	private boolean twentyOne;
	
	public Player() {
		hand = new Deck();
		currentTotal = 0;
		busted = false;
		standing = false;
		twentyOne = false;
	}
	
	// prints hand
	public void hand() {
		System.out.println("Hand: " + hand);
		System.out.println("Total Value = " + currentTotal);
	}
	
	// removes top card from deck and adds to hand
	public boolean hit(Deck deck) {
		
		if (deck.isEmpty()) {
			return false;
		}
		int increment = hand.addCard(deck.removeCard());
		this.currentTotal += increment;
		
		System.out.println("Dealer has dealt: " + hand.showName());
		
		if (this.currentTotal > 21) {
			bust();
		}
		if (this.currentTotal == 21) {
			this.twentyOne = true;
		}
		return true;
	}
	
	// stand
	public void stand() {
		this.standing = true;
	}
	
	// player busts
	public void bust() {
			this.busted = true;
	}
	
	// returns whether or not player busted
	public boolean busted() {
		return this.busted;
	}
	
	// returns whether or not player stands
	public boolean isStanding() {
		return this.standing;
	}
	
	// returns whether or not player has reached 21
	public boolean equalsTwentyOne() {
		return this.twentyOne;
	}
	
	// returns the players total for later use
	public int showTotal() {
		return this.currentTotal;
	}

}
