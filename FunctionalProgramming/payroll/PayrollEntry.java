package eu.glowacki.utp.assignment02.payroll;

import java.math.BigDecimal;

import eu.glowacki.utp.assignment02.employee.Employee;

public final class PayrollEntry {

	private final Employee _employee;
	private final BigDecimal _salaryPlusBonus;

	public PayrollEntry(Employee employee, BigDecimal salary, BigDecimal bonus) {
		_employee = employee;
		if(salary!=null && bonus == null)
			_salaryPlusBonus=salary;
			else
		_salaryPlusBonus = salary.add(bonus); // validate whether salary and bonus are not null
	}
	public BigDecimal get_salaryPlusBonus() {
		return _salaryPlusBonus;
	}

	@Override
	public String toString() {
		return "Payroll for {" +
				"Employee: " + _employee.getName() + " " + _employee.getSurname() +
				", Salary + bonus:  " + _salaryPlusBonus +
				'}' + '\n';
	}

	public Employee get_employee() {
		return _employee;
	}
}