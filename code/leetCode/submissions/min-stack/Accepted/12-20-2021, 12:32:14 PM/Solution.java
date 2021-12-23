// https://leetcode.com/problems/min-stack

class MinStack {
    Stack<int[]> stack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        int[] currentElement = new int[2];
        currentElement[0] = val;
        if(stack.isEmpty()){
            currentElement[1] = val;
        }else{
            int[] peekElement = stack.peek();
            currentElement[1] = Math.min(val, peekElement[1]);
        }
        stack.push(currentElement);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */