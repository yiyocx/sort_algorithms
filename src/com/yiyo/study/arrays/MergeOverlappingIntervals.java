package com.yiyo.study.arrays;

import java.util.*;

public class MergeOverlappingIntervals {

    /*
    Given a collection of intervals, merge all overlapping intervals.

    Example:
    Given [1,3],[2,6],[8,10],[15,18],
    return [1,6],[8,10],[15,18].

    Make sure the returned intervals are sorted.
     */
    public static void main(String[] args) {
        MergeOverlappingIntervals overlapping = new MergeOverlappingIntervals();

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(15, 18));

        List<Interval> result = overlapping.merge(intervals);
        for (Interval value : result) {
            System.out.print(value);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return intervals;
        }

        // An array sorted makes thing easier for this problem
        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        List<Interval> result = new ArrayList<>();
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (prev.end >= current.start) {
                prev = new Interval(prev.start, Math.max(prev.end, current.end));
            } else {
                result.add(prev);
                prev = current;
            }
        }
        result.add(prev);
        return result;
    }

    // Time Complexity: O(2 * n)
    // Space Complexity: O(2 * n)
    private List<Interval> alternativeMerge(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return intervals;
        }

        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        Stack<Interval> stack = new Stack<>();
        stack.push(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            Interval prev = stack.peek();
            // For intervals (a, b) y (c, d) If max(a, c) <= min(b, d) then exists an overlap
            if (Math.max(prev.start, current.start) <= Math.min(prev.end, current.end)) {
                prev = stack.pop();
                Interval mergedInterval = new Interval(Math.min(prev.start, current.start),
                        Math.max(prev.end, current.end));
                stack.push(mergedInterval);
            } else {
                stack.push(current);
            }
        }

        List<Interval> result = new LinkedList<>();
        while (!stack.isEmpty()) {
            result.add(0, stack.pop());
        }
        return result;
    }
}
