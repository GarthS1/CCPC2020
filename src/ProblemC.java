import java.util.*;

public class ProblemC {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numGames = scan.nextInt();
		int[] yraglacHand = new int [26];
		int[] friendsHand = new int [26];
		
		for( int round = 0; round < numGames; round++ ) {
			char[] friendsHandC = scan.next().toCharArray();
			char[] yraglacHandC = scan.next().toCharArray();
			int maxCards = 0;
			
			for(int i = 0; i < 26; i++) {
				if( friendsHandC[i] == 'T') {
					friendsHand[i] = 10;
				}
				else if( friendsHandC[i] == 'J') {
					friendsHand[i] = 11;
				}
				else if( friendsHandC[i] == 'Q') {
					friendsHand[i] = 12;
				}
				else if( friendsHandC[i] == 'K') {
					friendsHand[i] = 13;
				}
				else if( friendsHandC[i] == 'A') {
					friendsHand[i] = 14;
				}
				else {
					friendsHand[i] = friendsHandC[i] - 48; 
				}
			}
			
			for(int i = 0; i < 26; i++) {
				if( yraglacHandC[i] == 'T') {
					yraglacHand[i] = 10;
				}
				else if( yraglacHandC[i] == 'J') {
					yraglacHand[i] = 11;
				}
				else if( yraglacHandC[i] == 'Q') {
					yraglacHand[i] = 12;
				}
				else if( yraglacHandC[i] == 'K') {
					yraglacHand[i] = 13;
				}
				else if( yraglacHandC[i] == 'A') {
					yraglacHand[i] = 14;
				}
				else {
					yraglacHand[i] = yraglacHandC[i] - 48; 
				}
			}
			
			sort(friendsHand);
			sort(yraglacHand);
			
			ArrayList<Integer> possibleTies = new ArrayList<Integer>();
			for( int i = 0; i < 26 ; i++ ) {
				boolean cardFound = false;
				for( int j = 0; j < 26 ; j++) {
					if(yraglacHand[j] > friendsHand[i] ) {
						yraglacHand[j] = 0;
						maxCards += 2;
						cardFound = true;
						break;
					}
				}
				if(!cardFound) {
					possibleTies.add(i);
				}
			}
			
			for( int i = 0; i < possibleTies.size(); i++) {
				for( int j = 0; j < 26; j++) {
					if(yraglacHand[j] == friendsHand[possibleTies.get(i)] ) {
						yraglacHand[j] = 0;
						maxCards += 1;
						break;
					}
			}
		}
			System.out.println(maxCards);
		}
	}

	private static void sort(int[] hand) {
		
		for( int i = 0; i < 26; i++) {
			int big = i;
			for( int j = i + 1; j < 26; j++) {
				if( hand[j] > hand[big] ) {
					big = j;
				}
			}
			int temp = hand[i];
			hand[i] = hand[big];
			hand[big] = temp;
		}
	}
}
