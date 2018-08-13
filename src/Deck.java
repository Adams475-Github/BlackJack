import java.util.Random;
public class Deck {
	
	Card[] deck = new Card[52];
	String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
	String[] clss = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
	int[] value = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
	
	public void makeDeck() {
		
		//makes a 52 card deck
		int inc = -1;
		for (int j = 0; j <= 12; j++) {
			int cValue = 0;
			
			if (j == 0) {
				cValue = 11;
			} else if (j == 1) {
				cValue = 10;
			} else if (j == 2) {
				cValue = 10;
			} else if (j == 3) {
				cValue = 10;
			} else if (j == 4) {
				cValue = 10;
			} else {	
				cValue = 14-j;
			}
			
			for (int i = 0; i <= 3; i++) {
				inc++;
				
				Card c = new Card(suits[i], cValue, clss[j]);
				deck[inc] = c;
				
			}
			
		}
		
	}
	
	
	public void shuffleDeck() {
		Random rand = new Random();		
		
		for (int i = 0; i <= 10000000; i++) {
			int num = (rand.nextInt(50) + 1);
			Card temp = deck[num];
			deck[num] = deck[num-1];
			deck[num-1] = temp;
			
		}
		
	}
	
	public void printDeck() {
		
		for (int i = 0; i <= 51; i++) {
			
			System.out.println(deck[i].getClss() + " of " + deck[i].getSuit());
			
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Deck d = new Deck();
		
		d.makeDeck();
		d.shuffleDeck();	
		
	}

}
