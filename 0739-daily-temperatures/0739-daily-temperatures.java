class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (st.isEmpty()) {
                st.add(new int[] {temperatures[i], i});
                continue;
            }

            while (!st.isEmpty() && temperatures[i] > st.peek()[0]) {
                int[] tmp = st.pop();
                answer[tmp[1]] = i - tmp[1];
            }

            st.add(new int[] {temperatures[i], i});
        }

        while (!st.isEmpty()) {
            int[] tmp = st.pop();
            answer[tmp[1]] = 0;
        }

        return answer;
    }
}