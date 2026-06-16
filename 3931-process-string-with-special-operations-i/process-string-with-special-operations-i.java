class Solution {
    public String processStr(String s) {
        StringBuilder str = new StringBuilder();
        char[] ch = s.toCharArray();
        for(char c:ch)
        {
            if(c>='a' && c<='z')
            {
                str.append(c);
            }
            else if(c=='*')
            {
                if(str.length()!=0)
                {
                  str.deleteCharAt(str.length()-1);
                }

            }
            else if(c=='%')
            {
               str.reverse();
            }
            else
            {
                StringBuilder rev = new StringBuilder(str);
                char[] chh = rev.toString().toCharArray();
                for(char chhh:chh)
                {
                    str.append(chhh);
                }
            }
        }
    
        return str.toString();
    }
}