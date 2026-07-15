class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        if(n==0) return true;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++)
        {
           if(hm.containsKey(prerequisites[i][1]))
           {
            if(prerequisites[i][0]==hm.get(prerequisites[i][1])) return false;
           }
           hm.put(prerequisites[i][0],prerequisites[i][1]);
        }
        Arrays.sort(prerequisites,(a,b)->Integer.compare(a[1],b[1]));

        System.out.println(Arrays.deepToString(prerequisites));
        for(int i=0;i<n;i++)
        {
            int val1 = prerequisites[i][0];
            int val2 = prerequisites[i][1];
            if(val1 == val2) return false;
          for(int j=0;j<n;j++)
          {
             if(val2 == prerequisites[j][0])
             {
                prerequisites[j][0] = val1;
             } 
          }
        }
       
        return true;
    }
}