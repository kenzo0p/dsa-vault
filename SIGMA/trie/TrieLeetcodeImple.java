package trie;

class Trie {
    static class TrieNode {
        TrieNode children[] = new TrieNode[26];
        boolean eow = false;

        public TrieNode() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    private TrieNode root; // Instance root node
    private boolean hasChildren; // Tracks if Trie has any inserted words

    public Trie() {
        root = new TrieNode();
        hasChildren = false;
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
        hasChildren = true; // Set flag to indicate words exist
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    public boolean startsWith(String prefix) {
        if (!hasChildren) {
            return false; // If no words have been inserted, return false
        }
        TrieNode curr = root;
        for (int level = 0; level < prefix.length(); level++) {
            int idx = prefix.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
}
