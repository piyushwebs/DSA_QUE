class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        if(n==1)
        {
            return 0;
        }

        int profit = 0;

        int[] dpBuy = new int[n];
        int[] dpSell = new int[n];
        int[] bestBuy = new int[n];
        
        dpBuy[n-1] = 0;
        dpSell[n-1] = 0;
        dpSell[n-2] = 0;
        
        for(int i=n-2;i>=0;i--)
        {
            int buy = prices[i];
            for(int j=i+1;j<n;j++)
            {
               if(buy<prices[j])
               {
                 dpBuy[i] = Math.max(dpBuy[i],(prices[j]-buy+dpSell[j]));
                 
                 
                 
               }
            }
            bestBuy[i] = Math.max(bestBuy[i+1],dpBuy[i]);
            profit = Math.max(profit,dpBuy[i]);
            if(i<n-2)
            {
              dpSell[i] = bestBuy[i+2];
            }
            // for(int j=i+2;j<n;j++)
            // {
            //     dpSell[i] = Math.max(dpSell[i],dpBuy[j]);
            // }
            
        }
        
        return profit;
    }

   
}