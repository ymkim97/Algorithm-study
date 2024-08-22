class Solution {
    public int findComplement(int num) {
        String bin = convertToBin(num);

        int answer = 0;

        System.out.println(bin);

        for (int i = 0; i < bin.length(); i++) {
            answer += Math.pow(2, i) * Character.getNumericValue(bin.charAt(i));
        }

        return answer;
    }

    public String convertToBin(int num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(num % 2 == 1 ? 0 : 1);
            num /= 2;
        }

        return sb.toString();
    }
}