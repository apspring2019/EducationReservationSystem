package models.timing;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import models.Department;
import models.EducationClass;

public class ReservationService
{
    private final Department department;

    public ReservationService(Department department)
    {
        this.department = department;
    }

    /**
     * Gives a list of available classes for the day and the period.
     * @param dayOfWeek day of reservation
     * @param start start of the period
     * @param end end of the period
     * @param minCapacity minimum capacity required for the reservation
     * @return returns list of the available classes.
     */
    public List<Integer> suggestClasses(DayOfWeek dayOfWeek, LocalTime start, LocalTime end, int minCapacity)
    {
        ArrayList<Integer> retVal = new ArrayList<>();
        for (EducationClass eduClass : department.getAllClasses())
            if (eduClass.getCapacity() >= minCapacity &&
                    eduClass.getSchedule().isFree(dayOfWeek, start, end))
                retVal.add(eduClass.getClassNum());
        return retVal;
    }

    /**
     * Reserves the class for the specified time.
     * @param reservation the reservation to be added to schedule of the class
     * @return returns true if successful
     */
    public boolean reserveClass(Reservation reservation)
    {
        return department.getClass(reservation.getClassNumber())
                .getSchedule().reserve(reservation);
    }
}
