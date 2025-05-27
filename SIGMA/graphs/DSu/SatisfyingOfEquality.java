package DSu;

public class SatisfyingOfEquality {
    private int find(int i, int parent[]) {
        if (i == parent[i]) {
            return i;
        }

        return parent[i] = find(parent[i], parent);
    }

    private void union(int x, int y, int[] parent, int[] rank) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if (x_parent == y_parent) {
            return;
        }

        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if (rank[y_parent] > rank[x_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }

    }

    public boolean equationPossible(String[] equations) {
        int[] parent = new int[26];
        int rank[] = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // first do union of equal chars
        for (String s : equations) {
            if (s.charAt(1) == '=') { // a == b
                union(s.charAt(0) - 'a', s.charAt(3) - 'a', parent, rank);
            }
        }

        // find != waale cases and check validity
        for (String s : equations) {
            if (s.charAt(1) == '!') { // a!=b
                char first = s.charAt(0); // a
                char second = s.charAt(3); // b

                int parent_first = find(first - 'a', parent);
                int parent_second = find(second -'a', parent);
                // !=  case fails here if parents are equal
                if (parent_first == parent_second) {
                    return false;
                }
            }
        }

        return true;
    }
}
