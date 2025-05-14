public class RotateString {
      public static boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();

        // If the lengths are not equal, they can't be rotations
        if (m != n) {
            return false;
        }

        // Check all possible rotations
        for (int rotationCount = 1; rotationCount <= m; ++rotationCount) {
            // Perform one rotation by shifting left by one character
            s = s.substring(1) + s.charAt(0);
            if (s.equals(goal)) {
                return true;
            }
        }
        return false; 
    }


     public boolean rotateString(String s, String goal) { // abcdeabcde -> cdeab is present in this as substring the true (s+s concat then check for it contains)
       int n = s.length() , m  = goal.length();
       if(m== n && (s+s).contains(goal)){
        return true;
       }
       return false;
    }
    public static void main(String[]args){
       String s = "abcde", goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }
    
}
