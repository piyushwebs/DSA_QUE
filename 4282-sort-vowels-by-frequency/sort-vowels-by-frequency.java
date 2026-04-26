class Solution {
    public String sortVowels(String s) {
        LinkedHashMap<Character,Integer> lhm = new LinkedHashMap<>();
        int n =s.length();
        char[] ch = s.toCharArray();
        for(int i=0;i<n;i++)
        {
           if(ch[i]=='a'||ch[i]=='e'||ch[i]=='o'||ch[i]=='i'||ch[i]=='u')
           {
            lhm.put(ch[i],lhm.getOrDefault(ch[i],0)+1);
           }
        }
        int j =0;
        while(!lhm.isEmpty())
        {
         Set<Character> st = lhm.keySet();
         int max = Integer.MIN_VALUE;
         char maxC = 'a';
         for(Character c:st)
         {
           if(lhm.get(c)>max)
           {
            max = lhm.get(c);
            maxC = c;
           }
         }
         lhm.remove(maxC);
         while(j<n && max>0)
         {
             if(ch[j]=='a'||ch[j]=='e'||ch[j]=='o'||ch[j]=='i'||ch[j]=='u')
           {
               ch[j] = maxC;
               max--;
           }
           j++;
         }
        }
        StringBuilder str = new StringBuilder("");
        for(int i=0;i<n;i++)
        {
           str.append(ch[i]);
        }
        return str.toString();
    }
}