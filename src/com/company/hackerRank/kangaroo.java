/** https://www.hackerrank.com/challenges/kangaroo/problem */

package com.company.hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Kangaroo {

  static String kangaroo(int x1, int v1, int x2, int v2) {

    int k1 = x1;
    int k2 = x2;
    for (int i = 0; i < 10000; i++) {
      if (k1 == k2) {
        return "YES";
      }
      k1 = k1 + v1;
      k2 = k2 + v2;
    }
    return "NO";
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] x1V1X2V2 = scanner.nextLine().split(" ");

    int x1 = Integer.parseInt(x1V1X2V2[0]);

    int v1 = Integer.parseInt(x1V1X2V2[1]);

    int x2 = Integer.parseInt(x1V1X2V2[2]);

    int v2 = Integer.parseInt(x1V1X2V2[3]);

    String result = kangaroo(x1, v1, x2, v2);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
