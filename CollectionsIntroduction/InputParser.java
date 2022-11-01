package eu.glowacki.utp.assignment04;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


public final class InputParser {
	
	// 1. Use regular expresssions (Pattern) for validating input data
	//    U�y� regularnych wyra�e� (Pattern) do walidacji danych wej�ciowych
	//
	// 2. Convert input string representing date using SimpleDateFormat "yyyy-MM-dd" 
	//    Konwersj� wej�ciowego ci�gu znak�w reprezentuj�cego dat� nale�y oprze� np. DateFormat 
	//    SimpleDateFormat format "yyyy-MM-dd"

	public static List<Person> parse(File file) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		in.useDelimiter("; |\n");

		List<Person> people = new ArrayList<>();
		while(in.hasNext()){
			String name = in.next();
			String surname = in.next();
			String birthdayS = in.next();
			LocalDate birthday = LocalDate.parse(birthdayS);

			Person newPerson = new Person(name, surname,birthday);
			people.add(newPerson);
		}

		return people;
	}

}