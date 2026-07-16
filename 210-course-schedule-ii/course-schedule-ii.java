class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] ans = new int[numCourses];
        
        List<Integer>[] arr = new ArrayList[numCourses];
        
        for(int i=0;i<numCourses;i++)
        {
            arr[i] = new ArrayList<>();
        }
        
        int n = prerequisites.length;
        
        int[] inDegree = new int[numCourses];

        
        for(int i=0;i<n;i++)
        {
            arr[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        // for(int i=0;i<numCourses;i++)
        // {
        //     System.out.println(i+" : "+arr[i]);
        // }
        
        int j = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(inDegree[i]==0)
            {
                q.offer(i);
            }
        }
        while(!q.isEmpty())
        {
            int val = q.poll();
            ans[j] = val;
           
            ArrayList<Integer> temp = new ArrayList<>(arr[val]);
             j++;
            for(int i=0;i<temp.size();i++)
            {
                inDegree[temp.get(i)]--;
                if(inDegree[temp.get(i)]==0)
                {
                    q.offer(temp.get(i));
                }
            }
        }
        for(int i=0;i<numCourses;i++)
        {
            if(inDegree[i]!=0) return new int[0];
        }

        return ans;
    }
}