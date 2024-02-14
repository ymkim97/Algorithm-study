class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();

        for (int num : nums) {
            if (num > 0) {
                pos.offer(num);
            }

            else {
                neg.offer(num);
            }
        }

        while (!pos.isEmpty() || !neg.isEmpty()) {
            answer.add(pos.poll());
            answer.add(neg.poll());
        }

        return answer.stream().mapToInt(a -> a).toArray();
    }
}