class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int a = arrayA[0];
        int b = arrayB[0];
        
        for (int i = 1; i < arrayA.length; i++) {
            a = gcd(a, arrayA[i]);
        }
        
        for (int i = 1; i < arrayB.length; i++) {
            b = gcd(b, arrayB[i]);
        }
        
        if (check(arrayA, b)) {
            answer = Math.max(answer, b);
        }
        
        if (check(arrayB, a)) {
            answer = Math.max(answer, a);
        }
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        if (a % b == 0){
            return b;
        }
        
        return gcd(b, a % b);
    }
    
    public boolean check(int[] array, int n) {
        for (int a : array) {
            if (a % n == 0) return false;
        }
        
        return true;
    }
}