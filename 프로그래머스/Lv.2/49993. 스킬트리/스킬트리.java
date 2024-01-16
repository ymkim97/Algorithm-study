import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String skillTree : skill_trees) {
            StringBuilder sb = new StringBuilder();
            char[] tree = skillTree.toCharArray();
            
            for (int i = 0; i < tree.length; i++) {
                if (skill.contains(Character.toString(tree[i]))) {
                    sb.append(tree[i]);
                }
            }
            
            String tmp = sb.toString();
            if (skill.startsWith(tmp)) {
                answer += 1;
            }
        }
        
        return answer;
    }
}