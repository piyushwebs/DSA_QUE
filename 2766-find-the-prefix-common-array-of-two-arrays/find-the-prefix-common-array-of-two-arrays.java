class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
       int[] ans = new int[n];
       Arrays.fill(ans,0);
       HashMap<Integer,Integer> hm = new HashMap<>();
       hm.put(A[0],hm.getOrDefault(A[0],0)+1);
       for(int i=0;i<n;i++)
       {
         if(i==0)
         {
            if(A[i] == B[i])
            {
               ans[i] = 1;
            }
             else 
            {
             ans[i] = 0;
             hm.put(A[i],1);
             hm.put(B[i],1);
            }
         }
         else
         {
            if(A[i] == B[i])
            {
                ans[i] = ans[i-1]+1;
            }
            else
            {
                int count = 0;
                if(hm.containsKey(A[i]))
                {
                   count++;
                }
                else
                {
                     hm.put(A[i],1);
                }
                if(hm.containsKey(B[i]))
                {
                    count++;
                }
                else
                {
                     hm.put(B[i],1);
                }
                if(!hm.containsKey(A[i]) && !hm.containsKey(B[i]))
                {
                     ans[i] = ans[i-1];
                }
                else
                {
                    ans[i] = ans[i-1]+count;
                }
            }
         }
       }
        return ans;
    }
}