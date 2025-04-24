import java.util.*;

public class ChocolaProblem {


    /* Chocola Problem

         We are given a bar of chocolate composed of m x n square pieces.
         One should break the chocolate into single squares.
         Each break of a part of the chocolate is charged a cost expressed by a positive integer.
         This cost does not depend on the size of the part that is being broken
         but only depends on the line the break goes along.
         Let us denote the costs of breaking along consecutive vertical lines with
         x1, x2, ..., x(m-1) and along horizontal lines with y1, y2, ..., y(n-1).
         Compute the minimal cost of breaking the whole chocolate into single squares.*/

    //TODO: Revisit again
    public static int chocolaProblem(Integer[] costVer, Integer[] costHor, int n, int m) {
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;// it will always be one piece
        int cost = 0;
        while (h < costHor.length && v < costVer.length) {
            // vertical cost < hor cost
            if (costVer[v] <= costHor[h]) {// horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else {
                cost += (costVer[v] * hp); // vertical cuts
                vp++;
                v++;
            }
        }
        // if some are still
        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }
        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }
        return cost;
    }

    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costHor[] = { 4, 1, 2 };// n-1
        Integer costVer[] = { 2, 1, 3, 1, 4 };// m-1
        int cost = chocolaProblem(costVer, costHor, n, m);
        System.out.println(cost);
    }
}
