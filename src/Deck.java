import java.util.*;

public class Deck {
	
	// Deck is a stack object containing cards, which are nodes of a linked list
	// Each card A, 2 ... through to K will appear 4 times in a 52 card deck
	// The size of the deck must be a multiple of the amount of card ranks there are, so that they
	// all appear evenly in the deck. For a normal set, there are 13 ranks, so the deck must be 
	// equal to any multiple of 13
	
	// create inner class for card/node
	private class Card {
		
		private String cardName; // rank of card
		private int value; // value of card in game
		private Card nextCard; // reference to next card in deck
		
	
		// used to pair string type with integer value
		private int findMatch(String type) {
			int index = 0;
			for (int i = 0; i < Deck.cardRanks.length-1; i++) {
				if (Deck.cardRanks[i] == type) {
					index = i;
				}	
			}
			return Deck.values[index];
		}
		
		// recursively, randomly chooses a type of card to add to deck
		private String randomType() {
			Random typeChoice = new Random();
			int cardIndex = typeChoice.nextInt(13);
			
			String result = Deck.cardRanks[cardIndex]; // return a random number between 0 and 13 (total ranks), amount of all possible value
			timesAppearedinDeck[cardIndex]++;
			
			// if the type of card has appeared  times in the deck, it cannot appear again
			if (timesAppearedinDeck[cardIndex] > MAXSIZE/cardRanks.length) { // number of ranks
				result = randomType(); // try again with another card
				timesAppearedinDeck[cardIndex] = MAXSIZE/cardRanks.length;
			}

			return result;
		}
		
		// used to create first card of deck
		private Card() {
			this.cardName = randomType();
			this.value = findMatch(cardName);
			this.nextCard = null;
		}
		
		// used to create all other cards in deck
		private Card(Card below) {
			this.cardName = randomType();
			this.value = findMatch(cardName);
			this.nextCard = below;
		}
	}		
	
	// store all possible values and types for cards
	private static String[] cardRanks = {"A", "2", "3", "4", "5", "6",
			"7", "8", "9", "10", "J", "Q", "K"};
	
	private static int[] values = {1, 2, 3, 4, 5, 6,
			7, 8, 9, 10, 10, 10, 10};
	
	private static int[] timesAppearedinDeck = new int[13];
	
	
	private int length; // length of deck
	private final int MAXSIZE = 52; // max size of deck, must be a multiple of the number of ranks 
	private Card pile; // reference to top of deck
	
	// create empty deck
	private Deck() {
		this.pile = null;
		this.length = 0;
	}
	
	// pushes card onto stack 
	public void addRandomCard() {
		// check if the deck is maxed out at 52
		if (this.length+1 > MAXSIZE) {
			throw new IndexOutOfBoundsException("Max deck size (" + MAXSIZE + ") already reached");
		}
		
		// for first card in deck
		if (this.pile == null) {
			this.pile = new Card(); // assign first card to top of stack
		}
		// for all other cards
		else {
			Card c = new Card(pile); // create new card, set its reference to the current top of stack
			pile = c; // reassign top of stack to new card
		}
		this.length++;
	}
	
	// pops first card off of stack, returns name of the card for later
	public String removeCard() {
		Card prev = pile;
		pile = pile.nextCard;
		prev.nextCard = null;
		this.length--;
		return prev.cardName;
	}
	
	// prints entire deck
	public String toString() {
		
		Card trav = pile;
		String result = "";
		// stop before last card in deck
		while (trav.nextCard != null) {
			result += trav.cardName + ", ";
			trav = trav.nextCard;
		}
		// for last card in deck, do not add comma
		result += trav.cardName;
		return result;
	}
	
	public static void main(String[] args) {
		// test code
		Deck d = new Deck();
		
		// create 52 card deck
		for (int i = 0; i < 52; i++) {
			d.addRandomCard();
		}
		System.out.println(d.toString());
		// remove half of deck
		for (int i = 0; i < 21; i++) {
			System.out.println("removed " + d.removeCard());
		}
		System.out.println(d.toString());
	}

}
