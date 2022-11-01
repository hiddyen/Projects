package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public final class Manager extends Worker {

	// attributes
	// * subordinates (a list of immediate subordinates)

		protected List<Employee> subordinates;

	public Manager(String name, String surname, LocalDate birth, BigDecimal salary, Manager manager, LocalDate hireDate, BigDecimal bonus, List<Employee> subordinates) {
		super(name, surname, birth, salary, manager, hireDate, bonus);
		this.subordinates = subordinates;
	}

	public Manager(String name, String surname, LocalDate birth, BigDecimal salary, LocalDate hireDate, BigDecimal bonus, List<Employee> subordinates) {
		super(name, surname, birth, salary, hireDate, bonus);
		this.subordinates = subordinates;
	}


	@Override
	public String toString() {
		return "Manager name: " + this.getName() + ", Surname: " + this.getSurname() + ", hire date: " + this.getHireDate();
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}
}