class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] meetingCount = new int[n];

        //0: time, 1: roomNo.
        Queue<long[]>usedRooms = new PriorityQueue<long[]>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        Queue<Integer> unusedRooms = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            unusedRooms.offer(i);
        }

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                int room = (int)usedRooms.poll()[1];
                unusedRooms.offer(room);
            }

            if (!unusedRooms.isEmpty()) {
                int room = unusedRooms.poll();
                usedRooms.offer(new long[] {end, room});
                meetingCount[room] += 1;
            } else {
                long roomAvailTime = usedRooms.peek()[0];
                int room = (int)usedRooms.poll()[1];
                usedRooms.offer(new long[] {roomAvailTime + end - start, room});
                meetingCount[room] += 1;
            }
        }

        int maxMeetingCount = 0, maxMeetingCountRoom = 0;
        
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetingCount) {
                maxMeetingCount = meetingCount[i];
                maxMeetingCountRoom = i;
            }
        }

        return maxMeetingCountRoom;
    }
}