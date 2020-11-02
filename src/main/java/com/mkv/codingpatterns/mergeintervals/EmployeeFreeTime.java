package com.mkv.codingpatterns.mergeintervals;

/*
For ‘K’ employees, we are given a list of intervals representing each employee’s working hours.
Our goal is to determine if there is a free interval that is common to all employees.
You can assume that each list of employee working hours is sorted on the start time.

Time complexity #
The above algorithm’s time complexity is O(N*logK), where ‘N’ is the total number of intervals, and ‘K’ is the total number of employees.
This is because we are iterating through the intervals only once (which will take O(N)O(N)), and every time we process an interval, we remove (and can insert) one interval in the Min Heap, (which will take O(logK)O(logK)). At any time, the heap will not have more than ‘K’ elements.

Space complexity #
The space complexity of the above algorithm will be O(K)O(K) as at any time, the heap will not have more than ‘K’ elements.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {

  private List<Interval> findEmployeeFreeTime(List<List<Interval>> avails) {
    List<Interval> result = new ArrayList<>();

    PriorityQueue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.start));
    avails.forEach(pq::addAll);
    /*	  while (!pq.isEmpty()) {
    		Interval i = pq.poll();
        System.out.println("i = "+ i);
    }*/

    Interval temp = pq.poll();
    while (!pq.isEmpty()) {
      assert temp != null;
      if (temp.end < pq.peek().start) { // no intersect
        result.add(new Interval(temp.end, pq.peek().start));
        temp = pq.poll(); // becomes the next temp interval
      } else { // intersect or sub merged
        temp = temp.end < pq.peek().end ? pq.peek() : temp;
        pq.poll();
      }
    }
    return result;
  }

  public static void main(String[] args) {

    EmployeeFreeTime main = new EmployeeFreeTime();

    List<List<Interval>> input = new ArrayList<>();
    input.add(new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
    input.add(new ArrayList<>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
    List<Interval> result = main.findEmployeeFreeTime(input);
    System.out.print("Free intervals: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + ", " + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
    input.add(new ArrayList<>(Collections.singletonList(new Interval(2, 4))));
    input.add(new ArrayList<>(Collections.singletonList(new Interval(6, 8))));
    result = main.findEmployeeFreeTime(input);
    System.out.print("Free intervals: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + ", " + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new ArrayList<>(Collections.singletonList(new Interval(1, 3))));
    input.add(new ArrayList<>(Collections.singletonList(new Interval(2, 4))));
    input.add(new ArrayList<>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
    result = main.findEmployeeFreeTime(input);
    System.out.print("Free intervals: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + ", " + interval.end + "] ");
  }
}
