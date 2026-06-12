class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n =nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int[] selected = new int[n];
            List<Integer> temp =new ArrayList<>();
          
            Arrays.fill(selected,-1);
            selected[i]=0;
            temp.add(nums[i]);
            formPermut(nums,ans,temp,i,n,selected);
             
        }
        return ans;
    }
    public void formPermut(int[] nums,List<List<Integer>> ans,List<Integer> temp,int itr, int n,int[]selected)
    {
        for(int i=0;i<n;i++)
        {
            if(selected[i]==-1)
            {
               temp.add(nums[i]);
               selected[i]=0;
               formPermut(nums,ans,temp,i,n,selected);
               temp.remove(temp.size()-1);
               selected[i]=-1;
            }  
        }
        if(temp.size()==n)
        {
           ans.add(new ArrayList(temp));
        }
    }
}