import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import models.Department;
import models.EducationClass;
import models.timing.Reservation;

public class Main
{
    public static void main(String[] args)
    {
        Department department = new Department();
        department.addClass(new EducationClass(101, 90));
        department.addClass(new EducationClass(102, 90));
        department.addClass(new EducationClass(201, 40));
        department.addClass(new EducationClass(901, 70));


        List<Integer> classNumbers = department.getReservationService().suggestClasses(DayOfWeek.SATURDAY,
                LocalTime.of(12, 0), LocalTime.of(13, 30),
                50);
        System.out.println("classNumbers = " + classNumbers);
        department.getReservationService().reserveClass(new Reservation(
                LocalTime.of(12, 0), LocalTime.of(13, 30), DayOfWeek.SATURDAY,
                classNumbers.get(0), 40123));
        System.out.println(department.getReservationService().suggestClasses(DayOfWeek.SATURDAY,
                LocalTime.of(12, 0), LocalTime.of(13, 30),
                50));
    }
}
