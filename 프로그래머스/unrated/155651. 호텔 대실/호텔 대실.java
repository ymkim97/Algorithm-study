import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] bookInt = new int[book_time.length][2];
        
        for(int i = 0; i < book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", ""));
            
            end += 10;
            if(end % 100 >= 60) {
                end += 40;
            }
            
            bookInt[i][0] = start;
            bookInt[i][1] = end;
        }
        
        Arrays.sort(bookInt, (a, b) -> {
            
            if(a[0] > b[0]) {
                return 1;
            }
            
            else if(a[0] < b[0]) {
                return -1;
            }
            
            else {
                if(a[1] > b[1]) {
                    return 1;
                }
                else return -1;
            }
        });
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        
        for(int[] timeArr: bookInt) {
            if(rooms.size() == 0) {
                rooms.add(timeArr[1]);
                continue;
            }
            
            int earliest = rooms.peek();
            if(timeArr[0] >= earliest) {
                rooms.poll();
            }
            rooms.add(timeArr[1]);
        }
        
        return rooms.size();
    }
}