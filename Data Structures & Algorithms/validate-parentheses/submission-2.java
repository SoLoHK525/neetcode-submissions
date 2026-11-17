class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        if (s.length() % 2 == 1) {
            return false;
        }

        char[] cr = s.toCharArray();

        for(char c : cr) {
            if(c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else if(st.size() == 0) {
                return false;
            } else {
                char p = st.pop();
                if (
                    p == '(' && c != ')' ||
                    p == '{' && c != '}' ||
                    p == '[' && c != ']'
                ) {
                    return false;
                }
            }
        }

        return st.size() == 0;
    }
}
