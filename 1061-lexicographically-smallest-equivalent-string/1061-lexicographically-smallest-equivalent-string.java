class Solution {

    int[] parent = new int[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        for (int i = 0; i < 26; i++) {
            parent[i] = (int)i;
        }

        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 97, s2.charAt(i) - 97);
        }

        StringBuilder sb = new StringBuilder();

        for (char c : baseStr.toCharArray()) {
            sb.append((char)(find((int)c - 97) + 97));
        }

        return sb.toString();
    }

    private int find(int n) {
        if (parent[n] == n) return n;

        return parent[n] = find(parent[n]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else if (a > b) parent[a] = b;
        else return;
    }
}