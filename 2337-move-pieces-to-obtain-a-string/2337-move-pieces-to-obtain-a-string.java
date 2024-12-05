class Solution {
    public boolean canChange(String start, String target) {
        Stack<int[]> startStk = new Stack<>(); // 0: idx, 1: (0) = R, (1) = L
        Stack<int[]> targetStk = new Stack<>();

        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != '_') {
                if (start.charAt(i) == 'R') startStk.push(new int[] {i, 0});
                else startStk.push(new int[] {i, 1});
            }
        }

        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != '_') {
                if (target.charAt(i) == 'R') targetStk.push(new int[] {i, 0});
                else targetStk.push(new int[] {i, 1});
            }
        }

        if (startStk.size() != targetStk.size()) return false;

        while (!startStk.isEmpty() && !targetStk.isEmpty()) {
            int[] s = startStk.pop();
            int[] t = targetStk.pop();

            if (s[1] != t[1]) return false;

            if (s[1] == 0 && s[0] > t[0]) return false;
            else if (s[1] == 1 && t[0] > s[0]) return false;
        }

        return true;
    }
}