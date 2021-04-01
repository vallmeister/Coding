package Coding.codeJam.cj21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReversortEngineeringDFS {

  private final static String IMPOSSIBLE = "IMPOSSIBLE";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int testcases = scanner.nextInt();

    for (int i = 1; i <= testcases; i++) {
      int n = scanner.nextInt();
      int costs = scanner.nextInt();
      /*if (costs < n-1 || costs > n * (n + 1) / 2) {
        printOutput(i, null);
        continue;
      }*/
      List<Integer> initial = integers(n);
      List<Integer> result = resultList(new ArrayList<Integer>(), initial, costs);
      printOutput(i, result);
    }
  }

  private static void printOutput(int testcase, List<Integer> integers) {
    if (integers == null) {
      System.out.println("Case #" + testcase + ": " + IMPOSSIBLE);
    } else {
      System.out.print("Case #" + testcase + ":");
      for (int i = 0; i < integers.size(); i++) {
        System.out.print(" ");
        System.out.print(integers.get(i));
      }
      System.out.println();
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

  private static List<Integer> integers(int n) {
    List<Integer> result = new ArrayList<>(n);
    for (int i = 1; i <= n; i++) {
      result.add(i);
    }
    return result;
  }

  private static List<Integer> resultList(List<Integer> currentList, List<Integer> remainingValues, int costs) {
    if (remainingValues.isEmpty()) {
      List<Integer> checkCosts = new ArrayList<>(currentList);
      int currentCosts = reversort(checkCosts);
      if (currentCosts == costs) return currentList;
      else return null;
    }
    for (int i = 0; i < remainingValues.size(); i++) {
      List<Integer> currentTemp = new ArrayList<>(currentList);
      List<Integer> remainingTemp = new ArrayList<>(remainingValues);
      int value = remainingTemp.remove(i);
      currentTemp.add(value);
      List<Integer> resultTemp = resultList(currentTemp, remainingTemp, costs);
      if (resultTemp != null) return resultTemp;
    }
    return null;
  }
}
