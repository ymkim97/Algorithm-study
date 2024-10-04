class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String tree : skill_trees) {
            StringBuilder sb = new StringBuilder();
            
            for (char c : tree.toCharArray()) {
                if (skill.contains(String.valueOf(c))) sb.append(c);
            }
            
            String filtered = sb.toString();

            if (skill.startsWith(filtered)) answer += 1;
        }
        
        return answer;
    }
}