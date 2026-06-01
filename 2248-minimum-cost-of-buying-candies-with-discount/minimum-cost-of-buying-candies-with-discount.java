class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        Arrays.sort(cost);
        int costT = 0;
        int i=n-1;
        while(i>=0)
        {
          costT += cost[i--];
          if(i>=0)
          {
          costT += cost[i--];

          }
          i--; 
        }
        return costT;
    }
}