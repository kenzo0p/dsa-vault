import java.util.HashMap;
import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    //if we cant memoize in this problemm still the answer will be same as constraints are low

    private HashMap<String, Integer> map = new HashMap<>();

    private boolean hasDulpicate(StringBuilder temp, String s) {
        int arr[] = new int[26];
        // check also this : {"aa" , "bb"}
        for (char ch : temp.toString().toCharArray()) {
            if (arr[ch - 'a'] > 0) { //in the cases like the aa , bb
                return true;
            }
            arr[ch - 'a']++;
        }
        for (char ch : s.toCharArray()) {
            if (arr[ch - 'a'] > 0) { //in the cases like the aa , bb
                return true;
            }
            arr[ch - 'a']++;
        }
        return false; // no duplicate found at all

    }

    private int solve(int i, List<String> arr, StringBuilder temp, int n) {
        if (i >= n) {
            return temp.length();
        }
        String key = temp.toString();
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int include = 0;
        int exclude = 0;

        if (hasDulpicate(temp, arr.get(i))) {
            exclude = solve(i + 1, arr, temp, n);
        } else {
            temp.append(arr.get(i)); // include it and send it to the function
            include = solve(i + 1, arr, temp, n);
            temp.setLength(temp.length() - arr.get(i).length()); // now remove it and send it to the exclude call
            exclude = solve(i + 1, arr, temp, n);
        }
        map.put(key, Math.max(include, exclude));
        return Math.max(include, exclude);
    }

    public int maxLength(List<String> arr) {
        StringBuilder temp = new StringBuilder();
        int n = arr.size();

        int i = 0;
        return solve(i, arr, temp, n);
    }
}
