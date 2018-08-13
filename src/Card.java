public class Card {
	
	private String suit;
	private int value;
	private String clss;

	public Card(){
	}
		
	public Card(String defSuit, int defValue, String defClss) {
		
		this.suit = defSuit;
		this.value = defValue;
		this.clss = defClss;
		
	}
	
	public String getSuit() {
		
		return suit;
		
	}
	
	public int getValue() {
		
		return value;
		
	}
	
	public String getClss() {
		
		return clss;
		
	}

	public static void main(String[] args) {
		
		
		
	}

}
