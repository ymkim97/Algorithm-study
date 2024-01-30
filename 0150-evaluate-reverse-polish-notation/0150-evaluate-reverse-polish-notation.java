class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") &&!token.equals("/") &&!token.equals("*")) {
                st.add(Integer.parseInt(token));
                continue;
            }

            int a = st.pop();
            int b = st.pop();

            if (token.equals("+")) {
                st.add(a + b);
            }

            else if (token.equals("-")) {
                st.add(b - a);
            }

            else if (token.equals("*")) {
                st.add(a * b);
            }

            else {
                st.add(b / a);
            }
        }

        return st.pop();
    }
}