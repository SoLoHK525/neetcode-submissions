class Node {
    boolean end = false;
    Map<Character, Node> children = new HashMap<>();
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();

        Node trie = buildTrie(words);

        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board[y].length; x++) {
                char c = board[y][x];
                if(trie.children.containsKey(c)) {
                   dfs(board, x, y, trie, new StringBuilder(), res); 
                }
            }
        }

        return res;
    }

    public void dfs(char[][] board, int x, int y, Node trie, StringBuilder sb, List<String> res) {
        if (x < 0 || x >= board[0].length || y < 0 || y >= board.length) return;

        char c = board[y][x];
        if (c == '#' || !trie.children.containsKey(c)) return;  // visited or not in trie

        Node child = trie.children.get(c);
        sb.append(c);

        if (child.end) {
            res.add(sb.toString());
            child.end = false;
        }

        board[y][x] = '#';
        dfs(board, x - 1, y, child, sb, res);
        dfs(board, x + 1, y, child, sb, res);
        dfs(board, x, y - 1, child, sb, res);
        dfs(board, x, y + 1, child, sb, res);
        board[y][x] = c;

        sb.deleteCharAt(sb.length() - 1);
    }

    public Node buildTrie(String[] words) {
        Node root = new Node();

        for(String str : words) {
            Node n = root;
            for(char c : str.toCharArray()) {
                if(n.children.containsKey(c)) {
                    n = n.children.get(c);
                } else {
                    Node child = new Node();
                    n.children.put(c, child);
                    n = child;
                }
            }
            n.end = true;
        }

        return root;
    }
}
