package leetCode.practise;

import java.util.*;

public class _1268_searchSuggestionSystem {

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

    public static void main(String[] args) {
        String[] arr = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String s = "mouse";
        String[] arr1 = new String[]{"bags","baggage","banner","box","cloths"};
        String s1 = "bags";
        String[] arr2 = new String[]{"havana"};
        String s2 = "tatiana";
        System.out.println(new _1268_searchSuggestionSystem().suggestedProducts(arr, s));
        System.out.println(new _1268_searchSuggestionSystem().suggestedProducts(arr1, s1));
        System.out.println(new _1268_searchSuggestionSystem().suggestedProducts(arr2, s2));
    }
}
