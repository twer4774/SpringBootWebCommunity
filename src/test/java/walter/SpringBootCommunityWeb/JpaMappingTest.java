//package walter.SpringBootCommunityWeb;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import walter.SpringBootCommunityWeb.domain.Board;
//import walter.SpringBootCommunityWeb.domain.User;
//import walter.SpringBootCommunityWeb.domain.eums.BoardType;
//import walter.SpringBootCommunityWeb.domain.repository.BoardRepository;
//import walter.SpringBootCommunityWeb.domain.repository.UserRepository;
//
//import java.time.LocalDateTime;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//
//@DataJpaTest
//public class JpaMappingTest {
//
//    private final String boardTestTitle = "테스트";
//    private final String email = "test@gmail.com";
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    BoardRepository boardRepository;
//
//    @BeforeEach
//    public void init(){
//        User user = userRepository.save(User.builder()
//                .name("havi")
//                .password("test")
//                .email(email)
//                .createdDate(LocalDateTime.now())
//                .build());
//
//        boardRepository.save(Board.builder()
//                .title(boardTestTitle)
//                .subTitle("서브 타이틀")
//                .content("콘텐츠")
//                .boardType(BoardType.free)
//                .createdDate(LocalDateTime.now())
//                .updatedDate(LocalDateTime.now())
//                .user(user)
//                .build());
//    }
//
//    @Test
//    public void 제대로_생성됐는지_테스트(){
//        User user = userRepository.findByEmail(email);
//        assertThat(user.getName(), is("havi"));
//        assertThat(user.getPassword(), is("test"));
//        assertThat(user.getEmail(), is(email));
//
//        Board board  = boardRepository.findByUser(user);
//        assertThat(board.getTitle(), is(boardTestTitle));
//        assertThat(board.getSubTitle(), is("서브 타이틀"));
//        assertThat(board.getContent(), is("콘텐츠"));
//        assertThat(board.getBoardType(), is(BoardType.free));
//    }
//}
