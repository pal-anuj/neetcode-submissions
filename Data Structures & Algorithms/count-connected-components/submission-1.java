class Solution {
    public int countComponents(int n, int[][] edges) {

        // build adjList, graph
        List<List<Integer>> adjList= new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);// undirectional
        }
        boolean visited[] = new boolean[n];
        int component=0;

        for(int i=0;i<n;i++){
            if(visited[i]!=true){
                component++;
                DFS(i, adjList, visited);
            }
        }
        return component;
    }

    public void DFS(int i, List<List<Integer>> adjList
            ,boolean[] visited){
        visited[i]=true;
        for(int nei : adjList.get(i))
        {
            if(visited[nei]!=true)
                DFS(nei, adjList, visited);
        }
    }
}
