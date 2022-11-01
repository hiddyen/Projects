package eu.glowacki.utp.assignment02.employee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

public abstract class Person {

	// To implement an attribute means that you provide a backing field and
	// getter or optionally setter for read-write properties/attributes
	// 
	// NO BACKING FIELDS SHOULD BE PROVIDED FOR DERIVED ATTRIBUTES
	// THOSE SHOULD BE COMPUTED ON-LINE
	//
	// attributes:
	// * first name (read-only)
	// * surname (read-only)
	// * birth date (read-only) --- date MUST BE represented by an instance of
	// the type designed for date representation (either Date or LocalDate)
	//
	// * age (derived --- computed based on birth date) --- implemented as a
	// getter calculating the difference between the current date and birth date

	private final String name; // backing field
	private final String surname;
	private final LocalDate Birth;
	private  LocalDate now = LocalDate.now();

	public Person() {
		this.surname=null;
		this.Birth=null;
		this.name=null;
	}

	protected Person(String name, String surname, LocalDate Birth) {
		this.name = name;
		this.surname = surname;
		this.Birth = Birth;
	}


	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	
	public int getAge() {
		return Period.between(Birth,now).getYears();
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", Birth=" + Birth +
				", now=" + now +
				'}';
	}
}