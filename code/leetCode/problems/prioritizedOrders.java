package leetCode.problems;

import java.util.*;

public class prioritizedOrders {

  public static boolean isNumeric(String str){
    try{
      str = str.replace(" ", "");
      Integer.parseInt(str);
      return true;
    }
    catch (NumberFormatException ex){
      return false;
    }
  }

  static List<String> prioritizedOrders(int numOrders, List<String> orderList)
  {
    if(numOrders >=0 && numOrders <=1000){
      List<String> originalOrders = new ArrayList();
      List<String> nonPrimeOrders = new ArrayList<>();

      for(String str: orderList){
        String[] arrOfStr = str.split(" ");
        String temp = "";

        for(int i=0;i< arrOfStr.length;i++){
          if(i>0){
            temp = temp + arrOfStr[i] + " ";
          }
        }
        temp = temp.trim();
        if(!isNumeric(temp)){
          originalOrders.add(temp);
        }else{
          nonPrimeOrders.add(temp);
        }
      }
      Collections.sort(originalOrders);
      List<String> tempOrders = new ArrayList();
      List<String> tempOriginalList = new ArrayList<>(orderList);
      Collections.sort(tempOriginalList);
      for(String s: originalOrders){
        for(int i=0;i<tempOriginalList.size();i++){
          if(tempOriginalList.get(i).contains(s)){
            tempOrders.add(tempOriginalList.get(i));
            tempOriginalList.set(i, "");
            break;
          }
        }
      }
      for(String s: nonPrimeOrders){
        for(int i=0;i<tempOriginalList.size();i++){
          if(tempOriginalList.get(i).contains(s)){
            tempOrders.add(tempOriginalList.get(i));
            tempOriginalList.set(i, "");
            break;
          }
        }
      }

      return tempOrders;
    }
    else{
      return null;
    }
  }

  public static  void main(String[] args){
    List<String> x = new ArrayList<>();
    x.add("125 echo dot second generation");
    x.add("10a echo show");
    x.add("aba kindle book");
    x.add("ab1 kindle book");
    x.add("zId 93 12");
    x.add("17g 12 25 6");
    prioritizedOrders(6, x);
  }
}
