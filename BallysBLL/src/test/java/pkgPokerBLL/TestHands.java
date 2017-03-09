package pkgPokerBLL;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pkgPokerEnum.eHandStrength;
import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class TestHands {

	@Test
	public void TestStraight() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.NINE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.CLUBS));
		h.EvaluateHand();

		// Hand better be a straight
		assertEquals(eHandStrength.Straight.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Ten'
		assertEquals(eRank.TEN.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Six'
		assertEquals(eRank.SIX.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Straight has no kickers.
		assertEquals(0, h.getHandScore().getKickers().size());
	}

	@Test
	public void Test4OfAKind1() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.ACE, eSuit.CLUBS));
		h.EvaluateHand();

		// Hand better be a four of a kind
		assertEquals(eHandStrength.FourOfAKind.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'ACE'
		assertEquals(eRank.ACE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// Four of a kind has one kicker.
		assertEquals(1, h.getHandScore().getKickers().size());
	}

	@Test
	public void Test4OfAKind2() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.NINE, eSuit.CLUBS));
		h.EvaluateHand();

		// Hand better be a four of a kind
		assertEquals(eHandStrength.FourOfAKind.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Ten'
		assertEquals(eRank.TEN.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// Four of a kind has one kicker.
		assertEquals(1, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestFlush() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.QUEEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.CLUBS));
		h.EvaluateHand();

		// Hand better be a flush
		assertEquals(eHandStrength.Flush.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Queen'
		assertEquals(eRank.QUEEN.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// Flush has no kickers.
		assertEquals(0, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestThreeOfAKind() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TWO, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TWO, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.CLUBS));
		h.EvaluateHand();

		// Hand better be three of a kind
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Six'
		assertEquals(eRank.SIX.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// Three of a kind has two kickers.
		assertEquals(2, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestThreeOfAKind2() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.CLUBS));
		h.EvaluateHand();

		// Hand better be three of a kind
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Ace'
		assertEquals(eRank.ACE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// Three of a kind has two kickers.
		assertEquals(2, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestThreeOfAKind3() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.SIX, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.CLUBS));
		h.EvaluateHand();

		// Hand better be three of a kind
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Seven'
		assertEquals(eRank.SEVEN.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// Three of a kind has two kickers.
		assertEquals(2, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestTwoPair() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.SIX, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.DIAMONDS));
		h.EvaluateHand();

		// Hand better be a two pair
		assertEquals(eHandStrength.TwoPair.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Eight'
		assertEquals(eRank.EIGHT.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Six'
		assertEquals(eRank.SIX.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Two Pair has one kicker.
		assertEquals(1, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestTwoPair2() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FIVE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.DIAMONDS));
		h.EvaluateHand();

		// Hand better be a two pair
		assertEquals(eHandStrength.TwoPair.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Seven'
		assertEquals(eRank.SEVEN.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Five'
		assertEquals(eRank.FIVE.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Two Pair has one kicker.
		assertEquals(1, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestTwoPair3() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.SIX, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.DIAMONDS));
		h.EvaluateHand();

		// Hand better be a two pair
		assertEquals(eHandStrength.TwoPair.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Eight'
		assertEquals(eRank.EIGHT.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Six'
		assertEquals(eRank.SIX.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Two Pair has one kicker.
		assertEquals(1, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestPair() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.SIX, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.NINE, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.DIAMONDS));
		h.EvaluateHand();

		// Hand better be a pair
		assertEquals(eHandStrength.Pair.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Nine'
		assertEquals(eRank.NINE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Six'
		assertEquals(eRank.SIX.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Pair has three kickers.
		assertEquals(3, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestPair2() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FIVE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.NINE, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.DIAMONDS));
		h.EvaluateHand();

		// Hand better be a pair
		assertEquals(eHandStrength.Pair.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Nine'
		assertEquals(eRank.NINE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Five'
		assertEquals(eRank.FIVE.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Pair has three kickers.
		assertEquals(3, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestPair3() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.SIX, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.DIAMONDS));
		h.EvaluateHand();

		// Hand better be a pair
		assertEquals(eHandStrength.Pair.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Eight'
		assertEquals(eRank.EIGHT.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Pair has three kickers.
		assertEquals(3, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestPair4() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SEVEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.DIAMONDS));
		h.EvaluateHand();

		// Hand better be a pair
		assertEquals(eHandStrength.Pair.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Eight'
		assertEquals(eRank.EIGHT.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Pair has three kickers.
		assertEquals(3, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestHighCard() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.JACK, eSuit.DIAMONDS));
		h.EvaluateHand();

		// Hand better be high card
		assertEquals(eHandStrength.HighCard.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Ace'
		assertEquals(eRank.ACE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// High Card has no kickers.
		assertEquals(0, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestAcesAndEights() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.ACE, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.JACK, eSuit.DIAMONDS));
		h.EvaluateHand();

		// Hand better be Aces and Eights
		assertEquals(eHandStrength.AcesAndEights.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Ace'
		assertEquals(eRank.ACE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Eight'
		assertEquals(eRank.EIGHT.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Aces and Eights has one kicker.
		assertEquals(1, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestAcesAndEights2() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.ACE, eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.EIGHT, eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.TWO, eSuit.DIAMONDS));
		h.EvaluateHand();

		// Hand better be Aces and Eights
		assertEquals(eHandStrength.AcesAndEights.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Ace'
		assertEquals(eRank.ACE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Two'
		assertEquals(eRank.TWO.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Aces and Eights has one kicker.
		assertEquals(1, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestStrightFlush() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX, eSuit.CLUBS));
		h.EvaluateHand();

		// Hand better be a straight flush
		assertEquals(eHandStrength.StraightFlush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Ace'
		assertEquals(eRank.ACE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// Straight Flush has no kickers.
		assertEquals(0, h.getHandScore().getKickers().size());
	}

	@Test
	public void TestRoyalFlush() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.QUEEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.KING, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.ACE, eSuit.CLUBS));
		h.EvaluateHand();

		// Hand better be a royal flush
		assertEquals(eHandStrength.RoyalFlush.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Ace'
		assertEquals(eRank.ACE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// Royal Flush has no kickers.
		assertEquals(0, h.getHandScore().getKickers().size());

	}

	@Test
	public void TestFullHouse() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a full house
		assertEquals(eHandStrength.FullHouse.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Full House has no kickers.
		assertEquals(0, h.getHandScore().getKickers().size());

	}

}
