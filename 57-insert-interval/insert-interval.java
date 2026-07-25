class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        int currStart = 0;
        int currEnd = 0;

        List<List<Integer>> arr = new ArrayList<>();
        boolean flag = true;

        while(currEnd<n)
        {
          List<Integer> temp = new ArrayList<>();
          if( currEnd == 0 && newInterval[1]<intervals[currEnd][0])
          {
            flag = false;
            break;
          }
          while(currEnd<n && intervals[currEnd][1]<newInterval[0])
          {  
            currEnd++;
          }
          
          if(currEnd==n)
          {
            break;
          }
          else if(intervals[currEnd][0]<=newInterval[1])
          {
             int val1 = Math.min(intervals[currEnd][0],newInterval[0]);
             int val2 = Math.max(intervals[currEnd][1],newInterval[1]);

             intervals[currEnd][0] = val1;
             intervals[currEnd][1] = val2;
          }
          else
          {
            flag = false;
            break;
          }
          break;
        }
         
        System.out.println(Arrays.deepToString(intervals));

        if(!flag)
        {
            currEnd = 0;
            currStart = 0;

            while(currEnd<n)
            {
                currStart = currEnd;
                int min = intervals[currStart][0];
                int max = intervals[currStart][1];
               
                if(newInterval[1]<min && !flag)
                {
                    List<Integer> temp1 = new ArrayList<>();
                    temp1.add(newInterval[0]);
                    temp1.add(newInterval[1]);

                    arr.add(temp1);
                    flag = true;
                }

                List<Integer> temp = new ArrayList<>();

                temp.add(min);
                temp.add(max);

                arr.add(temp);
                currEnd++;
            }
        }
        else if(currEnd != n)
        {
            currEnd = 0;
            currStart = 0;
        
            while(currEnd<n)
            {
                
                int min = intervals[currEnd][0];
                int max = intervals[currEnd][1];
                while(currEnd<n-1 && intervals[currStart][1] >= intervals[currEnd+1][0])
                {
                    min = Math.min(min,intervals[currEnd+1][0]);
                    max = Math.max(max,intervals[currEnd+1][1]);
                    if(intervals[currStart][1]<intervals[currEnd+1][1])
                    {
                        currStart = currEnd+1;
                    }
                    currEnd++;
                }
                List<Integer> temp = new ArrayList<>();

                temp.add(min);
                temp.add(max);

                arr.add(temp);
                currEnd++;
                currStart = currEnd;
            }
        }
        else
        {
            currEnd = 0;
            currStart = 0;
        
            while(currEnd<n)
            {
                currStart = currEnd;
                int min = intervals[currStart][0];
                int max = intervals[currStart][1];
               
                List<Integer> temp = new ArrayList<>();

                temp.add(min);
                temp.add(max);

                arr.add(temp);
                currEnd++;
            }

            List<Integer> temp1 = new ArrayList<>();
            temp1.add(newInterval[0]);
            temp1.add(newInterval[1]);
            
            arr.add(temp1);
        }

        

        int m = arr.size();
        int[][] ans = new int[m][2];

        for(int i=0;i<m;i++)
        {
            List<Integer> temp = arr.get(i);

            ans[i][0] = temp.get(0);
            ans[i][1] = temp.get(1);
        }

        return ans;
    }
}