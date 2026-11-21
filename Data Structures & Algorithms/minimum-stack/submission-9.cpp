class MinStack {
public:
    long min = 0;

    stack<long> v;

    MinStack() {
        
    }
    
    void push(int val) {
        if(v.empty()) {
            min = val;
            v.push(0);
        } else {
            v.push(val - min);

            if(val < min) {
                min = val;
            }
        }
    }
    
    void pop() {
        if (v.empty()) return;

        long val = v.top();
        v.pop();

        if(val < 0) {
            min = min - val;
        }
    }
    
    int top() {
        long top = v.top();
        return top > 0 ? top + min : (int)min;
    }
    
    int getMin() {
        return min;
    }
};
