package cadispring.exercisespring1;
//하위 패키지들은 자동으로 스프링 빈으로 등록. 하위 패키지가 동일하거나 아닌 애들은 컴포넌트 스캔 대상이 안 됨.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciseSpring1Application {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseSpring1Application.class, args);
	}

}
