package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Employee extends Person {



	//
	// attributes:
	// * salary (use BigDecimal type for representing currency values)
	// * manager (empty if at top of hierarchy)
	protected BigDecimal salary;
	protected Manager manager;
	protected BigDecimal bonus;
	protected LocalDate hireDate;
	protected Employee(String name, String surname, LocalDate birth, BigDecimal salary, Manager manager,  LocalDate hireDate) {
		super(name, surname, birth);
		this.salary = salary;
		this.manager = manager;
		this.hireDate = hireDate;
		bonus=BigDecimal.valueOf(0);
	}


	protected Employee(String name, String surname, LocalDate birth, BigDecimal salary,  LocalDate hireDate) {
		super(name, surname, birth);
		this.salary = salary;
		this.manager = null;
		this.hireDate = hireDate;
		bonus=BigDecimal.valueOf(0);
	}

	public Employee(String name, String surname, LocalDate Birth) {
		super();
	}




	public BigDecimal getSalary() {
		return salary;
	}

	public Manager getManager() {
		return manager;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"salary=" + salary +
				", manager=" + manager +
				", bonus=" + bonus +
				'}';
	}

	public LocalDate getHireDate() {
		return hireDate;
	}
}