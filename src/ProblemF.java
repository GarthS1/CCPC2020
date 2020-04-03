/**
One of the most well-known and classic methods of encryption is the Vigenère cipher. Given a message and key of equal length, 
all you need to do to encrypt the message is shift each character forward by a certain number of characters in the alphabet.

For example, if your string is CALGARY and key is ALBERTA, the number of letters to shift the i-th letter in the message is 
given by the position in the alphabet of the i-th letter in the key, using 0-based indexing. So the first character in our 
message C is shifted 0 letters forward since the first character in our key is A. Likewise, A is shifted 11 characters since L 
is the 11-th letter in the alphabet. Repeating for each character, we’ll find the encrypted message ends up being CLMKRKY.

Of course since this is such a well known encryption method, it isn’t very safe so your friend Yraglac has come up with a 
brilliant idea: for each even-indexed character in your message, you do the usual encryption as described above, but for the 
odd-indexed characters, instead of shifting forwards by the key, you actually shift backwards. Thus, our example above would 
actually be encrypted as CPMCRYY. That’ll throw off any pesky hackers trying to read your secrets!

Of course Yraglac has left the implementation up to you. Given an encrypted message and the key, can you write a program to 
decrypt it? Don’t forget that everything is using 0-based indexing.

Input
Input consists of two lines. The first contains the encrypted message C and the second contains the key K. C and K are always of equal length between 1 and 200 characters long and consists only of uppercase alphabetic letters.

Output
Output the decrypted message.

Sample Input 1	Sample Output 1
CPMCRYY
ALBERTA
CALGARY
Sample Input 2	Sample Output 2
TDLIVA
OILERS
FLAMES
**/
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
