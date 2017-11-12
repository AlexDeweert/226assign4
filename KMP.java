/* 

   Rahnuma Islam Nishat - 08/02/2014
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class KMP 
{
    private static String pattern;

    /* KMP */
    public KMP(String pattern) {

    	//CREATE DFA

    	//I must construct a state transition matrix, a 2D array, based on the input pattern into the file.
    	//I know that the pattern will be based on this assignment { A C G T }
    	//I input the pattern containing only letters from that alphabet (some DNA sequence) and create the DFA based on that
    	//Basic steps:
    		/*
    			1) Create 2D array with numCols = alphabet.length(), numRows = pattern.length().
    			   Note for this step, we need 0 for the null (epsilon) step so we don't need a plus one.

    			2) Initialize all values in the int array to 0

				3) Create a string array which keeps track of all possible states of the pattern from length 1 to length n-1.
				   For example, if the pattern is G A T T A C A then the array will contain (for each ith state)
				   [ 0 ]: //null state
				   [ 1 ]: G
				   [ 2 ]: G A
				   [ 3 ]: G A T
				   [ 4 ]: G A T T
				   [ 5 ]: G A T T A
				   [ 6 ]: G A T T A C
				   [ 7 ]: G A T T A C A

    			4) For row i, determine the concatenation of (state)(col_j)
    			   For example, for the zeroth row, we know there are 4 possible resulting patterns to consider:
    			   eA, eC, eG, eT

    			   For each state pattern in the ith row, remove the first letter (e in this case) and compare the remaining string
    			   with the corresponding string in the state array. We only need to check the position of the state array
    			   which corresponds with the length of the remaining pattern. Since we pruned away e, then we only need to check
    			   one letter for each of the four patterns. The first row of the resulting 2D array is:
					
										  A    C    G    T

    			   [ 0 ]: //null state  |  0 |  0 |  1 |  0 |     eA, eC, eG, eT //no matches on any, prune away first char
				   [ 1 ]: G             |    |    |    |    |                    //then find the corresponding transition number
				   [ 2 ]: G A           |    |    |    |    |                    //in the possible state array - populate 2D arr[i][j]
				   [ 3 ]: G A T         |    |    |    |    |
				   [ 4 ]: G A T T       |    |    |    |    |
				   [ 5 ]: G A T T A     |    |    |    |    |
				   [ 6 ]: G A T T A C   |    |    |    |    |
				   [ 7 ]: G A T T A C A |    |    |    |    |

										   A    C    G    T

    			   [ 0 ]: //null state  |  0 |  0 |  1 |  0 |
				   [ 1 ]: G             |  2 |  0 |  1 |  0 |     GA, GC, GG, GT //Continue in the same manner, for the first round of
				   [ 2 ]: G A           |    |    |    |    |                    //state array compares, we only need to check index 2
				   [ 3 ]: G A T         |    |    |    |    |                    //since thats the length of each one. If match, then 
				   [ 4 ]: G A T T       |    |    |    |    |                    //dfa[i][j] = 2. Else prune down. If current pattern length
				   [ 5 ]: G A T T A     |    |    |    |    |                    //is 1 and there is no match in the possible states array, then
				   [ 6 ]: G A T T A C   |    |    |    |    |                    //Simply set the dfa[i][j] to 0.
				   [ 7 ]: G A T T A C A |    |    |    |    |

    		*/

    }
    
    /* SEARCH */
    public static int search(String txt) {
		return 0;
    }
    
    /* MAIN */
    public static void main(String[] args) throws FileNotFoundException {
	Scanner s;
	if (args.length > 0){
	    try{
			s = new Scanner(new File(args[0]));
	    } catch(java.io.FileNotFoundException e){
			System.out.println("Unable to open "+args[0]+ ".");
			return;
	    }
	    System.out.println("Opened file "+args[0] + ".");
	    String text = "";
	    while(s.hasNext()){
			text += s.next() + " ";
	    }
	    
	    for(int i = 1; i < args.length; i++){
			KMP k = new KMP(args[i]);
			int index = search(text);
			if(index >= text.length())System.out.println(args[i] + " was not found.");
			else System.out.println("The string \"" + args[i] + "\" was found at index " + index + ".");
	    }
	    
	    //System.out.println(text);
	    
	}
	else{
	    System.out.println("usage: java SubstringSearch <filename> <pattern_1> <pattern_2> ... <pattern_n>.");
	}
	
	
    }
}
