package lt.codeacademy.spring2025;

import java.util.List;

public class GradeService {
	public Double avarageGrade() {
		MarksDao marksDao = new InternalMarksDao();
		List<Integer> marks = marksDao.getMarks();

		double sum = 0;
		for (Integer mark : marks) {
			sum += mark;
		}

		return sum / marks.size();
	}
}
