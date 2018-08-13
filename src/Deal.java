public class Deal {
	
	private Hand h;
	private Deck d;
	private Hand dHand;
	
	public Deal(){
	}
	
	public Deal(Hand handNew, Deck deckNew, Hand dHandNew) {
		
		this.h = handNew;
		this.d = deckNew;
		this.dHand = dHandNew;
	}
	
	public int hitCount = 2;
	public int dCount = 50;
	public void dealStart() {
		
		d.makeDeck();
		d.shuffleDeck();
		
		h.addCard(d.deck[0]);
		h.addCard(d.deck[1]);
		
	}
	
	public void hit(boolean hPlayer) {
		
		if (hPlayer) {
			h.addCard(d.deck[hitCount]);
			hitCount++;
		} else {
			
			dHand.addCard(d.deck[dCount]);
			dCount--;
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Deal d = new Deal();
		
		d.dealStart();
		d.hit(true);
		d.hit(true);
		
	}

}
