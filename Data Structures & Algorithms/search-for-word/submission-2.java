class Solution {
    public boolean exist(char[][] board, String word) {
        // build trie
        Node trie = buildTrie(word);

        for(int y = 0; y < board.length; y++)
            for(int x = 0; x < board[y].length; x++) {
                if(dfs(board, x, y, trie)) {
                    return true;
                }
            }
        
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, Node trie) {
        if(x < 0 || y < 0 || x > board[0].length - 1 || y > board.length - 1) {
            return false;
        }

        char c = board[y][x];
        
        if(!trie.children.containsKey(c)) {
            return false;
        }

        trie = trie.children.get(c);

        if(trie.end) {
            return true;
        }

        board[y][x] = '#';
        boolean result = dfs(board, x + 1, y, trie) ||
            dfs(board, x - 1, y, trie) ||
            dfs(board, x, y + 1, trie) ||
            dfs(board, x, y - 1, trie);
        board[y][x] = c;

        return result;
    }

    public Node buildTrie(String word) {
        Node root = new Node();

        Node n = root;
        for(char c : word.toCharArray()) {
            if(n.children.containsKey(c)) {
                n = n.children.get(c);
            } else {
                Node child = new Node();
                n.children.put(c, child);
                n = child;
            }
        }

        n.end = true;
        return root;
    }
}

class Node {
    boolean end = false;
    Map<Character, Node> children = new HashMap<>();
}
