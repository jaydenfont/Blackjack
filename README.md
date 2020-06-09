# Blackjack 
OOP Implementation of Blackjack in Java 

To play the game, run Game.java

Deck and Cards: 
The deck of cards is represented by a Deck class (a stack object). The inner Card class representing the card objects are nodes in a linked list. The cards are single objects within containing a rank, numerical value (faces are 10, A is 1), and a reference to the next card in the stack. Ace cards are defaulted to 11 "points", but are changed to 1 in the event that 11 points would result in a bust. The deck has a reference to the top of the linked list of cards, a length attribute, and a max size attribute. The max size of the array must be a multiple of the amount of ranks in the deck. This allows each rank of card to appear in the deck in an even amount. For a traditional 52 card deck, the max size is 52, the number of ranks is 13, and each rank appears 4 times. For a 13 rank card set, a deck of a size of any multiple of 13 is possible, and each rank will appear in the same amount. When adding cards, the cards in the deck are pushed onto the stack, and when a card is being removed from the deck, it is popped from the top of the stack. 

Dealer:
Dealer has a Deck attribute, which is constructed with 52 cards in a random order. The deal() method returns the Dealer's deck, which will be popped to add cards from their deck to the player's deck.

Player and Game: 
Players have a hand attribute, which is a Deck object. They also maintain a field for the total value of their hand, and boolean fields for whether they have busted, chosen to stand, or have reached 21. A loop will prompt the player to either hit, stand, or view their hand. Every time the player chooses to hit, the top card from the Dealer's deck is added to the player's hand. After updating their total value, they are checked for a bust or 21. The player may also choose to stand, which breaks the loop. If the player busts, they lose. If the player chooses to stand, the top card of the Dealer's deck is revealed and if the value would have caused a bust, the player loses. If the value does not cause a bust, the player wins. If the player reaches exactly 21, they also win. 
