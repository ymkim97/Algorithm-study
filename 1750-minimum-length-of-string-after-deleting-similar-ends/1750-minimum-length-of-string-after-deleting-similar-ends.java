class Solution {

    public int minimumLength(String s) {
        while (s.length() > 1 && isSame(s)) {
            int l = 0;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(0)) {
                    l = i;
                }

                else {
                    break;
                }
            }

            if (l == s.length() - 1) {
                s = "";
                break;
            }

            s = s.substring(l + 1);

            int r = s.length() - 1;

            for (int i = r - 1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(s.length() - 1)) {
                    r = i;
                }

                else {
                    break;
                }
            }

            s = s.substring(0, r);
        }

        return s.length();
    }

    public boolean isSame(String s) {
        if (s.charAt(0) == s.charAt(s.length() - 1)) return true;

        return false;
    }
}