import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int[] visited;  // 0 = unvisited, 1 = visiting, 2 = visited

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build the graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            graph.get(pre).add(course);  // Edge: pre → course
        }

        visited = new int[numCourses];

        // Step 2: DFS on each course
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int course) {
        if (visited[course] == 1) {
            return false; // cycle detected
        }

        if (visited[course] == 2) {
            return true; // already processed safely
        }

        visited[course] = 1; // mark as visiting

        for (int neighbor : graph.get(course)) {
            if (!dfs(neighbor)) {
                return false;
            }
        }

        visited[course] = 2; // mark as visited
        return true;
    }
}
