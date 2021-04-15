package Coding.codeJam.cj21;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppendSort {
  private static Scanner scanner = new Scanner(System.in);
  private static final BigInteger NINE = new BigInteger("9");

  public static void main(String[] args) {
    int testcases = scanner.nextInt();

    for (int test = 1; test <= testcases; test++) {
      List<BigInteger> numbers = readInputNumbers();
      long operations = appendDigitsToList(numbers);
      System.out.format("Case #%d: %d%n", test, operations);
      //System.out.println(Arrays.toString(numbers.toArray()));
    }
  }

  private static List<BigInteger> readInputNumbers() {
    int n = scanner.nextInt();
    List<BigInteger> result = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      String input = scanner.next();
      BigInteger number = new BigInteger(input);
      result.add(number);
    }
    return result;
  }

  private static long appendDigitsToList(List<BigInteger> numbers) {
    long result = 0;
    BigInteger first = numbers.get(0);

    for (int i = 1; i < numbers.size(); i++) {
      BigInteger next = numbers.get(i);

      if (first.equals(next)) {
        next = next.multiply(BigInteger.TEN);
        result++;
      } else if (first.compareTo(next) > 0) {
        String firstString = String.valueOf(first);
        String nextString = String.valueOf(next);

        if (firstString.length() == nextString.length()) {
          next = next.multiply(BigInteger.TEN);
          result++;
        } else if (firstString.startsWith(nextString)) {
          int k = firstString.length() - nextString.length();
          BigInteger tmp = new BigInteger(next.toString());

          // appending nines to see if first is too large for next to have same length
          for (int j = 0; j < k; j++) {
            tmp = tmp.multiply(BigInteger.TEN);
            tmp = tmp.add(NINE);
          }

          if (tmp.compareTo(first) > 0) {
            next = first.add(BigInteger.ONE);
            result += k;
          } else {
            next = next.multiply(BigInteger.TEN.pow(k + 1));
            result += k + 1;
          }
        } else {
          int k = firstString.length() - nextString.length();
          next = next.multiply(BigInteger.TEN.pow(k));
          result += k;

          if (first.compareTo(next) > 0) {
            next = next.multiply(BigInteger.TEN);
            result++;
          }
        }
      }
      first = next;
      numbers.remove(i);
      numbers.add(i, next);
    }
    return result;
  }
}
