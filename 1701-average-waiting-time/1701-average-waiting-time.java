class Solution {
    public double averageWaitingTime(int[][] customers) {
        int cur = 0;
        long sum = 0;

        for (int[] customer : customers) {
            int in = customer[0];
            int out = customer[1];

            if (cur < in) cur = in + out;
            else if (cur >= in) cur += out;
            
            sum += (cur - in);
        }

        return ((double)sum / customers.length);
    }
}