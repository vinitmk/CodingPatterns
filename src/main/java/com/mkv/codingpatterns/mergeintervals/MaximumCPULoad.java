package com.mkv.codingpatterns.mergeintervals;

/*
We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.

Time complexity #
The time complexity of the above algorithm is O(N*logN), where ‘N’ is the total number of jobs.
This is due to the sorting that we did in the beginning. Also, while iterating the jobs,
we might need to poll/offer jobs to the priority queue. Each of these operations can take O(logN).
Overall our algorithm will take O(NlogN).

Space complexity #
The space complexity of the above algorithm will be O(N), which is required for sorting.
Also, in the worst case, we have to insert all the jobs into the priority queue (when all jobs overlap)
which will also take O(N) space. The overall space complexity of our algorithm is O(N).
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Job {
  int start;
  int end;
  int cpuLoad;

  Job(int start, int end, int cpuLoad) {
    this.start = start;
    this.end = end;
    this.cpuLoad = cpuLoad;
  }
}

public class MaximumCPULoad {

  private int findMaxCPULoad(List<Job> jobsList) {

    jobsList.sort(Comparator.comparingInt(a -> a.start));
    int currentCPULoad = 0, maxCPULoad = 0;
    PriorityQueue<Job> minHeap =
        new PriorityQueue<>(jobsList.size(), Comparator.comparingInt(a -> a.end));
    for (Job job : jobsList) {

      while (!minHeap.isEmpty() && job.start > minHeap.peek().end) {
        currentCPULoad -= minHeap.poll().cpuLoad;
      }

      minHeap.offer(job);
      currentCPULoad += job.cpuLoad;

      maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
    }
    return maxCPULoad;
  }

  public static void main(String[] args) {

    MaximumCPULoad main = new MaximumCPULoad();

    List<Job> input =
        new ArrayList<>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
    System.out.println("Maximum CPU load at any time: " + main.findMaxCPULoad(input));

    input =
        new ArrayList<>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
    System.out.println("Maximum CPU load at any time: " + main.findMaxCPULoad(input));

    input = new ArrayList<>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
    System.out.println("Maximum CPU load at any time: " + main.findMaxCPULoad(input));
  }
}
