class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int n = tasks.length;
        int m = workers.length;

        int left = 1;
        int right = Math.min(m, n);
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(tasks, workers, pills, strength, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean check(int[] tasks, int[] workers, int pills, int strength, int mid) {
        TreeMap<Integer, Integer> ws = new TreeMap<>();

        for (int i = workers.length - mid; i < workers.length; i++) {
            ws.put(workers[i], ws.getOrDefault(workers[i], 0) + 1);
        }

        for (int i = mid - 1; i >= 0; i--) {
            Integer key = ws.lastKey();

            if (key >= tasks[i]) {
                ws.put(key, ws.get(key) - 1);
                
                if (ws.get(key) == 0) ws.remove(key);
            } else {
                if (pills == 0) return false;

                key = ws.ceilingKey(tasks[i] - strength);

                if (key == null) return false;

                ws.put(key, ws.get(key) - 1);

                if (ws.get(key) == 0) ws.remove(key);

                pills -= 1;
            }
        }

        return true;
    }
}