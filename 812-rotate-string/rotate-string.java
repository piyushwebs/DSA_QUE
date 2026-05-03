class Solution {
    public boolean rotateString(String s, String goal) {
      int n = s.length();
      int m = goal.length();
      if(m!=n) return false;
      char[] sArr = s.toCharArray();
      char[] goalArr = goal.toCharArray();
      for(int i=0;i<m;i++)
      {
        if(goalArr[i] == sArr[0])
        {
            if(check(0,i,sArr,goalArr)) return true;
        }
      } 
      return false;
    }
    public boolean check(int startS, int startG, char[] s,char[] goal)
    {
       while(startS<s.length)
       {
        if(s[startS]!=goal[startG])
        {
            return false;
        }
        startS++;
        startG=(startG+1)%goal.length;
       }
       return true;
    }
}