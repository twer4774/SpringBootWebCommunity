package walter.SpringBootCommunityWeb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import walter.SpringBootCommunityWeb.domain.Board;
import walter.SpringBootCommunityWeb.domain.User;
import walter.SpringBootCommunityWeb.domain.eums.BoardType;
import walter.SpringBootCommunityWeb.domain.repository.BoardRepository;
import walter.SpringBootCommunityWeb.domain.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class SpringBootCommunityWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCommunityWebApplication.class, args);
	}

	/**
	 * 200개의 게시글을 저장하는 메소드
	 * {@link CommandLineRunner : 테스트용 데이터를 넣을 때 유용하게 사용됨. 애플리케이션 구동 후 특정 코드를 실행하고 싶을 때 직접구현하는 인터페이스}
	 * @param userRepository
	 * @param boardRepository
	 * @return
	 * @throws Exception
	 */
	@Bean
	public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository) throws Exception{
		return (args) -> {
			User user = userRepository.save(User.builder()
					.name("havi")
					.password("test")
					.email("havi@gmail.com")
					.createdDate(LocalDateTime.now())
					.build());

			IntStream.rangeClosed(1, 200).forEach(idx ->
					boardRepository.save(Board.builder()
							.title("게시글" + idx)
							.subTitle("순서"+idx)
							.content("콘텐츠")
							.boardType(BoardType.free)
							.createdDate(LocalDateTime.now())
							.updatedDate(LocalDateTime.now())
							.user(user)
							.build()));
		};
	}
}
