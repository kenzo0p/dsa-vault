public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    // followup question print the string so for that use dequeue becuase in dequeue
    // in we can delete from front and last
    public int minimumLength(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            char ch = s.charAt(i);
            while (i < j && s.charAt(i) == ch) {
                i++;
            }
            while (j >= i && s.charAt(j) == ch) { // why j>=i ex -> aa
                j--;
            }
        }

        int length = j - i + 1;
        return length;
    }
}
