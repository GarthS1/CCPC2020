
public class ProblemA {

	static public String getWinner(int[]src) {
		int totalCards = src[0];
		int range = src[2] - src[1];
		
		boolean alexTurn = true;
		
		while(totalCards >= 0) {
			if(range != 0)
				range = (int)((src[2]-src[1]) * Math.random());
			else 
				range = src[1];
			if(alexTurn) {
				if((totalCards - range) >= 0) {
					totalCards -= range;
					alexTurn = false;
				}else
					return "Barb";
					
			}else {
				if((totalCards - range) >= 0) {
					totalCards -= range;
					alexTurn = true;
				}else
					return "Alex";
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		
		int[] cardNum = new int[3];
		Scanner scan = new Scanner(System.in);

		for(int i = 0; i < 3; i++)
		{
		    cardNum[i] = scan.nextInt();
		}
		 
		System.out.println(getWinner(cardNum));
		
	}

}


/* Jiho's attempt*/
/*
import java.util.Scanner;
public class ProblemA {
	int cards;
	int lowerBound;
	int upperBound;
	public static void main(String args[]) {
		ProblemA test = new ProblemA();
		test.gatherInput();
		if(test.checkWinner())
			System.out.println("Alex");
		else
			System.out.println("Barb");
		
	}
	
	public void gatherInput() {
		Scanner scan = new Scanner(System.in);
		cards = scan.nextInt();
		lowerBound = scan.nextInt();
		upperBound = scan.nextInt();
		reduceNumber();
	}
	
	public boolean checkWinner() {
		//checking win conditions
		for(int i = 1; cards >= cards-lowerBound+i; i++ ) {
			int min = (cards-lowerBound+i) % (lowerBound + upperBound);
			if(min <= upperBound && min >= lowerBound)
				return true;
		}
		return false;
	}
	
	public void reduceNumber() {
		int denominator = gcd(gcd(cards, lowerBound), upperBound);
		cards /= denominator;
		lowerBound /= denominator;
		upperBound /= denominator;
	}
	
	private int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    } 
}
*/
