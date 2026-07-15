class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        if (n == 0)
            return true;
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(prerequisites[i][1])) {
                ArrayList<Integer> arr = hm.get(prerequisites[i][1]);
                for (int j = 0; j < arr.size(); j++) {
                    if (arr.get(j) == prerequisites[i][0])
                        return false;
                }
                    ArrayList<Integer> list1 = new ArrayList<>();
                    list1.add(prerequisites[i][1]);
                hm.put(prerequisites[i][0],list1);
            } else {
                if (hm.containsKey(prerequisites[i][0])) {
                    hm.get(prerequisites[i][0]).add(prerequisites[i][1]);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(prerequisites[i][1]);
                    hm.put(prerequisites[i][0], list);
                }
            }
        }
        Arrays.sort(prerequisites, (a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 0; i < n; i++) {
            int val1 = prerequisites[i][0];
            int val2 = prerequisites[i][1];
            if (val1 == val2)
                return false;
            for (int j = 0; j < n; j++) {
                if (val2 == prerequisites[j][0]) {
                    prerequisites[j][0] = val1;
                }
            }
        }

        return true;
    }
}