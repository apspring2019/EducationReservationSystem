package models;

import java.util.Collection;
import java.util.HashMap;

import models.timing.ReservationService;

public class Department
{
    private final HashMap<Integer, EducationClass> eduClasses = new HashMap<>();

    private final ReservationService reservationService;

    public Department()
    {
        this.reservationService = new ReservationService(this);
    }

    public boolean addClass(EducationClass eduClass)
    {
        return eduClasses.putIfAbsent(eduClass.getClassNum(), eduClass) == null;
    }

    public EducationClass getClass(int classNum)
    {
        return eduClasses.get(classNum);
    }

    public Collection<EducationClass> getAllClasses()
    {
        return eduClasses.values();
    }

    public ReservationService getReservationService()
    {
        return reservationService;
    }

}
