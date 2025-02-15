public class FindSubsetsString {
    public static void findStringSubsets(String str , String ans , int i){
        // base case
        if(i==str.length()){
            if(ans.length() == 0){
                System.out.println("null");
            }else {

                System.out.println(ans);
            }
            return;
        }

        // recursion\
        // yes choice
        findStringSubsets(str, ans+str.charAt(i), i+1);
        // no choice
        findStringSubsets(str, ans, i+1);
    }
    // use stringBuilder
    public static void main(String[]args){
        String str = "abc";
        findStringSubsets(str , "" , 0);
    }
}
