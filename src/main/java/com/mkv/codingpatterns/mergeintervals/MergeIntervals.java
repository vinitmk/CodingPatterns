package com.mkv.codingpatterns.mergeintervals;

/*
Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

Time complexity #
The time complexity of the above algorithm is O(N * logN), where ‘N’ is the total number of intervals.
We are iterating the intervals only once which will take O(N), in the beginning though,
since we need to sort the intervals, our algorithm will take O(N * logN).

Space complexity #
The space complexity of the above algorithm will be O(N) as we need to return a list containing all the merged intervals.
We will also need O(N) space for sorting. For Java, depending on its version, Collection.sort() either uses Merge sort or Timsort,
and both these algorithms need O(N) space. Overall, our algorithm has a space complexity of O(N).
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

  private List<Interval> merge(List<Interval> intervals) {
    List<Interval> mergedIntervals = new LinkedList<>();

    intervals.sort(Comparator.comparingInt(a -> a.start));

    for (Interval interval : intervals) {
      if (mergedIntervals.isEmpty()
          || mergedIntervals.get(mergedIntervals.size() - 1).end < interval.start) {
        mergedIntervals.add(interval);
      } else {
        mergedIntervals.get(mergedIntervals.size() - 1).end =
            Math.max(interval.end, mergedIntervals.get(mergedIntervals.size() - 1).end);
      }
    }
    return mergedIntervals;
  }

  public static void main(String[] args) {

    MergeIntervals main = new MergeIntervals();

    List<Interval> input = new ArrayList<>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 5));
    input.add(new Interval(7, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : main.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new Interval(6, 7));
    input.add(new Interval(2, 4));
    input.add(new Interval(5, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : main.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new Interval(3, 5));
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 6));

    System.out.print("Merged intervals: ");
    for (Interval interval : main.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}
