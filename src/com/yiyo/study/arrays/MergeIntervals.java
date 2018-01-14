package com.yiyo.study.arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    /*
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    You may assume that the intervals were initially sorted according to their start times.

    Example:
    Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9]
     */
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));
        Interval interval = new Interval(4, 9);

        List<Interval> result = mergeIntervals.insert(intervals, interval);
        for (Interval value : result) {
            System.out.print(value);
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // If start is greater than end then swap the values
        if (newInterval.start > newInterval.end) {
            newInterval.start = newInterval.start + newInterval.end;
            newInterval.end = newInterval.start - newInterval.end;
            newInterval.start = newInterval.start - newInterval.end;
        }

        int n = intervals.size();
        boolean inserted = false;
        for (int i = 0; i < n; i++) {
            Interval current = intervals.get(i);
            if (current.start > newInterval.start) {
                intervals.add(i, newInterval);
                inserted = true;
                break;
            }
        }

        if (!inserted) {
            intervals.add(newInterval);
        }

        return new MergeOverlappingIntervals().merge(intervals);
    }
}
