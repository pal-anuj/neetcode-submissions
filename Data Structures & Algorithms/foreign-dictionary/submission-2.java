class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, List<Character>> graph= new HashMap<>();
        HashMap<Character, Integer> indegree= new HashMap<>();
        for( String word : words){
            for(char c : word.toCharArray()){
                graph.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for(int i=0;i< words.length-1;i++){
            String first= words[i];
            String second= words[i+1];
            boolean foundDifference = false;

            for(int j=0;j< first.length() && j < second.length();j++){
                if(first.charAt(j)!= second.charAt(j)){
                    char u= first.charAt(j);
                    char v= second.charAt(j);
                    if(!graph.get(u).contains(v)){
                        graph.get(u).add(v);
                        indegree.put(v, indegree.get(v)+1);
                        
                    }
                    foundDifference=true;                    
                    break;
                }
            }
            // Invalid case:
            // ["abc", "ab"]
            if(!foundDifference && first.length() > second.length()) 
                return "";
        }



        // Topological Sort
        Queue<Character> q= new LinkedList<>();
        // adding all element which have 0 indegree
        for(char c : indegree.keySet()){ 
            if(indegree.get(c)==0)
                q.offer(c);
        }

        StringBuilder res= new StringBuilder();
        while(!q.isEmpty()){
            char u= q.poll();
            res.append(u);
            for(char v : graph.get(u)){
                indegree.put(v, indegree.get(v) - 1);
                if(indegree.get(v)==0){
                    q.offer(v);
                }
            }
        }

        // Cycle detected
        if (res.length() != indegree.size()) {
            return "";
        }

        return res.toString();
    }
}
