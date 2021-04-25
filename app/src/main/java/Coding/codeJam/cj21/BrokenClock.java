package Coding.codeJam.cj21;

import java.util.Scanner;

public class BrokenClock {
  private static Scanner scanner = new Scanner(System.in);

  private static final long BILLION = 1_000_000_000;

  private static final long HOUR_TICKS_PER_DAY = 12 * 3_600 * BILLION;
  private static final long MINUTE_TICKS_PER_DAY = HOUR_TICKS_PER_DAY * 12;
  private static final long SECOND_TICKS_PER_DAY = HOUR_TICKS_PER_DAY * 720;

  public static void main(String[] args) {
    int testcases = scanner.nextInt();

    for (int test = 1; test <= testcases; test++) {
      long a = scanner.nextLong();
      long b = scanner.nextLong();
      long c = scanner.nextLong();

      // assume a is the hour
      double hourDouble = a * 12 / (double) HOUR_TICKS_PER_DAY;
      int hour = (int) hourDouble % 12;
      double minuteDouble = hourDouble * 60;
      int minute = (int) minuteDouble % 60;
      double secondDouble = minuteDouble * 60;
      int second = (int) secondDouble % 3600;

      long nanoseconds = 0;

      System.out.format("Case #%d: %d %d %d %d\n", test, hour, minute, second, nanoseconds);
    }
  }

  // private static void solve()
}
