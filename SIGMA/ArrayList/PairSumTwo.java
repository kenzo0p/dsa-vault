import java.util.ArrayList;

public class PairSumTwo { 
    // o(n)
    public static boolean pairSumTwo(ArrayList<Integer> list, int tar) {
        int n = list.size();
        int breakingPoint = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) { // breaking point
                breakingPoint = i;
                break;
            }
        }

        int lp = breakingPoint + 1;
        int rp = breakingPoint;
        while (lp != rp) {
            // case1
            if (list.get(lp) + list.get(rp) == tar) {
                return true;
            }
            // case 2;
            if (list.get(lp) + list.get(rp) < tar) {
                lp = (lp + 1) % n;
            }
            // case 3
            else {
                rp = (n + rp - 1) % n;
            }

        }
        return false;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(pairSumTwo(list, target));
    }
}
