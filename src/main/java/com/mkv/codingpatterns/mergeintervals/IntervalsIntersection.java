package com.mkv.codingpatterns.mergeintervals;

/*

Given two lists of intervals, find the intersection of these two lists.
Each list consists of disjoint intervals sorted on their start time.

Time complexity #
As we are iterating through both the lists once, the time complexity of the above algorithm is O(N + M),
where ‘N’ and ‘M’ are the total number of intervals in the input arrays respectively.

Space complexity #
Ignoring the space needed for the result list, the algorithm runs in constant space O(1).

*/

import java.util.ArrayList;
import java.util.List;

public class IntervalsIntersection {

  private Interval[] merge(Interval[] input1, Interval[] input2) {
  	List<Interval> r = new ArrayList<>();
  	int index1 = 0 , index2 = 0;
  	while(index1 < input1.length && index2 < input2.length) {

  		if((input1[index1].start >= input2[index2].start && input1[index1].start <= input2[index2].end)
				|| (input2[index2].start >= input1[index1].start && input2[index2].start <= input1[index1].end)) {
  			//System.out.println("Starts are : " + input1[index1].start +"  "+input2[index2].start);
			//System.out.println("Ends are : " + input1[index1].end +"  "+input2[index2].end);
			int start = Math.max(input1[index1].start, input2[index2].start);
			int end = Math.min(input1[index1].end, input2[index2].end);
			r.add(new Interval(start, end));
		}

  		if(input1[index1].end < input2[index2].end)
  			index1++;
  		else
  			index2++;
	}
  	return r.toArray(new Interval[0]);
  }

  public static void main(String[] args) {

    IntervalsIntersection main = new IntervalsIntersection();

    Interval[] input1 = new Interval[] {new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
    Interval[] input2 = new Interval[] {new Interval(2, 3), new Interval(5, 7)};
    Interval[] result = main.merge(input1, input2);
    System.out.print("Intervals Intersection: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input1 = new Interval[] {new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
    input2 = new Interval[] {new Interval(5, 10)};
    result = main.merge(input1, input2);
    System.out.print("Intervals Intersection: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + "," + interval.end + "] ");
  }
}
