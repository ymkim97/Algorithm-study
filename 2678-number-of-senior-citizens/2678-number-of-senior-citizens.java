class Solution {
    public int countSeniors(String[] details) {
        int answer = 0;

        for (String detail : details) {
            if (Integer.parseInt(detail.substring(11, 13)) > 60) answer += 1;
        }

        return answer;
    }
}