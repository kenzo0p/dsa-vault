import java.util.*;

public class ActivitySelection {
    //same question disjoint set , max meetings in a room


    //
    public static int actSelection(int start[], int end[]) {
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // ! remember this for sorting if in ques its not given that its already an end base sort
        /*
         * 
         * sorting if array are not sorted as end time basis sort
         * int activities[][] = new int[start.length][3];// n*3
         * for (int i = 0; i < start.length; i++) {
         * activities[i][0] = i;
         * activities[i][1] = start[i];
         * activities[i][2] = end[i];
         * }
         * lambda function -> short form
         * Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));//2 because of end time sort
         * 
         */

        // first activity 1->2  
        maxAct = 1;
        ans.add(0);// activities[0][0]
        int lastEnd = end[0];// activities[0][2]
        for (int i = 0; i < end.length; i++) {
            if (start[i] >= lastEnd) {// activities[i][1] >= lastEnd
                // activity select
                maxAct++;
                ans.add(i);// activities[i][0]
                lastEnd = end[i];// activities[i][2]
            }
        }
        return maxAct;
    }

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        int activities = actSelection(start, end);
        System.out.println(activities);

        // end time basis sorted
    }
}
