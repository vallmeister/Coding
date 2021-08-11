package Coding.cpUlm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BrexitingAndBrentering {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Set<Character> vowels = new HashSet<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');

    String input = scanner.next();
    for (int i = input.length() - 1; i >= 0; i--) {
      if (vowels.contains(input.charAt(i))) {
        String output = input.substring(0, i + 1) + "ntry";
        System.out.println(output);
        break;
      }
    }
  }
}
