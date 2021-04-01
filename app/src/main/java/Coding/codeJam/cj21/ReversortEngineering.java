package Coding.codeJam.cj21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReversortEngineering {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testcases = scanner.nextInt();

    for (int test = 1; test <= testcases; test++) {
      int n = scanner.nextInt();
      int costs = scanner.nextInt();

      if (costs < n - 1 || costs > n * (n+1) / 2 - 1) {
        System.out.println("Case #" + test + ": " + "IMPOSSIBLE");
      } else {
        List<Integer> res = constructListWithCost(n, costs);
        System.out.print("Case #" + test + ":");
        for (int i = 0; i < n; i++) {
          System.out.print(" " + res.get(i));
        }
        System.out.println();
      }
    }
  }

  private static List<Integer> initializeList(int length) {
    List<Integer> result = new ArrayList<>(length);
    for (int i = 1; i <= length; i++) {
      result.add(i);
    }
    return result;
  }

  private static List<Integer> constructListWithCost(int n, int costs) {
    List<Integer> init = initializeList(n);
    performPermutation(init, n, costs, false);
    return init;
  }

  /*
  boolean side indicates whether the first or the last element will be omitted in the next call. False is first and True
  last element of the list.
   */
  private static void performPermutation(List<Integer> list, int n, int costs, boolean side) {
    if (costs == n-1) return;
    int range = Math.min(n, costs - n + 2);
    Collections.reverse(list.subList(0, range));
    if (side) {
      performPermutation(list.subList(n - range, n), n-1, costs - range, !side);
    } else {
      performPermutation(list.subList(0, range-1), n - 1, costs - range, !side);
    }
  }
}
