package Coding.codeJam.cj21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedianSort {
  private static int minimum = Integer.MAX_VALUE;
  private static int maximum = Integer.MIN_VALUE;
  private static Scanner scanner = new Scanner(System.in);


  public static void main (String[] args) {
    int testcases = scanner.nextInt();
    int numberOfElements = scanner.nextInt();
    int queries = scanner.nextInt();

    for (int testcase = 1; testcase <= testcases; testcase++) {
      List<Integer> minMax = findMinimumAndMaximum(numberOfElements);
      minimum = minMax.get(0);
      maximum = minMax.get(1);

      int[] temp = initializeArray(numberOfElements);
      mergeSort(temp, numberOfElements - 2);
      printOutput(temp, numberOfElements - 2);
    }
  }

  private static void mergeSort(int[] a, int n) {
    if (n < 2) {
      return;
    }
    int mid = n / 2;
    int[] l = new int[mid];
    int[] r = new int[n - mid];

    for (int i = 0; i < mid; i++) {
      l[i] = a[i];
    }
    for (int i = mid; i < n; i++) {
      r[i - mid] = a[i];
    }
    mergeSort(l, mid);
    mergeSort(r, n - mid);

    merge(a, l, r, mid, n - mid);
  }

  private static void merge(int[] a, int[] l, int[] r, int left, int right) {
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
      System.out.println(minimum + " " + l[i] + " " + r[j]);
      int median = scanner.nextInt();

      if (median == l[i]) { // l[i] < r[j]
        a[k++] = l[i++];
      } else {
        a[k++] = r[j++];
      }
    }
    while (i < left) {
      a[k++] = l[i++];
    }
    while (j < right) {
      a[k++] = r[j++];
    }
  }

  private static List<Integer> findMinimumAndMaximum(int n) {
    List<Integer> nonMedians = initializeList(n);
    int minimum = nonMedians.remove(0);
    int maximum = nonMedians.remove(0);
    int test = nonMedians.remove(0);

    while (!nonMedians.isEmpty()){
      System.out.println(minimum + " " + maximum + " " + test);
      int median = scanner.nextInt();
      if (median == minimum) {
        minimum = nonMedians.remove(0);
      } else if (median == maximum) {
        maximum = nonMedians.remove(0);
      } else {
        test = nonMedians.remove(0);
      }
    }
    nonMedians.add(minimum);
    nonMedians.add(maximum);
    nonMedians.add(test);
    System.out.println(minimum + " " + maximum + " " + test);
    int median = scanner.nextInt();
    nonMedians.remove((Object) median);

    return nonMedians.size() == 2 ? nonMedians : null;
  }

  private static List<Integer> initializeList(int n) {
    List<Integer> init = new ArrayList<>(n);
    for (int i = 1; i <= n; i++) {
      init.add(i);
    }
    return init;
  }

  private static int[] initializeArray(int n) {
    int[] result = new int[n - 2];
    int index = 0;
    for (int i = 1; i <= n; i++) {
      if (i == minimum || i == maximum) {
        continue;
      }
      result[index++] = i;
    }
    return result;
  }

  private static void printOutput(int[] numbers, int n) {
    System.out.print(minimum);
    for (int i = 0; i < n; i++) {
      System.out.print(" " + numbers[i]);
    }
    System.out.print(" " + maximum);
    System.out.println();

    int response = scanner.nextInt();
    if (response == -1) System.exit(0);
  }
}
