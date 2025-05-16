import java.util.HashMap;

public class RomanNumberToIntegerAndVideVersa {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (map.get(s.charAt(i - 1)) < map.get(s.charAt(i))) {
                ans -= map.get(s.charAt(i - 1));
            } else {
                ans += map.get(s.charAt(i - 1));
            }
        }
        // add the last char
        ans += map.get(s.charAt(s.length() - 1));

        return ans;
    }

    int number[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String sym[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public String intToRoman(int num) {
        String ans = "";
        int i = 0;
        while (num > 0) {
            while (num >= number[i]) {
                num -= number[i];
                ans += sym[i];
            }
            i++;
        }

        return ans;
    }

}
