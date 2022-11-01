package eu.glowacki.utp.assignment02;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import eu.glowacki.utp.assignment02.employee.Employee;
import eu.glowacki.utp.assignment02.employee.Manager;
import eu.glowacki.utp.assignment02.payroll.PayrollEntry;

public final class HumanResourcesStatistics {

	public static List<PayrollEntry> payroll(List<Employee> employees) {
		return employees.stream().map(emp -> new PayrollEntry(emp, emp.getSalary(), emp.getBonus())).collect(Collectors.toList());
	}

	// payroll for all subordinates
	public static List<PayrollEntry> subordinatesPayroll(Manager manager) {
		return manager.getSubordinates().stream().map(emp -> new PayrollEntry(emp, emp.getSalary(), emp.getBonus())).collect(Collectors.toList());
	}

	public static BigDecimal bonusTotal(List<Employee> employees) {

		return  employees.stream().map(Employee::getBonus).reduce(BigDecimal.valueOf(0),(a, b) -> a.add(b));

	}

	public static List<Employee> longestSeniority(List<Employee> employees) {
		LocalDate date = employees.stream().map(Employee::getHireDate).reduce(LocalDate.ofYearDay(2020,200), (a, b) -> a.isBefore(b)? a : b );
		return employees.stream().filter((Employee emp)->{
			return emp.getHireDate().isEqual(date);
		}).collect(Collectors.toList());
	}

	public static BigDecimal highestSalaryWithoutBonus(List<Employee> employees) {

		return employees.stream().map(Employee::getSalary).reduce(BigDecimal.valueOf(0), (a, b) -> a.compareTo(b)>0 ? a : b );
	}

	public static Optional<PayrollEntry> highestSalaryIncludingBonus(List<Employee> employees) {

		//return	payroll(employees).stream().map(PayrollEntry::get_salaryPlusBonus).reduce(BigDecimal.valueOf(0), (a, b) -> a.compareTo(b)>0 ? a : b );
		return employees.stream().map(emp -> new PayrollEntry(emp, emp.getSalary(), emp.getBonus())).reduce((a,b)-> a.get_salaryPlusBonus().compareTo(b.get_salaryPlusBonus())>0? a:b);
	}

	public static List<Employee> surnameBeginsWithA(Manager manager) {
		return manager.getSubordinates().stream().filter((Employee emp)->{
			return emp.getSurname().startsWith("A");
		}).collect(Collectors.toList());
	}

	public static List<Employee> earnMoreThan1000(List<Employee> employees) {

		return employees.stream().filter((Employee emp)->{
			return emp.getBonus().add(emp.getSalary()).compareTo(BigDecimal.valueOf(1000))>0;
		}).collect(Collectors.toList());
	}

	/// ...
	// rest of the methods specified in the assignment description
	
	
	/**
	 * samples for functional processing in Java
	 * 
	 */
	public static List<Integer> getAges(List<Employee> employees) {
		if (employees == null) {
			return null;
		}
		List<Integer> ages = employees //
				.stream() //
				.map(emp -> emp.getAge()) //
				.collect(Collectors.toList());
		return ages;
	}

	public static void printAges(List<Employee> employees) {
		if (employees == null) {
			return;
		}
		employees //
				.stream() //
				.map(emp -> (int) emp.getAge()) //
				.forEach(age -> System.out.print(age + ", "));
	}

	//
	// average age for the Employees whose first name starts with 'A' and they are older than 20
	public static short getAverageAgeInline(List<Employee> employees) {
		if (employees == null) {
			return 0;
		}
		int employeeTotalAge = employees //
				.stream() //
				.filter(emp -> emp.getName().startsWith("A") && emp.getAge() > 20) //
				.map(emp -> (int) emp.getAge()) //
				.reduce(0, //
						(total, age) -> total + age);

		long filteredEmployeesCount = employees //
				.stream() //
				.filter(emp -> emp.getName().startsWith("A") && emp.getAge() > 20) //
				.count();

		return (short) (employeeTotalAge / filteredEmployeesCount);
	}

	public static int getAverageAgeMethodReference(List<Employee> employees) {
		if (employees == null) {
			return 0;
		}
		int employeeTotalAge = employees //
				.stream() //
				.map(emp -> (int) emp.getAge()) //
				.reduce(0, HumanResourcesStatistics::totalAge);
		return (int) (employeeTotalAge / employees.size());
	}

	public static int getMaxAgeInline(List<Employee> employees) {
		int employeeMaxAge = employees //
				.stream() //
				.map(emp -> emp.getAge()) //
				.reduce((int) 0, //
						(maxAge, age) -> {
							if (maxAge < age) {
								return age;
							} else {
								return maxAge;
							}
						});
		return employeeMaxAge;
	}

	//public static LocalDate getOldestSenior(List<Employee> employees){
	//	return employees.stream().map(Employee::getHireDate).reduce(LocalDate.ofYearDay(2020, 200), (a, b) -> a.isBefore(b)? a : b );
	//}
	public static int getMaxAgeMethodReference(List<Employee> employees) {
		int employeeMaxAge = employees //
				.stream() //
				.map(emp -> emp.getAge()) //
				.reduce((int) 0, HumanResourcesStatistics::maxAge);
		return employeeMaxAge;
	}


	private static int totalAge(int totalAge, int age) {
		//
		return totalAge + age;
	}

	private static int maxAge(int maxAge, int age) {
		if (maxAge < age) {
			return age;
		} else {
			return maxAge;
		}
	}
	private static int LongestHire(int LongestHire, int Hire) {
		if (LongestHire > Hire) {
			return Hire;
		} else {
			return LongestHire;
		}
	}
}