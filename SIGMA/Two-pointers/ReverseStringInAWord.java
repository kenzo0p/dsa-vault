public class ReverseStringInAWord {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder rev = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            rev.append(words[i]);
            if (i != 0) {
                rev.append(" ");
            }
        }

        return rev.toString();
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ')
                i--; // skip spaces ending
            if (i < 0)
                break;
            int j = i; // always point to the last char of that word
            while (i >= 0 && s.charAt(i) != ' ')
                i--; // find word start
            if (sb.length() != 0)
                sb.append(' ');
            sb.append(s.substring(i + 1, j + 1));
        }
        return sb.toString();
    }

    public String reverseWords(String s) {
        // Remove leading and trailing spaces
        s = s.trim();

        // Convert to char array and reverse whole string
        char[] arr = new StringBuilder(s).reverse().toString().toCharArray();
        int n = arr.length;

        int i = 0, l = 0, r = 0;

        while (i < n) {
            // Skip spaces
            if (arr[i] == ' ') {
                i++;
                continue;
            }

            // Copy word to correct position
            if (r != 0)
                arr[r++] = ' '; // add space between words (not at start)
            l = r;

            // copy and move i
            while (i < n && arr[i] != ' ') {
                arr[r++] = arr[i++];
            }

            // reverse the word in place
            reverse(arr, l, r - 1);
        }

        return new String(arr, 0, r); // final string with correct length
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }

}
