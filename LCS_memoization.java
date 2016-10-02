package LCS_PROJECT;

import java.util.Random;

public class LCS_memoization {

	// TODO Auto-generated constructor stub
	private static final String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static int L[][];

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

		L = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < s1.length() + 1; i++) {
			for (int j = 0; j < s2.length() + 1; j++) {
				L[i][j] = -1;
			}
		}

		/**
		 * Start and end time before and after LCS_memoization is recorded to
		 * calculate the time taken to compute LCS.
		 */

		long start = System.currentTimeMillis();
		/*
		 * Call to the LCS_memoization which returns the final LCS of the
		 * strings s1 and s2.
		 */
		int result = LCS_recursive_memoization(s1.length(), s2.length(), s1, s2);
		long end = System.currentTimeMillis();
		System.out.println("Time elapsed in Milliseconds : " + (end - start));

		/**
		 * Prints the LCS length.
		 */
		System.out.println("MAX LENGTH IS " + result);

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
	public static int LCS_recursive_memoization(int i, int j, String s1, String s2) {
		int sol1, sol2, sol3;
		/**
		 * One of the strings has length zero. Therefore, no common characters.
		 * LCS is 0,
		 */

		if (i == 0 || j == 0) {
			return (0);
		}

		/**
		 * Check for memoized solution and return it.
		 */
		if (L[i][j] >= 0) {
			return (L[i][j]);
		}

		/**
		 * Recursive call if memoized solution is not stored.
		 */
		if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
			sol1 = LCS_recursive_memoization(i - 1, j - 1, s1, s2);
			/**
			 * Memoizing.
			 */
			L[i][j] = sol1 + 1;
			return (L[i][j]);
		} else {
			sol2 = LCS_recursive_memoization(i - 1, j, s1, s2);
			sol3 = LCS_recursive_memoization(i, j - 1, s1, s2);

			/**
			 * Saving the solution.
			 */
			if (sol2 >= sol3)
				L[i][j] = sol2;
			else if (sol3 > sol2)
				L[i][j] = sol3;

			return (L[i][j]);
		}

	}

}
