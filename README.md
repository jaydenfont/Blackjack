# Blackjack (Unfinished)
OOP Implementation of Blackjack in Java (unfinished)

When finished, a human player can play against a computer player following the conventional rules of blackjack.

Deck and Cards: 
The deck of cards is represented by a Deck class (a stack object). The inner Card class representing the card objects are nodes in a linked list. The cards are single objects within containing a rank, numerical value (faces are 10, A is 1), and a reference to the next card in the stack. The deck has a reference to the top of the linked list of cards, a length attribute, and a max size attribute. The max size of the array must be a multiple of the amount of ranks in the deck. This allows each rank of card to appear in the deck in an even amount. For a traditional 52 card deck, the max size is 52, the number of ranks is 13, and each rank appears 4 times. For a 13 rank card set, a deck of a size of any multiple of 13 is possible, and each rank will appear in the same amount. When adding cards, the cards in the deck are pushed onto the stack, and when a card is being removed from the deck, it is popped from the top of the stack. 
