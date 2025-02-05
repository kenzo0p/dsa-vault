public class Main {
    static void printGfg(int N) {
        // code here
        int i = 0;
       if(i>N){
           return;
       }else {
           System.out.print("GFG ");
           i++;
        }
        printGfg(N);
    }
    public static void main(String[]args){
        int n = 5;
        printGfg(n);
    }
}
