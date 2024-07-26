class Trie {

    // TrieNode class representing each node in the Trie
    class TrieNode {
        TrieNode[] children; // Array to store references to child nodes
        boolean isEnd; // Boolean flag to mark the end of a word

        // Constructor to initialize a TrieNode
        public TrieNode() {
            this.children = new TrieNode[26]; // Initialize the array to store 26 children (one for each letter of the
                                              // alphabet)
        }
    }

    TrieNode root; // Root node of the Trie

    // Constructor to initialize the Trie with a root node
    public Trie() {
        this.root = new TrieNode(); // Initialize the root node
    }

    // Method to insert a word into the Trie
    public void insert(String word) {
        TrieNode current = root; // Start from the root node
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i); // Get the current character
            if (current.children[c - 'a'] == null) { // If the child node doesn't exist, create it
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a']; // Move to the child node
        }
        current.isEnd = true; // Mark the end of the word
    }

    // Method to search for a word in the Trie
    public boolean search(String word) {
        TrieNode current = root; // Start from the root node
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i); // Get the current character
            if (current.children[c - 'a'] == null)
                return false; // If the child node doesn't exist, the word is not in the Trie
            current = current.children[c - 'a']; // Move to the child node
        }
        return current.isEnd; // Return true if the end of the word is reached, otherwise false
    }

    // Method to check if there is any word in the Trie that starts with the given
    // prefix
    public boolean startsWith(String prefix) {
        TrieNode current = root; // Start from the root node
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i); // Get the current character
            if (current.children[c - 'a'] == null)
                return false; // If the child node doesn't exist, the prefix is not in the Trie
            current = current.children[c - 'a']; // Move to the child node
        }
        return true; // Return true if the prefix exists in the Trie
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
