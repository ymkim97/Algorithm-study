class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (left == right) {
                answer += 1;
                break;
            }

            int lWeight = people[left];
            int rWeight = people[right];

            if (lWeight + rWeight <= limit) left += 1;

            answer += 1;
            right -= 1;
        }
    
        return answer;
    }
}