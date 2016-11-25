package Find_Right_Interval;

/**
 * Created by tanghanyi on 2016/11/25.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }*/
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Start {
    int start;
    int index;
    Start(int s, int i) { start = s; index = i; }
}
public class Solution {

    static class StartComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Start s1 = (Start) o1;
            Start s2 = (Start) o2;
            if (s1.start < s2.start) return -1;
            else return 1;
        }
    }

    private int binarySearch(ArrayList<Start> startlist, int end) {
        int l = 0, r = startlist.size() - 1;
        int n = r + 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (startlist.get(mid).start == end)return startlist.get(mid).index;
            else if(startlist.get(mid).start < end) l = mid + 1;
            else r = mid;
        }
        if (l >= n) return -1;
        else return r;
    }

    public int[] findRightInterval(Interval[] intervals) {
        int n = intervals.length;
        int []ret = new int[n];
        ArrayList<Start> l = new ArrayList<Start>();
        for (int i = 0; i < n; i++){
            l.add(new Start(intervals[i].start, i));
        }

        Collections.sort(l, new StartComparator());

        for (int i = 0; i < n; i++) {
            ret[i] = this.binarySearch(l, intervals[i].end);
        }

        return ret;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        Interval []intervals = new Interval[3];
        intervals[0] = new Interval(3, 4);
        intervals[1] = new Interval(2, 3);
        intervals[2] = new Interval(1, 2);
        int []ret = s.findRightInterval(intervals);
        for (int i:ret) {
            System.out.println(i);
        }
    }
}
