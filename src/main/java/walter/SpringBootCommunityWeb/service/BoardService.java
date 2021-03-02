package walter.SpringBootCommunityWeb.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import walter.SpringBootCommunityWeb.domain.Board;
import walter.SpringBootCommunityWeb.domain.repository.BoardRepository;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /**
     * pageable로 넘어온 객체의 pageable.getPageNumber()가 0 이하일 때 0으로 초기화, 기본 페이지 크기인 10으로 새로운 PageRequest 객체를 만들어 페이징 처리된 게시글 리스트 반환
     * @param pageable
     * @return 페이징 처리된 게시글 리스트 반환
     */
    //스프링부트 시큐리티 버전 2.0
    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());

        return boardRepository.findAll(pageable);
    }


    public Board findBoardByIdx(Long idx){
        return boardRepository.findById(idx).orElse(new Board());
    }
}
