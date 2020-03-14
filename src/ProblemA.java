
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
