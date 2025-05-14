public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return  "";
        String pref =  strs[0];
        int prefLength = pref.length();

        for(int i = 1;i<strs.length;i++){
            String s = strs[i];
            while(prefLength > s.length() || !pref.equals(s.substring(0 , prefLength))){
                prefLength--;
                if(prefLength == 0){
                    return "";
                }

                pref = pref.substring(0, prefLength);
            }
        }

        return pref;

    }

    public static void main(String[] args) {

    }
}
