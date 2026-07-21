class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans  = 0;
        
        HashMap<Character,Integer> hm = new HashMap<>();

        char[] a = s.toCharArray();

        int left = 0;
        int right = 0;

        while(right<n)
        {
            if(!hm.containsKey(a[right]))
            {
               hm.put(a[right],1);
               right++;
            }
            else
            {
                ans = Math.max(ans,(s.substring(left,right).length()));
                while(a[left]!=a[right])
                {
                    hm.remove(a[left]);
                    left++;
                }
                hm.remove(a[left]);
                left++;
            }
        }
        ans = Math.max(ans,s.substring(left,right).length());
        return ans;
    }
}