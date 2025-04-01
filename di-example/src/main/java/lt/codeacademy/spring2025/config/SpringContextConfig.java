package lt.codeacademy.spring2025.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lt.codeacademy.spring2025.GradeService;
import lt.codeacademy.spring2025.InternalMarksDao;
import lt.codeacademy.spring2025.MarksDao;

@Configuration
public class SpringContextConfig {

	@Bean
	public MarksDao getMarksDao() {
		return new InternalMarksDao();
	}

	@Bean
	public GradeService getGradeService() {
		return new GradeService(getMarksDao());
	}

}
