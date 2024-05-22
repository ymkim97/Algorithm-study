class Solution {

    List<List<String>> answer = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(0, s, new ArrayList<>());

        return answer;
    }

    public void backtrack(int idx, String s, List<String> lst) {
        if (idx >= s.length()) {
            answer.add(new ArrayList(lst));
            return;
        }

        for (int i = 0; idx + i < s.length(); i++) {
            if (isPalindrome(s, idx, i + 1)) {
                lst.add(s.substring(idx, idx + i + 1));
                backtrack(idx + i + 1, s, lst);
                lst.remove(lst.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int length) {
        String toCompare = s.substring(start, start + length);

        for (int i = 0; i < toCompare.length() / 2; i++) {
            if (toCompare.charAt(i) != toCompare.charAt(toCompare.length() - i - 1)) return false;
        }

        return true;
    }
}