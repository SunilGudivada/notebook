// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {
        String outputString = "";
        
        Stack<String> resultStack = new Stack<>();
        Stack<Integer> counterStack = new Stack<>();
        int n = s.length();
        int i=0;
        while(i <n){
            
            char currentCharacter = s.charAt(i);
            
            if(Character.isDigit(currentCharacter)){
                int count =0;
                while (Character.isDigit(s.charAt(i))) {
                    count = 10 * count + (s.charAt(i) - '0');
                    i++;
                }
                counterStack.push(count);
            
            }else if(currentCharacter == '['){
            
                resultStack.push(outputString);
                outputString = "";
                i++;
            
            }else if(currentCharacter == ']'){
                StringBuilder temp = new StringBuilder (resultStack.pop());
                int repeatTimes = counterStack.pop();
                for (int j = 0; j < repeatTimes; j++) {
                    temp.append(outputString);
                }
                outputString = temp.toString();
                i++;
                
            }else{
                outputString += s.charAt(i++);
            }
        }
        
        return outputString;
    }
}