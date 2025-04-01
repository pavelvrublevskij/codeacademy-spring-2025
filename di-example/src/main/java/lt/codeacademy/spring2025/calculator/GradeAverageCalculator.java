package lt.codeacademy.spring2025.calculator;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GradeAverageCalculator {

	public Double calc(List<Integer> marks) {
		double sum = 0;
		for (Integer mark : marks) {
			sum += mark;
		}

		return sum / marks.size();
	}
}
