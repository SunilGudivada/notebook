// https://leetcode.com/problems/search-suggestions-system

class Solution {
     public List<String> getproducts(String[] p, String s) {
        List<String> products = new ArrayList<>();
        for (int i = 0; i < p.length; i++) {
            if (p[i].indexOf(s) == 0) {
                products.add(p[i]);
            }
        }
        Collections.sort(products);
        if(products.size() > 3){
            return products.subList(0,3);
        }else{
            return products.subList(0,products.size());
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
       List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            List<String> list;
            String currentSearchKeyword = searchWord.substring(0, i+1);
            list = getproducts(products, currentSearchKeyword);
            result.add(list);
        }

        return result;
    }
}