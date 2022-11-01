package eu.glowacki.utp.assignment04.comparators;

import java.util.Comparator;

import eu.glowacki.utp.assignment04.Person;

public class FirstNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person person1, Person person2) {
		return person1.getName().compareTo(person2.getName()); //if value returned is 0 then they are equal if -1 if the latter one is bigger, and 1 if the first object is bigger
	}
}