package LCS_PROJECT;

public class LCS_AlgorithmC {

	private static final String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		
		/**
		 * TODO Calling the randomStringGenerator function to generate two
		 * random alphabet strings.
		 */

		String s1 = randomStringGenerator(40);
		String s2 = randomStringGenerator(10);
		
	
		/**
		 * Prints strings and their lengths
		 */
		
		System.out.println("String is: " + s1);
		System.out.println("Length of first string is " + s1.length());

		System.out.println("String is: " + s2);
		System.out.println("Length of second string is " + s2.length());
		
		/**
		 * Start and end time before and after LCS_memoization is recorded to
		 * calculate the time taken to compute LCS.
		 */
		
		long start = System.currentTimeMillis();
		/*
		 * Call to the LCS_AlgoC which returns the final LCS of the strings s1
		 * and s2.
		 */
		String result = LCS_AlgoC(s1.length(), s2.length(), s1, s2);
		long end = System.currentTimeMillis();
		System.out.println("Time elapsed in Milliseconds : " + (end - start));
		
		/**
		 * Prints the LCS and its length.
		 */
		System.out.println("LCS is : " + result);
		System.out.println("MAX LENGTH IS : " + result.length());
		

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
	 * Implementation of algorithm C of Hirschberg
	 * @param i
	 *            : length of string s1
	 * @param j
	 *            : length of string s2
	 * @param s1
	 *            : randomly generated string s1
	 * @param s2
	 *            : randomly generated string s2
	 * @returns the lcs of the 2 strings.
	 */
	public static String LCS_AlgoC(int i, int j, String s1, String s2) {
		int x = 0;
		int y = 0;
		String lcs = "";
		
		/**
		 * If length is zero.
		 */
		if (j == 0)
			lcs = "";
		/**
		 * if length is 1.
		 */
		else if (i == 1) {
			lcs = "";
			for (y = 0; y < j; y++) {
				if (s1.charAt(0) == s2.charAt(y)) {
					lcs = "" + s1.charAt(0);
					break;
				}
			}
		} else {
			/**
			 * Splitting the problem.
			 */
			x = (int) Math.floor(((double) i) / 2);
			int[] l1 = LCS_AlgoB(x, j, s1.substring(0, x), s2);
			int[] l2 = LCS_AlgoB(i - x, j, reverse(s1.substring(x)), reverse(s2));

			int k = search(l1, l2, j);
			/**
			 * recursive call for best solution.
			 */
			String c1 = LCS_AlgoC(x, k, s1.substring(0, x), s2.substring(0, k));
			String c2 = LCS_AlgoC(i - x, j - k, s1.substring(x), s2.substring(k));

			lcs = c1 + c2;

		}
		return lcs;

	}
	
	/**
	 * Implementation of algorithm B of Hirschberg
	 * @param i
	 *            : length of string s1
	 * @param j
	 *            : length of string s2
	 * @param s1
	 *            : randomly generated string s1
	 * @param s2
	 *            : randomly generated string s2
	 * @return
	 */
	private static int[] LCS_AlgoB(int i, int j, String s1, String s2) {
		// TODO Auto-generated method stub
		int[][] c = new int[2][j + 1];

		for (int u = 0; u <= j; u++) {
			c[1][u] = 0;
		}

		for (int w = 1; w <= i; w++) {
			for (int u = 0; u <= j; u++) {
				c[0][u] = c[1][u];
			}

			for (int u = 1; u <= j; u++) {
				if (s1.charAt(w - 1) == s2.charAt(u - 1)) {
					c[1][u] = c[0][u - 1] + 1;
				} else {
					c[1][u] = Math.max(c[1][u - 1], c[0][u]);
				}
			}
		}
		return c[1];
	}
	
	/**
	 * 
	 * @param i
	 *            : length of string s1
	 * @param j
	 *            : length of string s2
	 * @param s1
	 *            : randomly generated string s1
	 * @param s2
	 *            : randomly generated string s2
	 * @return
	 */
	private static int search(int[] l1, int[] l2, int j) {
		// TODO Auto-generated method stub
		int m = 0, n = 0;

		for (int u = 0; u <= j; u++) {
			if (m < (l1[u] + l2[j - u])) {
				m = l1[u] + l2[j - u];
				n = u;
			}
		}
		return n;
	}

	/**
	 * 
	 * @param string
	 * @return out. Reversed string
	 */
	private static String reverse(String string) {
		// TODO Auto-generated method stub
		String out = "";
		for (int i = string.length() - 1; i >= 0; i--) {
			out = out + string.charAt(i);
		}
		return out;
	}

	
}
