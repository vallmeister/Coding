package Coding.codeJam.cj20;

import java.util.Scanner;

// Reversing and complementing commute

public class EsabAtad {
  private static int length;
  private static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    int testcases = input.nextInt();
    length = input.nextInt();

    for (int i = 1; i <= testcases; i++) {
      // same pair for complement and different pair for reverse
      boolean samePairFound = false;
      boolean differentPairFound = false;
      // indices refer to the Java array, not the questioned array
      int indexSamePair = -1;
      int indexDiffPair = -1;

      char[] bits = new char[length];
      int index = 1;

      while (!arrayComplete(bits)) {
        // check fluctuation
        if (index % 10 == 1 && index > 1) {
          boolean complemented;
          boolean reversed;
          if (samePairFound) {
            complemented = checkComplement(bits, indexSamePair);
          } else {
            char before = bits[0];
            System.out.println(1);
            char after = input.next().charAt(0);
            complemented = before != after;
          }

          // check for reversal, palindrome doesn't matter
          if (differentPairFound) {
            reversed = checkReverse(bits, indexDiffPair, complemented);
          } else {
            reversed = false;
          }
          if (complemented) {
            performComplement(bits);
          }
          if (reversed) {
            performReversal(bits);
          }
        }

        // read from front or back
        if (index % 2 == 1) {
          System.out.println(index / 2 + 1);
          bits[index / 2] = input.next().charAt(0);
        } else if (index % 2 == 0) {
          System.out.println(length - index / 2 + 1);
          bits[length - index / 2] = input.next().charAt(0);
        }

        if (!samePairFound) {
          int tmp = findSamePair(bits, index / 2);
          if (tmp != -1) {
            samePairFound = true;
            indexSamePair = index;
          }
        }
        if (!differentPairFound) {
          int tmp = findDifferentPair(bits, index / 2);
          if (tmp != -1) {
            differentPairFound = true;
            indexDiffPair = index;
          }
        }

        index++;
      }

      System.out.println(new String(bits));
      char response = input.next().charAt(0);
      if (response == 'Y') {
        continue;
      } else {
        System.exit(0);
      }
      }
  }

  /* Looks for two same numbers that have the same distance from the mid of the array and returns the index or -1 if
  no two same numbers are found.
   */
  private static int findSamePair(char[] bits, int range) {
    int result = -1;
    for (int i = 0; i < range; i++) {
      if (bits[i] == bits[length - i - 1]) {
        result = i;
      }
    }

    return result;
  }

  /*
  Same for different numbers
   */
  private static int findDifferentPair(char[] bits, int range) {
    int result = -1;
    for (int i = 0; i < range; i++) {
      if (bits[i] != bits[length - i - 1]) {
        result = i;
      }
    }

    return result;
  }

  private static boolean checkComplement(char[] bits, int samePair) {
    char before = bits[samePair];
    System.out.println(samePair + 1);
    char after = input.next().charAt(0);
    return before != after;
  }

  private static boolean checkReverse(char[] bits, int diffPair, boolean complemented) {
    char before = bits[diffPair];
    System.out.println(diffPair + 1);
    char after = input.next().charAt(0);

    if (complemented) {
      return before == after;
    } else {
      return before != after;
    }
  }

  private static void performComplement(char[] bits) {
    for (int i = 0; i < length; i++) {
      if (bits[i] == '0') {
        bits[i] = '1';
      } else if (bits[i] == '1') {
        bits[i] = '0';
      }
    }
  }

  private static void performReversal(char[] bits) {
    for (int i = 0; i < length / 2; i++) {
      char tmp = bits[i];
      bits[i] = bits[length - i - 1];
      bits[length - i - 1] = tmp;
    }
  }

  private static boolean arrayComplete(char[] bits) {
    for (int i = 0; i < length; i++) {
      if (bits[i] != '0' && bits[i] != '1') return false;
    }
    return true;
  }
}
