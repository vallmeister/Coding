package Coding.codeJam.cj20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = in.nextInt();

        for (int i = 1; i <= testcases; i++) {
            int n = in.nextInt();
            List<Set<Integer>> rows = new ArrayList<>(n);
            List<Set<Integer>> columns = new ArrayList<>(n);
            int[][] latinSquare = new int[n][n];
            int duplicateRows = 0;
            int duplicateColumns = 0;
            int diagonal = 0;

            for (int j = 0; j < n; j++) {
                rows.add(new HashSet<>());
                columns.add(new HashSet<>());
            }

            // Scan input
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int number = in.nextInt();
                    latinSquare[j][k] = number;
                    rows.get(j).add(number);
                    columns.get(k).add(number);
                }
            }

            // Calculate results
            for (int j = 0; j < n; j++) {
                diagonal += latinSquare[j][j];
                if (rows.get(j).size() < n) duplicateRows++;
                if (columns.get(j).size() < n) duplicateColumns++;
            }
            System.out.println("Case #" + i + ": " + diagonal + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}
