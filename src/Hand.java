import java.util.ArrayList;

public class Hand {
	
	ArrayList<Card> h = new ArrayList<Card>();
	
	public void addCard(Card newCard) {
		
		h.add(0, newCard);
		
	}
	
	public void printCards() {
		
		for (int i = 0; i < h.size(); i++) {
			
			System.out.println(h.get(i).getClss() + " of " + h.get(i).getSuit());
			
		}
		
	}
	
	public int value() {
		
		int value = 0;
		
		for (int i = 0; i < h.size(); i++) {
			
			value += h.get(i).getValue();
			
		}
		
		return value;
		
	}
	
	public static void main(String[] args) {

		
	}

}
