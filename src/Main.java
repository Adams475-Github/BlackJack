import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Hand hand = new Hand();
		Hand dHand = new Hand();
		Deck deck = new Deck();
		Deal deal = new Deal(hand, deck, dHand);
		Scanner sc = new Scanner(System.in);
		
		deal.dealStart();
		
		deal.hit(false);
		System.out.println("The dealer's face up card is:");
		dHand.printCards();
		deal.hit(false);
		
		System.out.println("Your Current Hand is:");
		hand.printCards();
		System.out.println("Would you like to hit? Yes or No");
		
		int value = hand.value();
		boolean running = true;
	
		while (running) {
			
			String input = sc.nextLine();
			
			if (input.equalsIgnoreCase("Yes")) {
				deal.hit(true);
				value = hand.value();
			} else if (input.equalsIgnoreCase("No")) {
				break;
			} else {
				System.out.println("Unrecognized input, please try again.");
			}
			
			System.out.println("Your Current Hand is:");
			hand.printCards();
			//System.out.println(value);
			System.out.println("Would you like to hit? Yes or No");
			running = (value <= 21);
		}
		
		if (value > 21) {
			
			hand.printCards();
			System.out.println("You bust.");
			
		} else {
			
			System.out.println("Your lock in with:");
			hand.printCards();
			System.out.println("The Dealer ends with");
			
			if (dHand.value() < hand.value()) {
				
				boolean condition = true;
				while (condition) {
					
					deal.hit(false);
					int dValue = dHand.value();
					condition = (dValue <= 21);
					
				}
				
			}
			
			dHand.printCards();
			
			if (dHand.value() > 21) {
				
				System.out.println("You Won");
				System.exit(0);
				
			}
			
			if (hand.value() > dHand.value()){
				
				System.out.println("You Won!");
				
			} else if (hand.value() < dHand.value()) {
				
				System.out.println("You Lost.");
				
			} else {
				
				System.out.println("You Tied.");
				
			}
			
		}
	
		sc.close();
		
	}

}
