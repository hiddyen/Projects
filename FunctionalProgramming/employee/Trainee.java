package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Trainee extends Employee {

	// attributes:
	// * apprenticeship start date
	// * apprenticeship length (in days)
	protected int apprenticeshipLength;

	public Trainee(String name, String surname, LocalDate birth, BigDecimal salary ,Manager manager,LocalDate hireDate, int apprenticeshipLength) {
		super(name, surname, birth, salary ,manager, hireDate );
		this.apprenticeshipLength = apprenticeshipLength;
	}

	public Trainee(String name, String surname, LocalDate birth, BigDecimal salary,LocalDate hireDate , int apprenticeshipLength) {
		super(name, surname, birth, salary, hireDate );
		this.apprenticeshipLength = apprenticeshipLength;
	}


	@Override
	public String toString() {
		return "Trainee name : " + this.getName()+
				", Surname : " + this.getSurname();
	}
}