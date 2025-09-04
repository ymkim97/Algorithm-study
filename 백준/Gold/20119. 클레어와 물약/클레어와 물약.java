import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] recipeMap = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            recipeMap[i] = new ArrayList<>();
        }

        int[] recipeType = new int[M];
        int[] recipeIndegree = new int[M];
    
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int numberOfRecipe = Integer.parseInt(st.nextToken());

            for (int j = 0; j < numberOfRecipe; j++) {
                recipeMap[Integer.parseInt(st.nextToken())].add(i);
            }

            recipeIndegree[i] = numberOfRecipe;

            int potion = Integer.parseInt(st.nextToken());
            recipeType[i] = potion;
        }

        int L = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        List<Integer> answers = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < L; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }
        
        while (!q.isEmpty()) {
            int potion = q.poll();
            if (visited[potion]) continue;

            answers.add(potion);
            visited[potion] = true;

            for (int recipe : recipeMap[potion]) {
                recipeIndegree[recipe] -= 1;
                if (recipeIndegree[recipe] == 0) q.offer(recipeType[recipe]);
            }
        }

        answers.sort((a, b) -> a.compareTo(b));

        StringBuilder sb = new StringBuilder();
        sb.append(answers.size()).append("\n");
        for (int n : answers) {
            sb.append(n).append(" ");
        }
        System.out.println(sb.toString());
    }
}
