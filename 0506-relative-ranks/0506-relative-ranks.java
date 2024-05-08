class Solution {
    public String[] findRelativeRanks(int[] score) {
        List<int[]> lst = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            lst.add(new int[] {score[i], i});
        }

        Collections.sort(lst, (a, b) -> b[0] - a[0]);

        String[] answer = new String[score.length];

        for (int i = 0; i < score.length; i++) {
            if (i == 0) {
                answer[lst.get(i)[1]] = "Gold Medal";
            } else if (i == 1) {
                answer[lst.get(i)[1]] = "Silver Medal";
            } else if (i == 2) {
                answer[lst.get(i)[1]] = "Bronze Medal";
            } else {
                answer[lst.get(i)[1]] = String.valueOf(i + 1);
            }
        }

        return answer;
    }
}