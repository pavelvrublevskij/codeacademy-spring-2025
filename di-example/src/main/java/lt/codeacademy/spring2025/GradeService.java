package lt.codeacademy.spring2025;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import lt.codeacademy.spring2025.calculator.GradeAverageCalculator;

@Service
public class GradeService {

	private final MarksDao marksDao;
	private final GradeAverageCalculator gradeAverageCalculator;

	public GradeService(
			@Qualifier("internalMarksDao") final MarksDao marksDao,
			final GradeAverageCalculator gradeAverageCalculator) {
		this.marksDao = marksDao;
		this.gradeAverageCalculator = gradeAverageCalculator;
	}

	public Double averageGrade() {
		return gradeAverageCalculator.calc(marksDao.getMarks());
	}
}
