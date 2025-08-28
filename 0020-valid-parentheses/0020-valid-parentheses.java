class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stk.push(c);
            } else {
                if (stk.isEmpty()) return false;

                if (c == ')' && stk.peek() == '(') stk.pop();
                else if (c == '}' && stk.peek() == '{') stk.pop();
                else if (c == ']' && stk.peek() == '[') stk.pop();
                else return false;
            }
        }

        return stk.isEmpty();
    }
}