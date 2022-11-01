package eu.glowacki.utp.assignment04;

import eu.glowacki.utp.assignment04.InputParser;
import eu.glowacki.utp.assignment04.PersonDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\xd.txt");
        LocalDate date = LocalDate.ofYearDay(2015,1);
        System.out.println(InputParser.parse(file));
        PersonDatabase people = new PersonDatabase(InputParser.parse(file));
        System.out.println("Sorted by First Name");
        System.out.println(people.sortedByFirstName());
        System.out.println("Sorted By Surname, First Name And Birthdate");
        System.out.println(people.sortedBySurnameFirstNameAndBirthdate());
        System.out.println("Sorted by Birthday");
        System.out.println(people.sortedByBirthdate());
        System.out.println("Born on Day " + date );
        System.out.println(people.bornOnDay(date));

    }
}
