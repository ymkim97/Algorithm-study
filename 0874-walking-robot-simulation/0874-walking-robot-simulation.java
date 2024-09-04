class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] mx = {1, 0, -1, 0}; // down, left, up, right
        int[] my = {0, -1, 0, 1};
        int dir = 0;
        int[] cur = new int[] {0, 0};

        int answer = 0;

        Set<Obstacle> set = new HashSet<>();

        for (int[] o: obstacles) {
            set.add(new Obstacle(o[1], -1 * o[0]));
        }

        for (int command: commands) {
            if (command == -1) dir = (dir + 1) % 4;
            else if (command == -2) dir = (dir == 0 ? 3 : dir - 1);
            else {
                int x = cur[0];
                int y = cur[1];

                int dx = x;
                int dy = y;

                boolean avail = true;
                for (int i = 0; i < command; i++) {
                    if (!avail) break;

                    dx += mx[dir];
                    dy += my[dir];

                    if (set.contains(new Obstacle(dx, dy))) {
                        if (dir == 0) {
                            dx -= 1;
                        } else if (dir == 1) {
                            dy += 1;
                        } else if (dir == 2) {
                            dx += 1;
                        } else if (dir == 3) {
                            dy -= 1;
                        }
                        avail = false;
                    }
                }

                answer = Math.max(answer, (dx * dx + dy * dy));
                cur[0] = dx;
                cur[1] = dy;
            }
        }

        return answer;
    }

    static class Obstacle {
        int x;
        int y;

        public Obstacle(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Obstacle obs = (Obstacle) o;

            if (x == obs.x && y == obs.y) return true;
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}