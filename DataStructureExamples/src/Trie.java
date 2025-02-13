class Trie {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    private TrieNode root = new TrieNode();
    void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null)
                node.children[ch - 'a'] = new TrieNode();
            node = node.children[ch - 'a'];
        }
        node.isEndOfWord = true;
    }
}