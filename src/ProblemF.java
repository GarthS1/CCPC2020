import java.util.Scanner;

public class ProblemF {
	private String encrypted;
	private String key;

	public static void main(String args[]) {
		ProblemF test = new ProblemF();
		test.gatherInput();
		System.out.println(test.decrypt());
	}

	private void gatherInput() {
		Scanner scan = new Scanner(System.in);
		encrypted = scan.next();
		key = scan.next();
		scan.close();
	}

	/*
	 * Uses convertToChar and
	 */
	private String decrypt() {
		char[] encryptedChar = convertToChar(encrypted);
		char[] keyChar = convertToChar(key);
		changeCharArray(encryptedChar, keyChar);
		
		String decryptedKey = "";
		for(int i = 0; i < encryptedChar.length; i++)
			decryptedKey += encryptedChar[i];
		return decryptedKey;
	}

	// changes String to char array
	private char[] convertToChar(String temp) {
		char[] converted = new char[temp.length()];
		for (int i = 0; i < temp.length(); i++) {
			converted[i] = temp.charAt(i);
		}
		return converted;
	}

	private void changeCharArray(char[] encryptedChar, char[] keyChar) {
		for (int i = 0; i < encryptedChar.length; i++) {
			//System.out.println(keyChar[i] - 'A');
			if (i % 2 == 0) {
				encryptedChar[i] -= (keyChar[i] - 'A');
				if(encryptedChar[i] < 'A')
					encryptedChar[i] += ('Z' - 'A' +1 );
			}
			if (i % 2 == 1) {
				encryptedChar[i] += keyChar[i] - 'A';
				if(encryptedChar[i] > 'Z')
					encryptedChar[i] -= ('Z' - 'A' + 1);
			}
		}

	}
}
