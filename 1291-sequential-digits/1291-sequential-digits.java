class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        String number = "123456789";
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < number.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(number.charAt(i));

            for (int j = i + 1; j < number.length(); j++) {
                sb.append(number.charAt(j));

                int num = Integer.parseInt(sb.toString());
                if (num < low) continue;

                else if (num >= low && num <= high) {
                    answer.add(num);
                }

                else if (num > high) break;
            }
        }

        Collections.sort(answer);

        return answer;
    }
}