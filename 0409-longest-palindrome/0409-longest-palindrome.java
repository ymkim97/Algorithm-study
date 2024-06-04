class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();

        int count = 0;

        for(char c : s.toCharArray()) {
            if(set.remove(c)) {
                count++;
            }
            
            else {
                set.add(c);
            }
        }
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }
}