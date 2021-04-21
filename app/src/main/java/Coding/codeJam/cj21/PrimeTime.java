package Coding.codeJam.cj21;

import java.util.*;

public class PrimeTime {
  private static Scanner scanner = new Scanner(System.in);
  private static int maximumSum = 0;
  private static int cards = 0;
  private static List<Integer> primes = new ArrayList<>();
  private static Map<Integer, Integer> primesAndCards = new HashMap<>();

  public static void main(String[] args) {
    int testcases = scanner.nextInt();

    for (int test = 1; test <= testcases; test++) {
      int m = scanner.nextInt();
      readNumbers(m);

      int solution = solve();
      System.out.format("Case #%d: %d\n", test, solution);
    }
  }

  private static int solve() {
    int result = 0;

    return result;
  }

  private static void readNumbers(int m) {
    for (int i = 0; i < m; i++) {
      int prime = scanner.nextInt();
      int amount = scanner.nextInt();
      primes.add(prime);
      primesAndCards.put(prime, amount);
      maximumSum += prime * amount;
      cards += amount;
    }
  }
}
