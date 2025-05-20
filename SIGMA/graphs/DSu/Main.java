package graphs.DSu;

import java.util.ArrayList;

public class Main {

    // Notes find function and union
    public static int find(int i, ArrayList<Integer> parent) {
        if (i == parent.get(i)) {
            return i;
        }

        return find(parent.get(i), parent);
    }

    public static void union(int x, int y, ArrayList<Integer> parent) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if (x_parent != y_parent) {
            parent.add(x_parent, y_parent);
        }
    }

}
