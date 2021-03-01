package walter.SpringBootCommunityWeb.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import walter.SpringBootCommunityWeb.domain.Board;
import walter.SpringBootCommunityWeb.domain.User;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
