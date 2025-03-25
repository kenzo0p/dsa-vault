package trie;

public class Main {
    static class Node {
        Node children[] = new Node[26];// 'a' -'z'
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                // create new node for that char
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;

    }

    public static boolean search(String key) {// o(l)
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean startsWith(String prefix) {// 0(l)
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    // unique substring count
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) { // a ,b,c,d
            if (root.children[i] != null && root.children[i].eow == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                longestWord(root.children[i], temp);
                // backtrack
                temp.deleteCharAt(temp.length() - 1);// backtrack
            }
        }
    }

    public static void main(String[] args) {// o(l)
        // String word[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        // String key = "ilikesung";
        // for (int i = 0; i < word.length; i++) {
        // insert(word[i]);
        // }
        // System.out.println(search("any"));
        // System.out.println(search("an"));
        // System.out.println(wordBreak(key));

        // starts with
        // String str[] = { "apple", "app", "mango", "man", "woman" };
        // String prefix1 = "app";
        // String prefix2 = "moon";
        // for (int i = 0; i < str.length; i++) {
        // insert(str[i]);
        // }
        // }System.out.println(startsWith(prefix1));
        // System.out.println(startsWith(prefix2));

        // unique substring
        // String om = "ababa";
        // for (int i = 0; i < om.length(); i++) {
        // String suffix = om.substring(i);
        // insert(suffix);
        // }
        // System.out.println(countNodes(root));

        // longest word with all prefixess
        String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);

    }
}
