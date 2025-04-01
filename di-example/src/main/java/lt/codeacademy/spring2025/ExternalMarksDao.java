package lt.codeacademy.spring2025;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ExternalMarksDao implements MarksDao {
	@Override
	public List<Integer> getMarks() {
		return List.of(2, 2, 2, 2, 5, 5);
	}
}
