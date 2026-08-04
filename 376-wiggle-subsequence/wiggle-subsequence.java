class Solution {
    public int wiggleMaxLength(int[] nums) {
        int ans = 0;
        
        int n = nums.length;

        int[] dpPos = new int[n];
        int[] dpNeg = new int[n];

        Arrays.fill(dpPos,1);
        Arrays.fill(dpNeg,1);

        for(int i=n-2;i>=0;i--)
        {
            int val = nums[i];

            for(int j=i+1;j<n;j++)
            {
                if(val>nums[j])
                {
                    dpPos[i] = Math.max(dpPos[i],(dpNeg[j]+1));
                }
            }

            for(int j=i+1;j<n;j++)
            {
                if(val<nums[j])
                {
                    dpNeg[i] = Math.max(dpNeg[i],(dpPos[j]+1));
                }
            }
        }

        return Math.max(dpPos[0],dpNeg[0]);
     }
    }