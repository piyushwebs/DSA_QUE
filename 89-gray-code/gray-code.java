class Solution {
    public List<Integer> grayCode(int n) {
        int val = (int) Math.pow(2, n);
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        ans.add(0);
        int start = 0;
        hm.put(start, 1);
        int i=1;
        while (ans.size() != val) {
                int cal = start ^ i;
                if (!hm.containsKey(cal) && cal > 0 && cal < val) {
                    ans.add(cal);
                    hm.put(cal, 1);
                    start=cal;
                    i=0;
                }
                i++;
        }
        return ans;

    }
}