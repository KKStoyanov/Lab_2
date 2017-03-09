package pkgPokerBLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class Deck {

	private UUID DeckID;
	private ArrayList<Card> DeckCards = new ArrayList<Card>();

	public Deck() {

		for (eSuit Suit : eSuit.values()) {
			for (eRank Rank : eRank.values()) {
				DeckCards.add(new Card(Rank, Suit));
				System.out.printf("%3d%3d\n", Rank.getiRankNbr(), Suit.getiSuitNbr());
			}
		}
		Collections.shuffle(DeckCards);

	}

	public Card DrawCard() {
		Card c = DeckCards.get(0);
		DeckCards.remove(0);
		return c;
	}
	
	public int CardsRemaining(){
		int cardsRemaining = DeckCards.size();
		return cardsRemaining;
	}
}
