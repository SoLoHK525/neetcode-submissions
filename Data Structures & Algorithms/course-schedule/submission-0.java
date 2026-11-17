class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> depGraph = new HashMap<>();
        for(int[] pair : prerequisites) {
            depGraph.computeIfAbsent(pair[1], k -> new ArrayList<>())
            .add(pair[0]);
        }

        int[] state = new int[numCourses]; // 0=unvisited, 1=visiting, 2=visited
        
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(depGraph, i, state)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int course, int[] state) {
        if (state[course] == 1) return true;  // cycle detected
        if (state[course] == 2) return false; // already processed
        
        state[course] = 1; // mark visiting
        
        for (int next : graph.getOrDefault(course, Collections.emptyList())) {
            if (hasCycle(graph, next, state)) {
                return true;
            }
        }
        
        state[course] = 2; // mark visited
        return false;
    }
}
