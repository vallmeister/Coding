package Coding.codeJam.cj21;

import java.util.*;

public class ClosestPick {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int testcases = scanner.nextInt();

    for (int test = 1; test <= testcases; test++) {
      int n = scanner.nextInt();
      int k = scanner.nextInt();

      List<Integer> purchasedTickets = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        purchasedTickets.add(scanner.nextInt());
      }
      Collections.sort(purchasedTickets);

      double chance;
      if (allTicketsSold(k, purchasedTickets)) {
        chance = 0;
      } else {
        chance = solve(k, purchasedTickets);
      }

      System.out.format("Case #%d: %f\n", test, chance);
    }
  }

  private static boolean allTicketsSold(int k, List<Integer> tickets) {
    for (int i = 1; i <= k; i++) {
      if (!tickets.contains(i)) {
        return false;
      }
    }
    return true;
  }

  private static double solve(int k, List<Integer> tickets) {
    double reachableNumbers = 0d;
    List<Interval> intervals = new ArrayList<>();
    int first = tickets.get(0);
    int last = tickets.get(tickets.size() - 1);
    if (first > 1) {
      intervals.add(new Interval(true, first, 0));
    }
    if (last < k) {
      intervals.add(new Interval(true, k+1, last));
    }

    for (int i = 0; i < tickets.size() - 1; i++) {
      int lowerBound = tickets.get(i);
      int upperBound = tickets.get(i + 1);
      intervals.add(new Interval(false, upperBound, lowerBound));
    }
    Collections.sort(intervals);
    int index = intervals.size() - 1;
    reachableNumbers = reachableNumbers + intervals.get(index).size() + intervals.get(index - 1).size();

    return reachableNumbers / k;
  }
}

class Interval implements Comparable<Interval>{
  boolean edge;
  int upperBound;
  int lowerBound;

  Interval(boolean edge, int upper, int lower) {
    this.edge = edge;
    upperBound = upper;
    lowerBound = lower;
  }

  int size() {
    if (edge) return upperBound - lowerBound - 1;
    else {
      return (upperBound - lowerBound) / 2;
    }
  }


  @Override
  public int compareTo(Interval interval) {
    if (size() < interval.size()) return  -1;
    if (size() > interval.size()) return 1;
    return 0;
  }
}