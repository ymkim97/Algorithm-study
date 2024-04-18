import java.io.*;
import java.util.*;

class Main {
    
    static int answer = 0;
    static int N;
    static List<Egg> eggs = new ArrayList<>();
    static boolean[] isBroken;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        isBroken = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dur = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            eggs.add(new Egg(dur, weight));
        }
        
        backtrack(0, 0);
        
        System.out.println(answer);
    }
    
    static public void backtrack(int idx, int broken) {
        answer = Math.max(answer, broken);
        
        if (idx == N) return;
        
        if (isBroken[idx]) {
            backtrack(idx + 1, broken);
            return;
        }
        
        Egg egg = eggs.get(idx);
        
        for (int i = 0; i < N; i++) {
            if (i == idx || isBroken[i]) continue;
            int tmpCnt = 0;
            Egg tmp = eggs.get(i);
            
            egg.durability -= tmp.weight;
            tmp.durability -= egg.weight;
            
            if (egg.durability <= 0) {
                isBroken[idx] = true;
                tmpCnt += 1;
            }
            
            if (tmp.durability <= 0) {
                isBroken[i] = true;
                tmpCnt += 1;
            }
            
            eggs.set(idx, egg);
            eggs.set(i, tmp);
            backtrack(idx + 1, broken + tmpCnt);
            egg.durability += tmp.weight;
            tmp.durability += egg.weight;
            eggs.set(idx, egg);
            eggs.set(i, tmp);
            isBroken[idx] = false;
            isBroken[i] = false;
        }
    }
    
    static class Egg {
        int durability;
        int weight;
        
        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
