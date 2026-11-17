class Solution {
    Map<String, Boolean> cache = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict);
    }

    public boolean dfs(String s, List<String> wordDict) {
        if(s.length() == 0) return true;
        if(cache.containsKey(s)) return cache.get(s);

        for(String word : wordDict) {
            if(s.startsWith(word)) {
                if(dfs(s.substring(word.length(), s.length()), wordDict)) {
                    cache.put(s, true);
                    return true;
                }
            }
        }

        cache.put(s, false);

        return false;
    }
}
