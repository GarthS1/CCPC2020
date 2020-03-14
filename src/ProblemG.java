import java.util.ArrayList;
import java.util.Scanner;

public class ProblemG {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int queries  = scan.nextInt();
		
		for( int i = 0; i < queries; i++ ) {
			int mod = scan.nextInt();
			System.out.println(findNextRepeat(mod));
		}
	}

	private static int findNextRepeat(int mod) {
		
		int f0 = 1;
		int f1 = 1;
		boolean noRepeatFound = true;
		ArrayList<Integer> newFib = new ArrayList<Integer>();
		int index = 2;
		
		while(noRepeatFound) {
			int temp = f1;
			f1 += f0;
			f0 = temp;
			for( int i = 0 ; i < newFib.size(); i++ ) {
				if( (f1 % mod) == newFib.get(i)) {
					noRepeatFound = false;
					index += i;
				}
			}
			newFib.add( f1 % mod);
		}
		return index;
	}
}
