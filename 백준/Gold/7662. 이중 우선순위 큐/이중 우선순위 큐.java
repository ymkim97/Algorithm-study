import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N ; i++){
            TreeSet<Integer> set = new TreeSet<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            
            int M = Integer.parseInt(br.readLine());
            
            for(int j = 0 ; j < M ; j++){

                StringTokenizer st = new StringTokenizer(br.readLine());
                
                String data = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (data.equals("I")){
                    set.add(value);
                    
                    if (map.containsKey(value)){
                        map.put(value, map.get(value)+ 1);
                    }
                    
                    else {
                        map.put(value, 1);
                    }
                }
                
                else {
                	
                    if (value == 1){
                        if (!set.isEmpty())
                        {
                            int data1 = set.last();
                            if (map.get(data1) > 1){
                                map.put(data1, map.get(data1) - 1);
                            }
                            
                            else {
                                set.remove(data1);
                                map.put(data1, map.get(data1) - 1);
                            }
                        }

                    }
                    
                    else {
                        
                    	if (!set.isEmpty())
                        {
                            int data1 = set.first();
                            if(map.get(data1) > 1){
                                map.put(data1, map.get(data1) - 1);
                            }
                            
                            else {
                                set.remove(data1);
                                map.put(data1, map.get(data1) - 1);
                            }
                        }
                    }
                }
            }
            
            if(!set.isEmpty()){
                System.out.println(set.last() + " " + set.first());
            }
            
            else{
                System.out.println("EMPTY");
            }
        }
	}
}