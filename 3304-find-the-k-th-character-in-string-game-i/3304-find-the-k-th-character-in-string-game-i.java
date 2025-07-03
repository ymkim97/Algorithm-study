class Solution {
    public char kthCharacter(int k) {
        List<Character> word = new ArrayList<>();
        word.add('a');

        while (word.size() < k) {
            List<Character> tmp = new ArrayList<>();

            for (int i = 0; i < word.size(); i++) {
                char c = word.get(i);
                if (c == 'z') tmp.add('a');
                else tmp.add((char)(c + 1));
            }

            word.addAll(tmp);
        }

        return word.get(k - 1);
    }
}