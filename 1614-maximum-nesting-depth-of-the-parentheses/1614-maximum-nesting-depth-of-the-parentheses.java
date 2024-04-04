class Solution {
    public int maxDepth(String s) {
        int answer = 0;
        Stack<Character> stk = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stk.add(c);
                continue;
            }

            if (c == ')' && !stk.isEmpty()) {
                answer = Math.max(answer, stk.size());
                stk.pop();
            }
        }

        return stk.isEmpty() ? answer : 0;
    }
}