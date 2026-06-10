class Solution {
    public boolean isHappy(int n) {
      HashMap<Integer,Integer> hm = new HashMap<>();
      return check(n,hm);
    }
    public boolean check(int n,HashMap<Integer,Integer> hm)
    {
        if(n==1) return true;
       if(!hm.isEmpty() && hm.containsKey(n)) return false;
       hm.put(n,1);
       int sum =0;
       while(n>0)
       {
         int rem = n%10;
         sum = sum+(int)Math.pow(rem,2);
         n = n/10;
       } 
       return check(sum,hm);
    }
}