package eu.glowacki.utp.assignment04;

import java.time.LocalDate;
import java.util.Date;

public final class Person implements Comparable<Person> {
	
	private final String name;
	private final String surname;
	private final LocalDate birthdate;

	@Override
	public String toString() {
		return "Name: "+ this.getName() + ", Surname: " + this.getSurname()+ ",  Birthday: " + this.getBirthdate() + "\n";
	}

	public Person(String firstName, String surname, LocalDate birthdate) {
		this.name = firstName;
		this.surname = surname;
		this.birthdate = birthdate;
	}

	@Override
	public int compareTo(Person otherPerson) {
		// natural order based on:
		 int x = this.surname.compareTo(otherPerson.surname);
		 int y = this.name.compareTo(otherPerson.name);
		 int z = this.birthdate.compareTo(otherPerson.birthdate);
		// (1) surname;
		// (2) first name;
		// (3) birth date.
				if(x==0){
					if(y==0){
						if(z==0){
							return 0;
						} else return z;
					} else return y;
				} else return x;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}
}