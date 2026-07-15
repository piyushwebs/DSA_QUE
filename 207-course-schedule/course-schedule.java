class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, graph, visited, pathVisited))
                    return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, ArrayList<Integer>[] graph,
                        boolean[] visited,
                        boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbour : graph[node]) {

            if (!visited[neighbour]) {

                if (dfs(neighbour, graph, visited, pathVisited))
                    return true;

            } else if (pathVisited[neighbour]) {

                return true;
            }
        }

        pathVisited[node] = false;

        return false;
    }
}