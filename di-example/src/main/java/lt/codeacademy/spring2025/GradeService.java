package lt.codeacademy.spring2025;

import java.util.List;

public class GradeService {

	private final MarksDao marksDao;

	public GradeService(final MarksDao marksDao) {
		this.marksDao = marksDao;
	}

	public Double avarageGrade() {
		List<Integer> marks = marksDao.getMarks();

		double sum = 0;
		for (Integer mark : marks) {
			sum += mark;
		}

		return sum / marks.size();
	}
}
