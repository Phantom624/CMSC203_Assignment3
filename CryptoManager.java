/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: It creates a program that takes an input of strings and encrypts or decrypts it using either a Caesar or Bellaso cypher.
 * Due: 10/21/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: _Fernando Benitez-Diaz
*/

package Assignment3;

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple ï¿½substitution cipherï¿½ where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		boolean result;
		int len = plainText.length();
		char c;
		for (int i = 0; i < len; i++)
		{
			c= plainText.charAt(i);
			if ( (c < LOWER_RANGE) || (c > UPPER_RANGE) )
			{
				result = false;
				return(result);
			}
		}
		result = true;
		//throw new RuntimeException("method not implemented");
		return(result);
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		char ch;
		char c;
		int num;
		String encryptC = "";
		int len = plainText.length();
		for (int ind = 0; ind < len; ind++)
		{
			c = plainText.charAt(ind);
			if( ((c < 'A') || (c > 'Z')) && (c != ' ') )
			{
				return("The selected string is not in bounds, Try again.");
			}
		}
		
		for(int i = 0; i < len; i++)
		{
			ch = plainText.charAt(i);
			num= ch + key;
			while(num > UPPER_RANGE)
			{
				num -= RANGE;
			}
			ch = (char)num;
			encryptC += ch;
			
		}
		return (encryptC);
		//throw new RuntimeException("method not implemented");
	}
	

	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		char et;
		String decryptC = "";
		int num;
		int len = encryptedText.length();
		for (int i = 0; i < len; i++)
		{
			et = encryptedText.charAt(i);
			num = et - key;
			while(num < LOWER_RANGE)
			{
				num += RANGE;
			}
			et = (char)num;
			decryptC += et;
		}
		return (decryptC);
		
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		String encryptB = "";
		char b, p, c;
		int lenp = plainText.length();
		int lenB= bellasoStr.length();
		int iB = 0;
		int num;
			if ( !(isStringInBounds(plainText)) )
			{
				return("The selected string is not in bounds, Try again.");
			}
		
		for (int i = 0; i < lenp; i++)
		{
			if (lenB == iB)
			{
				iB = 0;
			}
			p = plainText.charAt(i);
			b = bellasoStr.charAt(iB);
			num = p + b;
			while (num > 95)
			{
				num -= RANGE;
			}
			c = (char)num;
			encryptB += c;
			iB++;
		}
		return(encryptB);
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		char b, et, d;
		String decryptB = "";
		int len = encryptedText.length();
		int lenB = bellasoStr.length();
		int iB = 0;
		int num;
		if ( !(isStringInBounds(encryptedText)) )
		{
			return("The selected string is not in bounds, Try again.");
		}
		for (int index = 0; index < len; index++)
		{
			if (lenB == iB)
			{
				iB = 0;
			}
			et = encryptedText.charAt(index);
			b = bellasoStr.charAt(iB);
			num = et - b;
			while (num < 32)
			{
				num += RANGE;
			}
			d = (char)num;
			decryptB += d;
			iB++;
		}
		return (decryptB);
	}
}


















