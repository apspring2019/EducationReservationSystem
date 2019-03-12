package models.timing;

import java.time.*;

/**
 * An immutable class that holds reservation information.
 */
public class Reservation
{
    private final LocalTime start;
    private final LocalTime end;
    private final DayOfWeek dayOfWeek;

    private final int classNumber;
    private final int courseNumber;

    public Reservation(LocalTime start, LocalTime end, DayOfWeek dayOfWeek, int classNumber, int courseNumber)
    {
        this.start = start;
        this.end = end;
        this.classNumber = classNumber;
        this.dayOfWeek = dayOfWeek;
        this.courseNumber = courseNumber;
    }

    public LocalTime getStart()
    {
        return start;
    }

    public LocalTime getEnd()
    {
        return end;
    }

    public DayOfWeek getDayOfWeek()
    {
        return dayOfWeek;
    }

    public int getClassNumber()
    {
        return classNumber;
    }

    public int getCourseNumber()
    {
        return courseNumber;
    }
}
