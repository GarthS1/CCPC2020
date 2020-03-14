
import java.util.Scanner;

public class ProblemE {

	static public int[] convertNotes(int length, String[] src) {
		int[] convert = new int[length];
		
		for(int i = 0; i < length; i++) {
			if(src[i].compareTo("C") == 0)
				convert[i] = 1;
			else if(src[i].compareTo("C#") == 0)
				convert[i] = 2;
			else if(src[i].compareTo("D") == 0)
				convert[i] = 3;
			else if(src[i].compareTo("D#") == 0)
				convert[i] = 4;
			else if(src[i].compareTo("E") == 0)
				convert[i] = 5;
			else if(src[i].compareTo("F") == 0)
				convert[i] = 6;
			else if(src[i].compareTo("F#") == 0)
				convert[i] = 7;
			else if(src[i].compareTo("G") == 0)
				convert[i] = 8;
			else if(src[i].compareTo("G#") == 0)
				convert[i] = 9;
			else if(src[i].compareTo("A") == 0)
				convert[i] = 10;
			else if(src[i].compareTo("A#") == 0)
				convert[i] = 11;
			else if(src[i].compareTo("B") == 0)
				convert[i] = 12;
		}
		return convert;
	}
	
	static public boolean checkTransposition(int length, int[] m1, int[] m2) {
		int range = m2[0] - m1[0];
		
		for(int i = 1; i < length; i++) {
			int noteRange = m2[i] - m1[i];
			if(noteRange != range)
				return false;
		}
		return true;
	}
	
	static public boolean checkInversion(int length, int[] m1, int[] m2) {
		
		for(int i = 1; i < length; i++) {
			int difference = m1[i] - m1[0];
			if(difference <= 0 )
				difference += 12;
			int difference2 = m2[0] - m2[i];
			if(difference2 <= 0 )
				difference2 += 12;
			
			if(difference2 != difference)
				return false;
		}
		return true;
	}
	
	static public boolean checkRetrograde(int length, int[]m1, int[]m2) {
		for(int i = 0; i < length ; i++) {
			if(m1[i] != m2[length - 1 - i])
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int melody = in.nextInt();
		
		String[] firstMelody = new String[melody];
		String[] secondMelody = new String[melody];
		
		for(int i = 0; i < melody; i++)
		{
		    firstMelody[i] = in.next();
		}

		for(int i = 0; i < melody; i++)
		{
		    secondMelody[i] = in.next();
		}

		int[] melodyOne = convertNotes(melody,firstMelody);
		int[] melodyTwo = convertNotes(melody,secondMelody);
		
		
		if(checkTransposition(melody,melodyOne, melodyTwo))
			System.out.println("Transposition");
		else if(checkRetrograde(melody,melodyOne,melodyTwo))
			System.out.println("Retrograde");
		else if(checkInversion(melody,melodyOne, melodyTwo))
			System.out.println("Inversion");
		else
			System.out.println("Nonsense");
		
	}
}

