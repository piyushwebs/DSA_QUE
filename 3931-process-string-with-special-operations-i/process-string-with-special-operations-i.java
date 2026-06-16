class Solution {
    public String processStr(String s) {
        Stack<Character> result = new Stack<>();
        char[] ch = s.toCharArray();
        for(char c:ch)
        {
            if(c>='a' && c<='z')
            {
                result.push(c);
            }
            else if(c=='*')
            {
                if(!result.isEmpty())
                {
                    result.pop();
                }
            }
            else if(c=='%')
            {
                StringBuilder st = new StringBuilder();
                while(!result.isEmpty())
                {
                    st.append(result.peek());
                    result.pop();
                }
                char[] chh = st.toString().toCharArray();
                for(char chhh:chh)
                {
                    result.push(chhh);
                }
            }
            else
            {
                StringBuilder str = new StringBuilder();
                while(!result.isEmpty())
                {
                    str.append(result.peek());
                    result.pop();
                }
                char[] chh = str.reverse().toString().toCharArray();
                for(char chhh:chh)
                {
                    result.push(chhh);
                }
                for(char chhh:chh)
                {
                    result.push(chhh);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while(!result.isEmpty())
        {
            res.append(result.peek());
            result.pop();
        } 
        return res.reverse().toString();
    }
}