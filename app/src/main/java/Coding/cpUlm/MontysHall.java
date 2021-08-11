package Coding.cpUlm;

import java.util.Scanner;

public class MontysHall {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int doors = scanner.nextInt();
    int chosen = scanner.nextInt();
    int opened = scanner.nextInt();

    double a = Math.max(0, 2 * chosen - doors + opened);
    double result = a / doors;
    result += (1 - (a / doors)) * (1 - ((chosen - a) / (doors - a))) * ((chosen - a) / (doors - opened - chosen));
    System.out.println(result);
  }
}
