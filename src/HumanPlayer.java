
public class HumanPlayer extends Player{
	
	public String name;
	
	public HumanPlayer(String name) {
		super();
		this.name = name;
	}
	public void showHand() {
		this.hand();
	}
	
	public boolean callHit(Deck deck) {
		return this.hit(deck);	
	}
	
	public void callStand() {
		stand();
	}
	
	public void win() {
		System.out.println(this.name + " wins!");
	}
	
	public void lose() {
		System.out.println(this.name + " loses!");
	}

}
