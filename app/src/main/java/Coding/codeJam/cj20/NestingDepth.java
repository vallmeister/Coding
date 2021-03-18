package Coding.codeJam.cj20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NestingDepth {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testcases = in.nextInt();

    for (int i = 1; i <= testcases; i++) {
      int parentheses = 0;
      StringBuilder stringBuilder = new StringBuilder("Case #" + i + ": ");

      String input = in.next();
      for (int j = 0; j < input.length(); j++) {
        int number = input.charAt(j) - 48;
        while (number > parentheses) {
          stringBuilder.append('(');
          parentheses++;
        }
        while (number < parentheses) {
          stringBuilder.append(')');
          parentheses--;
        }
        stringBuilder.append(number);
      }
      while (parentheses > 0) {
        stringBuilder.append(')');
        parentheses--;
      }

      System.out.println(stringBuilder.toString());
    }
  }
}
