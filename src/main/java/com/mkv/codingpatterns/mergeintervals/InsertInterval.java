package com.mkv.codingpatterns.mergeintervals;

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
