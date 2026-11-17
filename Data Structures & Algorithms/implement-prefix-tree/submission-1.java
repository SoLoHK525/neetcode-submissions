class Node {
    boolean end = false;
    HashMap<Character, Node> children = new HashMap<>();
}

class PrefixTree {
    Node root;

    public PrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node n = root;

        int idx = 0;
        for(char c : word.toCharArray()) {
            if(n.children.containsKey(c)) {
                n = n.children.get(c); 
            } else {
                Node child = new Node();
                n.children.put(c, child);
                n = child;
            }

            if(idx == word.length() - 1) {
                n.end = true;
            }

            idx++;
        }
    }

    public boolean search(String word) {
        Node n = this.root;

        char[] arr = word.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if(n.children.containsKey(c)) {
                n = n.children.get(c);

                if(i == arr.length - 1) {
                    return n.end;
                }
            } else {
                return false;
            }
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        Node n = this.root;

        char[] arr = prefix.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if(n.children.containsKey(c)) {
                n = n.children.get(c);
            } else {
                return false;
            }
        }

        return n != null;
    }
}
