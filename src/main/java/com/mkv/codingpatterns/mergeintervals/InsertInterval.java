package com.mkv.codingpatterns.mergeintervals;

/*
Given a list of non-overlapping intervals sorted by their start time,
insert a given interval at the correct position and merge all necessary
intervals to produce a list that has only mutually exclusive intervals.

Time complexity #
As we are iterating through all the intervals only once, the time complexity of the above algorithm is O(N),
where ‘N’ is the total number of intervals.

Space complexity #
The space complexity of the above algorithm will be O(N) as we need to return a list containing
all the merged intervals.

*/



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

  private List<Interval> insert(List<Interval> list, Interval newInterval) {
    List<Interval> mergedInterval = new LinkedList<>();
    int i = 0;

    while (i < list.size() && list.get(i).end < newInterval.start)
      mergedInterval.add(list.get(i++));

    while ((i < list.size()) && (list.get(i).start <= newInterval.end)) {
      newInterval.start = Math.min(list.get(i).start, newInterval.start);
      newInterval.end = Math.max(list.get(i).end, newInterval.end);
      i++;
    }
    mergedInterval.add(newInterval);

    while (i < list.size())
    	mergedInterval.add(list.get(i++));

    return mergedInterval;
  }

  public static void main(String[] args) {

    InsertInterval main = new InsertInterval();
    List<Interval> input = new ArrayList<>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : main.insert(input, new Interval(4, 6)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : main.insert(input, new Interval(4, 10)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new Interval(2, 3));
    input.add(new Interval(5, 7));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : main.insert(input, new Interval(1, 4)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}
