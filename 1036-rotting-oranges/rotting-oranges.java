class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int minutes = 0;

        Set<List<Integer>> st = new HashSet<>();
        Queue<List<Integer>> q = new LinkedList<>();

       

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 1)
                {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j);

                    st.add(arr);
                }
                else if(grid[i][j] == 2)
                {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j);

                    q.offer(arr);
                }
            }
        }



        if(st.size() == 0)
        {
            return 0;
        }

        while(!q.isEmpty() && !st.isEmpty())
        {
            int itr = q.size();
            minutes++;
            for(int i=0;i<itr;i++)
            {
                List<Integer> arr = q.poll();

                int[] a = {arr.get(0),arr.get(1)-1,arr.get(0),arr.get(1)+1,arr.get(0)+1,arr.get(1),arr.get(0)-1,arr.get(1)};
              
                int j = 0;
                while(j<8)
                {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(a[j],a[j+1]));
                    if(st.contains(temp))
                    {
                        q.offer(temp);
                        st.remove(temp);
                    }
                    j+=2;
                }
            }
        }
        if(st.size()!=0) 
        {
            return -1;
        }
        return minutes;
    }
}