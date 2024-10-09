class Solution {
    public int minAddToMakeValid(String s) {
        if (s.length() == 0) return 0;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == '(' && c == ')') stack.pop();
            else stack.add(c);
        }

        return stack.size();
    }
}