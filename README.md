# january22_2025
The problems that I solved today

1.You are given an integer matrix isWater of size m x n that represents a map of land and water cells. If isWater[i][j] == 0, cell (i, j) is a land cell. If isWater[i][j] == 1, cell (i, j) is a water cell. You must assign each cell a height in a way that follows these rules: The height of each cell must be non-negative. If the cell is a water cell, its height must be 0. Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching). Find an assignment of heights such that the maximum height in the matrix is maximized. Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.

Code:
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

2.Given the root of a binary tree, determine if it is a valid binary search tree (BST). A valid BST is defined as follows: The left subtree of a node contains only nodes with keys less than the node's key. The right subtree of a node contains only nodes with keys greater than the node's key. Both the left and right subtrees must also be binary search trees.

Code:
class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean valid(TreeNode root,long min,long max)
    {
        if(root==null)
            return true;
        if(root.val>=max || root.val<=min)
            return false;
        return valid(root.left,min,root.val) && valid(root.right,root.val,max);
    }
}
