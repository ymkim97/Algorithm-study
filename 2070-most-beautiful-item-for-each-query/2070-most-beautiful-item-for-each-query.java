class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] answer = new int[queries.length];

        Arrays.sort(items, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];

            return a[0] - b[0];
        });

        int maxB = items[0][1];

        for (int i = 0; i < items.length; i++) {
            maxB = Math.max(maxB, items[i][1]);
            items[i][1] = maxB;
        }

        int answerIdx = 0;

        for (int query : queries) {
            int idx = -1;

            int start = 0;
            int end = items.length - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                int[] now = items[mid];

                if (answerIdx == 0) System.out.println(mid);

                if (query >= now[0]) {
                    idx = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            if (idx == -1) answer[answerIdx] = 0;
            else answer[answerIdx] = items[idx][1];

            answerIdx += 1;
        }

        return answer;
    }
}