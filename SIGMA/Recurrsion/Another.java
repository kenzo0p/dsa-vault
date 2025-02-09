public class Another {
    // !Important: amazon
    public static int titlingProblem(int n) {
        // base case
        if (n == 1 || n == 0) {
            return 1;
        }
        // kaam
        // vertical
        int fnm1 = titlingProblem(n - 1);

        // hprizontal
        int fnm2 = titlingProblem(n - 2);

        int totalWays = fnm1 + fnm2;
        return totalWays;
    }

    // !google microsoft
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        // base case
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        // kaam
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            // duplicate
            removeDuplicates(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx + 1, newStr.append(currChar), map);
        }
    }

    // !golman sachs
    public static int friendsPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // 1*(n-1)+(n-1)*(n-2)
        int fnm1 = friendsPairing(n - 1);
        int fnm2 = friendsPairing(n - 2);
        int pairWays = (n - 1) * fnm2;
        int totWays = fnm1 + pairWays;
        return totWays;
    }

    // ! paytm
    // binary string

    public static void binaryString(int n, int lastPlace, String str) {

        // base case {
        if(n==0){
            System.out.println(str);
            return;
        }
        // kaam
        // if (lastPlace == 0) {
        // // sit 0 on chair n
        // binaryString(n - 1, 0, str+"0");
        // binaryString(n - 1, 1, str.append("1"));
        // } else {
        // binaryString(n - 1, 0, str+"0");
        // }
        binaryString(n-1, 0, str+"0");
        if(lastPlace == 0){
            binaryString(n-1, 1, str+"1");
        }
    }

    // ! tower of hanoi
    public static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
        // base case
        if (n == 0) {
            return;
        }
        // move n-1 disk rod A (from_rod) to rod B(aux rod)
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        // move nth disk from rod A (from_rod) to rod c (to_rod)
        System.out.println("Move Disk " + n + " from rod " + from_rod + " to rod " + to_rod);
        // move n-1 disk from rod b(aux_rod ) to rod c (to_rod)
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    public static void main(String[] args) {
        // System.out.println(titlingProblem(3));
        // String str = "appnnacollege";
        // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
        // towerOfHanoi(3, 'A', 'B', 'C');
        binaryString(3, 0, "");
    }
}