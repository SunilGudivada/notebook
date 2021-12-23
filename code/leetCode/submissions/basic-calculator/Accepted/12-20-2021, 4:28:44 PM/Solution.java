// https://leetcode.com/problems/basic-calculator

class Solution {
    public int calculate(String s) {
        s = s.trim();
        
        int result = 0;
        int sign = 1;
        
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char currentCharacter = s.charAt(i);
            if(Character.isDigit(currentCharacter)){
                int count = s.charAt(i) - '0';
                while(i + 1 < n && Character.isDigit(s.charAt(i+1))){
                    count = count*10 + s.charAt(i+1)-'0';
                    i++;
                }
                result += count * sign;
            }else if(currentCharacter == '('){
                stack.push(result);
                stack.push(sign);
                
                result =0;
                sign = 1;
            }else if(currentCharacter == ')'){
                result = result * stack.pop() + stack.pop();
            }else if(currentCharacter == '+'){
                sign = 1;
            }else if(currentCharacter == '-'){
                sign = -1;
            }
            
        }
        
        return result;
    }
}