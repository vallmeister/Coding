package Coding.codeJam.cj20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ParentingPartnering {
  private static final String IMP = "IMPOSSIBLE";

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testcases = in.nextInt();

    TEST: for (int i = 1; i <= testcases; i++) {
      int activities = in.nextInt();
      int cameronStart = 0;
      int jamieStart = 0;
      List<Activity> activityList = new ArrayList<>(activities);
      char[] solution = new char[activities];

      for (int j = 0; j < activities; j++) {
        int start = in.nextInt();
        int end = in.nextInt();
        activityList.add(new Activity(j, start, end));
      }
      Collections.sort(activityList);
      for (int j = 0; j < activities; j++) {
        Activity tmp = activityList.get(j);
        if (tmp.startTime >= cameronStart) {
          cameronStart = tmp.endTime;
          solution[tmp.index] = 'C';
        } else if (tmp.startTime >= jamieStart) {
          jamieStart = tmp.endTime;
          solution[tmp.index] = 'J';
        } else {
          System.out.println("Case #" + i + ": " + IMP);
          continue TEST;
        }
      }
      System.out.println("Case #" + i + ": " + new String(solution));
    }
  }
}

class Activity implements Comparable<Activity> {
  public int index;
  public int startTime;
  public int endTime;

  Activity(int ind, int start, int end) {
    index = ind;
    startTime = start;
    endTime = end;
  }

  @Override
  public int compareTo(Activity activity) {
    if (startTime < activity.startTime) return -1;
    else if (startTime > activity.startTime) return 1;
    else return 0;
  }
}
