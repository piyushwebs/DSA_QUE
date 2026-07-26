class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        int left = 0;
        while(left<n)
        {
           int right = ans.length()+left+1;
           while(right<=n)
           {
                String sub = s.substring(left,right);
                if(checkPal(sub))
                {
                    ans = sub;
                }
                right++;
            }
            left++;
        }
         
         return ans;

    }
    public boolean checkPal(String sub)
    {
        int left = 0;
        int right = sub.length()-1;
        while(left<right)
        {
            if(sub.charAt(left)!=sub.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}