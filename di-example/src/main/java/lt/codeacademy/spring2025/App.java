package lt.codeacademy.spring2025;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import lt.codeacademy.spring2025.calculator.GradeAverageCalculator;
import lt.codeacademy.spring2025.config.SpringContextConfig;

/**
 * Hello world!
 */
public class App {

	public static void main(String[] args) {
//		diExampleUsingSimpleJava();
		diExampleUsingSpringContext();
	}

	private static void diExampleUsingSpringContext() {
		final ApplicationContext springContext = new AnnotationConfigApplicationContext(SpringContextConfig.class);
		final GradeService gradeService = springContext.getBean(GradeService.class);
		System.out.println("Pazymiu vidurkis (internal): " + gradeService.averageGrade());

		final GradeExternalService gradeExternalService = springContext.getBean(GradeExternalService.class);
		System.out.println("Pazymiu vidurkis (external): " + gradeExternalService.averageGrade());
	}

	private static void diExampleUsingSimpleJava() {
		final MarksDao marksDao = new ExternalMarksDao();
		final GradeAverageCalculator calculator = new GradeAverageCalculator();
		System.out.println("Pazymiu vidurkis: " + new GradeService(marksDao, calculator).averageGrade());
	}
}
