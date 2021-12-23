// https://leetcode.com/problems/rings-and-rods

class Solution {
    public int countPoints(String rings) {
        List<HashMap<String, Integer>> rods = new ArrayList<>();
        for(int i=0;i<=9;i++){
            rods.add(new HashMap<String, Integer>());
        }
        for(int i=0;i<rings.length();i=i+2){
            if(i %2 == 0 ){
                String currentColor  =String.valueOf(rings.charAt(i));
                int currentRod = Integer.parseInt(String.valueOf(rings.charAt(i+1)));
                HashMap<String, Integer> map = rods.get(currentRod);
                
                if(map.containsKey(currentColor)){
                    int value = map.get(currentColor);
                    value++;
                    map.put(currentColor,value);
                }else{
                    map.put(currentColor,1);
                }
                rods.set(currentRod, map);
            }
        }
        int count =0;
        for(int i=0;i<=9;i++){
            if(rods.get(i) != null && rods.get(i).size() == 3) count++;
        }
        
        return count;
    }
}