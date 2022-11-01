package eu.glowacki.utp.assignment04;

import eu.glowacki.utp.assignment04.comparators.BirthdateComparator;
import eu.glowacki.utp.assignment04.comparators.FirstNameComparator;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class PersonDatabase {

	private final List<Person> people;

	public PersonDatabase(List<Person> people) { //
		this.people = people;
	}

	public List<Person> sortedByFirstName() { //
		return people.stream().sorted(new FirstNameComparator()).collect(Collectors.toList());
	}
	
	public List<Person> sortedBySurnameFirstNameAndBirthdate() { //
		return people.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()); // natural order (Comparable)
	}
	
	public List<Person> sortedByBirthdate() { //
		return people.stream().sorted(new BirthdateComparator()).collect(Collectors.toList()); // external rule for ordering (based on Comparator --- BirthdateComparator)
	}
	
	public List<Person> bornOnDay(LocalDate date) { //
		return people.stream().filter((Person person)->{
			return person.getBirthdate().isEqual(date);
		}).collect(Collectors.toList());
	}
}