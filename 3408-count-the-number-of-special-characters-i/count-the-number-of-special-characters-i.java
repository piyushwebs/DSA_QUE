class Solution {
    public int numberOfSpecialChars(String word) {
     int n = word.length();
     char[] ch = word.toCharArray();
     char[] sCh = new char[26];   
     char[] cCh = new char[26];
     char[] con = new char[26];
     int ans = 0;
     for(char c:ch)
     {
        if(c>='A'&&c<='Z')
        {

            if(con[c-'A']==0 && sCh[c-'A']!=0)
            {
                ans++;
                con[c-'A']++;
            }
            cCh[c-'A']++;
        }
        else
        {
             if(con[c-'a']==0&&cCh[c-'a']!=0)
            {
                ans++;
                con[c-'a']++;
            }
            sCh[c-'a']++;
        }
     }
     
    return ans;   
    }
}