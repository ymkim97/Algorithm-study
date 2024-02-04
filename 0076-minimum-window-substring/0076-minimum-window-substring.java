class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> targetFreq = new HashMap<>();
        Map<Character, Integer> windowFreq = new HashMap<>();

        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minLength = Integer.MAX_VALUE, minLeft = 0, requiredChars = targetFreq.size();

        while (right < s.length()) {
            char currentChar = s.charAt(right);

            windowFreq.put(currentChar, windowFreq.getOrDefault(currentChar, 0) + 1);

            if (targetFreq.containsKey(currentChar) && windowFreq.get(currentChar).equals(targetFreq.get(currentChar))) {
                requiredChars--;
            }

            while (requiredChars == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                if (targetFreq.containsKey(leftChar) && windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
                    requiredChars++;
                }

                left++;
            }

            right++;
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLength);
    }
}