import java.util.*;

/* The first line of the input contains a single integer, N, indicating the number of games of war to be played. Following, there are two lines of input for each game. 
 * The first of the two lines contains a 26-character string indicating the cards in the opponent’s pile, in the order that they will be played.
 * Non-numeric cards are encoded with a single capital letter as described in the problem statement.
 * The second of the two lines indicates the 26 cards in Yraglac’s pile. Both piles together will always form the set of cards in a standard 52-card deck.
 * In our variant of War for this problem, when a tie in rank occurs, both players take their one card back.
 */
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
			for( int i = 0; i < 26; i++ ) {
				boolean cardFound = false;
				int j;
				for( j = 0; j < 26; j++) {
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
		
		/*for( int c : friendsHand ) {
			System.out.println(c);
		}
		System.out.println();
		*/

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
