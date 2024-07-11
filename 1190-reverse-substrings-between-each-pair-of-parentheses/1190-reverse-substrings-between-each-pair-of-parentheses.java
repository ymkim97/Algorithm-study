class Solution {
        public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();

        for(char c: s.toCharArray()) {
            if( c == ')') {
                Queue<Character> p = new LinkedList<>();

                while(!st.isEmpty() && st.peek() != '(') p.add(st.pop());

                if(!st.isEmpty()) st.pop();
                
                while(!p.isEmpty()) st.push(p.remove());
            } 
            
            else {
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) sb.append(st.pop());
        
        return sb.reverse().toString();
    }
}