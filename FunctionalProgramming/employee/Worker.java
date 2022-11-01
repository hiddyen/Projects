package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Worker extends Employee {
	// attributes
	// * employment date
	// * bonus

	protected BigDecimal bonus;

	public Worker(String name, String surname, LocalDate birth, BigDecimal salary, Manager manager, LocalDate hireDate, BigDecimal bonus) {
		super(name, surname, birth, salary, manager, hireDate);

		this.bonus = bonus;
	}
	public Worker(String name, String surname, LocalDate birth, BigDecimal salary, LocalDate hireDate, BigDecimal bonus) {
		super(name, surname, birth, salary, hireDate);
		this.bonus = bonus;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	@Override
	public String toString() {
		return "Worker name : " + this.getName() + ", Surname : " + this.getSurname()  ;
	}
}