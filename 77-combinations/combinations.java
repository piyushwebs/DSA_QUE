class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> arr = new ArrayList<>();

       
            List<Integer> temp = new ArrayList<>();
            for(int idx = 1;idx<=(n-k+1);idx++)
            {
               combineList(n, k, arr, temp, idx);
               temp = new ArrayList<>();
            }
        
        return arr;
    }

    public void combineList(int n, int k, List<List<Integer>> arr, List<Integer> temp, int idx) {
        if (idx > n) {
            return;
        }
        temp.add(idx);
        if (temp.size() == k) {
            arr.add(new ArrayList<>(temp));
            return;
        }
        for (idx = idx; idx < n; idx++) {
            combineList(n, k, arr, temp, idx + 1);
            temp.remove(temp.size() - 1);
        }

    }

}