package geeksForGeeks.contest;

/**
 * Given a number N, find the smallest number which can be obtained by rearranging the digits of N.
 * The generated number should not have any leading zeroes.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 846903 Output:304689
 *
 * <p>Example 2:
 *
 * <p>Input: N = 55010 Output:10055
 *
 * <p>Your Task: You don't need to read input or print anything. Your task is to complete the
 * function smallestnum() which takes N (represented by a string) as input parameter and returns a
 * string representing the smallest possible rearrangement.
 */
public class rearrangeTheDigits {
  String smallestnum(String N)
  {
    int[] freq = new int[10];

    for(int i=0;i<N.length();i++){
      freq[N.charAt(i)-'0']++;
    }
    StringBuilder res = new StringBuilder();

    for (int i=1;i<=9;i++){
      if(freq[i] >0){
        freq[i]--;
        res.append(i);
        break;
      }
    }

    for(int i=0;i<=9;i++){
      while(freq[i]-- > 0){
        res.append(i);
      }
    }

    return res.toString();
  }

  public static void main(String[] args) {
    rearrangeTheDigits obj = new rearrangeTheDigits();
    System.out.println(obj.smallestnum("675356291270936062618792023759228973612931947845036106320615547656937452547443078688431492068926649504871727226106159490917711597767365639481293908850963856115984810304444763175962178574185975388318964333860488897764303092540594692247754812893680210511085064625862847240629908131103403919693380566400462675698728299602761321599149107587048042961042220552902838040919625449936050294351"));
  }
}
