package Coding.codeJam.cj21;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ClosestPick {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int testcases = scanner.nextInt();

    for (int test = 1; test <= testcases; test++) {
      int n = scanner.nextInt();
      int k = scanner.nextInt();

      int size = k;

      List<Integer> purchasedTickets = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        int number = scanner.nextInt();
        if (!purchasedTickets.contains(number)) {
          purchasedTickets.add(number);
          size--;
        }
      }
      Collections.sort(purchasedTickets);

      BigDecimal chance;
      if (size == 0) {
        chance = BigDecimal.ZERO;
      } else  if (size == 1 || size == 2){
        chance = BigDecimal.valueOf(size);
        chance = chance.divide(BigDecimal.valueOf(k), 6, RoundingMode.HALF_DOWN);
      } else if (n == 0) {
        chance = BigDecimal.ONE;
      } else {
        chance = solve(k, purchasedTickets);
      }

      System.out.format("Case #%d: %s\n", test, chance.toString());
    }
  }

  private static BigDecimal solve(int k, List<Integer> purchased) {
    purchased.add(k + 1);
    int lowerBound;
    int upperBound = 0;
    int biggestSize = 0;
    int bestValue = 0;
    int secondValue = 0;
    int counter = 0;

    while (!purchased.isEmpty()) {
      lowerBound = upperBound + 1;
      upperBound = purchased.remove(0);
      int value = intervalValue(k, lowerBound, upperBound);
      int size = upperBound - lowerBound;

      if (value > 0){
        biggestSize = Math.max(biggestSize, size);
        counter++;
        if (value > bestValue) {
          secondValue = bestValue;
          bestValue = value;
        } else if (value > secondValue) {
          secondValue = value;
        }
      }
    }
    if (counter == 0) return BigDecimal.ZERO;
    if (counter == 1){
      BigDecimal result = new BigDecimal(biggestSize);
      return result.divide(BigDecimal.valueOf(k), 6, RoundingMode.HALF_DOWN);
    }

    BigDecimal result = BigDecimal.valueOf(Math.max(biggestSize, bestValue + secondValue));

    result = result.divide(BigDecimal.valueOf(k), 6, RoundingMode.HALF_DOWN);

    return result;
  }

  private static int intervalValue(int k, int lowerBound, int upperBound) {
    if (lowerBound == 1 || upperBound > k) return upperBound - lowerBound;
    if (upperBound - lowerBound <= 0) return 0;
    else return (upperBound - lowerBound + 1) / 2;
  }
}
