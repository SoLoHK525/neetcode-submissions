class Solution {
    public String foreignDictionary(String[] words) {
        if(words.length == 0) {
            return ""; 
        }

        Map<Character, Set<Character>> graph = new HashMap();

        for(String str : words) {
            for(char c : str.toCharArray()) {
                if(graph.containsKey(c)) continue;
                graph.put(c, new HashSet<>());
            }
        }

        
        for(int i = 0; i < words.length - 1; i++) {
            String l = words[i];
            String r = words[i + 1];

            int len = Math.min(l.length(), r.length());

            int j = 0;
            while(j < len) {
                if(l.charAt(j) != r.charAt(j)) break; // if not equal

                if(!graph.containsKey(l.charAt(j))) {
                    graph.put(l.charAt(j), new HashSet<>());
                }
                j++;
            }

            if(j == len && l.length() > r.length()) return "";
            if(j == len) continue;

            Set<Character> leftSet = graph.get(l.charAt(j));
            leftSet.add(r.charAt(j));
        }

        Set<Character> visited = new HashSet<>();
        Set<Character> visiting = new HashSet<>();
        List<Character> result = new ArrayList<>();
        

        for(char c : graph.keySet()) {
            if (!dfs(graph, c, visited, visiting, result)) {
                return "";
            }
        }
        
        Collections.reverse(result);

        StringBuilder sb = new StringBuilder();

        for (char c : result) {
            sb.append(c);
        }
        return sb.toString();
    }

    boolean dfs(
        Map<Character, Set<Character>> graph, 
        char c, 
        Set<Character> visited, 
        Set<Character> visiting, 
        List<Character> result
        ) {
        if (visiting.contains(c)) return false; // cycle
        if (visited.contains(c)) return true;   // already done
        
        visiting.add(c);
        for (char neighbor : graph.get(c)) {
            if (!dfs(graph, neighbor, visited, visiting, result)) {
                return false;
            }
        }
        visiting.remove(c);
        visited.add(c);
        result.add(c);
        return true;
    }
}
