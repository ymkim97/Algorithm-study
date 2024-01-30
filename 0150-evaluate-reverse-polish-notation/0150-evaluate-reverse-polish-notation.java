class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();

        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") &&!token.equals("/") &&!token.equals("*")) {
                st.addLast(Integer.parseInt(token));
                continue;
            }

            int a = st.pollLast();
            int b = st.pollLast();

            if (token.equals("+")) {
                st.addLast(a + b);
            }

            else if (token.equals("-")) {
                st.addLast(b - a);
            }

            else if (token.equals("*")) {
                st.addLast(a * b);
            }

            else {
                st.addLast(b / a);
            }
        }

        return st.pollLast();
    }
}