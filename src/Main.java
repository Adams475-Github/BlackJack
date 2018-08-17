import java.util.Scanner;
public class Main {
	
	static int money = 100;

	public static void main(String[] args) {
		
		Hand hand = new Hand();
		Hand dHand = new Hand();
		Deck deck = new Deck();
		Deal deal = new Deal(hand, deck, dHand);
		Scanner sc = new Scanner(System.in);
		
		if (money < 1) {
			System.out.println("You're out of money there bucko, no more for you.");
			System.exit(0);
			
		}
		
		System.out.println("You have $" + money);
		System.out.println("How much do you want to bet?");
		
		int bet;
		bet = sc.nextInt();
		sc.nextLine();
		
		deal.dealStart();
		
		deal.hit(false);
		System.out.println("The dealer's face up card is:");
		dHand.printCards();
		deal.hit(false);
		
		System.out.println("\nYour Current Hand is:");
		hand.printCards();
		System.out.println("\nWould you like to hit? Yes or No");
		
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
			System.out.println("\nWould you like to hit? Yes or No");
			running = (value <= 21);
		}
		
		if (value > 21) {
			hand.printCards();
			System.out.println("\nYou busted.");
			money -= bet;
			
		} else {
			
			System.out.println("\nYour lock in with:");
			hand.printCards();
			
			if (dHand.value() < hand.value()) {
				boolean condition = true;
				
				while (condition) {
					
					deal.hit(false);
					int dValue = dHand.value();
					condition = (dValue <= 21);
					
				}
				
			}
			
			if (dHand.value() > 21) {
				System.out.println("\nThe Dealer has busted with:");
				dHand.printCards();
				
			} else {
				System.out.println("\nThe Dealer ends with:");
				dHand.printCards();
				
			}
			
			if (dHand.value() > 21) {
				System.out.println("\nYou Won");
				money += bet;
				
			} else if (hand.value() > dHand.value()){
				System.out.println("\nYou Won!");
				money += bet;
				
			} else if (hand.value() < dHand.value()) {
				System.out.println("\nYou Lost.");
				money -= bet;
				
			} else {
				System.out.println("\nYou Tied.");
				
			}
			
		}
		
		
		System.out.println("\nWould you like to play again?"); 
		boolean run2 = true;
		
		while (run2) {
			String input2 = sc.nextLine();
			
			if (input2.equalsIgnoreCase("yes")) {
				Main.main(null);
			} else if (input2.equalsIgnoreCase("no")) {
				System.exit(0);
			} else {
				System.out.println("Unknown input, please try again");
				System.out.println("\nWould you like to play again?");
			}
		}
		
		sc.close();
	}

}
