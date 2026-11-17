class Node {
    boolean end = false;
    HashMap<Character, Node> children = new HashMap<>();
}

class WordDictionary {
    Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
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
    }

    public boolean search(String word) {
        char[] arr = word.toCharArray();
        return searchInChildren(root, arr, 0);
    }

    public boolean searchInChildren(Node root, char[] arr, int start) {
        Node n = root;

        for(int i = start; i < arr.length; i++) {
            char c = arr[i];
            
            if(c == '.') {
                for(Node child : n.children.values()) {
                    if(searchInChildren(child, arr, i + 1)) {
                        return true;
                    }
                }

                return false;
            } else {
                if(!n.children.containsKey(c)) {
                    return false;
                }

                n = n.children.get(c);
            }
        }

        return n.end;
    }
}
