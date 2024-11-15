class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int answer = 0;
        int N = arr.length;

        // 1. Prefix removal
        for (int i = N - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                answer = i;
                break;
            }
        }

        // 2. Postfix removal
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                answer = Math.min(answer, N - i);
                break;
            }
        }

        // 3. Middle removal
        int l = 0;
        int r = N - 1;

        while (l < r) {
            while (r < N && l + 1 < r && arr[r] >= arr[r - 1] && arr[r] >= arr[l]) {
                r -= 1;
            }

            while (r < N && arr[r] < arr[l]) {
                r += 1;
            }

            answer = Math.min(answer, r - l - 1);

            if (arr[l] > arr[l + 1]) break;
            
            l += 1;
        }

        return answer;
    }
}