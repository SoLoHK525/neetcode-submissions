class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<long> st;

        for(string s : tokens) {
            if(s.size() == 1 && (
                s[0] == '+' ||
                s[0] == '-' ||
                s[0] == '*' ||
                s[0] == '/'
            )) {
                long v1,v2;
                v1 = st.top();
                st.pop();
                v2 = st.top();
                st.pop();

                st.push(calc(s[0], v2, v1));
                continue;
            }

            int n = stoi(s);
            st.push(n);
        }

        return st.top();
    }

    long calc(char op, int v1, int v2) {
        switch(op) {
            case '+':
                return v1 + v2;
            case '-':
                return v1 - v2;
            case '*':
                return v1 * v2;
            case '/':
                return v1 / v2;
            default:
                return -1;
        }
    }
};
