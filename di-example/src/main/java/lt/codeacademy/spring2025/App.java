package lt.codeacademy.spring2025;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		final MarksDao marksDao = new ExternalMarksDao();
		System.out.println("Pazymiu vidurkis: " + new GradeService(marksDao).avarageGrade());
	}
}
