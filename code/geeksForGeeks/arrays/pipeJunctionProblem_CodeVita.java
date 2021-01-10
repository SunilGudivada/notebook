package geeksForGeeks.arrays;

import java.util.Scanner;

public class pipeJunctionProblem_CodeVita {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int r = sc.nextInt();
    int inputSum = 0;
    int outputSum = 0;
    for (int i = 0; i < n; i++) {
      inputSum += sc.nextInt();
    }
    for (int i = 0; i < m; i++) {
      outputSum += sc.nextInt();
    }
    int res = inputSum - outputSum + r;
    res = res * -1;
    if (res == 0) {
      System.out.println("BALANCED");
    } else {
      System.out.println(res);
    }
  }
}
