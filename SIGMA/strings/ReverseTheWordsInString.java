public class ReverseTheWordsInString {
    public static String reverseWords(String s){
        String[] words = s.trim().split("\\s+");
        // return words[1];
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) reversed.append(" ");
        }
        
       return reversed.toString();
    }    
    
    
    public static void main(String[]args){
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
        
      
    }
}