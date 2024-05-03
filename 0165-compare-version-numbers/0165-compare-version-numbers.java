class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");

        int maxLength = Math.max(ver1.length, ver2.length);

        for (int i = 0; i < maxLength; i++) {
            int curV1 = -1;
            int curV2 = -1;

            if (ver1.length <= i) curV1 = 0;
            if (ver2.length <= i) curV2 = 0;

            if (curV1 == -1) curV1 = Integer.parseInt(ver1[i]);
            if (curV2 == -1) curV2 = Integer.parseInt(ver2[i]);

            if (curV1 != curV2) {
                return curV1 > curV2 ? 1 : -1;
            }
        }

        return 0;
    }
}