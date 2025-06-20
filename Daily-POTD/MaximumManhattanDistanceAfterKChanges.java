package Daily-POTD;

public class MaximumManhattanDistanceAfterKChanges {
        public int maxDistance(String s, int k) {
        int maxMD = 0;
        int east = 0;
        int west = 0;
        int north = 0;
        int south = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E')
                east++;
            else if (s.charAt(i) == 'W')
                west++;
            else if (s.charAt(i) == 'N')
                north++;
            else if (s.charAt(i) == 'S')
                south++;

            int currMD = Math.abs(east - west) + Math.abs(north - south);

            int steps = i + 1;
            int wasted = steps - currMD;

            int extra = 0;
            if(wasted != 0){ //worst case -> steps != currMD
                extra = Math.min(2*k , wasted);
            }

            int finalCurrMD = currMD + extra;

            maxMD = Math.max(maxMD , finalCurrMD);

        }
        return maxMD;
    }
}
