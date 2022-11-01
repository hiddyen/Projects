package eu.glowacki.utp.assignment04.comparators;

import java.util.Comparator;

import eu.glowacki.utp.assignment04.Person;

public final class BirthdateComparator implements Comparator<Person> {

	@Override
	public int compare(Person person1, Person person2) {
		// TODO Auto-generated method stub
		return person1.getBirthdate().compareTo(person2.getBirthdate()); //if value returned is 0 then they are equal if <0 if the first one is bigger, and >0 if the latter one is bigger
	}
}