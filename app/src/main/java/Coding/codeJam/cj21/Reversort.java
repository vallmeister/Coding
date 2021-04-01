package Coding.codeJam.cj21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Reversort {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int testcases = scanner.nextInt();

    for (int test = 1; test <= testcases; test++) {
      int n = scanner.nextInt();

      // read list of distinct numbers
      List<Integer> numbers = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        numbers.add(scanner.nextInt());
      }
      int costs = reversort(numbers);

    System.out.println("Case #" + test + ": " + costs);
    }
  }

  private static int findMinimumPosition(List<Integer> integers, int i) {
    int index = -1;
    int minimum = Integer.MAX_VALUE;

    for (; i < integers.size(); i++) {
      if (integers.get(i) < minimum) {
        minimum = integers.get(i);
        index = i;
      }
    }
    return index;
  }

  private static int reversort(List<Integer> numbers) {
    int result = 0;
    int length = numbers.size();
    for (int i = 0; i < length - 1; i++) {
      int j = findMinimumPosition(numbers, i);
      Collections.reverse(numbers.subList(i, j + 1));
      result += j - i + 1;
    }
    return result;
  }
}
