package geeksForGeeks.recursion;

public class josephusRecursion {
  static int josephus(int n, int k) {
    if (n == 1) return 0;
    return (josephus(n - 1, k) + k) % n;
  }

  static int myJosepphus(int n, int k){
    return josephus(n,k)+1;
  }

  public static void main(String[] args) {
    System.out.println(myJosepphus(3, 2));
  }
}
