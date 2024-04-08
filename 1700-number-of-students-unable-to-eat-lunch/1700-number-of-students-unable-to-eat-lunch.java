class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> stu = new ArrayDeque<>();
        Deque<Integer> san = new ArrayDeque<>();

        for (int i = 0; i < students.length; i++) {
            stu.offerLast(students[i]);
            san.offerLast(sandwiches[i]);
        }

        while (!san.isEmpty() && stu.contains(san.peekFirst())) {
            if (stu.peekFirst() == san.peekFirst()) {
                stu.removeFirst();
                san.removeFirst();
            }

            else {
                stu.offerLast(stu.removeFirst());
            }
        }

        return stu.size();
    }
}