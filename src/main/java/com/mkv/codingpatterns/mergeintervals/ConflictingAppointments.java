package com.mkv.codingpatterns.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

public class ConflictingAppointments {

  private boolean canAttendAllAppointments(Interval[] appointments) {
    boolean canAttend = true;

    Arrays.sort(appointments, Comparator.comparingInt(a -> a.start));

    for (int i = 0; i < appointments.length - 1; i++) {
      if (appointments[i].end > appointments[i + 1].start) {
        canAttend = false;
        break;
      }
    }
    return canAttend;
  }

  public static void main(String[] args) {

    ConflictingAppointments main = new ConflictingAppointments();

    Interval[] intervals = {new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
    boolean result = main.canAttendAllAppointments(intervals);
    System.out.println("Can attend all appointments: " + result);

    Interval[] intervals1 = {new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)};
    result = main.canAttendAllAppointments(intervals1);
    System.out.println("Can attend all appointments: " + result);

    Interval[] intervals2 = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)};
    result = main.canAttendAllAppointments(intervals2);
    System.out.println("Can attend all appointments: " + result);
  }
}
