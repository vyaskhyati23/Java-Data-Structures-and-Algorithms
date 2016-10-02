/**
 * 
 */
package LCS_PROJECT;

/**
 * @author Khyati K.Vyas
 *
 */
public class LCS_Naive {

	/**
	 * @param args
	 */
	private static final String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String result;

	public static void main(String[] args) {
		/**
		 * TODO Calling the randomStringGenerator function to generate two
		 * random alphabet strings.
		 */

		String s1 = randomStringGenerator(10);
		String s2 = randomStringGenerator(10);
		
		/**
		 * Prints strings and their lengths
		 */

		System.out.println("String is: " + s1);
		System.out.println("Length of first string is " + s1.length());

		System.out.println("String is: " + s2);
		System.out.println("Length of second string is " + s2.length());

		/**
		 * Start and end time before and after LCS_Naive is recorded to
		 * calculate the time taken to compute LCS.
		 */
		long start = System.currentTimeMillis();
		/*
		 * Call to the LCS_Naive which returns the final LCS of the strings s1
		 * and s2.
		 */
		String result = LCS_Naive(s1, s2);
		long end = System.currentTimeMillis();
		System.out.println("Time elapsed in Milliseconds : " + (end - start));
		/**
		 * Prints the LCS and its length.
		 */
		System.out.println("LCS IS " + result);
		System.out.println("Length of LCS is : " + result.length());
		
	}

	/**
	 * 
	 * @param number
	 *            -Creates randomly generated strings of the specified number.
	 * @return randomGeneratedString. The randomly generated string of varying
	 *         lengths.
	 */

	public static String randomStringGenerator(int number) {
		StringBuffer randomGeneratedString = new StringBuffer();

		int s_length = s.length();
		for (int i = 0; i < number; i++) {
			double position = Math.random() * s_length;
			randomGeneratedString.append(s.charAt((int) position));
		}
		return randomGeneratedString.toString();
	}
	/**
	 * 
	 * @param s1 : Randomly generated string 1.
	 * @param s2 : Randomly generated string 2.
	 * @return lcs of string s1 and s2
	 * 
	 * Function to compute the LCS of 2 strings of random length.
	 */

	private static String LCS_Naive(String s1, String s2) {
		// TODO Auto-generated method stub
		int l1 = s1.length();
		int l2 = s2.length();

		if (l1 == 0 || l2 == 0) {
			return "";
		} else if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
			return LCS_Naive(s1.substring(0, l1 - 1), s2.substring(0, l2 - 1)) + s1.charAt(l1 - 1);
		} else {
			String x = LCS_Naive(s1, s2.substring(0, l2 - 1));
			String y = LCS_Naive(s1.substring(0, l1 - 1), s2);
			if (x.length() > y.length())
				return x;
			else
				return y;
		}
	}

}
