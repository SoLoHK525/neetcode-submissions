class MinStack {
public:
    stack<int> minStack;
    stack<int> v;

    MinStack() {
        
    }
    
    void push(int val) {
        v.push(val);

        if(!minStack.empty() && val > minStack.top()) return;

        minStack.push(val);
    }
    
    void pop() {
        int val = v.top();
        v.pop();

        if(!minStack.empty() && val == minStack.top()) {
            minStack.pop();
        }
    }
    
    int top() {
        return v.top();
    }
    
    int getMin() {
        return minStack.top();
    }
};
