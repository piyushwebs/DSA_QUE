class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder("");
        for(int i=1;i<=n;i++)
        {
            str.append(i);
        }
        if(k == 1) return str.toString();
        String s = str.toString();
        List<String> ans = new ArrayList<>();
       
        for(int i=1;i<=n;i++)
        {
          boolean[] visited = new boolean[n+1];
          visited[i]=true;
          StringBuilder sb = new StringBuilder();
          formCombinations(s,ans,n,sb.append(i),visited);
        }
        return ans.get(k-1);
    }
    public void formCombinations(String s,List<String> ans, int n,StringBuilder temp,boolean[] visited)
    {
        for(int i=1;i<=n;i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                temp.append(i);
                formCombinations(s,ans,n,temp,visited);
                if(temp.length()==n)
                {
                  ans.add(new String(temp.toString()));
                }
                visited[i] = false;
                temp.deleteCharAt(temp.length()-1);
            }
        }
        
    }
}