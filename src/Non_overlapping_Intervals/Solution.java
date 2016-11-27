package Non_overlapping_Intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class Solution {
    class IntervalComprator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Interval i1 = (Interval) o1;
            Interval i2 = (Interval) o2;
            if (i1.end < i2.end) return -1;
            else if (i1.end == i2.end) {
                if (i1.start < i2.start) return -1;
                else return 1;
            }else {
                return 1;
            }
        }
    }
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new IntervalComprator());
        int start = intervals[0].start;
        int end = intervals[0].end;
        int ret = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                ret += 1;
                start = intervals[i].start;
                end = intervals[i].end;
            }
        }
        return intervals.length - ret;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        Interval[] intervals = new Interval[4];
        for (int i = 0; i < intervals.length; i++) {
            intervals[i] = new Interval();
        }
        intervals[0].start = 1;
        intervals[0].end = 2;
        intervals[1].start = 2;
        intervals[1].end = 3;
        intervals[2].start = 3;
        intervals[2].end = 4;
        intervals[3].start = 1;
        intervals[3].end = 3;

        System.out.println(s.eraseOverlapIntervals(intervals));
    }
}
