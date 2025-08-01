class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();

        answer.add(new ArrayList<>(List.of(1)));

        if (numRows == 1) {
            return answer;
        } else if (numRows == 2) {
            answer.add(new ArrayList<>(List.of(1, 1)));
            return answer;
        }

        answer.add(new ArrayList<>(List.of(1, 1)));

        for (int i = 0; i < numRows - 2; i++) {
            List<Integer> top = answer.get(answer.size() - 1);
            List<Integer> tmp = new ArrayList<>();

            tmp.add(1);
            for (int j = 0; j < top.size() - 1; j++) {
                tmp.add(top.get(j) + top.get(j + 1));
            }
            tmp.add(1);

            answer.add(tmp);
        }

        return answer;
    }
}
