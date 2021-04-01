package Coding.codeJam.cj21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MoonsAndUmbrellas {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int testcases = scanner.nextInt();

    for (int i = 1; i <= testcases; i++) {
      int result = 0;
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      String input = scanner.next();

      List<Integer> indicesOfSpaces = findSpaces(input);
      if (indicesOfSpaces.isEmpty()) {
        result = evaluateString(input, x, y);
      } else {
        String mural = constructCheapestMural(input);
        result = evaluateString(mural, x, y);
      }
      System.out.println("Case #" + i + ": " + result);
    }
  }

  private static int evaluateString(String string, int x, int y) {
    int costs = 0;
    for (int i = 0; i < string.length() - 1; i++) {
      char first = string.charAt(i);
      char second = string.charAt(i + 1);
      if (first == 'C' && second == 'J') costs += x;
      else if (first == 'J' && second == 'C') costs += y;
    }
    return costs;
  }

  /*
  Returns a list of indices where string contains '?'.
   */
  private static List<Integer> findSpaces(String string) {
    List<Integer> indices = new ArrayList<>();

    for (int i = 0; i < string.length(); i++) {
      if (string.charAt(i) == '?') indices.add(i);
    }
    return indices;
  }

  private static String constructCheapestMural(String string) {
    char[] chars = new char[string.length()];

    for (int i = 0; i < string.length(); i++) {
      char tmp = string.charAt(i);

      if (tmp == '?') {
        char last = findLastCharacter(chars, i - 1);
        char next = findNextCharacter(string, i + 1);
        if (last == '.') {
          if (next == '.') chars[i] = 'C';
          else chars[i] = next;
        } else if (last == 'C' && next == 'J' || last == 'J' && next == 'C') chars[i] = 'C';
        else if (last == 'C' && next == 'C') chars[i] = 'C';
        else if (last == 'J' && next == 'J') chars[i] = 'J';
        else if (last == 'C' && next == '.') chars[i] = 'C';
        else if (last == 'J' && next == '.') chars[i] = 'J';

      } else {
        chars[i] = tmp;
      }
    }
    return new String(chars);
  }

  private static char findNextCharacter(String string, int start) {
    for (int i = start; i < string.length(); i++) {
      if (string.charAt(i) == 'C') return 'C';
      if (string.charAt(i) == 'J') return 'J';
    }
    return '.';
  }

  private static char findLastCharacter(char[] characters, int start) {
    for (int i = start; i >= 0; i--) {
      if (characters[i] == 'C') return 'C';
      if (characters[i] == 'J') return 'J';
    }
    return '.';
  }
}
