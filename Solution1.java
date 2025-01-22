class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        int n=isWater.length;
        int m=isWater[0].length;
        int[][] res=new int[n][m];
        for(int[] x:res)
            Arrays.fill(x,-1);
        Queue<int[]> q=new LinkedList<>();
        int i,j;
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(isWater[i][j]==1)
                {
                    q.add(new int[]{i,j});
                    res[i][j]=0;
                }
            }
        }
        int cnt=1;
        while(!q.isEmpty())
        {
            int level=q.size();
            for(i=0;i<level;i++)
            {
                int[] x=q.poll();
                for(int[] d:dir)
                {
                    int nr=x[0]+d[0];
                    int nc=x[1]+d[1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && res[nr][nc]==-1)
                    {
                        res[nr][nc]=cnt;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            cnt++;
        }
        return res;
    }
}