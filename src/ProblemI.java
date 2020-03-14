import java.util.ArrayList;
import java.util.Scanner;

public class ProblemI {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int currentTime = scan.nextInt();
		int classTime = scan.nextInt();
		int numTranistRoutes = scan.nextInt();
		ArrayList<Integer> walkTimes = new ArrayList<Integer>();
		ArrayList<Integer> busTimes = new ArrayList<Integer>();
		ArrayList<Integer> arrivalTimes = new ArrayList<Integer>();
		
		for( int i = 0; i <= numTranistRoutes ; i++ ) {
			 walkTimes.add(scan.nextInt());
		}
		
		for( int i = 0; i < numTranistRoutes ; i++ ) {
			busTimes.add(scan.nextInt());
		}
		
		for( int i = 0; i < numTranistRoutes ; i++ ) {
			arrivalTimes.add(scan.nextInt());
		}
		
		int index = 0;
		while(index < numTranistRoutes ) {
			currentTime += walkTimes.get(index);
			for(; ( currentTime % arrivalTimes.get(index) ) != 0; currentTime++) {}
			currentTime += busTimes.get(index);
			index++;
		}
		
		currentTime += walkTimes.get(index);
		
		if( classTime >= currentTime ) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
}
