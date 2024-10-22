package Assignment3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CryptoManagerTestStudent {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("HELLO"));
		assertFalse(CryptoManager.isStringInBounds("hello"));
		assertTrue(CryptoManager.isStringInBounds("/ HELLO"));
		
	}

	@Test
	public void testCaesarEncryption() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("see you", 3));
		assertEquals("CDE", CryptoManager.caesarEncryption("ABC", 2));
		assertEquals("GHI", CryptoManager.caesarEncryption("ABC", 6));
	}

	@Test
	public void testCaesarDecryption() {
		assertEquals("TESTING", CryptoManager.caesarDecryption("UFTUJOH", 1));
		assertEquals("ABC", CryptoManager.caesarDecryption("GHI", 6));
		assertEquals("EFG", CryptoManager.caesarDecryption("GHI", 2));
		
	}

	@Test
	public void testBellasoDecryption() {
		assertEquals("TESTING", CryptoManager.bellasoDecryption("WN#\\N &", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("HELLO", CryptoManager.bellasoDecryption("IGOMQ", "ABC"));
		assertEquals("GCIKM", CryptoManager.bellasoDecryption("HELLO", "ABC"));
	}
	
	@Test
	public void testBellasoEncryption() {
		assertEquals("IGOMQ", CryptoManager.bellasoEncryption("HELLO", "ABC"));
		assertEquals("2/669", CryptoManager.bellasoEncryption("*****", "HELLO"));
		assertEquals("JIRNS", CryptoManager.bellasoEncryption("IGOMQ", "ABC"));
	}

}
