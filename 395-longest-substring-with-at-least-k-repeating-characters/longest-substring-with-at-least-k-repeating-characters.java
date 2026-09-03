class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        System.out.println(n);
        
        
        
        int left = 0;
        int ans = 0;
        
        for(int i=0;i<n;i++)
        {
            int[] arr = new int[26];
            for(int j=i;j<n;j++)
            {
                arr[s.charAt(j)-'a']++;
                if(check(arr,k))
                {
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
    public boolean check(int[] arr,int k)
    {
        for(int i=0;i<26;i++)
        {
            if(arr[i]!=0 && arr[i]<k)
            {
                return false;
            }
        }
        return true;
    }
}