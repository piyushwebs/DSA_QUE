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
        
        dpBuy[n-1] = 0;
        dpSell[n-1] = 0;
        dpSell[n-2] = 0;
        
        for(int i=n-2;i>=0;i--)
        {
            int buy = prices[i];
            int sell = prices[i];
            for(int j=i+1;j<n;j++)
            {
               if(buy<prices[j])
               {
                 dpBuy[i] = Math.max(dpBuy[i],(prices[j]-buy+dpSell[j]));
               }
            }
            
            for(int j=i+2;j<n;j++)
            {
                dpSell[i] = Math.max(dpSell[i],dpBuy[j]);
            }
            
        }
        
        int max = 0;
        for(int i=0;i<n;i++)
        {
            max = Math.max(max,dpBuy[i]);
        }

        return max;
    }

    public int findProfit(int[] prices,int idx,int profit,int n)
    {
        if(idx>n)
        {

            return profit;
        }
        int max = 0;
        for(int i=idx;i<n;i++)
        {
            if(prices[i]>prices[idx])
            {
                System.out.println(prices[i]);
                profit = profit + prices[i]-prices[idx];
                System.out.println("Profit: "+profit);
                profit = findProfit(prices,i+2,profit,n);
                max = Math.max(profit,max);
                profit = profit - (prices[i] - prices[idx]);
            }
        }
        return max;
    }
}