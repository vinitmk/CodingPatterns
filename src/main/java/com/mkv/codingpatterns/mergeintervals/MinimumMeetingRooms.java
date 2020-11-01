package com.mkv.codingpatterns.mergeintervals;

/*
Given a list of intervals representing the start and end time of ‘N’ meetings,
find the minimum number of rooms required to hold all the meetings.

Time complexity #
The time complexity of the above algorithm is O(N*logN), where ‘N’ is the total number of meetings.
This is due to the sorting that we did in the beginning. Also, while iterating the meetings we might
need to poll/offer meeting to the priority queue. Each of these operations can take O(logN).
Overall our algorithm will take O(NlogN).

Space complexity #
The space complexity of the above algorithm will be O(N) which is required for sorting.
Also, in the worst case scenario, we’ll have to insert all the meetings into the Min Heap
(when all meetings overlap) which will also take O(N) space.
The overall space complexity of our algorithm is O(N).
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {

  private int findMinimumMeetingRooms(List<Interval> inputs) {
    inputs.sort(Comparator.comparingInt(a -> a.start));

    PriorityQueue<Interval> minHeap =
        new PriorityQueue<>(inputs.size(), Comparator.comparingInt(a -> a.end));
    int meetingRoom = 0;
    for (Interval meeting : inputs) {

      while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) minHeap.poll();

      minHeap.offer(meeting);

      meetingRoom = Math.max(meetingRoom, minHeap.size());
    }

    return meetingRoom;
  }

  public static void main(String[] args) {
    MinimumMeetingRooms main = new MinimumMeetingRooms();
    List<Interval> input =
        new ArrayList<Interval>() {
          {
            add(new Interval(4, 5));
            add(new Interval(2, 3));
            add(new Interval(2, 4));
            add(new Interval(3, 5));
          }
        };
    int result = main.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input =
        new ArrayList<Interval>() {
          {
            add(new Interval(1, 4));
            add(new Interval(2, 5));
            add(new Interval(7, 9));
          }
        };
    result = main.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input =
        new ArrayList<Interval>() {
          {
            add(new Interval(6, 7));
            add(new Interval(2, 4));
            add(new Interval(8, 12));
          }
        };
    result = main.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input =
        new ArrayList<Interval>() {
          {
            add(new Interval(1, 4));
            add(new Interval(2, 3));
            add(new Interval(3, 6));
          }
        };
    result = main.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input =
        new ArrayList<Interval>() {
          {
            add(new Interval(4, 5));
            add(new Interval(2, 3));
            add(new Interval(2, 4));
            add(new Interval(3, 5));
          }
        };
    result = main.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);
  }
}
