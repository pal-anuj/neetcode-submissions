class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        
        int land=0;
        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i, j});
                }else if(grid[i][j]== 2147483647){
                    land++;
                }
            }
        }

        int[][] dirs= {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()){
            int size= q.size();

            for(int i=0;i<size;i++){
                int[] cur= q.poll();

                for(int[] dir : dirs){
                    int nr= cur[0] + dir[0];
                    int nc= cur[1] + dir[1];

                    if(nr >=0 && nc >= 0 && nr < n && nc < m 
                        && grid[nr][nc]==2147483647){
                        grid[nr][nc]= grid[cur[0]][cur[1]] + 1;
                        q.add(new int[]{nr,nc});
                        land--;
                    }
                }
            }
        }
    }
}
