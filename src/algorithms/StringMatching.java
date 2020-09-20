package algorithms;

public class StringMatching {
    public static void main(String[] args) {
        String text = "ABCD";
        String pattern = "ABCD";

        int result = bruteForceString(text, pattern);

        System.out.println("Result: " + result);
    }

/*  1)
    Substring Matching - Given a pattern P find it in Text T
    Type: Brute Force Algo

    BruteForceString(T[0..n-1], P[0..m-1])
        // Input: an Array T[0..n-1] of n chars representing a text and
                  an Array P[0..m-1] of m chars representing a pattern
        // Output: The index of the *first char* in the text that starts a matching
                   substring -1 if the search is unsuccessful
 */

    public static int bruteForceString(String text, String pattern) {
        // For text ABCD EF G of length 7, and pattern ABCD = 4
        // WE will for the match test loop 7 - 4 = 3 times
            // up to E because if the char E doesn't match A than the rest of the strings won't match
                // as they will be less (text.length) than pattern string.
                // i.e. if the pattern has 4 chars and in the text there is only 2 strings unchecked left it means
                        // pattern doesn't exist and will go out of index bound anyway.
        for(int i = 0; i< text.length()-pattern.length(); i++) {
            int j = i;
            System.out.println("i " + i);
            // text=ABCD EF G pattern=ABCD
            // while loop: do iteration for the count of pattern length and check if the index position of pattern i+j == text j
            //       loops: 1: 0 < 4 && i+j=0+0=pattern[0] == text[0] // A==A true; increment j to check next char match
            //              2: 1 < 4 && i+j=0+1=pattern[1] == text[1] // B=B true; increment j to check next char match
            //              3: 2 < 4 && i+j=0+2=pattern[2] == text[2] // C=C true; increment j to check next char match
            //              4: 3 < 4 && i+j=0+3=pattern[3] == text[3] // D=D true; increment j to check next char match
            //              5: 4 < 4    // FALSE; break loop; return i (starting position of match in this case is 0;
            while(j < pattern.length() && pattern.charAt(i+j) == text.charAt(j)) {
               j = j + 1;
           }
           if(j == pattern.length()) {
               return i;
           }
        }

        return -1; // no matching char found in text

    }

}


