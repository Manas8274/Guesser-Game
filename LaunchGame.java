package FirstPacakage;
import java.util.*;

class Guesser{
	private int guessNum;
	public int guessNumber() {
		Random rand = new Random();
		guessNum = rand.nextInt(100) + 1;
		return guessNum;
	}	
	
	public int getGuessNum() {
		return guessNum;
	}
}

class Player{
	private int pguessNum;
	public int guessNumber(int minrange,int maxrange) {
		
		System.out.println("Player! Kindly Guess the Number");
		Scanner sc = new Scanner(System.in);
		pguessNum = sc.nextInt();
		return pguessNum;
	}
	public boolean wasHint() {
		System.out.println("Do you want a hint about the range of the Guesser's number? (Enter 'yes' or 'no' ");
		Scanner sc  = new Scanner(System.in);
		String choice = sc.next();
		return choice.equalsIgnoreCase("yes");
	}
	public void provideHint(int minrange,int maxrange) {
		System.out.println("Hint: Guesser guess is between " + minrange + " and " + maxrange);
	}
	
}

class Umpire{
	private int numfromGuesser;
	private int numfromPlayer1;
	private int numfromPlayer2;
	private int numfromPlayer3;
	
	public void collectNumFromGuesser() {
		Guesser g = new Guesser();
		numfromGuesser = g.guessNumber();
	}
	public void collectNumFromPlayer() {
		int minrange = numfromGuesser - 5;
		int maxrange = numfromGuesser + 5;
		
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		
		if(p1.wasHint()) {
			p1.provideHint(minrange, maxrange);
		}
		numfromPlayer1 = p1.guessNumber(minrange,maxrange);
		if(p2.wasHint()) {
			p1.provideHint(minrange, maxrange);
		}
		numfromPlayer2 = p2.guessNumber(minrange,maxrange);
		if(p3.wasHint()) {
			p1.provideHint(minrange, maxrange);
		}
		numfromPlayer3 = p3.guessNumber(minrange,maxrange);
	}
	
	void compare() {
		boolean won = false;
		if(numfromGuesser == numfromPlayer1) {
			if(numfromGuesser == numfromPlayer2 && numfromGuesser == numfromPlayer3) {
				System.out.println("All are the Winneers!");
			}
			else if(numfromGuesser == numfromPlayer2) {
				System.out.println("Player 1 and Player 2 are the Winners!");
			}
			else if(numfromGuesser == numfromPlayer3) {
				System.out.println("Player 1 and Player 3 are the Winners!");
			}
			else {
				System.out.println("Player 1 is the Winner!");
			}
			won = true;
		}
		else if(numfromGuesser == numfromPlayer2) {
			if(numfromGuesser == numfromPlayer3) {
				System.out.println("Player 2 and Player 3 are the Winners");
			}
			else {
				System.out.println("Player is the Winner");
			}
			won  = true;
		}
		else if(numfromGuesser == numfromPlayer3){
			System.out.println("Player 3 is the Winner1");
			won = true;
		}
		if (!won) {
			System.out.println("No one won the Game. Guesser's number was: " + numfromGuesser);
		}
	}
}
public class LaunchGame {

	public static void main(String[] args) {
		
		System.out.println("Game is Started");
		Umpire u = new Umpire();
		u.collectNumFromGuesser();
		u.collectNumFromPlayer();
		u.compare();
		

	}

}
