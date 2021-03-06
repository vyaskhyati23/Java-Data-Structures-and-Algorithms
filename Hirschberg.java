package LCS_PROJECT;
import java.util.Random;

/*
 * Implementation of Hirschberg algorithm for finding a longest common sub-sequence of two strings
 * Evaluation is done in quadratic time and linear space
 */

public class Hirschberg {
        
      private  String LCS;                 // LCS string is stored here
      private  static enum TYPE {          // TYPE of input data could be either a sequence of 0s and 1s or A,C,G,T
        	ALPHA,NUMERIC 
        	}
       
        /*
         * Implementation of algorithm B
         * It offers a slight modification to algorithm A and it returns a vector C more like a column matrix
         */
        public int[] algorithmB(int mlength, int nlength, String a, String b) {
                
                int[][] c = new int[2][nlength+1];
                for( int j=0; j<=nlength; j++) {
                        c[1][j] = 0;
                }
                
                
                for(int i=1; i<=mlength; i++) {
                        
                        for(int j=0; j<=nlength; j++) {
                                c[0][j] = c[1][j];
                        }
                        
                         
                        for(int j=1; j<=nlength; j++) {
                                if(a.charAt(i-1) == b.charAt(j-1)) {
                                        c[1][j] = c[0][j-1] + 1;
                                }else{
                                        c[1][j] = Math.max(c[1][j-1], c[0][j]);
                                }
                        }
                }
                
                
                return c[1];
                
        }
        
        /**
         The maximum of two numbers is calculated here which is self explanatory
         */
        public int max(int x, int y) {
                if(x>y) {
                        return x;
                }else{
                        return y;
                }
        }
        /*
         * Implementation of algorithm C of Hirschberg
         * Accepts input strings A and B and has lengths m and n
         */
        public String algorithmC(int mlength, int nlength, String A, String B) {
                int ipos=0;
                int j=0;
                String c = "";
                
               
                if( nlength==0 ) {   // For trivial problems initialize to empty string if the length is zero.
                        c = "";
                } else if( mlength==1 ) {  // If the length is one
                        c = "";
                        for( j=0; j<nlength; j++ ) { // Iterate through n
                                if( A.charAt(0)==B.charAt(j) ) { //if A[i] = B[j]
                                        c= ""+A.charAt(0); //Initialize c with char at the zeroth position
                                        break;
                                }
                        }
                        
               
                } else { // else split the problems
                        ipos= (int) Math.floor(((double)mlength)/2);
                        
                        // Evaluation of L1 and L2 termed as length 1 and length 2
                        int[] length1 = algorithmB(ipos, nlength, A.substring(0,ipos), B);
                        int[] length2 = algorithmB(mlength-ipos, nlength, reverse_String(A.substring(ipos)), reverse_String(B));
                        
                        
                        int k = findC(length1, length2, nlength);
                       
                        // Find the best match through recursive calls                        
                        String c1 = algorithmC(ipos, k, A.substring(0, ipos), B.substring(0, k));
                        String c2 = algorithmC(mlength-ipos, nlength-k, A.substring(ipos), B.substring(k));
                        
                        c = c1+c2;// Concatenation of two strings
                }
                
                return c; // return the LCS
        }
        
     /*
      * Reversing the strings when invoked through algorithm B   
      */
       public String reverse_String(String in) {
                String output = "";
                
                for(int i=in.length()-1; i>=0; i--) {
                        output = output+in.charAt(i);
                }
                
                return output;
        }
        
        
        public int findC(int[] length1, int[] length2, int n) {
                int m = 0;
                int c = 0;
                
                for(int j=0; j<=n; j++) {       
                        if(m < (length1[j]+length2[n-j])) {
                                m = length1[j]+length2[n-j];
                                c = j;
                        }
                }
                
                return c;  
        }
        
        /*
         * Random String Generator Method
         * can be either a string of 0s and 1s or As Cs Gs or Ts
         */
  public static String randomStringGenerator(int length, TYPE type) throws Exception {
            
     

               StringBuffer newString = new StringBuffer();// New string is the random string generated
               String symbols = ""; //Initialize the string with an empty string

               switch(type){

                case NUMERIC:
                               symbols = "01";          //If NUMERIC is selected it is a sequence of 0s and 1s
                               break;

                case ALPHA:
                               symbols = "ACGT";       //If ALPHA it is a sequence of As Cs Gs and Ts
                               break;

                }

             int symbolsLength = symbols.length();   //Length of the symbols

             for (int i = 0; i < length; i++) {
             double position = Math.random() * symbolsLength;   //Random Numbers are generated
             newString.append(symbols.charAt((int) position));
             }

             
             return newString.toString(); // Return the randomly generated string
}
        
        public static void main(String[] args) throws Exception {
                
                       /* 
                        * 
                        * This part of the code is for just non-random strings similar to static input data.
                        * String x = "CGGGCCGTTA";
                          String y = "AGTTCCTAAA";
        	              String x = "10010101";
                          String y = "010110110";
                          Hirschberg hirsch = new Hirschberg();
                          long start = System.currentTimeMillis();
                          hirsch.LCS = hirsch.algorithmC(x.length(), y.length(),x,y);
                          System.out.println("LCS:"+hirsch.LCS);
                          long stop  = System.currentTimeMillis();
                          System.out.println("Time taken(in milliseconds):"+(stop-start));
                          System.out.println("Length of LCS:"+hirsch.LCS.length());
                          
                          */
        	/*
        	 * 
        	 *   This part of the code is for Random strings
        	 *   It invokes the random string generator algorithm first followed by Hirschberg algorithm
        	 *   LCS is calculated as well as its length			
        	 */
        	Hirschberg hirsch = new Hirschberg();
	       	for(int index=0;index<20;index++){
        		String x = Hirschberg.randomStringGenerator(5,Hirschberg.TYPE.ALPHA);
        		String y = Hirschberg.randomStringGenerator(2,Hirschberg.TYPE.ALPHA);
        		System.out.println("x:"+x);
        		System.out.println("y:"+y);
        		long start = System.currentTimeMillis();
        		hirsch.LCS = hirsch.algorithmC(x.length(), y.length(),x,y);
        		System.out.println("LCS:"+hirsch.LCS);
                long stop = System.currentTimeMillis();
                System.out.println("Time taken(in milliseconds):"+(stop-start));
                System.out.println("Length of LCS:"+hirsch.LCS.length());
        	}
        			

        	}
        

}