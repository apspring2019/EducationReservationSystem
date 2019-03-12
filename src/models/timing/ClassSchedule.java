package models.timing;

import java.time.*;
import java.util.*;

/**
 * A schedule that holds the reservations for a week.
 * <p>
 * Simply uses a list of {@code Reservation} for each day.
 * <p>
 * You can check if a period is free using {@code isFree}
 */
public class ClassSchedule
{
    private LocalTime startTime;
    private LocalTime endTime;

    private final ArrayList<ArrayList<Reservation>> reservations;

    public ClassSchedule(LocalTime startTime, LocalTime endTime)
    {
        this.startTime = startTime;
        this.endTime = endTime;
        reservations = new ArrayList<>(7);
        for (int i = 0; i < 7; i++)
            reservations.add(new ArrayList<>());
    }

    public LocalTime getStartTime()
    {
        return startTime;
    }

    public void setStartTime(LocalTime startTime)
    {
        this.startTime = startTime;
    }

    public LocalTime getEndTime()
    {
        return endTime;
    }

    public void setEndTime(LocalTime endTime)
    {
        this.endTime = endTime;
    }

    /**
     * Checks if this period is available for reservation in the schedule.
     *
     * @param dayOfWeek day to check
     * @param start     start of the period
     * @param end       end of the period
     * @return returns true if available
     */
    public boolean isFree(DayOfWeek dayOfWeek, LocalTime start, LocalTime end)
    {
        if (start.isBefore(this.startTime) || end.isAfter(this.endTime))
            return false;
        for (Reservation reservation : reservations.get(dayOfWeek.getValue() - 1))
            if (reservation.getStart().isBefore(end) && reservation.getEnd().isAfter(start))
                return false;
        return true;
    }

    /**
     * Adds a reservation to the schedule. Checks for availability of the period before adding.
     *
     * @param reservation the reservation to be added
     * @return returns true if reservation is successful
     */
    boolean reserve(Reservation reservation)
    {
        if (!isFree(reservation.getDayOfWeek(), reservation.getStart(), reservation.getEnd()))
            return false;
        reservations.get(reservation.getDayOfWeek().getValue() - 1).add(reservation);
        return true;
    }

    public List<Reservation> getReservations(DayOfWeek dayOfWeek)
    {
        return Collections.unmodifiableList(reservations.get(dayOfWeek.getValue() - 1));
    }
}
