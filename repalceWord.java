import java.util.List;

class Solution {
    TrieNode root;

    // TrieNode class represents each node in the Trie.
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26]; // Initialize the array for 26 lowercase English letters.
            this.isEnd = false; // Indicates if the node marks the end of a word.
        }
    }

    // Method to insert a word into the Trie.
    private void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode(); // Create a new TrieNode if it doesn't exist.
            }
            current = current.children[c - 'a'];
        }
        current.isEnd = true; // Mark the end of the word.
    }

    // Method to replace a word with its shortest prefix found in the Trie.
    private String replace(String word) {
        TrieNode current = root;
        StringBuilder replaceString = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.isEnd) {
                return replaceString.toString(); // Return the prefix if end of a word is found.
            }
            if (current.children[c - 'a'] == null) {
                return word; // Return the original word if no matching prefix is found.
            }
            replaceString.append(c);
            current = current.children[c - 'a'];
        }
        return word;
    }

    // Method to replace words in a sentence using the dictionary.
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode(); // Initialize the root node of the Trie.

        // Insert all words from the dictionary into the Trie.
        for (String word : dictionary) {
            insert(word);
        }

        StringBuilder result = new StringBuilder();
        String[] sentenceArr = sentence.split(" "); // Split the sentence into words.

        // Replace each word in the sentence.
        for (int i = 0; i < sentenceArr.length; i++) {
            result.append(replace(sentenceArr[i])); // Replace the word with its shortest prefix.
            if (i != sentenceArr.length - 1) {
                result.append(" "); // Add space between words, except after the last word.
            }
        }

        return result.toString(); // Return the modified sentence.
    }
}
