package practiseJava;

public class LongestSubstringWithoutRepeatingCharacter {

    public static void main(String[] args){

        String s = "abcabcbb";

        String t = "";
        int maxLength = -1;

        for(char c : s.toCharArray()){
            String current = String.valueOf(c);

            if(t.contains(current)){

                t = t.substring(t.indexOf(current) + 1);
            }

            t += current;
            maxLength = Math.max(t.length(),maxLength);
        }

        System.out.println(maxLength);

    }
}
