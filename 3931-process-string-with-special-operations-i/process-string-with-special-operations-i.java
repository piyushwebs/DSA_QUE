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
                str.append(str.toString());
                
            }
        }
    
        return str.toString();
    }
}