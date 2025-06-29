import java.util.Arrays;

public class PattitionLabels {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        List<Integer> result = new ArrayList<>();

        int mp[] = new int[26];
        Arrays.fill(mp, -1);
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            mp[idx] = i;
        }

        int i = 0;
        while (i < n) {
            int end = mp[s.charAt(i) - 'a'];

            int j = i;
            while (j < end) {
                end = Math.max(end, mp[s.charAt(j) - 'a']);
                j++;
            }

            result.add(j - i + 1);
            i = j + 1;
        }

        return result;

    }
}
