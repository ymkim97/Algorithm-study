import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Stack<String[]> stk = new Stack<>();
        Arrays.sort(plans, (a, b) -> a[1].compareTo(b[1]));
        
        for (String[] plan : plans) {
            String[] time = plan[1].split(":");
            int newTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            plan[1] = String.valueOf(newTime);
            plan[2] = String.valueOf(newTime + Integer.parseInt(plan[2]));
        }
        
        for (int i = 0; i < plans.length; i++) {
            if (i == plans.length - 1) { // 마지막 남은거는 끝까지 수행
                answer.add(plans[i][0]);
                break;
            }
            
            int nowStart = Integer.parseInt(plans[i][1]);
            int nowEnd = Integer.parseInt(plans[i][2]);
            int nextStart = Integer.parseInt(plans[i + 1][1]);
            
            if (nextStart >= nowEnd) { // 다음 과제 시작 전에 끝남
                answer.add(plans[i][0]);
                
                if (nowEnd != nextStart) { // 시간이 남고 중단한 과제가 있으면
                    int time = nowEnd;
                    
                    while (!stk.isEmpty() && time <= nextStart) {
                        String[] tmp = stk.pop();
                        int remainTime = Integer.parseInt(tmp[1]);
                        
                        if (remainTime + time <= nextStart) {
                            answer.add(tmp[0]);
                            time += remainTime;
                        }
                        
                        else {
                            stk.add(new String[] {tmp[0], String.valueOf(time + remainTime - nextStart)});
                            break;
                        }
                    }                  
                }
            }
            
            else {
                String remain = String.valueOf(nowEnd - nowStart - (nextStart - nowStart));
                stk.add(new String[] {plans[i][0], remain});
            }
        }
        
        while (!stk.isEmpty()) {
            answer.add(stk.pop()[0]);
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}