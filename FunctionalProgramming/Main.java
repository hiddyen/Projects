package eu.glowacki.utp.assignment02;

import eu.glowacki.utp.assignment02.employee.Employee;
import eu.glowacki.utp.assignment02.employee.Manager;
import eu.glowacki.utp.assignment02.employee.Trainee;
import eu.glowacki.utp.assignment02.employee.Worker;
import eu.glowacki.utp.assignment02.payroll.PayrollEntry;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String []args){
        List<Employee> subordinates = new ArrayList<>();
        List<Employee> subordinates1 = new ArrayList<>();
        Employee e1 = new Worker("Jacek", "Amon", LocalDate.of(2002,1,30) , BigDecimal.valueOf(12000.20), LocalDate.of(2020, 3, 23), BigDecimal.valueOf(1200));
        Employee e2 = new Worker("Wiktor", "Kowalewski", LocalDate.of(1990,3,3) , BigDecimal.valueOf(9000.20), LocalDate.of(2015, 12, 1), BigDecimal.valueOf(400));
        Manager e3 = new Manager("Dawid", "Krzeslo", LocalDate.of(1995,10,10) , BigDecimal.valueOf(100000.20), LocalDate.of(2010, 5, 4), BigDecimal.valueOf(5000),subordinates);
        Employee e4 = new Trainee("Wojtek", "Szczepara", LocalDate.of(1999,6,3) , BigDecimal.valueOf(1000), e3 ,LocalDate.of(2020, 2, 11), 100);
        Employee e5 = new Trainee("Zygmund", "Amaram", LocalDate.of(1997,8,21) , BigDecimal.valueOf(800), e3 ,LocalDate.of(2015, 7, 5), 25);
        Employee e6 = new Worker("Jacek", "Kowal", LocalDate.of(2007,1,9) , BigDecimal.valueOf(1250.20), LocalDate.of(2013, 5, 3), BigDecimal.valueOf(1200));
        Employee e7 = new Worker("Krzysztof", "Drewno", LocalDate.of(1989,6,15) , BigDecimal.valueOf(1400.20), LocalDate.of(2016, 4, 1), BigDecimal.valueOf(500));
        Employee e8 = new Worker("Bartosz", "Gbur", LocalDate.of(1999,11,26) , BigDecimal.valueOf(1600.20), LocalDate.of(2013  , 7, 12), BigDecimal.valueOf(1600));
        Employee e9 = new Worker("Tomasz", "Liszkiewicz", LocalDate.of(2000,12,7) , BigDecimal.valueOf(2200.20), LocalDate.of(2017, 10, 17), BigDecimal.valueOf(12000));
        Manager e10 = new Manager("Dawid", "Krzeslo", LocalDate.of(1995,10,13) , BigDecimal.valueOf(50000.20), LocalDate.of(2020, 6, 11), BigDecimal.valueOf(500000),subordinates);

        subordinates.add(e1);
        subordinates.add(e4);
        subordinates.add(e5);
        subordinates.add(e7);
        subordinates.add(e9);

        subordinates1.add(e2);
        subordinates1.add(e6);
        subordinates1.add(e3);
        subordinates1.add(e8);


        List<Employee> employees = new ArrayList<Employee>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        System.out.println("1");
        System.out.println(HumanResourcesStatistics.payroll(employees));
        System.out.println("2");
        System.out.println(HumanResourcesStatistics.subordinatesPayroll(e3));
        System.out.println("3");
        System.out.println(HumanResourcesStatistics.bonusTotal(employees));
        System.out.println("4");
        System.out.println(HumanResourcesStatistics.longestSeniority(employees));
        System.out.println("5");
        System.out.println(HumanResourcesStatistics.highestSalaryWithoutBonus(employees));
        System.out.println("6");
        System.out.println(HumanResourcesStatistics.highestSalaryIncludingBonus(employees));
        System.out.println("7");
        System.out.println(HumanResourcesStatistics.surnameBeginsWithA(e10));
        System.out.println("8");
        System.out.println(HumanResourcesStatistics.earnMoreThan1000(employees));
        System.out.println();
        LocalDate x = LocalDate.ofEpochDay(2020-01-01);
        LocalDate y = LocalDate.ofEpochDay(2020-01-05);
        System.out.println(x.compareTo(y));

    }
}
