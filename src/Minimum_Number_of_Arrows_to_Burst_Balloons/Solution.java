package Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 * Created by tanghanyi on 2016/11/28.
 */
public class Solution {
    class PointComprator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            int []p1 = (int [])o1;
            int []p2 = (int [])o2;
            if (p1[1] < p2[1]) return -1;
            else {
                if (p1[0] < p2[0]) return -1;
                else return 1;
            }
        }
    }
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        int ret = 1;
        Arrays.sort(points, new PointComprator());
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (end < points[i][0]) {
                ret += 1;
                end = points[i][1];
            }
        }
        return ret;
    }

    public static void main(String args[]) {

        Solution s = new Solution();
        int [][]points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(s.findMinArrowShots(points));
    }
}
