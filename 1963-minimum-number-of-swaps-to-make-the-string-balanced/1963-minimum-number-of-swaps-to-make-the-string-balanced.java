class Solution {
    public int minSwaps(String s) {
        int size = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[') 
                size += 1;
            else if (size > 0) 
                size -= 1;
        }

        return (size + 1) / 2;
    }
}