package models;

import java.time.LocalTime;

import models.timing.ClassSchedule;

public class EducationClass
{
    private int classNum;
    private int capacity;

    private ClassSchedule schedule;

    public EducationClass(int classNum, int capacity)
    {
        this.classNum = classNum;
        this.capacity = capacity;
        this.schedule = new ClassSchedule(LocalTime.of(7, 30), LocalTime.of(18, 0));
    }

    public int getClassNum()
    {
        return classNum;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public ClassSchedule getSchedule()
    {
        return schedule;
    }
}
