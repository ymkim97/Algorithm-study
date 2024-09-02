class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long total = 0;
        for (int c : chalk){
            total += c;
        }

        k %= total;

        int idx = 0;
        
        while (k > 0) {
            k -= chalk[idx];
            if (k < 0) break;
            idx = (idx + 1) % chalk.length;
        }

        return idx;
    }
}