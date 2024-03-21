package sandbox;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Course 
{
	private final String id;
	private final String name;
	private final String section;
	private final String term;
	private final Faculty faculty;
	private final Item textbook;
	private final LocalDate startDate;
	private final LocalDate endDate;

	public Course(String id, String name, String section, String term, Faculty faculty, Item textbook, LocalDate startDate, LocalDate endDate) {
		this.id = id;
		this.name = name;
		this.section = section;
		this.term = term;
		this.faculty = faculty;
		this.textbook = textbook;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSection() {
		return section;
	}

	public String getTerm() {
		return term;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public Item getTextbook() {
		return textbook;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}
}
