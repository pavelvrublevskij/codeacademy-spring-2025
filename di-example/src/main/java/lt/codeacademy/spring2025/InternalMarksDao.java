package lt.codeacademy.spring2025;

import java.util.List;

public class InternalMarksDao implements MarksDao {
	@Override
	public List<Integer> getMarks() {
		return List.of(5, 8, 9, 10, 3, 6, 7);
	}
}
