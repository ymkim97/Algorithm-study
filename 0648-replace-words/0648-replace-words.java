class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Node trie = new Node();

        for (String word : dictionary) {
            Node node = trie;

            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new Node();
                node = node.children[c - 'a'];
            }

            node.word = word;
        }

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            Node node = trie;

            for (char c : words[i].toCharArray()) {
                node = node.children[c - 'a'];

                if (node == null) break;

                if (node.word != null) {
                    words[i] = node.word;
                    break;
                }
            }
        }

        return String.join(" ", words);
    }

    public static class Node {
        String word;
        Node[] children = new Node[26];
    }
}