class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));

        List<List<Integer>> arr = new ArrayList<>();

        System.out.println(Arrays.deepToString(intervals));
        
        int left = 0;
        int right = 0;
        int i = 0;
        while(right<n)
        {
            int min = intervals[right][0];
            int max = intervals[right][1];
            while(right<n-1 && intervals[left][1]>=intervals[right+1][0])
            {
                min = Math.min(min,intervals[right+1][0]);
                max = Math.max(max,intervals[right+1][1]);
                if(intervals[left][1]<intervals[right+1][1])
                {
                  left=right+1;
                }
                right++;
            }
            
            List<Integer> temp = new ArrayList<>();

            temp.add(min);
            temp.add(max);
            
            arr.add(temp);
            right++;
            left = right;
            i++;
        }
        
        int[][] ans = new int[arr.size()][2];
        for(int j=0;j<arr.size();j++)
        {
           List<Integer> temp = arr.get(j);
           ans[j][0] = temp.get(0);
           ans[j][1] = temp.get(1);
        }

        return ans;
    }
}