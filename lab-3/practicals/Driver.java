import java.util.Objects;

class Card {
    private String rank;
    private String suit;

    Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Card))
            return false;

        Card c = (Card) obj;
        return rank.equals(c.rank) && suit.equals(c.suit);
    }

    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    public class Driver {

    public static void main(String[] args) {
        Card[] cards = new Card[5];

        cards[0] = new Card("Ace", "Spades");
        cards[1] = new Card("King", "Hearts");

        Card card = new Card("Ace", "Spades");
        boolean duplicate = false;

        for (int i = 0; i < 2; i++) {
            if (card.equals(cards[i])) {
                duplicate = true;
                break;
            }
        }

        if (duplicate) {
            System.out.println("Duplicate found: " + card);
        } else {
            cards[2] = card;
        }
    }
    }
}

