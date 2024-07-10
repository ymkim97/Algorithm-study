class Solution {
    public int minOperations(String[] logs) {
        int answer = 0;

        for (String log : logs) {
            if (log.equals("../")) {
                if (answer > 0) answer -= 1;
            }

            else if (log.equals("./")) {
                continue;
            }

            else {
                answer += 1;
            }
        }

        return answer;
    }
}