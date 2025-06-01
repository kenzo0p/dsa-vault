public class ReverseStringInAWord {
    public String reverseWords(String s){
        String [] words = s.trim().split("\\s+");
        StringBuilder rev = new StringBuilder();
        for(int i = words.length -1;i>=0;i--){
            rev.append(words[i]);
            if(i!=0){
                rev.append(" ");
            }
        }

        return rev.toString();
    }



       public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ')
                i--; // skip spaces ending
            if (i < 0)
                break;
            int j = i; // always point to the last char of that word
            while (i >= 0 && s.charAt(i) != ' ')
                i--; // find word start
            if (sb.length() != 0)
                sb.append(' ');
            sb.append(s.substring(i + 1, j + 1));
        }
        return sb.toString();
    }
}
