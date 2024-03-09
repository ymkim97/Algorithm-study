class Solution {
    
    int answer;
    String[] datas;
    boolean[] visited = new boolean[8];
    char[] kakao = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    StringBuilder sb = new StringBuilder();
    
    public int solution(int n, String[] data) {
        answer = 0;
        this.datas = data;
        
        dfs(0);
        
        return answer;
    }
    
    public void dfs(int depth) {
        if (depth == 8) {
            boolean isAvail = true;
            String line = sb.toString();
            
            for (String data : datas) {
                char a = data.charAt(0);
                char b = data.charAt(2);
                char op = data.charAt(3);
                int length = Integer.parseInt(String.valueOf(data.charAt(4))) + 1;
                int diff = Math.abs(line.indexOf(a) - line.indexOf(b));
                
                if (op == '=' && diff != length) {
                    isAvail = false;
                    break;
                }
                
                else if (op == '>' && diff <= length) {
                    isAvail = false;
                    break;
                }
                
                else if (op == '<' && diff >= length) {
                   isAvail = false;
                    break; 
                }
            }
            
            if (isAvail) answer += 1;
            
            return;
        } 
        
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(kakao[i]);
                dfs(depth + 1);
                sb.deleteCharAt(depth);
                visited[i] = false;
            }
        }
    }
}