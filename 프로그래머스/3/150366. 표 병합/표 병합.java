import java.util.*;

class Solution {
    public String[] solution(String[] commands) {
        List<String> output = new ArrayList<>();
        
        Point[][] merged = new Point[51][51];
        String[][] content = new String[51][51];
        
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                Point p = new Point(i, j);
                merged[i][j] = p;
                content[i][j] = "EMPTY";
            }
        }
        
        for (String command : commands) {
            String[] cmd = command.split(" ");
            
            if (cmd[0].equals("UPDATE")) {
                if (cmd.length == 4) {
                    Point p = merged[Integer.parseInt(cmd[1])][Integer.parseInt(cmd[2])];
                    content[p.r][p.c] = cmd[3];
                }
                else if (cmd.length == 3) {
                    for (int i = 0; i < 51; i++) {
                        for (int j = 0; j < 51; j++) {
                            if (content[i][j].equals(cmd[1])) content[i][j] = cmd[2];
                        }
                    }
                }
            } else if (cmd[0].equals("MERGE")) {
                Point p1 = merged[Integer.parseInt(cmd[1])][Integer.parseInt(cmd[2])];
                Point p2 = merged[Integer.parseInt(cmd[3])][Integer.parseInt(cmd[4])];
                
                merged[p2.r][p2.c] = p1;
                
                for (int i = 0; i < 51; i++) {
                    for (int j = 0; j < 51; j++) {
                        if (merged[i][j].r == p2.r && merged[i][j].c == p2.c) {
                            merged[i][j] = p1;
                        }
                    }
                }
                
                if (content[p1.r][p1.c] != "EMPTY") {
                    content[p2.r][p2.c] = content[p1.r][p1.c];
                } else {
                    content[p1.r][p1.c] = content[p2.r][p2.c];
                }
            } else if (cmd[0].equals("UNMERGE")) {
                Point p = merged[Integer.parseInt(cmd[1])][Integer.parseInt(cmd[2])];
                String temp = content[p.r][p.c];
                
                for (int i = 0; i < 51; i++) {
                    for (int j = 0; j < 51; j++) {
                        if (merged[i][j].r == p.r && merged[i][j].c == p.c) {
                            content[i][j] = "EMPTY";
                            merged[i][j] = new Point(i, j);
                        }
                    }
                }
                
                content[Integer.parseInt(cmd[1])][Integer.parseInt(cmd[2])] = temp;
                
            } else {
                Point p = merged[Integer.parseInt(cmd[1])][Integer.parseInt(cmd[2])];
                output.add(content[p.r][p.c]);
            }
        }
        
        String[] answer = new String[output.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = output.get(i);
        }
        
        return answer;
    }
    
    static class Point {
        int r;
        int c;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}