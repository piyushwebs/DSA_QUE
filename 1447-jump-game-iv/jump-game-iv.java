class Solution {
    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1)
            return 0;

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {

            hm.putIfAbsent(arr[i], new ArrayList<>());
            hm.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[n];

        q.add(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int curr = q.poll();

                if (curr == n - 1)
                    return steps;

                // curr - 1
                if (curr - 1 >= 0 && !visited[curr - 1]) {

                    visited[curr - 1] = true;
                    q.add(curr - 1);
                }

                // curr + 1
                if (curr + 1 < n && !visited[curr + 1]) {

                    visited[curr + 1] = true;
                    q.add(curr + 1);
                }

                // same value jumps
                if (hm.containsKey(arr[curr])) {

                    for (int next : hm.get(arr[curr])) {

                        if (!visited[next]) {

                            visited[next] = true;
                            q.add(next);
                        }
                    }

                    // important optimization
                    hm.remove(arr[curr]);
                }
            }

            steps++;
        }

        return -1;
    }
}