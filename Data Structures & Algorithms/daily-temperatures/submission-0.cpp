class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int size = temperatures.size();
        vector<int> res(size, 0);

        stack<int> st;

        for(int i = 0; i < size; i++) {
            if(st.empty()) {
                st.push(i);
                continue;
            }

            int temp = temperatures[i];

            while(!st.empty() && temp > temperatures[st.top()]) {
                int idx = st.top();
                st.pop();

                res[idx] = i - idx;
            }

            st.push(i);
        }

        return res;
    }
};
